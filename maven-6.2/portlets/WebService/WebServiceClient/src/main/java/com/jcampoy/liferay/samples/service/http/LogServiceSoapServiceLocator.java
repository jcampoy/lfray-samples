/**
 * LogServiceSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jcampoy.liferay.samples.service.http;

public class LogServiceSoapServiceLocator extends org.apache.axis.client.Service implements com.jcampoy.liferay.samples.service.http.LogServiceSoapService {

    public LogServiceSoapServiceLocator() {
    }


    public LogServiceSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LogServiceSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Plugin_WebServiceSample_LogService
    private java.lang.String Plugin_WebServiceSample_LogService_address = "http://localhost:8080/WebServiceSample-portlet/api/axis/Plugin_WebServiceSample_LogService";

    public java.lang.String getPlugin_WebServiceSample_LogServiceAddress() {
        return Plugin_WebServiceSample_LogService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Plugin_WebServiceSample_LogServiceWSDDServiceName = "Plugin_WebServiceSample_LogService";

    public java.lang.String getPlugin_WebServiceSample_LogServiceWSDDServiceName() {
        return Plugin_WebServiceSample_LogServiceWSDDServiceName;
    }

    public void setPlugin_WebServiceSample_LogServiceWSDDServiceName(java.lang.String name) {
        Plugin_WebServiceSample_LogServiceWSDDServiceName = name;
    }

    public com.jcampoy.liferay.samples.service.http.LogServiceSoap getPlugin_WebServiceSample_LogService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Plugin_WebServiceSample_LogService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPlugin_WebServiceSample_LogService(endpoint);
    }

    public com.jcampoy.liferay.samples.service.http.LogServiceSoap getPlugin_WebServiceSample_LogService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.jcampoy.liferay.samples.service.http.Plugin_WebServiceSample_LogServiceSoapBindingStub _stub = new com.jcampoy.liferay.samples.service.http.Plugin_WebServiceSample_LogServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getPlugin_WebServiceSample_LogServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPlugin_WebServiceSample_LogServiceEndpointAddress(java.lang.String address) {
        Plugin_WebServiceSample_LogService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.jcampoy.liferay.samples.service.http.LogServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.jcampoy.liferay.samples.service.http.Plugin_WebServiceSample_LogServiceSoapBindingStub _stub = new com.jcampoy.liferay.samples.service.http.Plugin_WebServiceSample_LogServiceSoapBindingStub(new java.net.URL(Plugin_WebServiceSample_LogService_address), this);
                _stub.setPortName(getPlugin_WebServiceSample_LogServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Plugin_WebServiceSample_LogService".equals(inputPortName)) {
            return getPlugin_WebServiceSample_LogService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:http.service.samples.liferay.jcampoy.com", "LogServiceSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:http.service.samples.liferay.jcampoy.com", "Plugin_WebServiceSample_LogService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Plugin_WebServiceSample_LogService".equals(portName)) {
            setPlugin_WebServiceSample_LogServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
