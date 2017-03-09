package com.jcampoy.liferay.samples.wsclient;

import com.jcampoy.liferay.samples.service.http.LogServiceSoap;
import com.jcampoy.liferay.samples.service.http.LogServiceSoapServiceLocator;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.rpc.ServiceException;

/**
 * Class that locate the service throuht the URL.
 * Authenticated connections is required, implementation via BASIC_AUTH.
 * 
 * @author José Angel Jiménez
 */
public class WebServiceClientUtil {

	/**
	 * Gets the LogSoapService located using default user and password: test test
	 * 
	 * @return LogServiceSoap The service
	 * @throws ServiceException
	 */
	public static LogServiceSoap getLogServiceWS() throws ServiceException {
		return getLogServiceWS("test", "test");
	}

	/**
	 * Gets the LogSoapService
	 * 
	 * @return LogServiceSoap The service
	 * @throws ServiceException
	 */
	public static LogServiceSoap getLogServiceWS(
		String remoteUser, String password) throws ServiceException {
	
		LogServiceSoapServiceLocator locator =
				new LogServiceSoapServiceLocator();

		LogServiceSoap logService =
			locator.getPlugin_WebServiceSample_LogService(
				WebServiceClientUtil.getWebServiceSampleURL(
					remoteUser, password, true, "LogService"));

		return logService;
	}
	/**
	 * Build the URL to the service.
	 * 
	 * @param remoteUser
	 * @param password
	 * @param authenticate
	 * @param serviceName
	 * @return URL
	 */
	private static URL getWebServiceSampleURL(
			String remoteUser, String password, boolean authenticate,
			String serviceName) {

		// Unauthenticated url
		String url = "http://localhost:8080/WebServiceSample-portlet/api/axis/Plugin_WebServiceSample_" + serviceName;

		// Authenticated url
		if (authenticate) {
			url = "http://" + remoteUser + ":" + password
				+ "@localhost:8080/WebServiceSample-portlet/api/axis/Plugin_WebServiceSample_"
				+ serviceName;
		}

		_log.debug(url);

		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			_log.error(e);
		}

		return null;
	}

	private static final Log _log =
		LogFactoryUtil.getLog(WebServiceClientUtil.class);
}
