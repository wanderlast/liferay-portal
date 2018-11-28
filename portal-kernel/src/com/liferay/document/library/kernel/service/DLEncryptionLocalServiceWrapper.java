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

package com.liferay.document.library.kernel.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DLEncryptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryptionLocalService
 * @generated
 */
@ProviderType
public class DLEncryptionLocalServiceWrapper implements DLEncryptionLocalService,
	ServiceWrapper<DLEncryptionLocalService> {
	public DLEncryptionLocalServiceWrapper(
		DLEncryptionLocalService dlEncryptionLocalService) {
		_dlEncryptionLocalService = dlEncryptionLocalService;
	}

	/**
	* Adds the document library encryption to the database. Also notifies the appropriate model listeners.
	*
	* @param dlEncryption the document library encryption
	* @return the document library encryption that was added
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption addDLEncryption(
		com.liferay.document.library.kernel.model.DLEncryption dlEncryption) {
		return _dlEncryptionLocalService.addDLEncryption(dlEncryption);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this class directly. Always use {@link DLEncryptionLocalServiceUtil} to access the document library encryption local service.
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption addDLEncryption(
		long fileEntryId, long fileVersionId, String status)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.addDLEncryption(fileEntryId,
			fileVersionId, status);
	}

	/**
	* Creates a new document library encryption with the primary key. Does not add the document library encryption to the database.
	*
	* @param fileEncryptionId the primary key for the new document library encryption
	* @return the new document library encryption
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption createDLEncryption(
		long fileEncryptionId) {
		return _dlEncryptionLocalService.createDLEncryption(fileEncryptionId);
	}

	/**
	* Deletes the document library encryption from the database. Also notifies the appropriate model listeners.
	*
	* @param dlEncryption the document library encryption
	* @return the document library encryption that was removed
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption deleteDLEncryption(
		com.liferay.document.library.kernel.model.DLEncryption dlEncryption) {
		return _dlEncryptionLocalService.deleteDLEncryption(dlEncryption);
	}

	/**
	* Deletes the document library encryption with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption that was removed
	* @throws PortalException if a document library encryption with the primary key could not be found
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption deleteDLEncryption(
		long fileEncryptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.deleteDLEncryption(fileEncryptionId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dlEncryptionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dlEncryptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _dlEncryptionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _dlEncryptionLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _dlEncryptionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _dlEncryptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLEncryption fetchDLEncryption(
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return _dlEncryptionLocalService.fetchDLEncryption(fileVersion);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLEncryption fetchDLEncryption(
		long fileEncryptionId) {
		return _dlEncryptionLocalService.fetchDLEncryption(fileEncryptionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dlEncryptionLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the document library encryption with the primary key.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption
	* @throws PortalException if a document library encryption with the primary key could not be found
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption getDLEncryption(
		long fileEncryptionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.getDLEncryption(fileEncryptionId);
	}

	/**
	* Returns a range of all the document library encryptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.portlet.documentlibrary.model.impl.DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @return the range of document library encryptions
	*/
	@Override
	public java.util.List<com.liferay.document.library.kernel.model.DLEncryption> getDLEncryptions(
		int start, int end) {
		return _dlEncryptionLocalService.getDLEncryptions(start, end);
	}

	/**
	* Returns the number of document library encryptions.
	*
	* @return the number of document library encryptions
	*/
	@Override
	public int getDLEncryptionsCount() {
		return _dlEncryptionLocalService.getDLEncryptionsCount();
	}

	@Override
	public String getDLEncryptionStatus(
		com.liferay.portal.kernel.repository.model.FileVersion fileVersion) {
		return _dlEncryptionLocalService.getDLEncryptionStatus(fileVersion);
	}

	@Override
	public String getDLEncryptionStatus(long fileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.getDLEncryptionStatus(fileEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dlEncryptionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _dlEncryptionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dlEncryptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the document library encryption in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dlEncryption the document library encryption
	* @return the document library encryption that was updated
	*/
	@Override
	public com.liferay.document.library.kernel.model.DLEncryption updateDLEncryption(
		com.liferay.document.library.kernel.model.DLEncryption dlEncryption) {
		return _dlEncryptionLocalService.updateDLEncryption(dlEncryption);
	}

	@Override
	public DLEncryptionLocalService getWrappedService() {
		return _dlEncryptionLocalService;
	}

	@Override
	public void setWrappedService(
		DLEncryptionLocalService dlEncryptionLocalService) {
		_dlEncryptionLocalService = dlEncryptionLocalService;
	}

	private DLEncryptionLocalService _dlEncryptionLocalService;
}