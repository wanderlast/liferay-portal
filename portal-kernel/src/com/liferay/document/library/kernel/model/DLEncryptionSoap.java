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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portlet.documentlibrary.service.http.DLEncryptionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.documentlibrary.service.http.DLEncryptionServiceSoap
 * @generated
 */
@ProviderType
public class DLEncryptionSoap implements Serializable {
	public static DLEncryptionSoap toSoapModel(DLEncryption model) {
		DLEncryptionSoap soapModel = new DLEncryptionSoap();

		soapModel.setFileEncryptionId(model.getFileEncryptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileVersionId(model.getFileVersionId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static DLEncryptionSoap[] toSoapModels(DLEncryption[] models) {
		DLEncryptionSoap[] soapModels = new DLEncryptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DLEncryptionSoap[][] toSoapModels(DLEncryption[][] models) {
		DLEncryptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DLEncryptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DLEncryptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DLEncryptionSoap[] toSoapModels(List<DLEncryption> models) {
		List<DLEncryptionSoap> soapModels = new ArrayList<DLEncryptionSoap>(models.size());

		for (DLEncryption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DLEncryptionSoap[soapModels.size()]);
	}

	public DLEncryptionSoap() {
	}

	public long getPrimaryKey() {
		return _fileEncryptionId;
	}

	public void setPrimaryKey(long pk) {
		setFileEncryptionId(pk);
	}

	public long getFileEncryptionId() {
		return _fileEncryptionId;
	}

	public void setFileEncryptionId(long fileEncryptionId) {
		_fileEncryptionId = fileEncryptionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getFileVersionId() {
		return _fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		_fileVersionId = fileVersionId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _fileEncryptionId;
	private long _groupId;
	private long _fileEntryId;
	private long _fileVersionId;
	private String _status;
}