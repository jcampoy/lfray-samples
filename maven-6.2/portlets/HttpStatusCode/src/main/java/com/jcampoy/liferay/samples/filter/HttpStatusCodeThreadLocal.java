package com.jcampoy.liferay.samples.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.InitialThreadLocal;

/**
 * @author Jose A Jimenez
 */
public class HttpStatusCodeThreadLocal {

	public static Integer getCustomStatus() {
		Integer status = _customStatus.get();

		if (_log.isDebugEnabled()) {
			_log.debug("getCustomStatus " + status);
		}

		return status;
	}

	public static void setCustomStatus(Integer status) {
		if (_log.isDebugEnabled()) {
			_log.debug("setCustomStatus " + status);
		}

		_customStatus.set(status);
	}

    public static void clearCustomStatus() {
		if (_log.isDebugEnabled()) {
			_log.debug("clearCustomStatus");
		}

        _customStatus.remove();
    }
    
	private static Log _log = LogFactoryUtil.getLog(HttpStatusCodeThreadLocal.class);

	private static ThreadLocal<Integer> _customStatus = new InitialThreadLocal<Integer>(
			HttpStatusCodeThreadLocal.class + "._customStatus", null, false);
}