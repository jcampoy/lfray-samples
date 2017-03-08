package com.jcampoy.liferay.samples.wsclient.portlet;

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
				String message = ParamUtil.getString(actionRequest, "logmessage");

				if (_log.isDebugEnabled()) {
					_log.debug("Calling LogService with message: " + message);
				}
	
				SessionMessages.add(actionRequest, "success");
			}
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
		}

		// PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(WebServiceClientPortlet.class);
}
