package com.jcampoy.liferay.samples.portlet;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Liferay scheduled job calling to the LogService Web Service
 *  
 * @author José Angel Jiménez
 */
public class HttpStatusCodePortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
			
		String statusCode = ParamUtil.getString(renderRequest, "statusCode");

		_log.debug("VIEW Status Code.. "+statusCode);

		/*if (!Validator.isBlank(statusCode)) {
			int code = Integer.parseInt(statusCode);

			PortalUtil.getHttpServletResponse(renderResponse).setStatus(code);
		}*/

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			String statusCode = ParamUtil.getString(actionRequest, "statusCode");

			_log.debug("ACTION Status Code: "+statusCode);

			if (!Validator.isBlank(statusCode)) {
				int code = Integer.parseInt(statusCode);

				PortalUtil.getHttpServletResponse(actionResponse).setStatus(code);

				SessionMessages.add(actionRequest, "success");
			}
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			_log.error(e);
		}

		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(HttpStatusCodePortlet.class);
}
