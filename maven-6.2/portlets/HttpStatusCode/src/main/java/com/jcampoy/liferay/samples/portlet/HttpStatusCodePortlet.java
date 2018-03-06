package com.jcampoy.liferay.samples.portlet;


import com.jcampoy.liferay.samples.filter.HttpStatusCodeFilter;
import com.jcampoy.liferay.samples.filter.HttpStatusCodeThreadLocal;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
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
 * @author Jose A. Jimenez
 */
public class HttpStatusCodePortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	
		_log.debug("doView");
		
		Integer statusCode = ParamUtil.getInteger(renderRequest, "statusCode", Integer.MIN_VALUE);

		if (statusCode != Integer.MIN_VALUE) {
			_log.debug("Save CustomStatusCode ... " + statusCode);
			HttpStatusCodeThreadLocal.setCustomStatus(statusCode);
			renderRequest.setAttribute(HttpStatusCodeFilter.CUSTOM_STATUS_ATTRIBUTE, statusCode);
		}
		
		super.doView(renderRequest, renderResponse);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(HttpStatusCodePortlet.class);
}
