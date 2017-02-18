package com.jcampoy.liferay.samples.service.impl;

import com.jcampoy.liferay.samples.service.base.FooServiceBaseImpl;

/**
 * The implementation of the foo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jcampoy.liferay.samples.service.FooService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jcampoy.liferay.samples.service.base.FooServiceBaseImpl
 * @see com.jcampoy.liferay.samples.service.FooServiceUtil
 */
public class FooServiceImpl extends FooServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.jcampoy.liferay.samples.service.FooServiceUtil} to access the foo remote service.
     */
}
