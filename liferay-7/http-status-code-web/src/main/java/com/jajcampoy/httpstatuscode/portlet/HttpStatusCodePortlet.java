package com.jajcampoy.httpstatuscode.portlet;

import com.jajcampoy.httpstatuscode.constants.*;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jose Angel Jimenez 
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=HttpStatusCode Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HttpStatusCodeConstants.PORTLET_KEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HttpStatusCodePortlet extends MVCPortlet {

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String statusCode = ParamUtil.getString(renderRequest, "statusCode");

		_log.debug("VIEW Status Code => " + statusCode);

		super.doView(renderRequest, renderResponse);
	}


	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			String statusCode = ParamUtil.getString(actionRequest, "statusCode");

			_log.debug("ACTION Status Code => " + statusCode);

			if (!Validator.isBlank(statusCode)) {
				int code = Integer.parseInt(statusCode);

				_log.debug("Applying Http Status Code => " + statusCode);

				PortalUtil.getHttpServletResponse(actionResponse).setStatus(code);
			}
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			_log.error(e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(HttpStatusCodePortlet.class);
}