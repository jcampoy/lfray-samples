package com.jcampoy.liferay.samples.service.impl;

import com.jcampoy.liferay.samples.service.base.LogServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the log remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jcampoy.liferay.samples.service.LogService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jcampoy.liferay.samples.service.base.LogServiceBaseImpl
 * @see com.jcampoy.liferay.samples.service.LogServiceUtil
 */
public class LogServiceImpl extends LogServiceBaseImpl {

	public void debug(String msg) {
		if (_log.isDebugEnabled()) {
			_log.debug(msg);
		}
	}

	public void fatal(String msg) {
		_log.fatal(msg);
	}

	public void info(String msg) {
		if (_log.isInfoEnabled()) {
			_log.info(msg);
		}
	}

	public void warn(String msg) {
		_log.warn(msg);
	}

	public void trace(String msg) {
		if (_log.isTraceEnabled()) {
			_log.trace(msg);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog("WebServiceSample");
}
