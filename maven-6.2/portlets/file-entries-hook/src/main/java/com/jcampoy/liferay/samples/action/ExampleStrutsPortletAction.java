package com.jcampoy.liferay.samples.action;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExampleStrutsPortletAction extends BaseStrutsAction {

	public String execute(
            HttpServletRequest request, HttpServletResponse response)
                    throws Exception {

		System.out.println("execute /sample/sampletest");

		return "/sample.jsp";
	}

}
