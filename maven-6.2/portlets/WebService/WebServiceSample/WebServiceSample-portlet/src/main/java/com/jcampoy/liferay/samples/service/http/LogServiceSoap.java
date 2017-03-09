package com.jcampoy.liferay.samples.service.http;

import com.jcampoy.liferay.samples.service.LogServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.jcampoy.liferay.samples.service.LogServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LogServiceHttp
 * @see com.jcampoy.liferay.samples.service.LogServiceUtil
 * @generated
 */
public class LogServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(LogServiceSoap.class);

    public static void debug(java.lang.String msg) throws RemoteException {
        try {
            LogServiceUtil.debug(msg);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void fatal(java.lang.String msg) throws RemoteException {
        try {
            LogServiceUtil.fatal(msg);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void info(java.lang.String msg) throws RemoteException {
        try {
            LogServiceUtil.info(msg);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void warn(java.lang.String msg) throws RemoteException {
        try {
            LogServiceUtil.warn(msg);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void trace(java.lang.String msg) throws RemoteException {
        try {
            LogServiceUtil.trace(msg);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
