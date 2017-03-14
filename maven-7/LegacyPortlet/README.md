# Legacy Porlet

## Synopsis

LegacyPortlet illustrates the usage of the ServiceTrackerFactory in a Portlet built in the legacy way (deployed as war file). This example requires connect to LDAP Servers, adding at least one configuration in the Control Panel > Instance Settings - LDAP tab

## Code 

The important code is in `com.jcampoy.liferay.samples.legacy.portlet.LegacyPortlet.java`

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
1. Click the button in the portlet view

*Result:*

* Environment details are written in the log file
* Server Names list is displayed in the view of the Legacy Portlet