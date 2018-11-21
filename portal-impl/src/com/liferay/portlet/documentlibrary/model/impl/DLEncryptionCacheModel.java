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

package com.liferay.portlet.documentlibrary.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.kernel.model.DLEncryption;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DLEncryption in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryption
 * @generated
 */
@ProviderType
public class DLEncryptionCacheModel implements CacheModel<DLEncryption>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DLEncryptionCacheModel)) {
			return false;
		}

		DLEncryptionCacheModel dlEncryptionCacheModel = (DLEncryptionCacheModel)obj;

		if (fileEncryptionId == dlEncryptionCacheModel.fileEncryptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileEncryptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{fileEncryptionId=");
		sb.append(fileEncryptionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileVersionId=");
		sb.append(fileVersionId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DLEncryption toEntityModel() {
		DLEncryptionImpl dlEncryptionImpl = new DLEncryptionImpl();

		dlEncryptionImpl.setFileEncryptionId(fileEncryptionId);
		dlEncryptionImpl.setGroupId(groupId);
		dlEncryptionImpl.setFileEntryId(fileEntryId);
		dlEncryptionImpl.setFileVersionId(fileVersionId);

		if (status == null) {
			dlEncryptionImpl.setStatus("");
		}
		else {
			dlEncryptionImpl.setStatus(status);
		}

		dlEncryptionImpl.resetOriginalValues();

		return dlEncryptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileEncryptionId = objectInput.readLong();

		groupId = objectInput.readLong();

		fileEntryId = objectInput.readLong();

		fileVersionId = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fileEncryptionId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(fileEntryId);

		objectOutput.writeLong(fileVersionId);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long fileEncryptionId;
	public long groupId;
	public long fileEntryId;
	public long fileVersionId;
	public String status;
}