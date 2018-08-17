package com.jcampoy.liferay.samples.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


/** 
 * @author José Angel Jiménez
 */
public class ScheduledTaskPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	
	private static final Log _log =
		LogFactoryUtil.getLog(ScheduledTaskPortlet.class);
}
