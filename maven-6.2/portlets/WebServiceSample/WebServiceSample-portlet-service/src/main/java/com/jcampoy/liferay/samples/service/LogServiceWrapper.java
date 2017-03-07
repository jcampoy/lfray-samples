package com.jcampoy.liferay.samples.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LogService}.
 *
 * @author Brian Wing Shun Chan
 * @see LogService
 * @generated
 */
public class LogServiceWrapper implements LogService,
    ServiceWrapper<LogService> {
    private LogService _logService;

    public LogServiceWrapper(LogService logService) {
        _logService = logService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _logService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _logService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _logService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void debug(java.lang.String msg) {
        _logService.debug(msg);
    }

    @Override
    public void fatal(java.lang.String msg) {
        _logService.fatal(msg);
    }

    @Override
    public void info(java.lang.String msg) {
        _logService.info(msg);
    }

    @Override
    public void warn(java.lang.String msg) {
        _logService.warn(msg);
    }

    @Override
    public void trace(java.lang.String msg) {
        _logService.trace(msg);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public LogService getWrappedLogService() {
        return _logService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedLogService(LogService logService) {
        _logService = logService;
    }

    @Override
    public LogService getWrappedService() {
        return _logService;
    }

    @Override
    public void setWrappedService(LogService logService) {
        _logService = logService;
    }
}
