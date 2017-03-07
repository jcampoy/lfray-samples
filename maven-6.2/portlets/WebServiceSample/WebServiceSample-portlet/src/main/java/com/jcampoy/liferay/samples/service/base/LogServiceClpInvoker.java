package com.jcampoy.liferay.samples.service.base;

import com.jcampoy.liferay.samples.service.LogServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LogServiceClpInvoker {
    private String _methodName20;
    private String[] _methodParameterTypes20;
    private String _methodName21;
    private String[] _methodParameterTypes21;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;

    public LogServiceClpInvoker() {
        _methodName20 = "getBeanIdentifier";

        _methodParameterTypes20 = new String[] {  };

        _methodName21 = "setBeanIdentifier";

        _methodParameterTypes21 = new String[] { "java.lang.String" };

        _methodName24 = "debug";

        _methodParameterTypes24 = new String[] { "java.lang.String" };

        _methodName25 = "fatal";

        _methodParameterTypes25 = new String[] { "java.lang.String" };

        _methodName26 = "info";

        _methodParameterTypes26 = new String[] { "java.lang.String" };

        _methodName27 = "warn";

        _methodParameterTypes27 = new String[] { "java.lang.String" };

        _methodName28 = "trace";

        _methodParameterTypes28 = new String[] { "java.lang.String" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName20.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
            return LogServiceUtil.getBeanIdentifier();
        }

        if (_methodName21.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
            LogServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            LogServiceUtil.debug((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            LogServiceUtil.fatal((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            LogServiceUtil.info((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            LogServiceUtil.warn((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            LogServiceUtil.trace((java.lang.String) arguments[0]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
