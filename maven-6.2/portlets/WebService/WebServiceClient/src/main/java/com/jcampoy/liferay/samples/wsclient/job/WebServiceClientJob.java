package com.jcampoy.liferay.samples.wsclient.job;

import com.jcampoy.liferay.samples.service.http.LogServiceSoap;
import com.jcampoy.liferay.samples.wsclient.WebServiceClientUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Liferay scheduled job calling to the LogService Web Service
 *  
 * @author José Angel Jiménez
 */
public class WebServiceClientJob implements MessageListener {

	private static final Log _log = 
		LogFactoryUtil.getLog(WebServiceClientJob.class);

	@Override
	public void receive(Message message) throws MessageListenerException {
		try {

			if (counter.get() == Integer.MAX_VALUE){
				_log.debug("Reset job execution counter");
				counter.set(0);
			}

			String msg = "Job execution # " + counter.incrementAndGet();

			if (_log.isDebugEnabled()) {
				_log.debug("Calling LogService with message: " + msg);
			}

			// get service using default user and passworkd
			LogServiceSoap logService = WebServiceClientUtil.getLogServiceWS();

			// call log service
			logService.info(msg);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static AtomicInteger counter = new AtomicInteger(0);
}
