/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.expando.exportimport.internal.data.handler;


import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.adapter.StagedExpandoTable;
import com.liferay.expando.kernel.model.adapter.StagedExpandoValue;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.adapter.ModelAdapterUtil;
import com.liferay.portal.kernel.xml.Element;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.sound.sampled.Port;
import java.util.List;

/**
 * @author Murilo Stodolni
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class StagedExpandoValueStagedModelDataHandler extends
	BaseStagedModelDataHandler<StagedExpandoValue> {

	public static final String[] CLASS_NAMES = {
		StagedExpandoValue.class.getName()
	};


	@Override
	public void deleteStagedModel(
		String uuid, long groupId, String className, String extraData)
		throws PortalException {
		_stagedModelRepository.deleteStagedModel(uuid, groupId, className, extraData);
	}

	@Override
	public void deleteStagedModel(StagedExpandoValue stagedExpandoValue)
		throws PortalException {
		_stagedModelRepository.deleteStagedModel(stagedExpandoValue );
	}

	@Override
	public List<StagedExpandoValue> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _stagedModelRepository.fetchStagedModelsByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doExportStagedModel(
		PortletDataContext portletDataContext, StagedExpandoValue stagedExpandoValue)
		throws Exception {
		ExpandoTable expandoTable = _expandoTableLocalService.getTable(
			stagedExpandoValue.getTableId());

		StagedExpandoTable stagedExpandoTable = ModelAdapterUtil.adapt(expandoTable, ExpandoTable.class, StagedExpandoTable.class);

		StagedModelDataHandlerUtil.exportReferenceStagedModel(portletDataContext, stagedExpandoValue, stagedExpandoTable,
			PortletDataContext.REFERENCE_TYPE_PARENT);

		Element stagedExpandoValueElement = portletDataContext.getExportDataElement(stagedExpandoValue);

		portletDataContext.addClassedModel(stagedExpandoValueElement, ExportImportPathUtil.getModelPath(stagedExpandoValue), stagedExpandoValue);
	}

	@Override
	protected void doImportStagedModel(
		PortletDataContext portletDataContext, StagedExpandoValue stagedExpandoValue)
		throws Exception {
		System.out.println("AINDA NAO FOI IMPLEMENTADAAAAAAAAAAAA");
	}

	@Reference
	private ExpandoTableLocalService _expandoTableLocalService;

	private StagedModelRepository<StagedExpandoValue> _stagedModelRepository;
}
