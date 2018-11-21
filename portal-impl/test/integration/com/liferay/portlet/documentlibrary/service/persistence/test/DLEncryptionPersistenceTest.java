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

package com.liferay.portlet.documentlibrary.service.persistence.test;

import com.liferay.document.library.kernel.exception.NoSuchEncryptionException;
import com.liferay.document.library.kernel.model.DLEncryption;
import com.liferay.document.library.kernel.service.DLEncryptionLocalServiceUtil;
import com.liferay.document.library.kernel.service.persistence.DLEncryptionPersistence;
import com.liferay.document.library.kernel.service.persistence.DLEncryptionUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
public class DLEncryptionPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = DLEncryptionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<DLEncryption> iterator = _dlEncryptions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLEncryption dlEncryption = _persistence.create(pk);

		Assert.assertNotNull(dlEncryption);

		Assert.assertEquals(dlEncryption.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		_persistence.remove(newDLEncryption);

		DLEncryption existingDLEncryption = _persistence.fetchByPrimaryKey(newDLEncryption.getPrimaryKey());

		Assert.assertNull(existingDLEncryption);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDLEncryption();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLEncryption newDLEncryption = _persistence.create(pk);

		newDLEncryption.setGroupId(RandomTestUtil.nextLong());

		newDLEncryption.setFileEntryId(RandomTestUtil.nextLong());

		newDLEncryption.setFileVersionId(RandomTestUtil.nextLong());

		newDLEncryption.setStatus(RandomTestUtil.randomString());

		_dlEncryptions.add(_persistence.update(newDLEncryption));

		DLEncryption existingDLEncryption = _persistence.findByPrimaryKey(newDLEncryption.getPrimaryKey());

		Assert.assertEquals(existingDLEncryption.getFileEncryptionId(),
			newDLEncryption.getFileEncryptionId());
		Assert.assertEquals(existingDLEncryption.getGroupId(),
			newDLEncryption.getGroupId());
		Assert.assertEquals(existingDLEncryption.getFileEntryId(),
			newDLEncryption.getFileEntryId());
		Assert.assertEquals(existingDLEncryption.getFileVersionId(),
			newDLEncryption.getFileVersionId());
		Assert.assertEquals(existingDLEncryption.getStatus(),
			newDLEncryption.getStatus());
	}

	@Test
	public void testCountByFileEntryId() throws Exception {
		_persistence.countByFileEntryId(RandomTestUtil.nextLong());

		_persistence.countByFileEntryId(0L);
	}

	@Test
	public void testCountByFileVersionId() throws Exception {
		_persistence.countByFileVersionId(RandomTestUtil.nextLong());

		_persistence.countByFileVersionId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		DLEncryption existingDLEncryption = _persistence.findByPrimaryKey(newDLEncryption.getPrimaryKey());

		Assert.assertEquals(existingDLEncryption, newDLEncryption);
	}

	@Test(expected = NoSuchEncryptionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<DLEncryption> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("DLEncryption",
			"fileEncryptionId", true, "groupId", true, "fileEntryId", true,
			"fileVersionId", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		DLEncryption existingDLEncryption = _persistence.fetchByPrimaryKey(newDLEncryption.getPrimaryKey());

		Assert.assertEquals(existingDLEncryption, newDLEncryption);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLEncryption missingDLEncryption = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDLEncryption);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		DLEncryption newDLEncryption1 = addDLEncryption();
		DLEncryption newDLEncryption2 = addDLEncryption();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLEncryption1.getPrimaryKey());
		primaryKeys.add(newDLEncryption2.getPrimaryKey());

		Map<Serializable, DLEncryption> dlEncryptions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, dlEncryptions.size());
		Assert.assertEquals(newDLEncryption1,
			dlEncryptions.get(newDLEncryption1.getPrimaryKey()));
		Assert.assertEquals(newDLEncryption2,
			dlEncryptions.get(newDLEncryption2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, DLEncryption> dlEncryptions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dlEncryptions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLEncryption.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, DLEncryption> dlEncryptions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dlEncryptions.size());
		Assert.assertEquals(newDLEncryption,
			dlEncryptions.get(newDLEncryption.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, DLEncryption> dlEncryptions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(dlEncryptions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDLEncryption.getPrimaryKey());

		Map<Serializable, DLEncryption> dlEncryptions = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, dlEncryptions.size());
		Assert.assertEquals(newDLEncryption,
			dlEncryptions.get(newDLEncryption.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = DLEncryptionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<DLEncryption>() {
				@Override
				public void performAction(DLEncryption dlEncryption) {
					Assert.assertNotNull(dlEncryption);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLEncryption.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileEncryptionId",
				newDLEncryption.getFileEncryptionId()));

		List<DLEncryption> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		DLEncryption existingDLEncryption = result.get(0);

		Assert.assertEquals(existingDLEncryption, newDLEncryption);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLEncryption.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fileEncryptionId",
				RandomTestUtil.nextLong()));

		List<DLEncryption> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		DLEncryption newDLEncryption = addDLEncryption();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLEncryption.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"fileEncryptionId"));

		Object newFileEncryptionId = newDLEncryption.getFileEncryptionId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileEncryptionId",
				new Object[] { newFileEncryptionId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFileEncryptionId = result.get(0);

		Assert.assertEquals(existingFileEncryptionId, newFileEncryptionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(DLEncryption.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"fileEncryptionId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("fileEncryptionId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected DLEncryption addDLEncryption() throws Exception {
		long pk = RandomTestUtil.nextLong();

		DLEncryption dlEncryption = _persistence.create(pk);

		dlEncryption.setGroupId(RandomTestUtil.nextLong());

		dlEncryption.setFileEntryId(RandomTestUtil.nextLong());

		dlEncryption.setFileVersionId(RandomTestUtil.nextLong());

		dlEncryption.setStatus(RandomTestUtil.randomString());

		_dlEncryptions.add(_persistence.update(dlEncryption));

		return dlEncryption;
	}

	private List<DLEncryption> _dlEncryptions = new ArrayList<DLEncryption>();
	private DLEncryptionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}