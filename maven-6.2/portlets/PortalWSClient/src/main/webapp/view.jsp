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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/init.jsp" %>

<liferay-ui:success key="success" message="success" />

<liferay-ui:error key="error" message="error"/>

<liferay-ui:error key="empty-user" message="empty-user"/>
<liferay-ui:error key="empty-password" message="empty-password"/>
<liferay-ui:error key="invalid-folder-or-repository" message="invalid-folder-or-repository"/>
<liferay-ui:error key="remote-error" message="remote-error"/>
<liferay-ui:error key="auth-error" message="auth-error"/>

<portlet:actionURL var="callServiceURL">
	<portlet:param name="<%= Constants.CMD %>" value="getFileEntries" />
</portlet:actionURL>

<aui:form action="<%= callServiceURL %>" method="post" name="fm">

	<aui:input label="remoteUser" name="user" type="text" value="" />
	<aui:input label="remotePassword" name="password" type="password" value="" />

	<aui:input label="folderId" name="folderId" type="text"  value="0">
		<aui:validator name="number" />
	</aui:input>

	<aui:input label="repositoryId" name="repositoryId" type="text" value="<%= themeDisplay.getSiteGroupId() %>">
		<aui:validator name="number" />
	</aui:input>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>


<%
String message = renderRequest.getAttribute("message") == null ? "" : (String) renderRequest.getAttribute("message") ;
%>

<%= message %>
