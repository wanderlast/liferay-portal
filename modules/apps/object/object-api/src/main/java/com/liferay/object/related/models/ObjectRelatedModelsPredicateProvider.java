/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.object.related.models;

import com.liferay.object.model.ObjectRelationship;
import com.liferay.petra.sql.dsl.expression.Predicate;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GroupThreadLocal;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Luis Miguel Barcos
 */
@ProviderType
public interface ObjectRelatedModelsPredicateProvider {

	public String getClassName();

	public String getObjectRelationshipType();

	public Predicate getPredicate(
			Long[] groupIds, ObjectRelationship objectRelationship,
			Predicate predicate)
		throws PortalException;

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             #getPredicate(Long[], ObjectRelationship, Predicate)}
	 */
	@Deprecated
	public default Predicate getPredicate(
			ObjectRelationship objectRelationship, Predicate predicate)
		throws PortalException {

		return getPredicate(
			new Long[] {GroupThreadLocal.getGroupId()}, objectRelationship,
			predicate);
	}

}