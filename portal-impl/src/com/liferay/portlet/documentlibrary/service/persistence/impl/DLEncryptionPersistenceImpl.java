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

package com.liferay.portlet.documentlibrary.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.kernel.exception.NoSuchEncryptionException;
import com.liferay.document.library.kernel.model.DLEncryption;
import com.liferay.document.library.kernel.service.persistence.DLEncryptionPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.portlet.documentlibrary.model.impl.DLEncryptionImpl;
import com.liferay.portlet.documentlibrary.model.impl.DLEncryptionModelImpl;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the document library encryption service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLEncryptionPersistence
 * @see com.liferay.document.library.kernel.service.persistence.DLEncryptionUtil
 * @generated
 */
@ProviderType
public class DLEncryptionPersistenceImpl extends BasePersistenceImpl<DLEncryption>
	implements DLEncryptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DLEncryptionUtil} to access the document library encryption persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DLEncryptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileEntryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID =
		new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileEntryId",
			new String[] { Long.class.getName() },
			DLEncryptionModelImpl.FILEENTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEENTRYID = new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileEntryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the document library encryptions where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileEntryId(long fileEntryId) {
		return findByFileEntryId(fileEntryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document library encryptions where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @return the range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileEntryId(long fileEntryId, int start,
		int end) {
		return findByFileEntryId(fileEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document library encryptions where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileEntryId(long fileEntryId, int start,
		int end, OrderByComparator<DLEncryption> orderByComparator) {
		return findByFileEntryId(fileEntryId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the document library encryptions where fileEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileEntryId the file entry ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileEntryId(long fileEntryId, int start,
		int end, OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { fileEntryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEENTRYID;
			finderArgs = new Object[] { fileEntryId, start, end, orderByComparator };
		}

		List<DLEncryption> list = null;

		if (retrieveFromCache) {
			list = (List<DLEncryption>)FinderCacheUtil.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DLEncryption dlEncryption : list) {
					if ((fileEntryId != dlEncryption.getFileEntryId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DLENCRYPTION_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DLEncryptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				if (!pagination) {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document library encryption
	 * @throws NoSuchEncryptionException if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption findByFileEntryId_First(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = fetchByFileEntryId_First(fileEntryId,
				orderByComparator);

		if (dlEncryption != null) {
			return dlEncryption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append("}");

		throw new NoSuchEncryptionException(msg.toString());
	}

	/**
	 * Returns the first document library encryption in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption fetchByFileEntryId_First(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator) {
		List<DLEncryption> list = findByFileEntryId(fileEntryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document library encryption
	 * @throws NoSuchEncryptionException if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption findByFileEntryId_Last(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = fetchByFileEntryId_Last(fileEntryId,
				orderByComparator);

		if (dlEncryption != null) {
			return dlEncryption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileEntryId=");
		msg.append(fileEntryId);

		msg.append("}");

		throw new NoSuchEncryptionException(msg.toString());
	}

	/**
	 * Returns the last document library encryption in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption fetchByFileEntryId_Last(long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator) {
		int count = countByFileEntryId(fileEntryId);

		if (count == 0) {
			return null;
		}

		List<DLEncryption> list = findByFileEntryId(fileEntryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document library encryptions before and after the current document library encryption in the ordered set where fileEntryId = &#63;.
	 *
	 * @param fileEncryptionId the primary key of the current document library encryption
	 * @param fileEntryId the file entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document library encryption
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption[] findByFileEntryId_PrevAndNext(long fileEncryptionId,
		long fileEntryId, OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = findByPrimaryKey(fileEncryptionId);

		Session session = null;

		try {
			session = openSession();

			DLEncryption[] array = new DLEncryptionImpl[3];

			array[0] = getByFileEntryId_PrevAndNext(session, dlEncryption,
					fileEntryId, orderByComparator, true);

			array[1] = dlEncryption;

			array[2] = getByFileEntryId_PrevAndNext(session, dlEncryption,
					fileEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DLEncryption getByFileEntryId_PrevAndNext(Session session,
		DLEncryption dlEncryption, long fileEntryId,
		OrderByComparator<DLEncryption> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DLENCRYPTION_WHERE);

		query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DLEncryptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileEntryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dlEncryption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DLEncryption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document library encryptions where fileEntryId = &#63; from the database.
	 *
	 * @param fileEntryId the file entry ID
	 */
	@Override
	public void removeByFileEntryId(long fileEntryId) {
		for (DLEncryption dlEncryption : findByFileEntryId(fileEntryId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dlEncryption);
		}
	}

	/**
	 * Returns the number of document library encryptions where fileEntryId = &#63;.
	 *
	 * @param fileEntryId the file entry ID
	 * @return the number of matching document library encryptions
	 */
	@Override
	public int countByFileEntryId(long fileEntryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEENTRYID;

		Object[] finderArgs = new Object[] { fileEntryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DLENCRYPTION_WHERE);

			query.append(_FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileEntryId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEENTRYID_FILEENTRYID_2 = "dlEncryption.fileEntryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEVERSIONID =
		new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileVersionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID =
		new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, DLEncryptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileVersionId",
			new String[] { Long.class.getName() },
			DLEncryptionModelImpl.FILEVERSIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEVERSIONID = new FinderPath(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFileVersionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the document library encryptions where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @return the matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileVersionId(long fileVersionId) {
		return findByFileVersionId(fileVersionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document library encryptions where fileVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileVersionId the file version ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @return the range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end) {
		return findByFileVersionId(fileVersionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document library encryptions where fileVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileVersionId the file version ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator) {
		return findByFileVersionId(fileVersionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document library encryptions where fileVersionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileVersionId the file version ID
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching document library encryptions
	 */
	@Override
	public List<DLEncryption> findByFileVersionId(long fileVersionId,
		int start, int end, OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID;
			finderArgs = new Object[] { fileVersionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEVERSIONID;
			finderArgs = new Object[] {
					fileVersionId,
					
					start, end, orderByComparator
				};
		}

		List<DLEncryption> list = null;

		if (retrieveFromCache) {
			list = (List<DLEncryption>)FinderCacheUtil.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DLEncryption dlEncryption : list) {
					if ((fileVersionId != dlEncryption.getFileVersionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DLENCRYPTION_WHERE);

			query.append(_FINDER_COLUMN_FILEVERSIONID_FILEVERSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DLEncryptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileVersionId);

				if (!pagination) {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document library encryption
	 * @throws NoSuchEncryptionException if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption findByFileVersionId_First(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = fetchByFileVersionId_First(fileVersionId,
				orderByComparator);

		if (dlEncryption != null) {
			return dlEncryption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileVersionId=");
		msg.append(fileVersionId);

		msg.append("}");

		throw new NoSuchEncryptionException(msg.toString());
	}

	/**
	 * Returns the first document library encryption in the ordered set where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption fetchByFileVersionId_First(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator) {
		List<DLEncryption> list = findByFileVersionId(fileVersionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document library encryption
	 * @throws NoSuchEncryptionException if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption findByFileVersionId_Last(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = fetchByFileVersionId_Last(fileVersionId,
				orderByComparator);

		if (dlEncryption != null) {
			return dlEncryption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileVersionId=");
		msg.append(fileVersionId);

		msg.append("}");

		throw new NoSuchEncryptionException(msg.toString());
	}

	/**
	 * Returns the last document library encryption in the ordered set where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document library encryption, or <code>null</code> if a matching document library encryption could not be found
	 */
	@Override
	public DLEncryption fetchByFileVersionId_Last(long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator) {
		int count = countByFileVersionId(fileVersionId);

		if (count == 0) {
			return null;
		}

		List<DLEncryption> list = findByFileVersionId(fileVersionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document library encryptions before and after the current document library encryption in the ordered set where fileVersionId = &#63;.
	 *
	 * @param fileEncryptionId the primary key of the current document library encryption
	 * @param fileVersionId the file version ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document library encryption
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption[] findByFileVersionId_PrevAndNext(
		long fileEncryptionId, long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = findByPrimaryKey(fileEncryptionId);

		Session session = null;

		try {
			session = openSession();

			DLEncryption[] array = new DLEncryptionImpl[3];

			array[0] = getByFileVersionId_PrevAndNext(session, dlEncryption,
					fileVersionId, orderByComparator, true);

			array[1] = dlEncryption;

			array[2] = getByFileVersionId_PrevAndNext(session, dlEncryption,
					fileVersionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DLEncryption getByFileVersionId_PrevAndNext(Session session,
		DLEncryption dlEncryption, long fileVersionId,
		OrderByComparator<DLEncryption> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DLENCRYPTION_WHERE);

		query.append(_FINDER_COLUMN_FILEVERSIONID_FILEVERSIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DLEncryptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileVersionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dlEncryption);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DLEncryption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document library encryptions where fileVersionId = &#63; from the database.
	 *
	 * @param fileVersionId the file version ID
	 */
	@Override
	public void removeByFileVersionId(long fileVersionId) {
		for (DLEncryption dlEncryption : findByFileVersionId(fileVersionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dlEncryption);
		}
	}

	/**
	 * Returns the number of document library encryptions where fileVersionId = &#63;.
	 *
	 * @param fileVersionId the file version ID
	 * @return the number of matching document library encryptions
	 */
	@Override
	public int countByFileVersionId(long fileVersionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEVERSIONID;

		Object[] finderArgs = new Object[] { fileVersionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DLENCRYPTION_WHERE);

			query.append(_FINDER_COLUMN_FILEVERSIONID_FILEVERSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileVersionId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FILEVERSIONID_FILEVERSIONID_2 = "dlEncryption.fileVersionId = ?";

	public DLEncryptionPersistenceImpl() {
		setModelClass(DLEncryption.class);
	}

	/**
	 * Caches the document library encryption in the entity cache if it is enabled.
	 *
	 * @param dlEncryption the document library encryption
	 */
	@Override
	public void cacheResult(DLEncryption dlEncryption) {
		EntityCacheUtil.putResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionImpl.class, dlEncryption.getPrimaryKey(), dlEncryption);

		dlEncryption.resetOriginalValues();
	}

	/**
	 * Caches the document library encryptions in the entity cache if it is enabled.
	 *
	 * @param dlEncryptions the document library encryptions
	 */
	@Override
	public void cacheResult(List<DLEncryption> dlEncryptions) {
		for (DLEncryption dlEncryption : dlEncryptions) {
			if (EntityCacheUtil.getResult(
						DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
						DLEncryptionImpl.class, dlEncryption.getPrimaryKey()) == null) {
				cacheResult(dlEncryption);
			}
			else {
				dlEncryption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all document library encryptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		EntityCacheUtil.clearCache(DLEncryptionImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the document library encryption.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DLEncryption dlEncryption) {
		EntityCacheUtil.removeResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionImpl.class, dlEncryption.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DLEncryption> dlEncryptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DLEncryption dlEncryption : dlEncryptions) {
			EntityCacheUtil.removeResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
				DLEncryptionImpl.class, dlEncryption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new document library encryption with the primary key. Does not add the document library encryption to the database.
	 *
	 * @param fileEncryptionId the primary key for the new document library encryption
	 * @return the new document library encryption
	 */
	@Override
	public DLEncryption create(long fileEncryptionId) {
		DLEncryption dlEncryption = new DLEncryptionImpl();

		dlEncryption.setNew(true);
		dlEncryption.setPrimaryKey(fileEncryptionId);

		return dlEncryption;
	}

	/**
	 * Removes the document library encryption with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileEncryptionId the primary key of the document library encryption
	 * @return the document library encryption that was removed
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption remove(long fileEncryptionId)
		throws NoSuchEncryptionException {
		return remove((Serializable)fileEncryptionId);
	}

	/**
	 * Removes the document library encryption with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document library encryption
	 * @return the document library encryption that was removed
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption remove(Serializable primaryKey)
		throws NoSuchEncryptionException {
		Session session = null;

		try {
			session = openSession();

			DLEncryption dlEncryption = (DLEncryption)session.get(DLEncryptionImpl.class,
					primaryKey);

			if (dlEncryption == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEncryptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dlEncryption);
		}
		catch (NoSuchEncryptionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected DLEncryption removeImpl(DLEncryption dlEncryption) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dlEncryption)) {
				dlEncryption = (DLEncryption)session.get(DLEncryptionImpl.class,
						dlEncryption.getPrimaryKeyObj());
			}

			if (dlEncryption != null) {
				session.delete(dlEncryption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dlEncryption != null) {
			clearCache(dlEncryption);
		}

		return dlEncryption;
	}

	@Override
	public DLEncryption updateImpl(DLEncryption dlEncryption) {
		boolean isNew = dlEncryption.isNew();

		if (!(dlEncryption instanceof DLEncryptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(dlEncryption.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(dlEncryption);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in dlEncryption proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DLEncryption implementation " +
				dlEncryption.getClass());
		}

		DLEncryptionModelImpl dlEncryptionModelImpl = (DLEncryptionModelImpl)dlEncryption;

		Session session = null;

		try {
			session = openSession();

			if (dlEncryption.isNew()) {
				session.save(dlEncryption);

				dlEncryption.setNew(false);
			}
			else {
				dlEncryption = (DLEncryption)session.merge(dlEncryption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!DLEncryptionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { dlEncryptionModelImpl.getFileEntryId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
				args);

			args = new Object[] { dlEncryptionModelImpl.getFileVersionId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEVERSIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID,
				args);

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY);
			FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((dlEncryptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dlEncryptionModelImpl.getOriginalFileEntryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);

				args = new Object[] { dlEncryptionModelImpl.getFileEntryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEENTRYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEENTRYID,
					args);
			}

			if ((dlEncryptionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dlEncryptionModelImpl.getOriginalFileVersionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEVERSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID,
					args);

				args = new Object[] { dlEncryptionModelImpl.getFileVersionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEVERSIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEVERSIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
			DLEncryptionImpl.class, dlEncryption.getPrimaryKey(), dlEncryption,
			false);

		dlEncryption.resetOriginalValues();

		return dlEncryption;
	}

	/**
	 * Returns the document library encryption with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the document library encryption
	 * @return the document library encryption
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEncryptionException {
		DLEncryption dlEncryption = fetchByPrimaryKey(primaryKey);

		if (dlEncryption == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEncryptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dlEncryption;
	}

	/**
	 * Returns the document library encryption with the primary key or throws a {@link NoSuchEncryptionException} if it could not be found.
	 *
	 * @param fileEncryptionId the primary key of the document library encryption
	 * @return the document library encryption
	 * @throws NoSuchEncryptionException if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption findByPrimaryKey(long fileEncryptionId)
		throws NoSuchEncryptionException {
		return findByPrimaryKey((Serializable)fileEncryptionId);
	}

	/**
	 * Returns the document library encryption with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document library encryption
	 * @return the document library encryption, or <code>null</code> if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = EntityCacheUtil.getResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
				DLEncryptionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		DLEncryption dlEncryption = (DLEncryption)serializable;

		if (dlEncryption == null) {
			Session session = null;

			try {
				session = openSession();

				dlEncryption = (DLEncryption)session.get(DLEncryptionImpl.class,
						primaryKey);

				if (dlEncryption != null) {
					cacheResult(dlEncryption);
				}
				else {
					EntityCacheUtil.putResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
						DLEncryptionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
					DLEncryptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dlEncryption;
	}

	/**
	 * Returns the document library encryption with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileEncryptionId the primary key of the document library encryption
	 * @return the document library encryption, or <code>null</code> if a document library encryption with the primary key could not be found
	 */
	@Override
	public DLEncryption fetchByPrimaryKey(long fileEncryptionId) {
		return fetchByPrimaryKey((Serializable)fileEncryptionId);
	}

	@Override
	public Map<Serializable, DLEncryption> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DLEncryption> map = new HashMap<Serializable, DLEncryption>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DLEncryption dlEncryption = fetchByPrimaryKey(primaryKey);

			if (dlEncryption != null) {
				map.put(primaryKey, dlEncryption);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = EntityCacheUtil.getResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
					DLEncryptionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (DLEncryption)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DLENCRYPTION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (DLEncryption dlEncryption : (List<DLEncryption>)q.list()) {
				map.put(dlEncryption.getPrimaryKeyObj(), dlEncryption);

				cacheResult(dlEncryption);

				uncachedPrimaryKeys.remove(dlEncryption.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(DLEncryptionModelImpl.ENTITY_CACHE_ENABLED,
					DLEncryptionImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the document library encryptions.
	 *
	 * @return the document library encryptions
	 */
	@Override
	public List<DLEncryption> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document library encryptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @return the range of document library encryptions
	 */
	@Override
	public List<DLEncryption> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document library encryptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document library encryptions
	 */
	@Override
	public List<DLEncryption> findAll(int start, int end,
		OrderByComparator<DLEncryption> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document library encryptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DLEncryptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of document library encryptions
	 * @param end the upper bound of the range of document library encryptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of document library encryptions
	 */
	@Override
	public List<DLEncryption> findAll(int start, int end,
		OrderByComparator<DLEncryption> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<DLEncryption> list = null;

		if (retrieveFromCache) {
			list = (List<DLEncryption>)FinderCacheUtil.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DLENCRYPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DLENCRYPTION;

				if (pagination) {
					sql = sql.concat(DLEncryptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DLEncryption>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the document library encryptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DLEncryption dlEncryption : findAll()) {
			remove(dlEncryption);
		}
	}

	/**
	 * Returns the number of document library encryptions.
	 *
	 * @return the number of document library encryptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DLENCRYPTION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DLEncryptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document library encryption persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DLEncryptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DLENCRYPTION = "SELECT dlEncryption FROM DLEncryption dlEncryption";
	private static final String _SQL_SELECT_DLENCRYPTION_WHERE_PKS_IN = "SELECT dlEncryption FROM DLEncryption dlEncryption WHERE fileEncryptionId IN (";
	private static final String _SQL_SELECT_DLENCRYPTION_WHERE = "SELECT dlEncryption FROM DLEncryption dlEncryption WHERE ";
	private static final String _SQL_COUNT_DLENCRYPTION = "SELECT COUNT(dlEncryption) FROM DLEncryption dlEncryption";
	private static final String _SQL_COUNT_DLENCRYPTION_WHERE = "SELECT COUNT(dlEncryption) FROM DLEncryption dlEncryption WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dlEncryption.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DLEncryption exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DLEncryption exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DLEncryptionPersistenceImpl.class);
}