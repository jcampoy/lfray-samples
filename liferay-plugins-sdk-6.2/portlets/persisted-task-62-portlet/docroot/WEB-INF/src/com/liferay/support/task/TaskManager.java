package com.liferay.support.task;

import com.liferay.portal.kernel.scheduler.Trigger;

public interface TaskManager {

	public void addTask(String jobName, String groupName, Trigger trigger, String portletId, String logMessage) ;
}
