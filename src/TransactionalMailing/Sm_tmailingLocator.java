/**
 * Sm_tmailingLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class Sm_tmailingLocator extends org.apache.axis.client.Service implements TransactionalMailing.Sm_tmailing {

/**
 * Transactional Mailing Web Service Definition
 */

    public Sm_tmailingLocator() {
    }


    public Sm_tmailingLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Sm_tmailingLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for sm_tmailing
    private java.lang.String sm_tmailing_address = "http://strongmail1.rd.com:9000/SOAP/sm_tmailing";

    public java.lang.String getsm_tmailingAddress() {
        return sm_tmailing_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sm_tmailingWSDDServiceName = "sm_tmailing";

    public java.lang.String getsm_tmailingWSDDServiceName() {
        return sm_tmailingWSDDServiceName;
    }

    public void setsm_tmailingWSDDServiceName(java.lang.String name) {
        sm_tmailingWSDDServiceName = name;
    }

    public TransactionalMailing.Sm_tmailingPortType getsm_tmailing() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sm_tmailing_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsm_tmailing(endpoint);
    }

    public TransactionalMailing.Sm_tmailingPortType getsm_tmailing(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            TransactionalMailing.Sm_tmailingStub _stub = new TransactionalMailing.Sm_tmailingStub(portAddress, this);
            _stub.setPortName(getsm_tmailingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsm_tmailingEndpointAddress(java.lang.String address) {
        sm_tmailing_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (TransactionalMailing.Sm_tmailingPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                TransactionalMailing.Sm_tmailingStub _stub = new TransactionalMailing.Sm_tmailingStub(new java.net.URL(sm_tmailing_address), this);
                _stub.setPortName(getsm_tmailingWSDDServiceName());
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
        if ("sm_tmailing".equals(inputPortName)) {
            return getsm_tmailing();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:TransactionalMailing", "sm_tmailing");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:TransactionalMailing", "sm_tmailing"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sm_tmailing".equals(portName)) {
            setsm_tmailingEndpointAddress(address);
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
