package com.liferay.support.task;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerEventMessageListenerWrapper;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;

public class PersistedTaskUtil {

	public static MessageListener registerListener(MessageListener listener, SchedulerResponse schedulerResponse) {
		
		String listenerClassName = listener.getClass().getName();

		SchedulerEventMessageListenerWrapper schedulerEventMessageListenerWrapper =
			new SchedulerEventMessageListenerWrapper();

		SchedulerEntryImpl schedulerEntry = new SchedulerEntryImpl();
	
		schedulerEntry.setTrigger(schedulerResponse.getTrigger());
		schedulerEntry.setDescription(schedulerResponse.getDescription());
		schedulerEntry.setEventListenerClass(listenerClassName);
	
		schedulerEventMessageListenerWrapper.setSchedulerEntry(schedulerEntry);
		schedulerEventMessageListenerWrapper.setMessageListener(listener);
	
		_log.fatal("Register "+listenerClassName+" for:: jobName[" + schedulerResponse.getJobName()  + "] groupName[" +schedulerResponse.getGroupName() + "] startDate[" + schedulerResponse.getTrigger().getStartDate()+ "]");
	
		MessageBusUtil.registerMessageListener(DestinationNames.SCHEDULER_DISPATCH, schedulerEventMessageListenerWrapper);

		return schedulerEventMessageListenerWrapper;
	}

	public static String getJobKey(SchedulerResponse schedulerResponse) {
		return  schedulerResponse.getGroupName() + "_" + schedulerResponse.getJobName();
	}


	private static final Log _log = LogFactoryUtil.getLog(LogMessageListener.class);
}
