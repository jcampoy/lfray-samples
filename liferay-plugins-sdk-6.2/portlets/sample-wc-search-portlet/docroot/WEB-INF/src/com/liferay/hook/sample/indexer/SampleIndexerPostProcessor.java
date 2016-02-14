package com.liferay.hook.sample.indexer;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.StructureFieldException;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMIndexerUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMUtil;
import com.liferay.portlet.journal.model.JournalArticle;

/**
 * This is a sample for modify the search query and filter by structure field and values if they are provided in the parameter maps.
 * @author jose
 *
 */
public class SampleIndexerPostProcessor extends BaseIndexerPostProcessor {

	public void postProcessContextQuery(BooleanQuery contextQuery,
			SearchContext searchContext)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug(" postProcessContextQuery()");
		}

		Map<String, Object> params = (Map<String, Object>) searchContext.getAttribute("params");

		if (params == null) {
			return;
		}

		Map<String, Serializable> searchByFields = (Map<String, Serializable>)params.get(SampleConstants.STRUCTURE_FIELDS);

		String structureKey = (String)params.get(SampleConstants.STRUCTURE_KEY);

		Long groupId = (Long)params.get(SampleConstants.STRUCTURE_GROUP_ID);

		Locale locale = searchContext.getLocale();

		DDMStructure structure = DDMStructureLocalServiceUtil.fetchStructure(groupId, PortalUtil.getClassNameId(JournalArticle.class), structureKey, true);

		if (!isCustomSearch(structure, groupId, searchByFields)) {
			return;
		}

		for (String fieldName : searchByFields.keySet()) {
			try {
				Serializable value = searchByFields.get(fieldName);

				String indexType = structure.getFieldProperty(
					fieldName, "indexType");

				if (Validator.isNull(indexType)) {
					if (_log.isDebugEnabled()) {
						_log.debug(
							"fieldName " + fieldName + " is not indexable");
					}

					continue;
				}

				// some types are stored in a special way

				try {
					value = DDMUtil.getIndexedFieldValue(
						value, structure.getFieldType(fieldName));
				}
				catch (StructureFieldException sfe) {
					_log.error(sfe);

					continue;
				}

				contextQuery.addRequiredTerm(
					DDMIndexerUtil.encodeName(structure.getStructureId(), fieldName, locale),
					StringPool.QUOTE + value + StringPool.QUOTE);
			}
			catch (Exception e) {
				_log.error("Error processing custom search", e);
			}
		}

		_log.debug(contextQuery);
	}

	private boolean isCustomSearch(DDMStructure structure, Long groupId,
			Map<String, Serializable> searchByFields) {

		if (structure != null &&
			searchByFields != null &&
			!searchByFields.isEmpty() &&
			groupId != null
			&& groupId > 0) {

			return true;
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(
			SampleIndexerPostProcessor.class);

}