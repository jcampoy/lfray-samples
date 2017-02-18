package com.jcampoy.liferay.samples.service.impl;

import com.jcampoy.liferay.samples.model.Foo;
import com.jcampoy.liferay.samples.service.base.FooLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jcampoy.liferay.samples.service.FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.jcampoy.liferay.samples.service.base.FooLocalServiceBaseImpl
 * @see com.jcampoy.liferay.samples.service.FooLocalServiceUtil
 */
public class FooLocalServiceImpl extends FooLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.jcampoy.liferay.samples.service.FooLocalServiceUtil} to access the foo local service.
     */

    /**
     * Returns a range of all the foos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.jcampoy.liferay.samples.model.impl.FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of foos
     * @param end the upper bound of the range of foos (not inclusive)
     * @return the range of foos
     * @throws SystemException if a system exception occurred
     */
	 public List<Foo> listFoos(int start, int end) throws SystemException {
        return fooPersistence.findAll(start, end);
    }

}
