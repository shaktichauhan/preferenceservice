/**
 * LogDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class LogDetails  implements java.io.Serializable {
    private boolean success;

    private boolean failure;

    private boolean fullSuccess;

    private boolean fullFailure;

    public LogDetails() {
    }

    public LogDetails(
           boolean success,
           boolean failure,
           boolean fullSuccess,
           boolean fullFailure) {
           this.success = success;
           this.failure = failure;
           this.fullSuccess = fullSuccess;
           this.fullFailure = fullFailure;
    }


    /**
     * Gets the success value for this LogDetails.
     * 
     * @return success
     */
    public boolean isSuccess() {
        return success;
    }


    /**
     * Sets the success value for this LogDetails.
     * 
     * @param success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }


    /**
     * Gets the failure value for this LogDetails.
     * 
     * @return failure
     */
    public boolean isFailure() {
        return failure;
    }


    /**
     * Sets the failure value for this LogDetails.
     * 
     * @param failure
     */
    public void setFailure(boolean failure) {
        this.failure = failure;
    }


    /**
     * Gets the fullSuccess value for this LogDetails.
     * 
     * @return fullSuccess
     */
    public boolean isFullSuccess() {
        return fullSuccess;
    }


    /**
     * Sets the fullSuccess value for this LogDetails.
     * 
     * @param fullSuccess
     */
    public void setFullSuccess(boolean fullSuccess) {
        this.fullSuccess = fullSuccess;
    }


    /**
     * Gets the fullFailure value for this LogDetails.
     * 
     * @return fullFailure
     */
    public boolean isFullFailure() {
        return fullFailure;
    }


    /**
     * Sets the fullFailure value for this LogDetails.
     * 
     * @param fullFailure
     */
    public void setFullFailure(boolean fullFailure) {
        this.fullFailure = fullFailure;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LogDetails)) return false;
        LogDetails other = (LogDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.success == other.isSuccess() &&
            this.failure == other.isFailure() &&
            this.fullSuccess == other.isFullSuccess() &&
            this.fullFailure == other.isFullFailure();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isSuccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isFailure() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isFullSuccess() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isFullFailure() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LogDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "LogDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("success");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Success"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failure");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Failure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullSuccess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FullSuccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullFailure");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FullFailure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
