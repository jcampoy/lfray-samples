package com.jcampoy.liferay.samples.legacy.portlet;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.security.ldap.PortalLDAP;
import com.liferay.portal.security.ldap.configuration.ConfigurationProvider;
import com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.ldap.LdapContext;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Illustrate how to get PortalLDAP service and LDAPServerConfigurationProvider service
 * 
 * @author José Ángel Jiménez
 */
public class LegacyPortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();

		_log.info("Open trackers");

		Bundle bundle = FrameworkUtil.getBundle(LDAPServerConfiguration.class);
		String filter = "(factoryPid=com.liferay.portal.security.ldap.configuration.LDAPServerConfiguration)";

		_ldapServerCfgProviderTracker = ServiceTrackerFactory.open(bundle.getBundleContext(), filter);

		_portalLDAPTracker = ServiceTrackerFactory.open(PortalLDAP.class);
	}

	@Override
	public void destroy() {
		super.destroy();

		_log.info("Close trackers");

		_ldapServerCfgProviderTracker.close();

		_portalLDAPTracker.close();
	}


	/**
	 * Add LDAP_SERVER_NAMES to the view.jsp 
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<String> serverNames = 
			renderRequest.getAttribute(LDAP_SERVER_NAMES) != null ? 
				(List<String>)renderRequest.getAttribute(LDAP_SERVER_NAMES) : new ArrayList<String>();

		renderRequest.setAttribute(LDAP_SERVER_NAMES, serverNames);

		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Get the LDAP Server configurations and write information about the environment of each one in the log file
	 * Also calculates the LDAP Server Names for the view.
	 */
	@Override
	public void processAction(
			ActionRequest actionRequest,
			ActionResponse actionResponse)
			throws IOException, PortletException {

		long companyId = PortalUtil.getCompanyId(actionRequest);
		LdapContext context = null;
		List<String> serverNames = new ArrayList<String>();

		try {
			for (LDAPServerConfiguration ldapCfg: getLDAPConfigurations(companyId)){

				context = getContext(ldapCfg.ldapServerId(), companyId);

				_log.info("Server Name: " + ldapCfg.serverName());

				if (context != null) {
					serverNames.add(ldapCfg.serverName());

					Hashtable<Object, Object> environment = (Hashtable<Object, Object>) context.getEnvironment();
					for (Object key: environment.keySet()) {
						_log.info(key + ": " + environment.get(key));
					}

					try {
						context.close();
					} catch (Exception e2) {
						_log.error(e2);
					}
				} 

				_log.info("---");
			}
		}
		catch (Exception e) {
			_log.error(e);
		}

		actionRequest.setAttribute(LDAP_SERVER_NAMES, serverNames);
	}

	@SuppressWarnings("unchecked")
	private List<LDAPServerConfiguration> getLDAPConfigurations(long companyId) {

		if(_ldapServerCfgProviderTracker.getService() == null) {
			_log.error("Configuration provider for LDAP Server is not available");

			return new ArrayList<LDAPServerConfiguration>();
		}

		return _ldapServerCfgProviderTracker
				.getService().getConfigurations(companyId);
	}

	private LdapContext getContext(long ldapServerId, long companyId)
			throws Exception {

		if ( _portalLDAPTracker.getService() == null) {
			_log.error("PortalLDAP service is not available");
			return null;
		}
	
		return _portalLDAPTracker.getService().getContext(ldapServerId, companyId);
	}

	private ServiceTracker<ConfigurationProvider, ConfigurationProvider> 
		_ldapServerCfgProviderTracker = null;

	private ServiceTracker<PortalLDAP, PortalLDAP> 
		_portalLDAPTracker = null;

	public static final String LDAP_SERVER_NAMES = "LDAP_SERVER_NAMES";

	private static Log _log = LogFactoryUtil.getLog(LegacyPortlet.class);
}