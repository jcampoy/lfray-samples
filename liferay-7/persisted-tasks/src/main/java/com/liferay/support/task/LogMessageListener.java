package com.liferay.support.task;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;

/**
 * The listener interface for receiving logMessage events. The class that is
 * interested in processing a logMessage event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addLogMessageListener<code> method. When the logMessage
 * event occurs, that object's appropriate method is invoked.
 *
 * @author Jose A. Jimenez
 * @see LogMessageEvent
 */
@Component(
		immediate = true,
		service = MessageListener.class
	)
public class LogMessageListener extends BaseMessageListener {

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.messaging.BaseMessageListener#doReceive(com.liferay.portal.kernel.messaging.Message)
	 */
	@Override
	protected void doReceive(Message message) throws Exception {
		_log.fatal("Message received: " + message);
		
		if (message.contains("logMessage")) {
			_log.fatal(message.get("logMessage"));
		}
	}

	/**
	 * Sets the destination.
	 *
	 * @param destination
	 *            the new destination
	 */
	@Reference(
		target = "(destination.name=" + DestinationNames.SCHEDULER_DISPATCH + ")",
		unbind = "-"
	)
	protected void setDestination(Destination destination) {
	}

	/**
	 * Sets the module service lifecycle.
	 *
	 * @param moduleServiceLifecycle
	 *            the new module service lifecycle
	 */
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(LogMessageListener.class);

}