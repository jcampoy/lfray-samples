<%@ include file="/init.jsp" %>

<liferay-ui:success key="success" message="success" />
<liferay-ui:error key="error" message="error"/>

<portlet:actionURL var="actionURL" />

<aui:form action="<%= actionURL %>" method="post" >
	<aui:select name="statusCode" value="">
		<aui:option label="200" />
		<aui:option label="404" />
		<aui:option label="500" />
	</aui:select>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

