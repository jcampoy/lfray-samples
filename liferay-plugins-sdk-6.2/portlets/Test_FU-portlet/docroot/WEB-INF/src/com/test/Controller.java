package com.test;


import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Controller
 */
public class Controller extends MVCPortlet {

	public Controller() {
		super();
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String idPromo = ParamUtil.getString(renderRequest, "idPromo");

		_log.info("doView - render");
		_log.info("idPromo = " + idPromo);
		
		super.doView(renderRequest, renderResponse);

	}

	public void altaPromo(ActionRequest actionRequest,
		ActionResponse actionResponse) throws IOException, PortletException {

		String idPromo = ParamUtil.getString(actionRequest, "idPromo");
		String action = ParamUtil.getString(actionRequest,
												ActionRequest.ACTION_NAME);

		_log.info("altaPromo - action");
		_log.info("idPromo = " + idPromo);
		_log.info("javax.portlet.action="+ action);

	}

	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		String idPromo = ParamUtil.getString(resourceRequest, "idPromo");

		_log.info("serveResource");
		_log.info("idPromo = " + idPromo);

		PrintWriter out = resourceResponse.getWriter();

		if(idPromo.equals("1234"))
			out.write("#OK#");
		else
			out.write("#KO#");
					
	}	

	private static Log _log = LogFactoryUtil.getLog(Controller.class);	
}
