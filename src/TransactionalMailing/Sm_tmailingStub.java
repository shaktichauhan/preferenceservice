/**
 * Sm_tmailingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class Sm_tmailingStub extends org.apache.axis.client.Stub implements TransactionalMailing.Sm_tmailingPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[11];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Load");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Class"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "SerialNumber"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Resume");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Pause");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeOutbound");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseOutbound");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Cancel");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Close");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetState");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingStates"));
        oper.setReturnClass(TransactionalMailing.MailingStates.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "State"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Save");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SMTPMailing"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingDetails"), TransactionalMailing.MailingDetails.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SMPPMailing"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMailingDetails"), TransactionalMailing.SMPPMailingDetails.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Overwrite"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        oper.setReturnClass(long.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "Result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SerialNumber"), org.apache.axis.description.ParameterDesc.INOUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), java.lang.Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "State"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingStates"), TransactionalMailing.MailingStates.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingID"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "StartTime"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "EndTime"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ElapsedTime"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "LastRestartTime"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Restarts"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "TotalDatabaseRecords"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MessagesDelivered"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MessagesFailed"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MessagesDeferred"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MessagesInvalid"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Send");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Credentials"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails"), TransactionalMailing.AuthDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MailingName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FileInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"), TransactionalMailing.FileDetails.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "DatabaseId"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Count"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"),
                      "TransactionalMailing.Exception",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"),
                      "TransactionalMailing.MailingCreationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"),
                      "TransactionalMailing.ConnectionError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"),
                      "TransactionalMailing.MailingOperationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"),
                      "TransactionalMailing.FeatureUnavailabilityError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"),
                      "TransactionalMailing.VSGError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"),
                      "TransactionalMailing.AuthenticationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"),
                      "TransactionalMailing.DatabaseSpecificationError",
                      new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError"), 
                      true
                     ));
        _operations[10] = oper;

    }

    public Sm_tmailingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Sm_tmailingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Sm_tmailingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.AuthDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "AuthenticationError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.AuthenticationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "ConnectionError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.ConnectionError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "DatabaseSpecificationError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.DatabaseSpecificationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "EmailDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.EmailDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "Encoding");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.Encoding.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "Exception");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.Exception.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "FeatureUnavailabilityError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.FeatureUnavailabilityError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDataArray");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.FileDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.FileDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "FormatType");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.FormatType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "GenerationType");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.GenerationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "LogDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.LogDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingAssetsError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingAssetsError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingCreationError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingCreationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingOperationError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingOperationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingStates");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingStates.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingType");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MailingType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MessageData");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MessageData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MessageDataArray");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.MessageData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "MessageData");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "Priority");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.Priority.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SchemaDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SchemaDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SchemaDetailsArray");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SchemaDetails[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SchemaDetails");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMailingDetails");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SMPPMailingDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMessageData");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SMPPMessageData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMessageDataArray");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SMPPMessageData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMessageData");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPTerminus");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.SMPPTerminus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "StringArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:TransactionalMailing", "VSGError");
            cachedSerQNames.add(qName);
            cls = TransactionalMailing.VSGError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public long load(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, java.lang.String _class) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Load"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName, _class});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long resume(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Resume"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long pause(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Pause"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long resumeOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "ResumeOutbound"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long pauseOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "PauseOutbound"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long cancel(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Cancel"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long close(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Close"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public TransactionalMailing.MailingStates getState(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "GetState"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (TransactionalMailing.MailingStates) _resp;
            } catch (java.lang.Exception _exception) {
                return (TransactionalMailing.MailingStates) org.apache.axis.utils.JavaUtils.convert(_resp, TransactionalMailing.MailingStates.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public long save(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.MailingDetails SMTPMailing, TransactionalMailing.SMPPMailingDetails SMPPMailing, boolean overwrite) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Save"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName, SMTPMailing, SMPPMailing, new java.lang.Boolean(overwrite)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Long) _resp).longValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_resp, long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void getStatus(TransactionalMailing.AuthDetails credentials, javax.xml.rpc.holders.StringHolder mailingName, javax.xml.rpc.holders.LongWrapperHolder serialNumber, TransactionalMailing.holders.MailingStatesHolder state, javax.xml.rpc.holders.StringHolder mailingID, javax.xml.rpc.holders.StringHolder startTime, javax.xml.rpc.holders.StringHolder endTime, javax.xml.rpc.holders.LongHolder elapsedTime, javax.xml.rpc.holders.StringHolder lastRestartTime, javax.xml.rpc.holders.LongHolder restarts, javax.xml.rpc.holders.LongHolder totalDatabaseRecords, javax.xml.rpc.holders.LongHolder messagesDelivered, javax.xml.rpc.holders.LongHolder messagesFailed, javax.xml.rpc.holders.LongHolder messagesDeferred, javax.xml.rpc.holders.LongHolder messagesInvalid) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "GetStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName.value, serialNumber.value});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                mailingName.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "MailingName"));
            } catch (java.lang.Exception _exception) {
                mailingName.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MailingName")), java.lang.String.class);
            }
            try {
                serialNumber.value = (java.lang.Long) _output.get(new javax.xml.namespace.QName("", "SerialNumber"));
            } catch (java.lang.Exception _exception) {
                serialNumber.value = (java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "SerialNumber")), java.lang.Long.class);
            }
            try {
                state.value = (TransactionalMailing.MailingStates) _output.get(new javax.xml.namespace.QName("", "State"));
            } catch (java.lang.Exception _exception) {
                state.value = (TransactionalMailing.MailingStates) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "State")), TransactionalMailing.MailingStates.class);
            }
            try {
                mailingID.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "MailingID"));
            } catch (java.lang.Exception _exception) {
                mailingID.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MailingID")), java.lang.String.class);
            }
            try {
                startTime.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "StartTime"));
            } catch (java.lang.Exception _exception) {
                startTime.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "StartTime")), java.lang.String.class);
            }
            try {
                endTime.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "EndTime"));
            } catch (java.lang.Exception _exception) {
                endTime.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "EndTime")), java.lang.String.class);
            }
            try {
                elapsedTime.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "ElapsedTime"))).longValue();
            } catch (java.lang.Exception _exception) {
                elapsedTime.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "ElapsedTime")), long.class)).longValue();
            }
            try {
                lastRestartTime.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "LastRestartTime"));
            } catch (java.lang.Exception _exception) {
                lastRestartTime.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "LastRestartTime")), java.lang.String.class);
            }
            try {
                restarts.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "Restarts"))).longValue();
            } catch (java.lang.Exception _exception) {
                restarts.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Restarts")), long.class)).longValue();
            }
            try {
                totalDatabaseRecords.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "TotalDatabaseRecords"))).longValue();
            } catch (java.lang.Exception _exception) {
                totalDatabaseRecords.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "TotalDatabaseRecords")), long.class)).longValue();
            }
            try {
                messagesDelivered.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "MessagesDelivered"))).longValue();
            } catch (java.lang.Exception _exception) {
                messagesDelivered.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MessagesDelivered")), long.class)).longValue();
            }
            try {
                messagesFailed.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "MessagesFailed"))).longValue();
            } catch (java.lang.Exception _exception) {
                messagesFailed.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MessagesFailed")), long.class)).longValue();
            }
            try {
                messagesDeferred.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "MessagesDeferred"))).longValue();
            } catch (java.lang.Exception _exception) {
                messagesDeferred.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MessagesDeferred")), long.class)).longValue();
            }
            try {
                messagesInvalid.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "MessagesInvalid"))).longValue();
            } catch (java.lang.Exception _exception) {
                messagesInvalid.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "MessagesInvalid")), long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void send(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.FileDetails fileInfo, javax.xml.rpc.holders.StringHolder databaseId, javax.xml.rpc.holders.LongHolder count) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:TransactionalMailing", "Send"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {credentials, mailingName, fileInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            java.util.Map _output;
            _output = _call.getOutputParams();
            try {
                databaseId.value = (java.lang.String) _output.get(new javax.xml.namespace.QName("", "DatabaseId"));
            } catch (java.lang.Exception _exception) {
                databaseId.value = (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "DatabaseId")), java.lang.String.class);
            }
            try {
                count.value = ((java.lang.Long) _output.get(new javax.xml.namespace.QName("", "Count"))).longValue();
            } catch (java.lang.Exception _exception) {
                count.value = ((java.lang.Long) org.apache.axis.utils.JavaUtils.convert(_output.get(new javax.xml.namespace.QName("", "Count")), long.class)).longValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.Exception) {
              throw (TransactionalMailing.Exception) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingCreationError) {
              throw (TransactionalMailing.MailingCreationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.ConnectionError) {
              throw (TransactionalMailing.ConnectionError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.MailingOperationError) {
              throw (TransactionalMailing.MailingOperationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.FeatureUnavailabilityError) {
              throw (TransactionalMailing.FeatureUnavailabilityError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.VSGError) {
              throw (TransactionalMailing.VSGError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.AuthenticationError) {
              throw (TransactionalMailing.AuthenticationError) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof TransactionalMailing.DatabaseSpecificationError) {
              throw (TransactionalMailing.DatabaseSpecificationError) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
