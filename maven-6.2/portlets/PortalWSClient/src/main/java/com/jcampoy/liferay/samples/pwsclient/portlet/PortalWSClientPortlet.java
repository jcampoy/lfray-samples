package com.jcampoy.liferay.samples.pwsclient.portlet;

import com.jcampoy.liferay.samples.pwsclient.util.WebServiceClientUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntrySoap;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.documentlibrary.service.http.DLAppServiceSoap;
import com.liferay.portlet.documentlibrary.util.comparator.RepositoryModelCreateDateComparator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Sample portlet
 *  
 * @author José Angel Jiménez
 */
public class PortalWSClientPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		
		try {
			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			if (cmd.equals("getFileEntries")) {
				long folderId =
					ParamUtil.getLong(actionRequest, "folderId", 0);

				long repositoryId =
					ParamUtil.getLong(actionRequest, "repositoryId", 0);

				String remoteUser =
						ParamUtil.getString(actionRequest, "user", "");
				String password =
						ParamUtil.getString(actionRequest, "password", "");

				if (folderId >= 0 && 
					repositoryId >= 0 &&
					!remoteUser.equals("") &&
					!password.equals("")) {

					if (_log.isDebugEnabled()) {
						_log.debug("Calling DLAppService getFileEntries");
					}
					

					DLAppServiceSoap dlAppService =
						WebServiceClientUtil.getDLAppServiceWS(remoteUser,password);
					OrderByComparator obc =  new OrderByComparator() {
					} ;
					
					for ( FileEntrySoap fe: 
								dlAppService.getFileEntries(
									repositoryId,
									folderId,
									-1,
									-1, 
									obc)) {
						_log.debug(fe.getTitle());
					}
					
					SessionMessages.add(actionRequest, "success");
				}
				else {
					if (remoteUser.equals("")) {
						SessionErrors.add(actionRequest, "empty-user");
					}
					if (password.equals("")) {
						SessionErrors.add(actionRequest, "empty-password");
					}
					if (folderId <0 || repositoryId <= 0) {
						SessionErrors.add(actionRequest, "invalid-folder-or-repository");
					}
				}
			}
		}
		catch (java.lang.SecurityException s) {
			SessionErrors.add(actionRequest, "auth-error");
			_log.error(s);
		}
		catch (java.rmi.RemoteException r) {
			SessionErrors.add(actionRequest, "remote-error");
			_log.error(r);
		}
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error");
			_log.error(e);
		}

		// PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}

	private static final Log _log =
		LogFactoryUtil.getLog(PortalWSClientPortlet.class);
}
