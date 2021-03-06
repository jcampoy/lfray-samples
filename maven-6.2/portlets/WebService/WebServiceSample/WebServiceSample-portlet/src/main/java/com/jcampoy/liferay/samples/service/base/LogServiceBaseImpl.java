package com.jcampoy.liferay.samples.service.base;

import com.jcampoy.liferay.samples.service.LogService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.ClassNamePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the log remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.jcampoy.liferay.samples.service.impl.LogServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jcampoy.liferay.samples.service.impl.LogServiceImpl
 * @see com.jcampoy.liferay.samples.service.LogServiceUtil
 * @generated
 */
public abstract class LogServiceBaseImpl extends BaseServiceImpl
    implements LogService, IdentifiableBean {
    @BeanReference(type = com.jcampoy.liferay.samples.service.LogService.class)
    protected com.jcampoy.liferay.samples.service.LogService logService;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ClassNameLocalService.class)
    protected com.liferay.portal.service.ClassNameLocalService classNameLocalService;
    @BeanReference(type = com.liferay.portal.service.ClassNameService.class)
    protected com.liferay.portal.service.ClassNameService classNameService;
    @BeanReference(type = ClassNamePersistence.class)
    protected ClassNamePersistence classNamePersistence;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private LogServiceClpInvoker _clpInvoker = new LogServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.jcampoy.liferay.samples.service.LogServiceUtil} to access the log remote service.
     */

    /**
     * Returns the log remote service.
     *
     * @return the log remote service
     */
    public com.jcampoy.liferay.samples.service.LogService getLogService() {
        return logService;
    }

    /**
     * Sets the log remote service.
     *
     * @param logService the log remote service
     */
    public void setLogService(
        com.jcampoy.liferay.samples.service.LogService logService) {
        this.logService = logService;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the class name local service.
     *
     * @return the class name local service
     */
    public com.liferay.portal.service.ClassNameLocalService getClassNameLocalService() {
        return classNameLocalService;
    }

    /**
     * Sets the class name local service.
     *
     * @param classNameLocalService the class name local service
     */
    public void setClassNameLocalService(
        com.liferay.portal.service.ClassNameLocalService classNameLocalService) {
        this.classNameLocalService = classNameLocalService;
    }

    /**
     * Returns the class name remote service.
     *
     * @return the class name remote service
     */
    public com.liferay.portal.service.ClassNameService getClassNameService() {
        return classNameService;
    }

    /**
     * Sets the class name remote service.
     *
     * @param classNameService the class name remote service
     */
    public void setClassNameService(
        com.liferay.portal.service.ClassNameService classNameService) {
        this.classNameService = classNameService;
    }

    /**
     * Returns the class name persistence.
     *
     * @return the class name persistence
     */
    public ClassNamePersistence getClassNamePersistence() {
        return classNamePersistence;
    }

    /**
     * Sets the class name persistence.
     *
     * @param classNamePersistence the class name persistence
     */
    public void setClassNamePersistence(
        ClassNamePersistence classNamePersistence) {
        this.classNamePersistence = classNamePersistence;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = InfrastructureUtil.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
