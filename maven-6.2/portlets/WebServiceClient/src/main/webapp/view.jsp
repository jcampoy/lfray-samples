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

<%
String message = renderRequest.getAttribute("message") == null ? "" : (String) renderRequest.getAttribute("message") ;
%>

<liferay-ui:success key="success" message="success" />

<liferay-ui:error key="error" message="error"/>

<%= message %>

<portlet:actionURL var="addURL">
	<portlet:param name="<%= Constants.CMD %>" value="writelog" />
</portlet:actionURL>

<aui:form action="<%= addURL %>" method="post" name="fm">

	<aui:input label="write-to-log-file" name="message" type="text" value="" />

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>