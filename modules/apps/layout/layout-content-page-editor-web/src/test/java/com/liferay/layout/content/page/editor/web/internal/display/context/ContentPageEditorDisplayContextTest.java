/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.layout.content.page.editor.web.internal.display.context;

import com.liferay.exportimport.kernel.staging.Staging;
import com.liferay.frontend.token.definition.FrontendTokenDefinitionRegistry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.test.rule.LiferayUnitTestRule;
import com.liferay.style.book.model.StyleBookEntry;
import com.liferay.style.book.service.StyleBookEntryLocalService;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author Gabriel Lima
 */
public class ContentPageEditorDisplayContextTest {

	@ClassRule
	@Rule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testGetStyleBookEntryERC() throws Exception {
		ContentPageEditorDisplayContext contentPageEditorDisplayContext =
			Mockito.mock(ContentPageEditorDisplayContext.class);

		ReflectionTestUtil.setFieldValue(
			contentPageEditorDisplayContext, "_frontendTokenDefinitionRegistry",
			Mockito.mock(FrontendTokenDefinitionRegistry.class));

		StyleBookEntryLocalService styleBookEntryLocalService = Mockito.mock(
			StyleBookEntryLocalService.class);

		ReflectionTestUtil.setFieldValue(
			contentPageEditorDisplayContext, "_styleBookEntryLocalService",
			styleBookEntryLocalService);

		Staging staging = Mockito.mock(Staging.class);

		ReflectionTestUtil.setFieldValue(
			contentPageEditorDisplayContext, "_staging", staging);

		ThemeDisplay themeDisplay = Mockito.mock(ThemeDisplay.class);

		Layout layout = Mockito.mock(Layout.class);

		Mockito.when(
			themeDisplay.getLayout()
		).thenReturn(
			layout
		);

		ReflectionTestUtil.setFieldValue(
			contentPageEditorDisplayContext, "themeDisplay", themeDisplay);

		Mockito.when(
			layout.getStyleBookEntryERC()
		).thenReturn(
			RandomTestUtil.randomString()
		);

		Mockito.when(
			layout.getGroupId()
		).thenReturn(
			RandomTestUtil.randomLong()
		);

		Mockito.when(
			staging.getLiveGroupId(Mockito.anyLong())
		).thenReturn(
			RandomTestUtil.randomLong()
		);

		Mockito.when(
			styleBookEntryLocalService.
				fetchStyleBookEntryByExternalReferenceCode(
					Mockito.anyString(), Mockito.anyLong())
		).thenReturn(
			Mockito.mock(StyleBookEntry.class)
		);

		Assert.assertEquals(
			StringPool.BLANK,
			ReflectionTestUtil.invoke(
				contentPageEditorDisplayContext, "_getStyleBookEntryERC",
				new Class<?>[0]));
	}

}