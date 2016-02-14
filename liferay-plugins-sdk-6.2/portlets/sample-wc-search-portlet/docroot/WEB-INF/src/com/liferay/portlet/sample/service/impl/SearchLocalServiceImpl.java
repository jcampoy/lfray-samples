/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portlet.sample.service.impl;

import com.liferay.hook.sample.indexer.SampleConstants;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.portlet.dynamicdatamapping.util.DDMXMLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.sample.service.base.SearchLocalServiceBaseImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * The implementation of the search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.portlet.sample.service.SearchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.sample.service.base.SearchLocalServiceBaseImpl
 * @see com.liferay.portlet.sample.service.SearchLocalServiceUtil
 */
public class SearchLocalServiceImpl extends SearchLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.portlet.sample.service.SearchLocalServiceUtil} to access the search local service.
	 */
	
	public List<JournalArticle> searchWC(String structureKey, 
			String fieldName, 
			Serializable fieldValue,
			ThemeDisplay themeDisplay) {

		List<JournalArticle> articles = new ArrayList<JournalArticle>();

		try {
			SearchContext searchContext = new SearchContext();
			int start = QueryUtil.ALL_POS;
			int end = QueryUtil.ALL_POS;			

			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

			Map<String, Serializable> searchByFields = new LinkedHashMap<String, Serializable>();
			searchByFields.put(fieldName, fieldValue);

			params.put(SampleConstants.STRUCTURE_FIELDS, searchByFields);
			params.put(SampleConstants.STRUCTURE_KEY, structureKey);
			params.put(SampleConstants.STRUCTURE_GROUP_ID, themeDisplay.getScopeGroupId());

			Map<String, Serializable> attributes =
				new HashMap<String, Serializable>();

			attributes.put("params", params);

			searchContext.setAttributes(attributes);

			searchContext.setAndSearch(true);
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setGroupIds(new long[] {PortalUtil.getSiteGroupId(themeDisplay.getScopeGroupId())});

			searchContext.setAttribute("paginationType", "none");

			QueryConfig queryConfig = new QueryConfig();
			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			searchContext.setQueryConfig(queryConfig);

			searchContext.setStart(start);
			searchContext.setEnd(end);

			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				JournalArticle.class);

			articles = getJournalArticles(indexer.search(searchContext));
		}
		catch (Exception e) {
			_log.error(e);
		}

		return articles;
	}

	public String getFieldValue(JournalArticle article, String fieldName, Locale locale) {
		String fieldValue = null;
		try {
			DDMStructure ddmStructure = DDMStructureLocalServiceUtil.getStructure(
					PortalUtil.getSiteGroupId(article.getGroupId()),
					PortalUtil.getClassNameId(JournalArticle.class),
					article.getStructureId(), true);

			Fields fields = DDMXMLUtil.getFields(ddmStructure, article.getContent());

			fieldValue = fields.get(fieldName).getRenderedValue(locale);
		} catch (PortalException pe) {
			_log.error("Error retrieving field value" , pe);
		} catch (SystemException se) {
			_log.error("Error retrieving field value" , se);
		}

		return fieldValue;
	}

	private List<JournalArticle> getJournalArticles(Hits hits) {

		_log.debug("Processing " + hits.getLength() + " hits");

		List<JournalArticle> articles = new ArrayList<JournalArticle>();
		List<Long> processedPK = new ArrayList<Long>();

		String journalArticleClassName = JournalArticle.class.getName();

		for (Document document : hits.getDocs()) {
			String className = GetterUtil.getString(document.get(Field.ENTRY_CLASS_NAME));

			if (!journalArticleClassName.equals(className)) {
				continue;
			}

			String articleId = GetterUtil.getString(document.get("articleId"));
			long groupId = GetterUtil.getLong(document.get("groupId"));

			try {

				// avoid duplicated results when there is more than one version in the index
				JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(groupId, articleId, WorkflowConstants.STATUS_APPROVED);

				if (!processedPK.contains(article.getResourcePrimKey())) {
					articles.add(article);
					processedPK.add(article.getResourcePrimKey());
				}

			} catch (Exception e) {
				_log.error("Error processing hits", e);
			}
		}

		return articles;
	}

	private static Log _log = LogFactoryUtil.getLog(SearchLocalServiceImpl.class);

}