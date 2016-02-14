package com.liferay.support.task;

import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
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
public class TaskManagerImpl implements TaskManager {

	/**
	 * Instantiates a new task manager impl.
	 */
	public TaskManagerImpl() {
		jobs = new HashMap<String, MessageListener>();

		_log.fatal("Activate TaskManager");

		try {
			for (SchedulerResponse schedulerResponse: SchedulerEngineHelperUtil.getScheduledJobs(PersistedTaskConstants.GROUP_NAME, StorageType.PERSISTED)) {
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
//
//			SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();
//
//			schedulerEntry.setTrigger(schedulerResponse.getTrigger());
//			schedulerEntry.setDescription(schedulerResponse.getDescription());
//			schedulerEntry.setEventListenerClass(LogMessageListener.class.getName());
//
//			schedulerEventMessageListenerWrapper.setSchedulerEntry(schedulerEntry);
			schedulerEventMessageListenerWrapper.setGroupName(schedulerResponse.getGroupName());
			schedulerEventMessageListenerWrapper.setJobName(schedulerResponse.getJobName());
			schedulerEventMessageListenerWrapper.setMessageListener(new LogMessageListener());
			schedulerEventMessageListenerWrapper.afterPropertiesSet();
			_log.fatal("Register listener for:: jobName[" + schedulerResponse.getJobName()  + "] groupName[" +schedulerResponse.getGroupName() + "] startDate[" + schedulerResponse.getTrigger().getStartDate()+ "]");

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
	 * @see com.liferay.support.task.TaskManager#addTask(java.lang.String, java.lang.String, com.liferay.portal.kernel.scheduler.Trigger, java.lang.String, java.lang.String)
	 */
	@Override
	public void addTask(String jobName, String groupName, Trigger trigger, String portletId, String logMessage) {
		try {
			Message message = new Message();
			message.put("info", "Hello world!");
			message.put("logMessage", logMessage);
			//message.put(SchedulerEngine.MESSAGE_LISTENER_CLASS_NAME, value);
			//message.put(SchedulerEngine.PORTLET_ID, value);
			
//			SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();
//	
//			//schedulerEntry.setTrigger(trigger);
//			schedulerEntry.setDescription("This is the schedulerEntry description");
//			schedulerEntry.setEventListenerClass(LogMessageListener.class.getName());

			_log.fatal("Scheduling new task:: jobName[" + jobName + "] groupName[" + PersistedTaskConstants.GROUP_NAME+"]");

			SchedulerEngineHelperUtil.addJob(trigger, StorageType.PERSISTED, "This is an example of persisted task",
					DestinationNames.SCHEDULER_DISPATCH, message, LogMessageListener.class.getName(), portletId, 10);

			//SchedulerResponse schedulerResponse = _schedulerEngineHelper.getScheduledJob(jobName, PersistedTaskConstants.GROUP_NAME, StorageType.PERSISTED);

			//registerListener(trigger);

		//_log.fatal("Registering new listener for schedulerEntry:: jobName[" + jobName + "] groupName[" + PersistedTaskConstants.GROUP_NAME+"]");
		//SchedulerEngineHelperUtil.register(new LogMessageListener(), schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		} catch (Exception e)  {
			_log.error(e);
		}
	}

	/**
	 * Destroy.
	 *
	 * @throws Throwable
	 *             the throwable
	 */
	protected void destroy() throws Throwable {

	}

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(TaskManager.class);

	/** The jobs. */
	private static Map<String, MessageListener> jobs;
}
