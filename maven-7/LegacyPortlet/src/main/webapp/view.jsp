<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jcampoy.liferay.samples.legacy.portlet.LegacyPortlet"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

This is the <b>LegacyPortlet</b>

<br/><br/>

<% 
List<String> serverNames = renderRequest.getAttribute(LegacyPortlet.LDAP_SERVER_NAMES) != null ? 
	(List<String>)renderRequest.getAttribute(LegacyPortlet.LDAP_SERVER_NAMES) : new ArrayList<String>();

	if(serverNames.size()>0){
%>
		<h2>Ldap Servers</h2>
	<%
	}
	
	for (String s: serverNames) {
	%>
		<strong><%= s %></strong> 
		<br/>
	<% 
	}
	%>

<portlet:actionURL var="actionURL"/>

<aui:form action="<%= actionURL %>" method="post" name="fm">

	<aui:button-row>
		<aui:button type="submit" value="Get LDAP Servers"/>
	</aui:button-row>
</aui:form>