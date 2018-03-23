<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<liferay-ui:success key="success" message="success" />
<liferay-ui:error key="error" message="error"/>

<liferay-portlet:renderURL var="addRenderCookie">
		<portlet:param name="addRenderCookie" value="addRenderCookie" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL var="addActionCookie">
	<portlet:param name="addActionCookie" value="addActionCookie" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL var="cleanPortletCookies">
	<portlet:param name="cleanPortletCookies" value="cleanPortletCookies" />
</liferay-portlet:actionURL>

<aui:form action="<%= addRenderCookie %>" method="post" >
	<aui:button-row>
		<aui:button type="submit" value="Add cookie in render phase" />
	</aui:button-row>
</aui:form>

<aui:form action="<%= addActionCookie %>" method="post" >
	<aui:button-row>
		<aui:button type="submit" value="Add cookie in action phase" />
	</aui:button-row>
</aui:form>

<aui:form action="<%= cleanPortletCookies %>" method="post" >
	<aui:button-row>
		<aui:button type="submit" value="Clean portlet cookies" />
	</aui:button-row>
</aui:form>