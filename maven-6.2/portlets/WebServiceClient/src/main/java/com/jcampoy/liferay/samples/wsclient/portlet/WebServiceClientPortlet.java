package com.jcampoy.liferay.samples.wsclient.portlet;

import com.jcampoy.liferay.samples.service.http.LogServiceSoap;
import com.jcampoy.liferay.samples.service.http.LogServiceSoapServiceLocator;
import com.jcampoy.liferay.samples.wsclient.WebServiceClientUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class WebServiceClientPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		
		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals("writelog")) {
				String message =
					ParamUtil.getString(actionRequest, "logmessage", "");

				String remoteUser =
						ParamUtil.getString(actionRequest, "user", "");
				String password =
						ParamUtil.getString(actionRequest, "password", "");

				if (!message.equals("") &&
					!remoteUser.equals("") &&
					!password.equals("")) {

					if (_log.isDebugEnabled()) {
						_log.debug("Calling LogService with message: " + message);
					}
		
					LogServiceSoapServiceLocator locator =
						new LogServiceSoapServiceLocator();

					LogServiceSoap logService =
						locator.getPlugin_WebServiceSample_LogService(
							WebServiceClientUtil.getWebServiceSampleURL(
								remoteUser, password, true));

					logService.info(message);

					SessionMessages.add(actionRequest, "success");
				}
				else {
					if (remoteUser.equals("")) {
						SessionErrors.add(actionRequest, "empty-user");
					}
					if (password.equals("")) {
						SessionErrors.add(actionRequest, "empty-password");
					}
					if (message.equals("")) {
						SessionErrors.add(actionRequest, "empty-log-message");
					}
				}
			}
		}
		catch (java.lang.SecurityException s) {
			SessionErrors.add(actionRequest, "auth-error");
			_log.error(s);
		}
		catch (java.rmi.RemoteException r) {
			SessionErrors.add(actionRequest, "remote-error");
			_log.error(r);
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			_log.error(e);
		}

		// PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(WebServiceClientPortlet.class);
}
