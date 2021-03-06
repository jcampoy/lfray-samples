package com.jcampoy.liferay.samples.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Log. This utility wraps
 * {@link com.jcampoy.liferay.samples.service.impl.LogServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LogService
 * @see com.jcampoy.liferay.samples.service.base.LogServiceBaseImpl
 * @see com.jcampoy.liferay.samples.service.impl.LogServiceImpl
 * @generated
 */
public class LogServiceUtil {
    private static LogService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.jcampoy.liferay.samples.service.impl.LogServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void debug(java.lang.String msg) {
        getService().debug(msg);
    }

    public static void fatal(java.lang.String msg) {
        getService().fatal(msg);
    }

    public static void info(java.lang.String msg) {
        getService().info(msg);
    }

    public static void warn(java.lang.String msg) {
        getService().warn(msg);
    }

    public static void trace(java.lang.String msg) {
        getService().trace(msg);
    }

    public static void clearService() {
        _service = null;
    }

    public static LogService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LogService.class.getName());

            if (invokableService instanceof LogService) {
                _service = (LogService) invokableService;
            } else {
                _service = new LogServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(LogServiceUtil.class, "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(LogService service) {
    }
}
