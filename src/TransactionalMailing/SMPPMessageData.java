/**
 * SMPPMessageData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class SMPPMessageData  implements java.io.Serializable {
    private TransactionalMailing.FileDetails body;

    private TransactionalMailing.FileDetails xslContent;

    private boolean useUCS2BOM;

    private java.lang.String inputCharset;

    private java.lang.String outputCharset;

    private TransactionalMailing.GenerationType generationType;

    public SMPPMessageData() {
    }

    public SMPPMessageData(
           TransactionalMailing.FileDetails body,
           TransactionalMailing.FileDetails xslContent,
           boolean useUCS2BOM,
           java.lang.String inputCharset,
           java.lang.String outputCharset,
           TransactionalMailing.GenerationType generationType) {
           this.body = body;
           this.xslContent = xslContent;
           this.useUCS2BOM = useUCS2BOM;
           this.inputCharset = inputCharset;
           this.outputCharset = outputCharset;
           this.generationType = generationType;
    }


    /**
     * Gets the body value for this SMPPMessageData.
     * 
     * @return body
     */
    public TransactionalMailing.FileDetails getBody() {
        return body;
    }


    /**
     * Sets the body value for this SMPPMessageData.
     * 
     * @param body
     */
    public void setBody(TransactionalMailing.FileDetails body) {
        this.body = body;
    }


    /**
     * Gets the xslContent value for this SMPPMessageData.
     * 
     * @return xslContent
     */
    public TransactionalMailing.FileDetails getXslContent() {
        return xslContent;
    }


    /**
     * Sets the xslContent value for this SMPPMessageData.
     * 
     * @param xslContent
     */
    public void setXslContent(TransactionalMailing.FileDetails xslContent) {
        this.xslContent = xslContent;
    }


    /**
     * Gets the useUCS2BOM value for this SMPPMessageData.
     * 
     * @return useUCS2BOM
     */
    public boolean isUseUCS2BOM() {
        return useUCS2BOM;
    }


    /**
     * Sets the useUCS2BOM value for this SMPPMessageData.
     * 
     * @param useUCS2BOM
     */
    public void setUseUCS2BOM(boolean useUCS2BOM) {
        this.useUCS2BOM = useUCS2BOM;
    }


    /**
     * Gets the inputCharset value for this SMPPMessageData.
     * 
     * @return inputCharset
     */
    public java.lang.String getInputCharset() {
        return inputCharset;
    }


    /**
     * Sets the inputCharset value for this SMPPMessageData.
     * 
     * @param inputCharset
     */
    public void setInputCharset(java.lang.String inputCharset) {
        this.inputCharset = inputCharset;
    }


    /**
     * Gets the outputCharset value for this SMPPMessageData.
     * 
     * @return outputCharset
     */
    public java.lang.String getOutputCharset() {
        return outputCharset;
    }


    /**
     * Sets the outputCharset value for this SMPPMessageData.
     * 
     * @param outputCharset
     */
    public void setOutputCharset(java.lang.String outputCharset) {
        this.outputCharset = outputCharset;
    }


    /**
     * Gets the generationType value for this SMPPMessageData.
     * 
     * @return generationType
     */
    public TransactionalMailing.GenerationType getGenerationType() {
        return generationType;
    }


    /**
     * Sets the generationType value for this SMPPMessageData.
     * 
     * @param generationType
     */
    public void setGenerationType(TransactionalMailing.GenerationType generationType) {
        this.generationType = generationType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMPPMessageData)) return false;
        SMPPMessageData other = (SMPPMessageData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.xslContent==null && other.getXslContent()==null) || 
             (this.xslContent!=null &&
              this.xslContent.equals(other.getXslContent()))) &&
            this.useUCS2BOM == other.isUseUCS2BOM() &&
            ((this.inputCharset==null && other.getInputCharset()==null) || 
             (this.inputCharset!=null &&
              this.inputCharset.equals(other.getInputCharset()))) &&
            ((this.outputCharset==null && other.getOutputCharset()==null) || 
             (this.outputCharset!=null &&
              this.outputCharset.equals(other.getOutputCharset()))) &&
            ((this.generationType==null && other.getGenerationType()==null) || 
             (this.generationType!=null &&
              this.generationType.equals(other.getGenerationType())));
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
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getXslContent() != null) {
            _hashCode += getXslContent().hashCode();
        }
        _hashCode += (isUseUCS2BOM() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getInputCharset() != null) {
            _hashCode += getInputCharset().hashCode();
        }
        if (getOutputCharset() != null) {
            _hashCode += getOutputCharset().hashCode();
        }
        if (getGenerationType() != null) {
            _hashCode += getGenerationType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMPPMessageData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMessageData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Body"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xslContent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XslContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("useUCS2BOM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UseUCS2BOM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputCharset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InputCharset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputCharset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OutputCharset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("generationType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GenerationType"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "GenerationType"));
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
