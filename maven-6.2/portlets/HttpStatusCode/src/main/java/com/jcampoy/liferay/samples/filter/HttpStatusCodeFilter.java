package com.jcampoy.liferay.samples.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.servlet.TryFinallyFilter;
import com.liferay.portal.kernel.servlet.WrapHttpServletResponseFilter;
import com.liferay.portal.kernel.util.CentralizedThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;

/**
 * @author Jose A. Jimenez
 */
public class HttpStatusCodeFilter extends BaseFilter
    implements TryFinallyFilter {

    public static String CUSTOM_STATUS_ATTRIBUTE = "LIFERAY_SHARED_CUSTOM_STATUS_CODE";

    @Override
	public void init(FilterConfig filterConfig) {
        super.init(filterConfig);

        boolean useRequestAttribute = GetterUtil.getBoolean(
            filterConfig.getInitParameter("useRequestAttribute"), false);

        _useRequestAttribute = useRequestAttribute;
        
        if (_useRequestAttribute) {
            _log.info("HttpStatusCodeFilter will use the request attribute: " + CUSTOM_STATUS_ATTRIBUTE);
        } else {
            _log.info("HttpStatusCodeFilter will use the threadLocal: " + HttpStatusCodeThreadLocal.class );
        }
    }

    @Override
	public Object doFilterTry(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
            _log.debug("--- doFilterTry " + request.getRequestURI());

            Integer customStatusCode = null;

            if (_useRequestAttribute) {
                if (request.getAttribute(CUSTOM_STATUS_ATTRIBUTE) != null) {
                    customStatusCode = (Integer)request.getAttribute(CUSTOM_STATUS_ATTRIBUTE);
                    _log.debug("From request attribute: " + customStatusCode);
                }
            }
            else {
                customStatusCode = HttpStatusCodeThreadLocal.getCustomStatus();
                _log.debug("From ThreadLocal: " + customStatusCode);
            }

            if (customStatusCode != null) {
                response.setStatus(customStatusCode.intValue());

                _log.debug("--- Custom status has been stablished to " + customStatusCode);

                // Clear customStatusCode after execute the filters chain
                return Boolean.TRUE;
            }

            // Do not clear customStatusCode after execute the filters chain
            return Boolean.FALSE;
    }

    @Override
    public void doFilterFinally(
        HttpServletRequest request, HttpServletResponse response, Object filterTryResult) {
        try {
            boolean clearCustomStatus = ((Boolean) filterTryResult).booleanValue();
            
            if (clearCustomStatus) {
                _log.debug("x Clear CustomStatus");

                if (_useRequestAttribute) {
                    request.removeAttribute(CUSTOM_STATUS_ATTRIBUTE);
                } else {
                    HttpStatusCodeThreadLocal.clearCustomStatus();
                }
            } 
        } catch (Exception e) {
            _log.error("Trying to clear HttpStatusCodeThreadLocal", e);
        }
    }

    @Override
    protected Log getLog() {
        return _log;
    }

    private static boolean _useRequestAttribute = true;

    private static final Log _log = LogFactoryUtil.getLog(HttpStatusCodeFilter.class);
}
