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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.test.util.OrganizationTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Lianne Louie
 */
public class OrganizationModelListenerTest {

	@Before
	public void setUp() throws Exception {
		_organization = OrganizationTestUtil.addOrganization();
		_organization2 = OrganizationTestUtil.addOrganization();
	}

	@Test
	public void testAddParentOrganization() throws Exception {
		_organization2.setParentOrganizationId(
			_organization.getOrganizationId());
		Assert.assertEquals(
			_organization2.getParentOrganization(), _organization);
	}

	@Test
	public void testRemoveParentOrganization() throws Exception {
		_organization3 = OrganizationTestUtil.addOrganization(
			_organization.getOrganizationId(), RandomTestUtil.randomString(),
			false);

		Assert.assertEquals(
			_organization3.getParentOrganizationId(),
			_organization.getOrganizationId());

		_organization3.setParentOrganizationId(
			OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID);

		Assert.assertEquals(_organization3.getParentOrganizationId(),0);


	}

	private Organization _organization;
	private Organization _organization2;
	private Organization _organization3;

}