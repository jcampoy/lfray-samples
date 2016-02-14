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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Search. This utility wraps
 * {@link com.liferay.portlet.sample.service.impl.SearchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SearchLocalService
 * @see com.liferay.portlet.sample.service.base.SearchLocalServiceBaseImpl
 * @see com.liferay.portlet.sample.service.impl.SearchLocalServiceImpl
 * @generated
 */
public class SearchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.sample.service.impl.SearchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.portlet.sample.service.SearchLocalServiceUtil} to access the search local service.
	*/
	public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> searchWC(
		java.lang.String structureKey, java.lang.String fieldName,
		java.io.Serializable fieldValue,
		com.liferay.portal.theme.ThemeDisplay themeDisplay) {
		return getService()
				   .searchWC(structureKey, fieldName, fieldValue, themeDisplay);
	}

	public static java.lang.String getFieldValue(
		com.liferay.portlet.journal.model.JournalArticle article,
		java.lang.String fieldName, java.util.Locale locale) {
		return getService().getFieldValue(article, fieldName, locale);
	}

	public static void clearService() {
		_service = null;
	}

	public static SearchLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SearchLocalService.class.getName());

			if (invokableLocalService instanceof SearchLocalService) {
				_service = (SearchLocalService)invokableLocalService;
			}
			else {
				_service = new SearchLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SearchLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SearchLocalService service) {
	}

	private static SearchLocalService _service;
}