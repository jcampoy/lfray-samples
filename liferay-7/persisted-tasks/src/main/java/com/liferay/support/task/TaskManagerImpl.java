package com.liferay.support.task;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerEventMessageListenerWrapper;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;

/**
 * The Class TaskManagerImpl.
 *
 * @author Jose A. Jimenez
 */
@Component(
	immediate = true
)
public class TaskManagerImpl implements TaskManager {

	/**
	 * Activate.
	 */
	@Activate
	protected void activate() {
		jobs = new HashMap<String, MessageListener>();

		_log.fatal("Activate TaskManager");

		try {
			for (SchedulerResponse schedulerResponse: _schedulerEngineHelper.getScheduledJobs(PersistedTaskConstants.GROUP_NAME, StorageType.PERSISTED)) {
				registerListener(schedulerResponse); 
			}
		} catch (SchedulerException e) {
			_log.error("ERROR registering listener",e);
		}
	}

	/**
	 * Register listener.
	 *
	 * @param schedulerResponse
	 *            the scheduler response
	 */
	private void registerListener(SchedulerResponse schedulerResponse) {
		String jobKey = PersistedTaskUtil.getJobKey(schedulerResponse);

		if (jobs.containsKey(jobKey)) {
			_log.fatal("Listener already exists for " + jobKey);
			jobs.get(jobKey);
		}
		else {
			SchedulerEventMessageListenerWrapper
			schedulerEventMessageListenerWrapper =
				new SchedulerEventMessageListenerWrapper();

			SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();

			schedulerEntry.setTrigger(schedulerResponse.getTrigger());
			schedulerEntry.setDescription(schedulerResponse.getDescription());
			schedulerEntry.setEventListenerClass(LogMessageListener.class.getName());

			schedulerEventMessageListenerWrapper.setSchedulerEntry(schedulerEntry);
			schedulerEventMessageListenerWrapper.setMessageListener(new LogMessageListener());

			_log.fatal("Register listener for:: jobName[" + schedulerResponse.getJobName()  + "] groupName[" +schedulerResponse.getGroupName() + "] startDate[" + schedulerResponse.getTrigger().getStartDate()+ "]");

			MessageBusUtil.registerMessageListener(DestinationNames.SCHEDULER_DISPATCH, schedulerEventMessageListenerWrapper);

			jobs.put(jobKey, schedulerEventMessageListenerWrapper);
		}
	}

	/**
	 * Register listener.
	 *
	 * @param trigger
	 *            the trigger
	 */
	private void registerListener(Trigger trigger) {
		String jobKey = getJobKey(trigger);

		if (jobs.containsKey(jobKey)) {
			_log.fatal("Listener already exists for " + jobKey);
			jobs.get(jobKey);
		}
		else {
			SchedulerEventMessageListenerWrapper
			schedulerEventMessageListenerWrapper =
				new SchedulerEventMessageListenerWrapper();

			SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();

			schedulerEntry.setTrigger(trigger);
			schedulerEntry.setDescription("sample description");
			schedulerEntry.setEventListenerClass(LogMessageListener.class.getName());

			schedulerEventMessageListenerWrapper.setSchedulerEntry(schedulerEntry);
			schedulerEventMessageListenerWrapper.setMessageListener(new LogMessageListener());

			_log.fatal("Register listener for:: jobName[" + trigger.getJobName()  + "] groupName[" +trigger.getGroupName() + "] startDate[" + trigger.getStartDate()+ "]");

			MessageBusUtil.registerMessageListener(DestinationNames.SCHEDULER_DISPATCH, schedulerEventMessageListenerWrapper);

			jobs.put(jobKey, schedulerEventMessageListenerWrapper);
		}
	}

	/**
	 * Gets the job key.
	 *
	 * @param trigger
	 *            the trigger
	 * @return the job key
	 */
	public String getJobKey(Trigger trigger) {
		return  trigger.getGroupName() + "_" + trigger.getJobName();
	}

	/* (non-Javadoc)
	 * @see com.liferay.support.task.TaskManager#addTask(java.lang.String, java.lang.String, com.liferay.portal.kernel.scheduler.Trigger, java.lang.String)
	 */
	public void addTask(String jobName, String groupName, Trigger trigger, String logMessage) {
		try {
			Message message = new Message();
			message.put("info", "Hello world!");
			message.put("logMessage", logMessage);
	
			SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();
	
			schedulerEntry.setTrigger(trigger);
			schedulerEntry.setDescription("This is the schedulerEntry description");
			schedulerEntry.setEventListenerClass(LogMessageListener.class.getName());
	
			_log.fatal("Scheduling new task:: jobName[" + jobName + "] groupName[" + PersistedTaskConstants.GROUP_NAME+"]");

			_schedulerEngineHelper.schedule(
				trigger, StorageType.PERSISTED, "This is an example of persisted task",
				DestinationNames.SCHEDULER_DISPATCH, message, 10);

			registerListener(trigger);

		} catch (Exception e)  {
			_log.error(e);
		}
	}

	/**
	 * Deactivate.
	 */
	@Deactivate
	protected void deactivate() {
		for (MessageListener l: jobs.values()) {
			_log.fatal("Unregister " + l.toString() );
			MessageBusUtil.unregisterMessageListener(DestinationNames.SCHEDULER_DISPATCH, l);
		}
	}

	/**
	 * Sets the scheduler engine helper.
	 *
	 * @param schedulerEngineHelper
	 *            the new scheduler engine helper
	 */
	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
		SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(TaskManager.class);
	
	/** The _scheduler engine helper. */
	private SchedulerEngineHelper _schedulerEngineHelper;

	/** The jobs. */
	private static Map<String, MessageListener> jobs;
}
