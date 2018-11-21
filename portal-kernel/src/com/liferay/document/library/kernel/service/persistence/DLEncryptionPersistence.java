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

import com.liferay.document.library.kernel.exception.NoSuchEncryptionException;
import com.liferay.document.library.kernel.model.DLEncryption;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the document library encryption service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.documentlibrary.service.persistence.impl.DLEncryptionPersistenceImpl
 * @see DLEncryptionUtil
 * @generated
 */
@ProviderType
public interface DLEncryptionPersistence extends BasePersistence<DLEncryption> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DLEncryptionUtil} to access the document library encryption persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the document library encryptions where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the matching document library encryptions
	*/
	public java.util.List<DLEncryption> findByFileEntryId(long fileEntryId);

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
	public java.util.List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end);

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
	public java.util.List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

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
	public java.util.List<DLEncryption> findByFileEntryId(long fileEntryId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public DLEncryption findByFileEntryId_First(long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public DLEncryption fetchByFileEntryId_First(long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

	/**
	* Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public DLEncryption findByFileEntryId_Last(long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public DLEncryption fetchByFileEntryId_Last(long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

	/**
	* Returns the document library encryptions before and after the current document library encryption in the ordered set where fileEntryId = &#63;.
	*
	* @param fileEncryptionId the primary key of the current document library encryption
	* @param fileEntryId the file entry ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public DLEncryption[] findByFileEntryId_PrevAndNext(long fileEncryptionId,
		long fileEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Removes all the document library encryptions where fileEntryId = &#63; from the database.
	*
	* @param fileEntryId the file entry ID
	*/
	public void removeByFileEntryId(long fileEntryId);

	/**
	* Returns the number of document library encryptions where fileEntryId = &#63;.
	*
	* @param fileEntryId the file entry ID
	* @return the number of matching document library encryptions
	*/
	public int countByFileEntryId(long fileEntryId);

	/**
	* Returns all the document library encryptions where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @return the matching document library encryptions
	*/
	public java.util.List<DLEncryption> findByFileVersionId(long fileVersionId);

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
	public java.util.List<DLEncryption> findByFileVersionId(
		long fileVersionId, int start, int end);

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
	public java.util.List<DLEncryption> findByFileVersionId(
		long fileVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

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
	public java.util.List<DLEncryption> findByFileVersionId(
		long fileVersionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public DLEncryption findByFileVersionId_First(long fileVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public DLEncryption fetchByFileVersionId_First(long fileVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

	/**
	* Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption
	* @throws NoSuchEncryptionException if a matching document library encryption could not be found
	*/
	public DLEncryption findByFileVersionId_Last(long fileVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	*/
	public DLEncryption fetchByFileVersionId_Last(long fileVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

	/**
	* Returns the document library encryptions before and after the current document library encryption in the ordered set where fileVersionId = &#63;.
	*
	* @param fileEncryptionId the primary key of the current document library encryption
	* @param fileVersionId the file version ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public DLEncryption[] findByFileVersionId_PrevAndNext(
		long fileEncryptionId, long fileVersionId,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException;

	/**
	* Removes all the document library encryptions where fileVersionId = &#63; from the database.
	*
	* @param fileVersionId the file version ID
	*/
	public void removeByFileVersionId(long fileVersionId);

	/**
	* Returns the number of document library encryptions where fileVersionId = &#63;.
	*
	* @param fileVersionId the file version ID
	* @return the number of matching document library encryptions
	*/
	public int countByFileVersionId(long fileVersionId);

	/**
	* Caches the document library encryption in the entity cache if it is enabled.
	*
	* @param dlEncryption the document library encryption
	*/
	public void cacheResult(DLEncryption dlEncryption);

	/**
	* Caches the document library encryptions in the entity cache if it is enabled.
	*
	* @param dlEncryptions the document library encryptions
	*/
	public void cacheResult(java.util.List<DLEncryption> dlEncryptions);

	/**
	* Creates a new document library encryption with the primary key. Does not add the document library encryption to the database.
	*
	* @param fileEncryptionId the primary key for the new document library encryption
	* @return the new document library encryption
	*/
	public DLEncryption create(long fileEncryptionId);

	/**
	* Removes the document library encryption with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption that was removed
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public DLEncryption remove(long fileEncryptionId)
		throws NoSuchEncryptionException;

	public DLEncryption updateImpl(DLEncryption dlEncryption);

	/**
	* Returns the document library encryption with the primary key or throws a {@link NoSuchEncryptionException} if it could not be found.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption
	* @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	*/
	public DLEncryption findByPrimaryKey(long fileEncryptionId)
		throws NoSuchEncryptionException;

	/**
	* Returns the document library encryption with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileEncryptionId the primary key of the document library encryption
	* @return the document library encryption, or <code>null</code> if a document library encryption with the primary key could not be found
	*/
	public DLEncryption fetchByPrimaryKey(long fileEncryptionId);

	@Override
	public java.util.Map<java.io.Serializable, DLEncryption> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the document library encryptions.
	*
	* @return the document library encryptions
	*/
	public java.util.List<DLEncryption> findAll();

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
	public java.util.List<DLEncryption> findAll(int start, int end);

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
	public java.util.List<DLEncryption> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator);

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
	public java.util.List<DLEncryption> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the document library encryptions from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of document library encryptions.
	*
	* @return the number of document library encryptions
	*/
	public int countAll();
}