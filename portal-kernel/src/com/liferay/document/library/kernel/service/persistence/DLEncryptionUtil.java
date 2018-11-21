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

package com.liferay.document.library.kernel.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.kernel.model.DLEncryption;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the document library encryption service. This utility wraps {@link com.liferay.portlet.documentlibrary.service.persistence.impl.DLEncryptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryptionPersistence
 * @see com.liferay.portlet.documentlibrary.service.persistence.impl.DLEncryptionPersistenceImpl
 * @generated
 */
@ProviderType
public class DLEncryptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(DLEncryption dlEncryption) {
		getPersistence().clearCache(dlEncryption);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DLEncryption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DLEncryption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DLEncryption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DLEncryption update(DLEncryption dlEncryption) {
		return getPersistence().update(dlEncryption);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DLEncryption update(DLEncryption dlEncryption,
		ServiceContext serviceContext) {
		return getPersistence().update(dlEncryption, serviceContext);
	}

	/**
	* Returns all the document library encryptions where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching document library encryptions
	*/
	public static List<DLEncryption> findByFileEntryId(long fileEntryId) {
		return getPersistence().findByFileEntryId(fileEntryId);
	}

	/**
	* Returns a range of all the document library encryptions where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @return the range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end) {
		return getPersistence().findByFileEntryId(fileEntryId, start, end);
	}

	/**
	* Returns an ordered range of all the document library encryptions where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .findByFileEntryId(fileEntryId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the document library encryptions where fileEntryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileEntryId the file entry ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFileEntryId(fileEntryId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public static DLEncryption findByFileEntryId_First(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileEntryId_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public static DLEncryption fetchByFileEntryId_First(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .fetchByFileEntryId_First(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public static DLEncryption findByFileEntryId_Last(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileEntryId_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public static DLEncryption fetchByFileEntryId_Last(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .fetchByFileEntryId_Last(fileEntryId, orderByComparator);
	}

	/**
	* Returns the document library encryptions before and after the current document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEncryptionId the primary key of the current document library encryption
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public static DLEncryption[] findByFileEntryId_PrevAndNext(
		long fileEncryptionId, long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileEntryId_PrevAndNext(fileEncryptionId,
			fileEntryId, orderByComparator);
	}

	/**
	* Removes all the document library encryptions where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	*/
	public static void removeByFileEntryId(long fileEntryId) {
		getPersistence().removeByFileEntryId(fileEntryId);
	}

	/**
	* Returns the number of document library encryptions where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching document library encryptions
	*/
	public static int countByFileEntryId(long fileEntryId) {
		return getPersistence().countByFileEntryId(fileEntryId);
	}

	/**
	* Returns all the document library encryptions where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @return the matching document library encryptions
	*/
	public static List<DLEncryption> findByFileVersionId(long fileVersionId) {
		return getPersistence().findByFileVersionId(fileVersionId);
	}

	/**
	* Returns a range of all the document library encryptions where fileVersionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileVersionId the file version ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @return the range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end) {
		return getPersistence().findByFileVersionId(fileVersionId, start, end);
	}

	/**
	* Returns an ordered range of all the document library encryptions where fileVersionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileVersionId the file version ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .findByFileVersionId(fileVersionId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the document library encryptions where fileVersionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileVersionId the file version ID
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching document library encryptions
	*/
	public static List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFileVersionId(fileVersionId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public static DLEncryption findByFileVersionId_First(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileVersionId_First(fileVersionId, orderByComparator);
	}

	/**
	* Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public static DLEncryption fetchByFileVersionId_First(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .fetchByFileVersionId_First(fileVersionId, orderByComparator);
	}

	/**
	* Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public static DLEncryption findByFileVersionId_Last(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileVersionId_Last(fileVersionId, orderByComparator);
	}

	/**
	* Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public static DLEncryption fetchByFileVersionId_Last(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence()
				   .fetchByFileVersionId_Last(fileVersionId, orderByComparator);
	}

	/**
	* Returns the document library encryptions before and after the current document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileEncryptionId the primary key of the current document library encryption
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public static DLEncryption[] findByFileVersionId_PrevAndNext(
		long fileEncryptionId, long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence()
				   .findByFileVersionId_PrevAndNext(fileEncryptionId,
			fileVersionId, orderByComparator);
	}

	/**
	* Removes all the document library encryptions where fileVersionId = &#63; from the database.
	*
	* @param fileVersionId the file version ID
	*/
	public static void removeByFileVersionId(long fileVersionId) {
		getPersistence().removeByFileVersionId(fileVersionId);
	}

	/**
	* Returns the number of document library encryptions where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @return the number of matching document library encryptions
	*/
	public static int countByFileVersionId(long fileVersionId) {
		return getPersistence().countByFileVersionId(fileVersionId);
	}

	/**
	* Caches the document library encryption in the entity cache if it is enabled.
	*
	* @param dlEncryption the document library encryption
	*/
	public static void cacheResult(DLEncryption dlEncryption) {
		getPersistence().cacheResult(dlEncryption);
	}

	/**
	* Caches the document library encryptions in the entity cache if it is enabled.
	*
	* @param dlEncryptions the document library encryptions
	*/
	public static void cacheResult(List<DLEncryption> dlEncryptions) {
		getPersistence().cacheResult(dlEncryptions);
	}

	/**
	* Creates a new document library encryption with the primary key. Does not add the document library encryption to the database.
	*
	* @param fileEncryptionId the primary key for the new document library encryption
	* @return the new document library encryption
	*/
	public static DLEncryption create(long fileEncryptionId) {
		return getPersistence().create(fileEncryptionId);
	}

	/**
	* Removes the document library encryption with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption that was removed
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public static DLEncryption remove(long fileEncryptionId)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence().remove(fileEncryptionId);
	}

	public static DLEncryption updateImpl(DLEncryption dlEncryption) {
		return getPersistence().updateImpl(dlEncryption);
	}

	/**
	* Returns the document library encryption with the primary key or throws a {@link NoSuchEncryptionException} if it could not be found.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public static DLEncryption findByPrimaryKey(long fileEncryptionId)
		throws com.liferay.document.library.kernel.exception.NoSuchEncryptionException {
		return getPersistence().findByPrimaryKey(fileEncryptionId);
	}

	/**
	* Returns the document library encryption with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption, or <code>null</code> if a document library encryption with the primary key could not be found
	*/
	public static DLEncryption fetchByPrimaryKey(long fileEncryptionId) {
		return getPersistence().fetchByPrimaryKey(fileEncryptionId);
	}

	public static java.util.Map<java.io.Serializable, DLEncryption> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the document library encryptions.
	*
	* @return the document library encryptions
	*/
	public static List<DLEncryption> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the document library encryptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @return the range of document library encryptions
	*/
	public static List<DLEncryption> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the document library encryptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of document library encryptions
	*/
	public static List<DLEncryption> findAll(int start, int end,
		OrderByComparator<DLEncryption> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the document library encryptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of document library encryptions
	* @param end the upper bound of the range of document library encryptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of document library encryptions
	*/
	public static List<DLEncryption> findAll(int start, int end,
		OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the document library encryptions from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of document library encryptions.
	*
	* @return the number of document library encryptions
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DLEncryptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DLEncryptionPersistence)PortalBeanLocatorUtil.locate(DLEncryptionPersistence.class.getName());

			ReferenceRegistry.registerReference(DLEncryptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static DLEncryptionPersistence _persistence;
}