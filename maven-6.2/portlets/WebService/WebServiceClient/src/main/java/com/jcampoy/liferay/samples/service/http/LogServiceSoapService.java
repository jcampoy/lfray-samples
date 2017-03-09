/**
 * LogServiceSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jcampoy.liferay.samples.service.http;

public interface LogServiceSoapService extends javax.xml.rpc.Service {
    public java.lang.String getPlugin_WebServiceSample_LogServiceAddress();

    public com.jcampoy.liferay.samples.service.http.LogServiceSoap getPlugin_WebServiceSample_LogService() throws javax.xml.rpc.ServiceException;

    public com.jcampoy.liferay.samples.service.http.LogServiceSoap getPlugin_WebServiceSample_LogService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
