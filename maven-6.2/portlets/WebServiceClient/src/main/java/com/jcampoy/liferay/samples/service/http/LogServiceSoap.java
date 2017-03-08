/**
 * LogServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.jcampoy.liferay.samples.service.http;

public interface LogServiceSoap extends java.rmi.Remote {
    public void debug(java.lang.String msg) throws java.rmi.RemoteException;
    public void fatal(java.lang.String msg) throws java.rmi.RemoteException;
    public void info(java.lang.String msg) throws java.rmi.RemoteException;
    public void trace(java.lang.String msg) throws java.rmi.RemoteException;
    public void warn(java.lang.String msg) throws java.rmi.RemoteException;
}
