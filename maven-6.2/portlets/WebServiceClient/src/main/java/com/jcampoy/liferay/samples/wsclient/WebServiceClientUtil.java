package com.jcampoy.liferay.samples.wsclient;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URL;

public class WebServiceClientUtil {

	public static URL getWebServiceSampleURL(
		String remoteUser, String password, boolean authenticate)
	throws Exception {

		// Unauthenticated url
		String url = "http://localhost:8080/WebServiceSample-portlet/api/axis/Plugin_WebServiceSample_LogService";

		// Authenticated url
		if (authenticate) {
			url = "http://" + remoteUser + ":" + password
				+ "@localhost:8080/WebServiceSample-portlet/api/axis/Plugin_WebServiceSample_LogService";
		}

		_log.debug(url);

		return new URL(url);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(WebServiceClientUtil.class);
}
