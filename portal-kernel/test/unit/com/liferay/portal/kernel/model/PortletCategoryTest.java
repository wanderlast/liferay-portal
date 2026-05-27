/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Eric Yan
 */
public class PortletCategoryTest {

	@Test
	public void testGetCategory() {
		PortletCategory childPortletCategory = new PortletCategory("child");
		PortletCategory parentPortletCategory = new PortletCategory("parent");

		parentPortletCategory.addCategory(childPortletCategory);

		PortletCategory rootPortletCategory = new PortletCategory();

		rootPortletCategory.addCategory(parentPortletCategory);

		Assert.assertSame(
			parentPortletCategory, rootPortletCategory.getCategory("parent"));
		Assert.assertSame(
			childPortletCategory,
			rootPortletCategory.getCategory("parent//child"));

		Assert.assertSame(
			childPortletCategory, parentPortletCategory.getCategory("child"));

		Assert.assertNull(rootPortletCategory.getCategory("root//parent"));
		Assert.assertNull(
			rootPortletCategory.getCategory("root//parent//child"));
		Assert.assertNull(parentPortletCategory.getCategory("parent//child"));
	}

	@Test
	public void testPath() {
		PortletCategory childPortletCategory = new PortletCategory("child");
		PortletCategory parentPortletCategory = new PortletCategory("parent");

		Assert.assertEquals("child", childPortletCategory.getPath());
		Assert.assertEquals("parent", parentPortletCategory.getPath());

		parentPortletCategory.addCategory(childPortletCategory);

		Assert.assertEquals("parent", parentPortletCategory.getPath());
		Assert.assertEquals("parent//child", childPortletCategory.getPath());

		PortletCategory rootPortletCategory = new PortletCategory();

		Assert.assertEquals("root", rootPortletCategory.getPath());

		rootPortletCategory.addCategory(parentPortletCategory);

		Assert.assertEquals("root", rootPortletCategory.getPath());

		Assert.assertEquals("root//parent", parentPortletCategory.getPath());
		Assert.assertEquals(
			"root//parent//child", childPortletCategory.getPath());
	}

}