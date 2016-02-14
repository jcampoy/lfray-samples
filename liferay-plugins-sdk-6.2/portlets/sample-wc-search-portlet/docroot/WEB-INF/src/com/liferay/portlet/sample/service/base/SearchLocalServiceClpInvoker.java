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

package com.liferay.portlet.sample.service.base;

import com.liferay.portlet.sample.service.SearchLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SearchLocalServiceClpInvoker {
	public SearchLocalServiceClpInvoker() {
		_methodName14 = "getBeanIdentifier";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "setBeanIdentifier";

		_methodParameterTypes15 = new String[] { "java.lang.String" };

		_methodName18 = "searchWC";

		_methodParameterTypes18 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.Serializable",
				"com.liferay.portal.theme.ThemeDisplay"
			};

		_methodName19 = "getFieldValue";

		_methodParameterTypes19 = new String[] {
				"com.liferay.portlet.journal.model.JournalArticle",
				"java.lang.String", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SearchLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			SearchLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return SearchLocalServiceUtil.searchWC((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(java.io.Serializable)arguments[2],
				(com.liferay.portal.theme.ThemeDisplay)arguments[3]);
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return SearchLocalServiceUtil.getFieldValue((com.liferay.portlet.journal.model.JournalArticle)arguments[0],
				(java.lang.String)arguments[1], (java.util.Locale)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
}