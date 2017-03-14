# Legacy Porlet

## Synopsis
LegacyPortlet illustrates the usage of the ServiceTrackerFactory in a Portlet built in the legacy way (deployed as war file). This example requires connect an LDAP Servers, see https://dev.liferay.com/discover/deployment/-/knowledge_base/7-0/ldap

## Code 
The important code is in `com.jcampoy.liferay.samples.legacy.portlet.LegacyPortlet`

**init**
	Open service trackers using the util class `com.liferay.osgi.util.ServiceTrackerFactory`

**destroy**
	Close the service Trackers

**processAction**
	Use the services obtained throught the service trackers and invoke some service actions

## Installation
1. Configure custom LIFERAY_DE_HOME path in the pom.xml
1. Start your LIFERAY DE server
1. run `mvn clean install`


## Tests
1. Log into the portal and add your _Control Panel > Instance Settings > LDAP > Add new LDAP Server_
1. Go to the home page and add the Legacy Portlet to the page.
1. Click in the button displayed by the portlet view

*Results:*

* LDAP Environment details are written in the log file

```18:08:39,491 INFO  [http-nio-8080-exec-10][LegacyPortlet:96] Server Name: server1
18:08:39,492 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.provider.url: ldap://192.168.0.20:1389
18:08:39,492 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.factory.initial: com.sun.jndi.ldap.LdapCtxFactory
18:08:39,493 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.ldap.version: 3
18:08:39,493 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.factory.url.pkgs: org.apache.naming
18:08:39,493 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.security.principal: cn=admin,dc=spaceprogram,dc=liferay,dc=com
18:08:39,493 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.security.credentials: test
18:08:39,494 INFO  [http-nio-8080-exec-10][LegacyPortlet:103] java.naming.referral: follow
```
* LDAP Server name list is displayed in the view of the Legacy Portlet