<%@ include file="./init.jsp" %>

<p>
	<b><liferay-ui:message key="persisted_tasks_PersistedTasksPortlet.caption"/></b>
</p>

<liferay-portlet:actionURL var="scheduleURL" name="schedule" />
<liferay-portlet:actionURL var="unscheduleURL" name="unschedule" />

<aui:form action="<%= scheduleURL %>" method="post" name='<%= "fm" %>' > 
	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="schedule" />
	</aui:button-row>
</aui:form>

<aui:form action="<%= unscheduleURL %>" method="post" name='<%= "fm2" %>' > 
	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="unschedule"/>
	</aui:button-row>
</aui:form>
