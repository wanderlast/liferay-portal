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

package com.liferay.document.library.kernel.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for DLEncryption. This utility wraps
 * {@link com.liferay.portlet.documentlibrary.service.impl.DLEncryptionServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryptionService
 * @see com.liferay.portlet.documentlibrary.service.base.DLEncryptionServiceBaseImpl
 * @see com.liferay.portlet.documentlibrary.service.impl.DLEncryptionServiceImpl
 * @generated
 */
@ProviderType
public class DLEncryptionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.documentlibrary.service.impl.DLEncryptionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DLEncryptionService getService() {
		if (_service == null) {
			_service = (DLEncryptionService)PortalBeanLocatorUtil.locate(DLEncryptionService.class.getName());

			ReferenceRegistry.registerReference(DLEncryptionServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static DLEncryptionService _service;
}