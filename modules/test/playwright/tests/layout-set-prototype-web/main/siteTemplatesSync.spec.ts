/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {expect, mergeTests} from '@playwright/test';

import {applicationsMenuPageTest} from '../../../fixtures/applicationsMenuPageTest';
import {dataApiHelpersTest} from '../../../fixtures/dataApiHelpersTest';
import {featureFlagsTest} from '../../../fixtures/featureFlagsTest';
import {loginTest} from '../../../fixtures/loginTest';
import {productMenuPageTest} from '../../../fixtures/productMenuPageTest';
import {sitesPageTest} from '../../../fixtures/sitesPageTest';
import {ChangeTrackingPage} from '../../../pages/change-tracking-web/ChangeTrackingPage';
import {clickAndExpectToBeVisible} from '../../../utils/clickAndExpectToBeVisible';
import getRandomString from '../../../utils/getRandomString';
import {sitesAdminPagesTest} from '../../site-admin-web/main/fixtures/sitesAdminPagesTest';
import {layoutSetPrototypePageTest} from './fixtures/layoutSetPrototypePageTest';
import createSiteTemplate from './utils/createSiteTemplate';

export const test = mergeTests(
	applicationsMenuPageTest,
	dataApiHelpersTest,
	featureFlagsTest({
		'LPD-35443': {enabled: true},
		'LPD-82107': {enabled: true},
	}),
	layoutSetPrototypePageTest,
	loginTest(),
	productMenuPageTest,
	sitesAdminPagesTest,
	sitesPageTest
);

test(
	'Execute Site Template Sync action is hidden for inactive Site Templates',
	{tag: '@LPD-87027'},
	async ({apiHelpers, applicationsMenuPage, layoutSetPrototypePage}) => {

		// Create an inactive Site Template

		const siteTemplateName = 'SiteTemplate-' + getRandomString();

		const layoutSetPrototype =
			await apiHelpers.jsonWebServicesLayoutSetPrototype.addLayoutSetPrototypes(
				{
					active: false,
					name: siteTemplateName,
				}
			);

		apiHelpers.data.push({
			id: layoutSetPrototype.layoutSetPrototypeId,
			type: 'layoutSetPrototype',
		});

		await applicationsMenuPage.goToSiteTemplates();

		// Inactive: Activate is shown and the sync action is hidden

		await clickAndExpectToBeVisible({
			target: layoutSetPrototypePage.activateMenuItem,
			trigger: layoutSetPrototypePage.rowActions(siteTemplateName),
		});

		await expect(layoutSetPrototypePage.executeSyncMenuItem).toBeHidden();

		// Activate the Site Template and verify the sync action is now visible

		await layoutSetPrototypePage.activateMenuItem.click();

		await clickAndExpectToBeVisible({
			target: layoutSetPrototypePage.executeSyncMenuItem,
			trigger: layoutSetPrototypePage.rowActions(siteTemplateName),
		});
	}
);

test(
	'Execute Site Template Sync is blocked when Publications is enabled',
	{tag: '@LPD-87027'},
	async ({
		apiHelpers,
		applicationsMenuPage,
		layoutSetPrototypePage,
		page,
	}) => {
		const siteTemplateName = 'SiteTemplate-' + getRandomString();

		const layoutSetPrototype =
			await apiHelpers.jsonWebServicesLayoutSetPrototype.addLayoutSetPrototypes(
				{
					name: siteTemplateName,
				}
			);

		apiHelpers.data.push({
			id: layoutSetPrototype.layoutSetPrototypeId,
			type: 'layoutSetPrototype',
		});

		const changeTrackingPage = new ChangeTrackingPage(page);

		try {
			await changeTrackingPage.enablePublications(true);

			await applicationsMenuPage.goToSiteTemplates();

			await clickAndExpectToBeVisible({
				target: layoutSetPrototypePage.executeSyncMenuItem,
				trigger: layoutSetPrototypePage.rowActions(siteTemplateName),
			});

			await layoutSetPrototypePage.executeSyncMenuItem.click();

			await expect(
				page.getByText(
					'The site template sync cannot be run with publications enabled.'
				)
			).toBeVisible();

			await expect(
				page.getByText(
					'This will apply changes from your site template to linked sites'
				)
			).toBeHidden();

			// Close the dialog so it does not block the navigation that
			// disables publications during cleanup

			const dialog = page.getByRole('alertdialog');

			await dialog
				.locator('.modal-footer')
				.getByRole('button', {name: 'Close'})
				.click();

			await expect(dialog).toBeHidden();
		}
		finally {
			await changeTrackingPage.enablePublications(false);
		}
	}
);

test(
	'Execute Site Template Sync propagates changes to a linked Site',
	{tag: '@LPD-87027'},
	async ({
		apiHelpers,
		applicationsMenuPage,
		layoutSetPrototypePage,
		page,
		productMenuPage,
		sitesAdminPage,
		sitesPage,
	}) => {
		test.slow();

		// Create the Site Template and a linked Site

		const siteTemplateName = 'SiteTemplate-' + getRandomString();

		const layoutSetPrototype = await createSiteTemplate({
			apiHelpers,
			page,
			productMenuPage,
			templateName: siteTemplateName,
		});

		apiHelpers.data.push({
			id: layoutSetPrototype.layoutSetPrototypeId,
			type: 'layoutSetPrototype',
		});

		await sitesAdminPage.goto();

		const siteName = 'Site-' + getRandomString();

		const siteId = await sitesPage.createSite({
			isCustom: true,
			siteName,
			templateName: siteTemplateName,
		});

		apiHelpers.data.push({id: siteId, type: 'site'});

		const siteGroup = await apiHelpers.jsonWebServicesGroup.getGroupByKey(
			layoutSetPrototype.companyId,
			siteName
		);

		const externalReferenceCode = siteGroup.externalReferenceCode;

		// Add a new page to the Site Template

		const layoutSetPrototypeGroup =
			await apiHelpers.jsonWebServicesGroup.getGroupByKey(
				layoutSetPrototype.companyId,
				layoutSetPrototype.layoutSetPrototypeId
			);

		const newPageName = 'NewPage-' + getRandomString();

		await apiHelpers.jsonWebServicesLayout.addLayout({
			groupId: layoutSetPrototypeGroup.groupId,
			privateLayout: 'true',
			title: newPageName,
		});

		// Trigger the manual sync from the Site Templates list and wait for the
		// asynchronous completion notification

		await applicationsMenuPage.goToSiteTemplates();

		await layoutSetPrototypePage.executeSyncAndWaitForSuccess(
			siteTemplateName
		);

		// The new page propagates to the linked Site

		await expect(async () => {
			const sitePages = await apiHelpers.headlessAdminSite.getPages(
				externalReferenceCode,
				'pageSize=100&privateLayout=false'
			);

			expect(
				sitePages.items.some(
					(item) => item.name_i18n['en-US'] === newPageName
				)
			).toBeTruthy();
		}).toPass();
	}
);
