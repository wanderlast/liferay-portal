/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export const OBJECT_DEFINITION_CLASS_NAME =
	'com.liferay.object.model.ObjectDefinition';
export const OBJECT_ENTRY_FOLDER_CLASS_NAME =
	'com.liferay.object.model.ObjectEntryFolder';

export const ENTERPRISE_URL = 'https://www.liferay.com/en/contact-sales';

export const ERC_MAX_LENGTH = 75;

export const FDS_EVENT_UPDATE_DISPLAY = 'fds-update-display';

export const ROOT_FOLDER_ERC = {
	CONTENTS: 'L_CONTENTS',
	FILES: 'L_FILES',
} as const;

export const ROOT_FOLDER_ERCS: ReadonlySet<string> = new Set([
	ROOT_FOLDER_ERC.CONTENTS,
	ROOT_FOLDER_ERC.FILES,
]);

export function isRootFolderERC(erc: string | undefined) {
	return !!erc && ROOT_FOLDER_ERCS.has(erc);
}
