package com.jcampoy.liferay.samples.service.http;

public class LogServiceSoapProxy implements com.jcampoy.liferay.samples.service.http.LogServiceSoap {
  private String _endpoint = null;
  private com.jcampoy.liferay.samples.service.http.LogServiceSoap logServiceSoap = null;
  
  public LogServiceSoapProxy() {
    _initLogServiceSoapProxy();
  }
  
  public LogServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initLogServiceSoapProxy();
  }
  
  private void _initLogServiceSoapProxy() {
    try {
      logServiceSoap = (new com.jcampoy.liferay.samples.service.http.LogServiceSoapServiceLocator()).getPlugin_WebServiceSample_LogService();
      if (logServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)logServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)logServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (logServiceSoap != null)
      ((javax.xml.rpc.Stub)logServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.jcampoy.liferay.samples.service.http.LogServiceSoap getLogServiceSoap() {
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    return logServiceSoap;
  }
  
  public void debug(java.lang.String msg) throws java.rmi.RemoteException{
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    logServiceSoap.debug(msg);
  }
  
  public void fatal(java.lang.String msg) throws java.rmi.RemoteException{
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    logServiceSoap.fatal(msg);
  }
  
  public void info(java.lang.String msg) throws java.rmi.RemoteException{
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    logServiceSoap.info(msg);
  }
  
  public void trace(java.lang.String msg) throws java.rmi.RemoteException{
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    logServiceSoap.trace(msg);
  }
  
  public void warn(java.lang.String msg) throws java.rmi.RemoteException{
    if (logServiceSoap == null)
      _initLogServiceSoapProxy();
    logServiceSoap.warn(msg);
  }
  
  
}