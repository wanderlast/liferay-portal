/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import React, {useCallback, useEffect, useRef, useState} from 'react';

import '../../../css/components/BulkActionsMonitor.scss';

import Badge from '@clayui/badge';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import DropDown from '@clayui/drop-down';
import ClayLink from '@clayui/link';
import classnames from 'classnames';
import {openToast} from 'frontend-js-components-web';
import {debounce} from 'frontend-js-web';

import AssetBulkActionTaskService from '../../common/services/AssetBulkActionTaskService';
import {
	IBulkActionTask,
	IBulkActionTaskStarter,
	IBulkActionTaskStarterDTO,
	IBulkActionType,
} from '../../common/types/BulkActionTask';
import {FDS_EVENT_UPDATE_DISPLAY} from '../../common/utils/constants';
import {START_TASK} from '../../common/utils/events';
import {displaySystemErrorToast} from '../../common/utils/toastUtil';
import BulkActionsMonitorItemList from './components/BulkActionsMonitorItemList';
import {BulkActionTaskStarter} from './services/BulkActionTaskStarter';
import {
	INTERVAL_TASK_POLLING_MS,
	TASK_REPORT_FDS_ID,
	URL_TASKS_REPORT,
} from './util/constants';
import {getBulkActionTaskMessage} from './util/notifications';

type DataSetLoading = Record<string, {resetSearch?: boolean}>;

const INITIAL_DATA_SET_LOADING = {
	[TASK_REPORT_FDS_ID]: {resetSearch: false},
};

function BulkActionsMonitor() {
	const [active, setActive] = useState<boolean>(false);
	const [dataSetLoading, setDataSetLoading] = useState<DataSetLoading>(
		INITIAL_DATA_SET_LOADING
	);
	const intervalRef = useRef<ReturnType<typeof setInterval> | null>(null);
	const [processingTasks, setProcessingTask] = useState(0);
	const processingTasksRef = useRef(0);
	const [taskContext, setTaskContext] = useState<Record<string, any>>(() => {
		try {
			return JSON.parse(
				sessionStorage.getItem('cms_bulk_action_context') || '{}'
			);
		}
		catch {
			return {};
		}
	});
	const [tasks, setTasks] = useState<IBulkActionTask[]>([]);
	const [tasksLoading, setTasksLoading] = useState<boolean>(false);

	useEffect(() => {
		sessionStorage.setItem(
			'cms_bulk_action_context',
			JSON.stringify(taskContext)
		);
	}, [taskContext]);

	const getTasks = useCallback(
		() =>
			debounce(async () => {
				setTasksLoading(true);

				const {data} = await AssetBulkActionTaskService.getTasks({
					pageSize: 5,
					sort: 'dateCreated:desc',
				});

				const newTasks = data?.items || [];

				tasks.forEach((oldTask) => {
					const newTask = newTasks.find(
						(task) => task.id === oldTask.id
					);

					if (
						newTask &&
						oldTask.executionStatus.key !== 'completed' &&
						newTask.executionStatus.key === 'completed'
					) {
						const context = taskContext[newTask.id] || {};
						const itemsCount =
							context.itemCount ||
							(newTask.numberOfItems || 0) -
								(newTask.numberOfFailedItems || 0);

						const message = getBulkActionTaskMessage(
							newTask.type,
							'success',
							{
								items: new Array(itemsCount),
								selectAll: context.selectAll || false,
							},
							context
						);

						if (message) {
							openToast({message, type: 'success'});
						}

						setTaskContext((prevContext) => {
							const newContext = {...prevContext};
							delete newContext[newTask.id];

							return newContext;
						});
					}
				});

				setTasks(newTasks);
				setTasksLoading(false);
			}, 500)(),
		[tasks, taskContext]
	);

	const onActiveChange = useCallback(
		(active: boolean) => {
			setActive(active);

			if (active) {
				getTasks();
			}
		},
		[getTasks, setActive]
	);

	const stopPolling = useCallback(() => {
		if (intervalRef.current) {
			clearInterval(intervalRef.current);

			intervalRef.current = null;
		}
	}, [intervalRef]);

	const pollProcessingTasks = useCallback(() => {
		if (intervalRef.current) {
			return;
		}

		const getProcessingTasks = async () => {
			try {
				const {data} = await AssetBulkActionTaskService.getTasks({
					filter: `executionStatus eq 'initial' or executionStatus eq 'started'`,
				});

				if (!data?.totalCount) {
					stopPolling();
				}

				const dataTotalCount = data?.totalCount || 0;

				if (dataTotalCount < processingTasksRef.current) {
					Object.entries(dataSetLoading).forEach(
						([dataSetId, options]) => {
							Liferay.fire(FDS_EVENT_UPDATE_DISPLAY, {
								id: dataSetId,
								resetSearch: options.resetSearch,
							});
						}
					);

					if (dataTotalCount === 0) {
						setDataSetLoading(INITIAL_DATA_SET_LOADING);
					}
				}

				processingTasksRef.current = dataTotalCount;

				setProcessingTask(dataTotalCount);
			}
			catch {
				stopPolling();
			}
		};

		getProcessingTasks();

		intervalRef.current = setInterval(
			getProcessingTasks,
			INTERVAL_TASK_POLLING_MS
		);
	}, [dataSetLoading, setProcessingTask, stopPolling]);

	const postBulkAction = useCallback(
		async (
			bulkActionDTO: IBulkActionTaskStarterDTO<keyof IBulkActionType>
		) => {
			const bulkAction: IBulkActionTaskStarter =
				new BulkActionTaskStarter(bulkActionDTO);

			try {
				const response = await AssetBulkActionTaskService.createTask(
					bulkAction.payload,
					bulkAction.postURL
				);

				if (response.data) {
					bulkAction.onCreateSuccess(response);

					const newTask = response.data as any;

					if (newTask) {
						const {additionalData, selectedData} = bulkActionDTO;
						let assetName: string | undefined;

						if (
							selectedData.items &&
							selectedData.items.length === 1
						) {
							assetName = selectedData.items[0].title;
						}

						setTaskContext((prevContext) => ({
							...prevContext,
							[newTask.id]: {
								assetName,
								itemCount: selectedData.items?.length || 0,
								replacement: additionalData?.replacement,
								search: additionalData?.search,
								selectAll: selectedData.selectAll,
								targetName: additionalData?.targetName,
							},
						}));
					}

					setDataSetLoading((prevState) => {
						if (bulkActionDTO.dataSetId) {
							return {
								...prevState,
								[bulkActionDTO.dataSetId]: {
									resetSearch: bulkActionDTO.resetSearch,
								},
							};
						}

						return prevState;
					});

					pollProcessingTasks();
				}

				if (response.error) {
					bulkAction.onCreateError(response);
				}
			}
			catch (error) {
				bulkAction.onCreateError(error as unknown as any);

				if (!bulkAction.overrideDefaultErrorToast) {
					displaySystemErrorToast();
				}
			}
		},
		[pollProcessingTasks, setDataSetLoading]
	);

	useEffect(() => {
		Liferay.on(START_TASK, postBulkAction);

		return () => {
			Liferay.detach(START_TASK, postBulkAction);

			stopPolling();
		};
	}, [postBulkAction, stopPolling]);

	useEffect(() => {
		getTasks();

		pollProcessingTasks();
	}, [getTasks, pollProcessingTasks]);

	return processingTasks || tasks.length ? (
		<DropDown
			active={active}
			onActiveChange={onActiveChange}
			trigger={
				<div>
					<ClayButtonWithIcon
						aria-label={Liferay.Language.get('task-status-toggle')}
						borderless
						className={classnames('task-status-toggle', {
							'task-status-toggle-show': !processingTasks,
						})}
						displayType="secondary"
						symbol="forms"
					/>

					{processingTasks > 0 ? (
						<ClayButton
							className={classnames(
								'task-status-toggle',
								'task-status-toggle-processing',
								'task-status-toggle-show',
								{
									'border-info text-3 text-info': !active,
									'btn-info text-3': active,
								}
							)}
							displayType="secondary"
						>
							<Badge
								className={classnames({
									'mr-2 badge-info': !active,
									'mr-2 badge-light': active,
								})}
								label={processingTasks}
							/>

							{processingTasks === 1
								? Liferay.Language.get('processing-task')
								: Liferay.Language.get('processing-tasks')}
						</ClayButton>
					) : null}
				</div>
			}
		>
			<>
				<BulkActionsMonitorItemList items={tasks} />

				{tasksLoading ? (
					<div className="task-status-loading">
						<span className="loading-animation text-secondary" />
					</div>
				) : null}

				<div className="p-1">
					<ClayLink
						block
						className="btn btn-block btn-secondary task-status-view-all text-3"
						displayType="secondary"
						href={URL_TASKS_REPORT}
					>
						{Liferay.Language.get('view-all-tasks')}
					</ClayLink>
				</div>
			</>
		</DropDown>
	) : null;
}

export default BulkActionsMonitor;
