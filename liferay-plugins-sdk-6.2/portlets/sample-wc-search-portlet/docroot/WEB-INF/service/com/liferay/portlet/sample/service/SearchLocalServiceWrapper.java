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

package com.liferay.portlet.sample.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SearchLocalService
 * @generated
 */
public class SearchLocalServiceWrapper implements SearchLocalService,
	ServiceWrapper<SearchLocalService> {
	public SearchLocalServiceWrapper(SearchLocalService searchLocalService) {
		_searchLocalService = searchLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _searchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_searchLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _searchLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.portlet.sample.service.SearchLocalServiceUtil} to access the search local service.
	*/
	@Override
	public java.util.List<com.liferay.portlet.journal.model.JournalArticle> searchWC(
		java.lang.String structureKey, java.lang.String fieldName,
		java.io.Serializable fieldValue,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return _searchLocalService.searchWC(structureKey, fieldName,
			fieldValue, themeDisplay);
	}

	@Override
	public java.lang.String getFieldValue(
		com.liferay.portlet.journal.model.JournalArticle article,
		java.lang.String fieldName, java.util.Locale locale) {
		return _searchLocalService.getFieldValue(article, fieldName, locale);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SearchLocalService getWrappedSearchLocalService() {
		return _searchLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSearchLocalService(
		SearchLocalService searchLocalService) {
		_searchLocalService = searchLocalService;
	}

	@Override
	public SearchLocalService getWrappedService() {
		return _searchLocalService;
	}

	@Override
	public void setWrappedService(SearchLocalService searchLocalService) {
		_searchLocalService = searchLocalService;
	}

	private SearchLocalService _searchLocalService;
}