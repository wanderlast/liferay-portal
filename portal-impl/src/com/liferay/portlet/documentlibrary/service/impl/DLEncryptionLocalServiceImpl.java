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

package com.liferay.portlet.documentlibrary.service.impl;

import com.liferay.document.library.kernel.model.DLEncryption;
import com.liferay.document.library.kernel.model.DLEncryptionConstants;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.persistence.DLEncryptionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portlet.documentlibrary.service.base.DLEncryptionLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the document library encryption local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.document.library.kernel.service.DLEncryptionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryptionLocalServiceBaseImpl
 * @see com.liferay.document.library.kernel.service.DLEncryptionLocalServiceUtil
 */
public class DLEncryptionLocalServiceImpl
	extends DLEncryptionLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.document.library.kernel.service.DLEncryptionLocalServiceUtil} to access the document library encryption local service.
	 */
	public DLEncryption addDLEncryption(long fileEntryId, long fileVersionId)
		throws PortalException {

		return addDLEncryption(
			fileEntryId, fileVersionId,
			DLEncryptionConstants.STATUS_NOT_CREATED);
	}

	public DLEncryption addDLEncryption(
			long fileEntryId, long fileVersionId, String status)
		throws PortalException {

		long fileEncryptionId = counterLocalService.increment();

		DLEncryption dlEncryption = dlEncryptionPersistence.create(
			fileEncryptionId);

		dlEncryption.setFileEntryId(fileEntryId);
		dlEncryption.setFileVersionId(fileVersionId);
		dlEncryption.setStatus(status);

		DLFileEntry dlFileEntry = dlFileEntryLocalService.getDLFileEntry(
			fileEntryId);

		long groupId = dlFileEntry.getGroupId();

		dlEncryption.setGroupId(groupId);

		dlEncryptionPersistence.update(dlEncryption);

		return dlEncryption;
	}

	public DLEncryption fetchDLEncryption(FileVersion fileVersion) {
		long fileVersionId = fileVersion.getFileVersionId();

		List<DLEncryption> dlEncryptionList =
			DLEncryptionUtil.findByFileVersionId(fileVersionId);

		if (dlEncryptionList.isEmpty()) {
			return null;
		}

		return dlEncryptionList.get(0);
	}

	public String getDLEncryptionStatus(FileVersion fileVersion) {
		long fileVersionId = fileVersion.getFileVersionId();

		List<DLEncryption> dlEncryptionList =
			DLEncryptionUtil.findByFileVersionId(fileVersionId);

		if (dlEncryptionList.isEmpty()) {
			return null;
		}

		DLEncryption dlEncryption = dlEncryptionList.get(0);

		return dlEncryption.getStatus();
	}

	public String getDLEncryptionStatus(long fileEntryId)
		throws PortalException {

		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(
			fileEntryId);

		FileVersion fileVersion = (FileVersion)fileEntry.getLatestFileVersion(
			true);

		return getDLEncryptionStatus(fileVersion);
	}

	public DLEncryption updateDLEncryption(
		long dlEncryptionId, long fileEntryId, long fileVersionId,
		String status) {

		DLEncryption dlEncryption = DLEncryptionUtil.fetchByPrimaryKey(
			dlEncryptionId);

		dlEncryption.setFileEntryId(fileEntryId);
		dlEncryption.setFileVersionId(fileVersionId);
		dlEncryption.setStatus(status);

		dlEncryptionPersistence.update(dlEncryption);

		return dlEncryption;
	}

}