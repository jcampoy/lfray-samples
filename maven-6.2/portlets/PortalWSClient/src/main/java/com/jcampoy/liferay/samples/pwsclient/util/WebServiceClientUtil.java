package com.jcampoy.liferay.samples.pwsclient.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoap;
import com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoapServiceLocator;

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
	public static DLAppServiceSoap getDLAppServiceWS() throws ServiceException {
		return getDLAppServiceWS("test", "test");
	}

	/**
	 * Gets the LogSoapService
	 * 
	 * @return LogServiceSoap The service
	 * @throws ServiceException
	 */
	public static DLAppServiceSoap getDLAppServiceWS(
		String remoteUser, String password) throws ServiceException {
	
			DLAppServiceSoapServiceLocator locator =
				new DLAppServiceSoapServiceLocator();

			DLAppServiceSoap logService =
					locator.getPortlet_DL_DLAppService(
						WebServiceClientUtil.getServiceURL(
								remoteUser, password, true, "Portlet_DL_DLAppService"));

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
	private static URL getServiceURL(
			String remoteUser, String password, boolean authenticate,
			String serviceName) {

		// Unauthenticated url
		String url = "http://localhost:8080/api/axis/" + serviceName;

		// Authenticated url
		if (authenticate) {
			url = "http://" + remoteUser + ":" + password
				+ "@localhost:8080/api/axis/"
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
