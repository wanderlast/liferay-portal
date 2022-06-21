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

package com.liferay.expando.exportimport.internal.model.adapter;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.model.adapter.StagedExpandoValue;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Murilo Stodolni
 */
public class StagedExpandoValueImpl implements StagedExpandoValue {

	public StagedExpandoValueImpl() {
	}

	public StagedExpandoValueImpl(ExpandoValue expandoValue) {
		_expandoValue = expandoValue;

		ExpandoTable expandoTable = null;

		try {
			expandoTable = ExpandoTableLocalServiceUtil.getExpandoTable(
				expandoValue.getTableId());
		}
		catch (PortalException portalException) {
			throw new RuntimeException(
				"Could not find expando table for tableId=" +
				expandoValue.getTableId(),
				portalException);
		}

		_expandoTableClassName = expandoTable.getClassName();
		_expandoTableName = expandoTable.getName();
	}

	@Override
	public Object clone() {
		StagedExpandoValueImpl stagedExpandoValueImpl =
			new StagedExpandoValueImpl();

		stagedExpandoValueImpl._expandoValue =
			(ExpandoValue) _expandoValue.clone();

		return stagedExpandoValueImpl;
	}

	@Override
	public ExpandoValue cloneWithOriginalValues() {
		return (ExpandoValue)clone();
	}

	@Override
	public int compareTo(ExpandoValue expandoValue) {
		return _expandoValue.compareTo(expandoValue);
	}

	@Override
	public List<Locale> getAvailableLocales() throws PortalException {
		return _expandoValue.getAvailableLocales();
	}

	@Override
	public boolean getBoolean() throws PortalException {
		return _expandoValue.getBoolean();
	}

	@Override
	public boolean[] getBooleanArray() throws PortalException {
		return _expandoValue.getBooleanArray();
	}

	@Override
	public ExpandoColumn getColumn() throws PortalException {
		return _expandoValue.getColumn();
	}

	@Override
	public Date getDate() throws PortalException {
		return _expandoValue.getDate();
	}

	@Override
	public Date[] getDateArray() throws PortalException {
		return _expandoValue.getDateArray();
	}

	@Override
	public Locale getDefaultLocale() throws PortalException {
		return _expandoValue.getDefaultLocale();
	}

	@Override
	public double getDouble() throws PortalException {
		return _expandoValue.getDouble();
	}

	@Override
	public double[] getDoubleArray() throws PortalException {
		return _expandoValue.getDoubleArray();
	}

	@Override
	public float getFloat() throws PortalException {
		return _expandoValue.getFloat();
	}

	@Override
	public float[] getFloatArray() throws PortalException {
		return _expandoValue.getFloatArray();
	}

	@Override
	public JSONObject getGeolocationJSONObject() throws PortalException {
		return _expandoValue.getGeolocationJSONObject();
	}

	@Override
	public int getInteger() throws PortalException {
		return _expandoValue.getInteger();
	}

	@Override
	public int[] getIntegerArray() throws PortalException {
		return _expandoValue.getIntegerArray();
	}

	@Override
	public long getLong() throws PortalException {
		return _expandoValue.getLong();
	}

	@Override
	public long[] getLongArray() throws PortalException {
		return _expandoValue.getLongArray();
	}

	@Override
	public Number getNumber() throws PortalException {
		return _expandoValue.getNumber();
	}

	@Override
	public Number[] getNumberArray() throws PortalException {
		return _expandoValue.getNumberArray();
	}

	@Override
	public Serializable getSerializable() throws PortalException {
		return _expandoValue.getSerializable();
	}

	@Override
	public short getShort() throws PortalException {
		return _expandoValue.getShort();
	}

	@Override
	public short[] getShortArray() throws PortalException {
		return _expandoValue.getShortArray();
	}

	@Override
	public String getString() throws PortalException {
		return _expandoValue.getString();
	}

	@Override
	public String getString(Locale locale) throws PortalException {
		return _expandoValue.getString(locale);
	}

	@Override
	public String[] getStringArray() throws PortalException {
		return _expandoValue.getStringArray();
	}

	@Override
	public String[] getStringArray(Locale locale) throws PortalException {
		return _expandoValue.getStringArray(locale);
	}

	@Override
	public Map<Locale, String[]> getStringArrayMap() throws PortalException {
		return _expandoValue.getStringArrayMap();
	}

	@Override
	public Map<Locale, String> getStringMap() throws PortalException {
		return _expandoValue.getStringMap();
	}

	@Override
	public void setBoolean(boolean data) throws PortalException {
		_expandoValue.setBoolean(data);
	}

	@Override
	public void setBooleanArray(boolean[] data) throws PortalException {
		_expandoValue.setBooleanArray(data);
	}

	@Override
	public void setColumn(ExpandoColumn column) {
		_expandoValue.setColumn(column);
	}

	@Override
	public void setDate(Date data) throws PortalException {
		_expandoValue.setDate(data);
	}

	@Override
	public void setDateArray(Date[] data) throws PortalException {
		_expandoValue.setDateArray(data);
	}

	@Override
	public void setDouble(double data) throws PortalException {
		_expandoValue.setDouble(data);
	}

	@Override
	public void setDoubleArray(double[] data) throws PortalException {
		_expandoValue.setDoubleArray(data);
	}

	@Override
	public void setFloat(float data) throws PortalException {
		_expandoValue.setFloat(data);
	}

	@Override
	public void setFloatArray(float[] data) throws PortalException {
		_expandoValue.setFloatArray(data);
	}

	@Override
	public void setGeolocationJSONObject(JSONObject dataJSONObject)
		throws PortalException {
		_expandoValue.setGeolocationJSONObject(dataJSONObject);
	}

	@Override
	public void setInteger(int data) throws PortalException {
		_expandoValue.setInteger(data);
	}

	@Override
	public void setIntegerArray(int[] data) throws PortalException {
		_expandoValue.setIntegerArray(data);
	}

	@Override
	public void setLong(long data) throws PortalException {
		_expandoValue.setLong(data);
	}

	@Override
	public void setLongArray(long[] data) throws PortalException {
		_expandoValue.setLongArray(data);
	}

	@Override
	public void setNumber(Number data) throws PortalException {
		_expandoValue.setNumber(data);
	}

	@Override
	public void setNumberArray(Number[] data) throws PortalException {
		_expandoValue.setNumberArray(data);
	}

	@Override
	public void setShort(short data) throws PortalException {
		_expandoValue.setShort(data);
	}

	@Override
	public void setShortArray(short[] data) throws PortalException {
		_expandoValue.setShortArray(data);
	}

	@Override
	public void setString(String data) throws PortalException {
		_expandoValue.setString(data);
	}

	@Override
	public void setString(String data, Locale locale, Locale defaultLocale)
		throws PortalException {
		_expandoValue.setString(data, locale, defaultLocale);
	}

	@Override
	public void setStringArray(String[] data) throws PortalException {
		_expandoValue.setStringArray(data);
	}

	@Override
	public void setStringArray(
		String[] data, Locale locale, Locale defaultLocale)
		throws PortalException {
		_expandoValue.setStringArray(data, locale, defaultLocale);
	}

	@Override
	public void setStringArrayMap(
		Map<Locale, String[]> dataMap, Locale defaultLocale)
		throws PortalException {
		_expandoValue.setStringArrayMap(dataMap, defaultLocale);
	}

	@Override
	public void setStringMap(Map<Locale, String> dataMap, Locale defaultLocale)
		throws PortalException {
		_expandoValue.setStringMap(dataMap, defaultLocale);
	}

	@Override
	public long getPrimaryKey() {
		return _expandoValue.getPrimaryKey();
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		_expandoValue.setPrimaryKey(primaryKey);
	}

	@Override
	public long getMvccVersion() {
		return _expandoValue.getMvccVersion();
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_expandoValue.setMvccVersion(mvccVersion);
	}

	@Override
	public long getCtCollectionId() {
		return _expandoValue.getCtCollectionId();
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		_expandoValue.setCtCollectionId(ctCollectionId);
	}

	@Override
	public long getValueId() {
		return _expandoValue.getValueId();
	}

	@Override
	public void setValueId(long valueId) {
		_expandoValue.setValueId(valueId);
	}

	@Override
	public long getCompanyId() {
		return _expandoValue.getCompanyId();
	}

	@Override
	public Date getCreateDate() {
		return new Date();
	}

	@Override
	public Date getModifiedDate() {
		return new Date();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(StagedExpandoValue.class);
	}

	@Override
	public String getUuid() {
		return StringBundler.concat(
			_expandoTableClassName, StringPool.POUND, _expandoTableName);
	}

	@Override
	public void setCompanyId(long companyId) {
		_expandoValue.setCompanyId(companyId);
	}

	@Override
	public void setCreateDate(Date date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setModifiedDate(Date date) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUuid(String uuid) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getTableId() {
		return _expandoValue.getTableId();
	}

	@Override
	public void setTableId(long tableId) {
		_expandoValue.setTableId(tableId);
	}

	@Override
	public long getColumnId() {
		return _expandoValue.getColumnId();
	}

	@Override
	public void setColumnId(long columnId) {
		_expandoValue.setColumnId(columnId);
	}

	@Override
	public long getRowId() {
		return _expandoValue.getRowId();
	}

	@Override
	public void setRowId(long rowId) {
		_expandoValue.setRowId(rowId);
	}

	@Override
	public String getClassName() {
		return _expandoValue.getClassName();
	}

	@Override
	public void setClassName(String className) {
		_expandoValue.setClassName(className);
	}

	@Override
	public long getClassNameId() {
		return _expandoValue.getClassNameId();
	}

	@Override
	public void setClassNameId(long classNameId) {
		_expandoValue.setClassNameId(classNameId);
	}

	@Override
	public long getClassPK() {
		return _expandoValue.getClassPK();
	}

	@Override
	public void setClassPK(long classPK) {
		_expandoValue.setClassPK(classPK);
	}

	@Override
	public String getData() {
		return _expandoValue.getData();
	}

	@Override
	public void setData(String data) {
		_expandoValue.setData(data);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _expandoValue.getExpandoBridge();
	}

	@Override
	public Class<?> getModelClass() {
		return _expandoValue.getModelClass();
	}

	@Override
	public String getModelClassName() {
		return _expandoValue.getModelClassName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		return _expandoValue.getModelAttributes();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expandoValue.getPrimaryKeyObj();
	}

	@Override
	public boolean isCachedModel() {
		return _expandoValue.isCachedModel();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _expandoValue.isEntityCacheEnabled();
	}

	@Override
	public boolean isEscapedModel() {
		return _expandoValue.isEscapedModel();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _expandoValue.isFinderCacheEnabled();
	}

	@Override
	public boolean isNew() {
		return _expandoValue.isNew();
	}

	@Override
	public void resetOriginalValues() {
		_expandoValue.resetOriginalValues();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expandoValue.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		_expandoValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_expandoValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_expandoValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		_expandoValue.setModelAttributes(attributes);
	}

	@Override
	public void setNew(boolean n) {
		_expandoValue.setNew(n);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_expandoValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public CacheModel<ExpandoValue> toCacheModel() {
		return _expandoValue.toCacheModel();
	}

	@Override
	public ExpandoValue toEscapedModel() {
		return _expandoValue.toEscapedModel();
	}

	@Override
	public ExpandoValue toUnescapedModel() {
		return _expandoValue.toUnescapedModel();
	}

	@Override
	public String toXmlString() {
		return _expandoValue.toXmlString();
	}

	@Override
	public void persist() {
		_expandoValue.persist();
	}

	private ExpandoValue _expandoValue;
	private String _expandoTableClassName;
	private String _expandoTableName;
}
