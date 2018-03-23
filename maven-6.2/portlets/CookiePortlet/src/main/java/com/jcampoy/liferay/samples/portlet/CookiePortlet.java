package com.jcampoy.liferay.samples.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CookieUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

/** 
 * @author Jose A. Jimenez
 */
public class CookiePortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	
		_log.debug("doView");

		String addRenderCookie = ParamUtil.getString(renderRequest, "addRenderCookie");

		if (!Validator.isBlank(addRenderCookie)) {
			_log.debug(addRenderCookie);

			Cookie renderCookie = new Cookie("RENDER_COOKIE","RENDER_COOKIE");
			renderResponse.addProperty(renderCookie);
		}
		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		try {
			String addActionCookie = ParamUtil.getString(actionRequest, "addActionCookie");
			String cleanPortletCookies = ParamUtil.getString(actionRequest, "cleanPortletCookies");

			if (!Validator.isBlank(addActionCookie)) {
				_log.debug(addActionCookie);

				Cookie actionCookie = new Cookie("ACTION_COOKIE","ACTION_COOKIE");
				actionResponse.addProperty(actionCookie);
			}

			if (!Validator.isBlank(cleanPortletCookies)) {
				_log.debug(cleanPortletCookies);

				for (Cookie c: actionRequest.getCookies()) {
					String cookieName = c.getName();
					if (cookieName.equals("RENDER_COOKIE") || cookieName.equals("ACTION_COOKIE")){
						_log.debug("Delete " + cookieName);
						c.setMaxAge(0);
						actionResponse.addProperty(c);
					}
				}
			}
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			_log.error(e);
		}
	}
	
	private static final Log _log =
		LogFactoryUtil.getLog(CookiePortlet.class);
}
