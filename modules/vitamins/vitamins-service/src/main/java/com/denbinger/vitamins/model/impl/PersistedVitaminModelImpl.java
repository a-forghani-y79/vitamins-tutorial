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

package com.denbinger.vitamins.model.impl;

import com.denbinger.vitamins.model.PersistedVitamin;
import com.denbinger.vitamins.model.PersistedVitaminModel;
import com.denbinger.vitamins.model.PersistedVitaminSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PersistedVitamin service. Represents a row in the &quot;FOO_PersistedVitamin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>PersistedVitaminModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersistedVitaminImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminImpl
 * @generated
 */
@JSON(strict = true)
public class PersistedVitaminModelImpl
	extends BaseModelImpl<PersistedVitamin> implements PersistedVitaminModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a persisted vitamin model instance should use the <code>PersistedVitamin</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_PersistedVitamin";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"persistedVitaminId", Types.BIGINT},
		{"surrogateId", Types.VARCHAR}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"groupName", Types.VARCHAR},
		{"articleId", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("persistedVitaminId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("surrogateId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("groupName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("articleId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_PersistedVitamin (uuid_ VARCHAR(75) null,persistedVitaminId LONG not null primary key,surrogateId VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,groupName VARCHAR(75) null,articleId VARCHAR(75) null,description VARCHAR(75) null,name VARCHAR(75) null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table FOO_PersistedVitamin";

	public static final String ORDER_BY_JPQL =
		" ORDER BY persistedVitamin.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FOO_PersistedVitamin.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SURROGATEID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static PersistedVitamin toModel(PersistedVitaminSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PersistedVitamin model = new PersistedVitaminImpl();

		model.setUuid(soapModel.getUuid());
		model.setPersistedVitaminId(soapModel.getPersistedVitaminId());
		model.setSurrogateId(soapModel.getSurrogateId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setGroupName(soapModel.getGroupName());
		model.setArticleId(soapModel.getArticleId());
		model.setDescription(soapModel.getDescription());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<PersistedVitamin> toModels(
		PersistedVitaminSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<PersistedVitamin> models = new ArrayList<PersistedVitamin>(
			soapModels.length);

		for (PersistedVitaminSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public PersistedVitaminModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _persistedVitaminId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPersistedVitaminId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _persistedVitaminId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PersistedVitamin.class;
	}

	@Override
	public String getModelClassName() {
		return PersistedVitamin.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PersistedVitamin, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PersistedVitamin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersistedVitamin, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PersistedVitamin)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PersistedVitamin, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PersistedVitamin, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PersistedVitamin)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PersistedVitamin, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PersistedVitamin, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PersistedVitamin>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PersistedVitamin.class.getClassLoader(), PersistedVitamin.class,
			ModelWrapper.class);

		try {
			Constructor<PersistedVitamin> constructor =
				(Constructor<PersistedVitamin>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<PersistedVitamin, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PersistedVitamin, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PersistedVitamin, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<PersistedVitamin, Object>>();
		Map<String, BiConsumer<PersistedVitamin, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PersistedVitamin, ?>>();

		attributeGetterFunctions.put("uuid", PersistedVitamin::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<PersistedVitamin, String>)PersistedVitamin::setUuid);
		attributeGetterFunctions.put(
			"persistedVitaminId", PersistedVitamin::getPersistedVitaminId);
		attributeSetterBiConsumers.put(
			"persistedVitaminId",
			(BiConsumer<PersistedVitamin, Long>)
				PersistedVitamin::setPersistedVitaminId);
		attributeGetterFunctions.put(
			"surrogateId", PersistedVitamin::getSurrogateId);
		attributeSetterBiConsumers.put(
			"surrogateId",
			(BiConsumer<PersistedVitamin, String>)
				PersistedVitamin::setSurrogateId);
		attributeGetterFunctions.put("groupId", PersistedVitamin::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<PersistedVitamin, Long>)PersistedVitamin::setGroupId);
		attributeGetterFunctions.put(
			"companyId", PersistedVitamin::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<PersistedVitamin, Long>)PersistedVitamin::setCompanyId);
		attributeGetterFunctions.put("userId", PersistedVitamin::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<PersistedVitamin, Long>)PersistedVitamin::setUserId);
		attributeGetterFunctions.put("userName", PersistedVitamin::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<PersistedVitamin, String>)
				PersistedVitamin::setUserName);
		attributeGetterFunctions.put(
			"createDate", PersistedVitamin::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<PersistedVitamin, Date>)
				PersistedVitamin::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", PersistedVitamin::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<PersistedVitamin, Date>)
				PersistedVitamin::setModifiedDate);
		attributeGetterFunctions.put(
			"groupName", PersistedVitamin::getGroupName);
		attributeSetterBiConsumers.put(
			"groupName",
			(BiConsumer<PersistedVitamin, String>)
				PersistedVitamin::setGroupName);
		attributeGetterFunctions.put(
			"articleId", PersistedVitamin::getArticleId);
		attributeSetterBiConsumers.put(
			"articleId",
			(BiConsumer<PersistedVitamin, String>)
				PersistedVitamin::setArticleId);
		attributeGetterFunctions.put(
			"description", PersistedVitamin::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<PersistedVitamin, String>)
				PersistedVitamin::setDescription);
		attributeGetterFunctions.put("name", PersistedVitamin::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<PersistedVitamin, String>)PersistedVitamin::setName);
		attributeGetterFunctions.put("type", PersistedVitamin::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<PersistedVitamin, String>)PersistedVitamin::setType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getPersistedVitaminId() {
		return _persistedVitaminId;
	}

	@Override
	public void setPersistedVitaminId(long persistedVitaminId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_persistedVitaminId = persistedVitaminId;
	}

	@JSON
	@Override
	public String getSurrogateId() {
		if (_surrogateId == null) {
			return "";
		}
		else {
			return _surrogateId;
		}
	}

	@Override
	public void setSurrogateId(String surrogateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_surrogateId = surrogateId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSurrogateId() {
		return getColumnOriginalValue("surrogateId");
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getGroupName() {
		if (_groupName == null) {
			return "";
		}
		else {
			return _groupName;
		}
	}

	@Override
	public void setGroupName(String groupName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupName = groupName;
	}

	@JSON
	@Override
	public String getArticleId() {
		if (_articleId == null) {
			return "";
		}
		else {
			return _articleId;
		}
	}

	@Override
	public void setArticleId(String articleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_articleId = articleId;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_type = type;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(PersistedVitamin.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), PersistedVitamin.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PersistedVitamin toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PersistedVitamin>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PersistedVitaminImpl persistedVitaminImpl = new PersistedVitaminImpl();

		persistedVitaminImpl.setUuid(getUuid());
		persistedVitaminImpl.setPersistedVitaminId(getPersistedVitaminId());
		persistedVitaminImpl.setSurrogateId(getSurrogateId());
		persistedVitaminImpl.setGroupId(getGroupId());
		persistedVitaminImpl.setCompanyId(getCompanyId());
		persistedVitaminImpl.setUserId(getUserId());
		persistedVitaminImpl.setUserName(getUserName());
		persistedVitaminImpl.setCreateDate(getCreateDate());
		persistedVitaminImpl.setModifiedDate(getModifiedDate());
		persistedVitaminImpl.setGroupName(getGroupName());
		persistedVitaminImpl.setArticleId(getArticleId());
		persistedVitaminImpl.setDescription(getDescription());
		persistedVitaminImpl.setName(getName());
		persistedVitaminImpl.setType(getType());

		persistedVitaminImpl.resetOriginalValues();

		return persistedVitaminImpl;
	}

	@Override
	public int compareTo(PersistedVitamin persistedVitamin) {
		int value = 0;

		value = getName().compareTo(persistedVitamin.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedVitamin)) {
			return false;
		}

		PersistedVitamin persistedVitamin = (PersistedVitamin)object;

		long primaryKey = persistedVitamin.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<PersistedVitamin> toCacheModel() {
		PersistedVitaminCacheModel persistedVitaminCacheModel =
			new PersistedVitaminCacheModel();

		persistedVitaminCacheModel.uuid = getUuid();

		String uuid = persistedVitaminCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			persistedVitaminCacheModel.uuid = null;
		}

		persistedVitaminCacheModel.persistedVitaminId = getPersistedVitaminId();

		persistedVitaminCacheModel.surrogateId = getSurrogateId();

		String surrogateId = persistedVitaminCacheModel.surrogateId;

		if ((surrogateId != null) && (surrogateId.length() == 0)) {
			persistedVitaminCacheModel.surrogateId = null;
		}

		persistedVitaminCacheModel.groupId = getGroupId();

		persistedVitaminCacheModel.companyId = getCompanyId();

		persistedVitaminCacheModel.userId = getUserId();

		persistedVitaminCacheModel.userName = getUserName();

		String userName = persistedVitaminCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			persistedVitaminCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			persistedVitaminCacheModel.createDate = createDate.getTime();
		}
		else {
			persistedVitaminCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			persistedVitaminCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			persistedVitaminCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		persistedVitaminCacheModel.groupName = getGroupName();

		String groupName = persistedVitaminCacheModel.groupName;

		if ((groupName != null) && (groupName.length() == 0)) {
			persistedVitaminCacheModel.groupName = null;
		}

		persistedVitaminCacheModel.articleId = getArticleId();

		String articleId = persistedVitaminCacheModel.articleId;

		if ((articleId != null) && (articleId.length() == 0)) {
			persistedVitaminCacheModel.articleId = null;
		}

		persistedVitaminCacheModel.description = getDescription();

		String description = persistedVitaminCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			persistedVitaminCacheModel.description = null;
		}

		persistedVitaminCacheModel.name = getName();

		String name = persistedVitaminCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			persistedVitaminCacheModel.name = null;
		}

		persistedVitaminCacheModel.type = getType();

		String type = persistedVitaminCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			persistedVitaminCacheModel.type = null;
		}

		return persistedVitaminCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PersistedVitamin, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PersistedVitamin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersistedVitamin, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PersistedVitamin)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<PersistedVitamin, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PersistedVitamin, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PersistedVitamin, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PersistedVitamin)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PersistedVitamin>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _persistedVitaminId;
	private String _surrogateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _groupName;
	private String _articleId;
	private String _description;
	private String _name;
	private String _type;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<PersistedVitamin, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((PersistedVitamin)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("persistedVitaminId", _persistedVitaminId);
		_columnOriginalValues.put("surrogateId", _surrogateId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("groupName", _groupName);
		_columnOriginalValues.put("articleId", _articleId);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("type_", _type);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("type_", "type");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("persistedVitaminId", 2L);

		columnBitmasks.put("surrogateId", 4L);

		columnBitmasks.put("groupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("groupName", 512L);

		columnBitmasks.put("articleId", 1024L);

		columnBitmasks.put("description", 2048L);

		columnBitmasks.put("name", 4096L);

		columnBitmasks.put("type_", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private PersistedVitamin _escapedModel;

}