package com.liferay.support.portlet;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.CronText;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.scheduler.TriggerType;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.support.task.PersistedTaskConstants;
import com.liferay.support.task.TaskManager;
import com.liferay.support.task.TaskManagerImpl;
import com.liferay.util.bridges.mvc.MVCPortlet;


/**
 * Portlet implementation class PersistedTaskPortlet
 */
public class PersistedTaskPortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();
		setTaskManager(new TaskManagerImpl());
	}

	public void schedule(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		String portletId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		_log.fatal(portletId);

		Calendar startDate = Calendar.getInstance(TimeZoneUtil.GMT);

		Calendar endDate = Calendar.getInstance(TimeZoneUtil.GMT);
		endDate.add(Calendar.YEAR, 1);

		String curDate = DateUtil.getCurrentDate("HH:mm:ss dd-MM-yyyy", LocaleUtil.SPAIN);

		String jobName = "SampleTask_".concat(curDate);
		CronText cronText = new CronText(startDate, CronText.MINUTELY_FREQUENCY, 1);

		//Trigger trigger = TriggerFactoryUtil.createTrigger(jobName, PersistedTaskConstants.GROUP_NAME, 1, TimeUnit.MINUTE);

		try {
			Trigger trigger = TriggerFactoryUtil.buildTrigger(
					TriggerType.CRON, jobName, PersistedTaskConstants.GROUP_NAME,
					startDate.getTime(), endDate.getTime(), cronText.toString());

			_taskManager.addTask(jobName, PersistedTaskConstants.GROUP_NAME, trigger, portletId, "Hi! I am the job: " + jobName);
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

	protected void setTaskManager(TaskManager taskManager) {
		_taskManager = taskManager;
	}

	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}


	private TaskManager _taskManager;
	private static final Log _log = LogFactoryUtil.getLog(PersistedTaskPortlet.class);

}
