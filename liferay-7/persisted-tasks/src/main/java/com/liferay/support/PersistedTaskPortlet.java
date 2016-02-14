package com.liferay.support;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.support.task.PersistedTaskConstants;
import com.liferay.support.task.TaskManager;


@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Persisted Tasks",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language"
	},
	service = Portlet.class
)
public class PersistedTaskPortlet extends MVCPortlet {

	public void schedule(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String portletId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		_log.fatal(portletId);

		// Calendar startTime = Calendar.getInstance(TimeZoneUtil.GMT);

		String curDate = DateUtil.getCurrentDate("HH:mm dd-MM-yyyy", LocaleUtil.SPAIN);

		String jobName = "SampleTask_".concat(curDate);
		Trigger trigger = TriggerFactoryUtil.createTrigger(jobName, PersistedTaskConstants.GROUP_NAME, 1, TimeUnit.MINUTE);

		try {
			_taskManager.addTask(jobName, PersistedTaskConstants.GROUP_NAME, trigger, "Hi! I am the job: " + jobName);

		} catch (Exception e) {
			_log.error(e);
		}
		
	}

	public void unschedule(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		_log.fatal("Unschedule");

		try {
			for (SchedulerResponse schedulerResponse: SchedulerEngineHelperUtil.getScheduledJobs()) {
				if(schedulerResponse.getGroupName().equals(PersistedTaskConstants.GROUP_NAME)){
					_log.fatal("Unscheduling:: jobName[" + schedulerResponse.getJobName()  + "] groupName[" +schedulerResponse.getGroupName() + "] storageType["+schedulerResponse.getStorageType()+"]");
					SchedulerEngineHelperUtil.unschedule(schedulerResponse.getJobName(), schedulerResponse.getGroupName(), schedulerResponse.getStorageType());
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

	}

	@Reference(unbind = "-")
	protected void setTaskManager(
		TaskManager taskManager) {

		_taskManager = taskManager;

	}

	private TaskManager _taskManager;
	private static final Log _log = LogFactoryUtil.getLog(PersistedTaskPortlet.class);
}