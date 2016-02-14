package com.liferay.support.task;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Jose A. Jimenez
 */
public class LogMessageListener
	extends BaseMessageListener {//BaseSchedulerEntryMessageListener {// BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		_log.fatal("Message received: " + message);
		
		if (message.contains("logMessage")) {
			_log.fatal(message.get("logMessage"));
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(LogMessageListener.class);
}