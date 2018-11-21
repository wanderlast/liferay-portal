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

package com.liferay.document.library.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DLEncryption}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryption
 * @generated
 */
@ProviderType
public class DLEncryptionWrapper implements DLEncryption,
	ModelWrapper<DLEncryption> {
	public DLEncryptionWrapper(DLEncryption dlEncryption) {
		_dlEncryption = dlEncryption;
	}

	@Override
	public Class<?> getModelClass() {
		return DLEncryption.class;
	}

	@Override
	public String getModelClassName() {
		return DLEncryption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileEncryptionId", getFileEncryptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileVersionId", getFileVersionId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileEncryptionId = (Long)attributes.get("fileEncryptionId");

		if (fileEncryptionId != null) {
			setFileEncryptionId(fileEncryptionId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long fileVersionId = (Long)attributes.get("fileVersionId");

		if (fileVersionId != null) {
			setFileVersionId(fileVersionId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Object clone() {
		return new DLEncryptionWrapper((DLEncryption)_dlEncryption.clone());
	}

	@Override
	public int compareTo(DLEncryption dlEncryption) {
		return _dlEncryption.compareTo(dlEncryption);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dlEncryption.getExpandoBridge();
	}

	/**
	* Returns the file encryption ID of this document library encryption.
	*
	* @return the file encryption ID of this document library encryption
	*/
	@Override
	public long getFileEncryptionId() {
		return _dlEncryption.getFileEncryptionId();
	}

	/**
	* Returns the file entry ID of this document library encryption.
	*
	* @return the file entry ID of this document library encryption
	*/
	@Override
	public long getFileEntryId() {
		return _dlEncryption.getFileEntryId();
	}

	/**
	* Returns the file version ID of this document library encryption.
	*
	* @return the file version ID of this document library encryption
	*/
	@Override
	public long getFileVersionId() {
		return _dlEncryption.getFileVersionId();
	}

	/**
	* Returns the group ID of this document library encryption.
	*
	* @return the group ID of this document library encryption
	*/
	@Override
	public long getGroupId() {
		return _dlEncryption.getGroupId();
	}

	/**
	* Returns the primary key of this document library encryption.
	*
	* @return the primary key of this document library encryption
	*/
	@Override
	public long getPrimaryKey() {
		return _dlEncryption.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dlEncryption.getPrimaryKeyObj();
	}

	/**
	* Returns the status of this document library encryption.
	*
	* @return the status of this document library encryption
	*/
	@Override
	public String getStatus() {
		return _dlEncryption.getStatus();
	}

	@Override
	public int hashCode() {
		return _dlEncryption.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dlEncryption.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dlEncryption.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dlEncryption.isNew();
	}

	@Override
	public void persist() {
		_dlEncryption.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dlEncryption.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dlEncryption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dlEncryption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dlEncryption.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file encryption ID of this document library encryption.
	*
	* @param fileEncryptionId the file encryption ID of this document library encryption
	*/
	@Override
	public void setFileEncryptionId(long fileEncryptionId) {
		_dlEncryption.setFileEncryptionId(fileEncryptionId);
	}

	/**
	* Sets the file entry ID of this document library encryption.
	*
	* @param fileEntryId the file entry ID of this document library encryption
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_dlEncryption.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the file version ID of this document library encryption.
	*
	* @param fileVersionId the file version ID of this document library encryption
	*/
	@Override
	public void setFileVersionId(long fileVersionId) {
		_dlEncryption.setFileVersionId(fileVersionId);
	}

	/**
	* Sets the group ID of this document library encryption.
	*
	* @param groupId the group ID of this document library encryption
	*/
	@Override
	public void setGroupId(long groupId) {
		_dlEncryption.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_dlEncryption.setNew(n);
	}

	/**
	* Sets the primary key of this document library encryption.
	*
	* @param primaryKey the primary key of this document library encryption
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dlEncryption.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dlEncryption.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this document library encryption.
	*
	* @param status the status of this document library encryption
	*/
	@Override
	public void setStatus(String status) {
		_dlEncryption.setStatus(status);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<DLEncryption> toCacheModel() {
		return _dlEncryption.toCacheModel();
	}

	@Override
	public DLEncryption toEscapedModel() {
		return new DLEncryptionWrapper(_dlEncryption.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dlEncryption.toString();
	}

	@Override
	public DLEncryption toUnescapedModel() {
		return new DLEncryptionWrapper(_dlEncryption.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dlEncryption.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DLEncryptionWrapper)) {
			return false;
		}

		DLEncryptionWrapper dlEncryptionWrapper = (DLEncryptionWrapper)obj;

		if (Objects.equals(_dlEncryption, dlEncryptionWrapper._dlEncryption)) {
			return true;
		}

		return false;
	}

	@Override
	public DLEncryption getWrappedModel() {
		return _dlEncryption;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dlEncryption.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dlEncryption.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dlEncryption.resetOriginalValues();
	}

	private final DLEncryption _dlEncryption;
}