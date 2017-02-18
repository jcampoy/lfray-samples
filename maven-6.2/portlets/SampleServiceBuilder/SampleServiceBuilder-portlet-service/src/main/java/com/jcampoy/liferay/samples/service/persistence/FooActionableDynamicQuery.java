package com.jcampoy.liferay.samples.service.persistence;

import com.jcampoy.liferay.samples.model.Foo;
import com.jcampoy.liferay.samples.service.FooLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FooActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FooActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FooLocalServiceUtil.getService());
        setClass(Foo.class);

        setClassLoader(com.jcampoy.liferay.samples.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fooId");
    }
}
