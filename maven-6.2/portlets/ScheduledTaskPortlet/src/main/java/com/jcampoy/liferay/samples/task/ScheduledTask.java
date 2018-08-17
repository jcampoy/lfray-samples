package com.jcampoy.liferay.samples.task;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Scheduled Job listener
 *  
 * @author José Angel Jiménez
 */
public class ScheduledTask implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		if (counter.get() == Integer.MAX_VALUE) {
			_log.debug("Reset job execution counter");
			counter.set(0);
		}

		String taskId = "TaskID #" + counter.incrementAndGet() ;
		
		String threadName = Thread.currentThread().getName();

		if (_IN_PROGRESS) {
			_log.warn(
				String.format( 
					"****** %s Discarding %s because is already one in progress ", threadName, taskId));
			return;
		} 
		else {
			try {
				_IN_PROGRESS = true;
				process(message, taskId, threadName);
			} catch (InterruptedException ie) {
				_log.error(ie);
			}
			catch (Exception e) {
				_log.error(e);
			} finally {
				_IN_PROGRESS = false;
			}
		}
	}

	/**
	 * Add the main logic of the task here.
	 */
	private void process(Message messagge, String taskId, String threadName) 
		throws Exception {

		// main logic of the task here

		_log.info(
			String.format( 
				"****** %s Running %s (simulates the execution during 5:30 minutes)", 
					threadName, 
					taskId));

		Thread.sleep(360000);

		_log.info(
			String.format( 
				"****** %s Finished %s ", 
					threadName, 
					taskId));
	}

	private static AtomicInteger counter = new AtomicInteger(0);

	private volatile static boolean _IN_PROGRESS = false;

	private static final Log _log = 
		LogFactoryUtil.getLog(ScheduledTask.class);
}
