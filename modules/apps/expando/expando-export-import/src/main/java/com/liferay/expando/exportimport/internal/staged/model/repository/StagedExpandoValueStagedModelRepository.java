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

package com.liferay.expando.exportimport.internal.staged.model.repository;

import com.liferay.expando.kernel.model.adapter.StagedExpandoValue;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Murilo Stodolni
 */
public class StagedExpandoValueStagedModelRepository implements
	StagedModelRepository<StagedExpandoValue> {

	@Override
	public StagedExpandoValue addStagedModel(
		PortletDataContext portletDataContext, StagedExpandoValue stagedExpandoValue)
		throws PortalException {

		System.out.println("ADD STAGED MODEL");
		return null;
	}

	@Override
	public void deleteStagedModel(
		String uuid, long groupId, String className, String extraData)
		throws PortalException {
		System.out.println("DELETE STAGED MODEL");
	}

	@Override
	public void deleteStagedModel(StagedExpandoValue stagedExpandoValue)
		throws PortalException {
		System.out.println("DELETE STAGED MODEL 2");

	}

	@Override
	public void deleteStagedModels(PortletDataContext portletDataContext)
		throws PortalException {
		System.out.println("DELETE STAGED MODEL 3");
	}

	@Override
	public StagedExpandoValue fetchStagedModelByUuidAndGroupId(
		String uuid, long groupId) {

		System.out.println("FECTH STAGED MODEL");


		return null;
	}

	@Override
	public List<StagedExpandoValue> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {

		System.out.println("FETCH STAGED MODEL 2");
		return null;
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext) {

		System.out.println("GET STAGED MODEL");
		return null;
	}

	@Override
	public StagedExpandoValue saveStagedModel(StagedExpandoValue stagedExpandoValue)
		throws PortalException {

		System.out.println("SAVE STAGED MODEL");
		return null;
	}

	@Override
	public StagedExpandoValue updateStagedModel(
		PortletDataContext portletDataContext, StagedExpandoValue stagedExpandoValue)
		throws PortalException {

		System.out.println("UPDATE STAGED MODEL");
		return null;
	}
}
