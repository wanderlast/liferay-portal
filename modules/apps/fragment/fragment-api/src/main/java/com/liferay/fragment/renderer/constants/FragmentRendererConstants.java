/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.fragment.renderer.constants;

/**
 * @author Jorge Ferrer
 */
public class FragmentRendererConstants {

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             #FRAGMENT_RENDERER_CLASS_NAME_COLLECTION_FILTER}
	 */
	@Deprecated
	public static final String COLLECTION_FILTER_FRAGMENT_RENDERER_KEY =
		FragmentRendererConstants.
			FRAGMENT_RENDERER_CLASS_NAME_COLLECTION_FILTER;

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             #FRAGMENT_RENDERER_KEY_FRAGMENT_ENTRY}
	 */
	@Deprecated
	public static final String FRAGMENT_ENTRY_FRAGMENT_RENDERER_KEY =
		FragmentRendererConstants.FRAGMENT_RENDERER_KEY_FRAGMENT_ENTRY;

	/**
	 * @deprecated As of Cavanaugh (7.4.x), replaced by {@link
	 *             #FRAGMENT_RENDERER_KEY_FRAGMENT_ENTRY_REACT}
	 */
	@Deprecated
	public static final String FRAGMENT_ENTRY_FRAGMENT_RENDERER_KEY_REACT =
		"FRAGMENT_ENTRY_FRAGMENT_RENDERER_KEY_REACT";

	public static final String FRAGMENT_RENDERER_CLASS_NAME_COLLECTION_FILTER =
		"com.liferay.fragment.renderer.collection.filter.internal." +
			"CollectionFilterFragmentRenderer";

	public static final String FRAGMENT_RENDERER_KEY_FRAGMENT_ENTRY =
		"FRAGMENT_ENTRY_FRAGMENT_RENDERER_KEY";

	public static final String FRAGMENT_RENDERER_KEY_FRAGMENT_ENTRY_REACT =
		"FRAGMENT_ENTRY_FRAGMENT_RENDERER_REACT_KEY";

}