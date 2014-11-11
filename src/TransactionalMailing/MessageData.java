/**
 * MessageData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class MessageData  implements java.io.Serializable {
    private java.lang.String[] headers;

    private TransactionalMailing.FileDetails body;

    private TransactionalMailing.FileDetails xslContent;

    private java.lang.String contentType;

    private java.lang.String inputCharset;

    private java.lang.String outputCharset;

    private TransactionalMailing.GenerationType generationType;

    private TransactionalMailing.Encoding encoding;

    public MessageData() {
    }

    public MessageData(
           java.lang.String[] headers,
           TransactionalMailing.FileDetails body,
           TransactionalMailing.FileDetails xslContent,
           java.lang.String contentType,
           java.lang.String inputCharset,
           java.lang.String outputCharset,
           TransactionalMailing.GenerationType generationType,
           TransactionalMailing.Encoding encoding) {
           this.headers = headers;
           this.body = body;
           this.xslContent = xslContent;
           this.contentType = contentType;
           this.inputCharset = inputCharset;
           this.outputCharset = outputCharset;
           this.generationType = generationType;
           this.encoding = encoding;
    }


    /**
     * Gets the headers value for this MessageData.
     * 
     * @return headers
     */
    public java.lang.String[] getHeaders() {
        return headers;
    }


    /**
     * Sets the headers value for this MessageData.
     * 
     * @param headers
     */
    public void setHeaders(java.lang.String[] headers) {
        this.headers = headers;
    }


    /**
     * Gets the body value for this MessageData.
     * 
     * @return body
     */
    public TransactionalMailing.FileDetails getBody() {
        return body;
    }


    /**
     * Sets the body value for this MessageData.
     * 
     * @param body
     */
    public void setBody(TransactionalMailing.FileDetails body) {
        this.body = body;
    }


    /**
     * Gets the xslContent value for this MessageData.
     * 
     * @return xslContent
     */
    public TransactionalMailing.FileDetails getXslContent() {
        return xslContent;
    }


    /**
     * Sets the xslContent value for this MessageData.
     * 
     * @param xslContent
     */
    public void setXslContent(TransactionalMailing.FileDetails xslContent) {
        this.xslContent = xslContent;
    }


    /**
     * Gets the contentType value for this MessageData.
     * 
     * @return contentType
     */
    public java.lang.String getContentType() {
        return contentType;
    }


    /**
     * Sets the contentType value for this MessageData.
     * 
     * @param contentType
     */
    public void setContentType(java.lang.String contentType) {
        this.contentType = contentType;
    }


    /**
     * Gets the inputCharset value for this MessageData.
     * 
     * @return inputCharset
     */
    public java.lang.String getInputCharset() {
        return inputCharset;
    }


    /**
     * Sets the inputCharset value for this MessageData.
     * 
     * @param inputCharset
     */
    public void setInputCharset(java.lang.String inputCharset) {
        this.inputCharset = inputCharset;
    }


    /**
     * Gets the outputCharset value for this MessageData.
     * 
     * @return outputCharset
     */
    public java.lang.String getOutputCharset() {
        return outputCharset;
    }


    /**
     * Sets the outputCharset value for this MessageData.
     * 
     * @param outputCharset
     */
    public void setOutputCharset(java.lang.String outputCharset) {
        this.outputCharset = outputCharset;
    }


    /**
     * Gets the generationType value for this MessageData.
     * 
     * @return generationType
     */
    public TransactionalMailing.GenerationType getGenerationType() {
        return generationType;
    }


    /**
     * Sets the generationType value for this MessageData.
     * 
     * @param generationType
     */
    public void setGenerationType(TransactionalMailing.GenerationType generationType) {
        this.generationType = generationType;
    }


    /**
     * Gets the encoding value for this MessageData.
     * 
     * @return encoding
     */
    public TransactionalMailing.Encoding getEncoding() {
        return encoding;
    }


    /**
     * Sets the encoding value for this MessageData.
     * 
     * @param encoding
     */
    public void setEncoding(TransactionalMailing.Encoding encoding) {
        this.encoding = encoding;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MessageData)) return false;
        MessageData other = (MessageData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.headers==null && other.getHeaders()==null) || 
             (this.headers!=null &&
              java.util.Arrays.equals(this.headers, other.getHeaders()))) &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.xslContent==null && other.getXslContent()==null) || 
             (this.xslContent!=null &&
              this.xslContent.equals(other.getXslContent()))) &&
            ((this.contentType==null && other.getContentType()==null) || 
             (this.contentType!=null &&
              this.contentType.equals(other.getContentType()))) &&
            ((this.inputCharset==null && other.getInputCharset()==null) || 
             (this.inputCharset!=null &&
              this.inputCharset.equals(other.getInputCharset()))) &&
            ((this.outputCharset==null && other.getOutputCharset()==null) || 
             (this.outputCharset!=null &&
              this.outputCharset.equals(other.getOutputCharset()))) &&
            ((this.generationType==null && other.getGenerationType()==null) || 
             (this.generationType!=null &&
              this.generationType.equals(other.getGenerationType()))) &&
            ((this.encoding==null && other.getEncoding()==null) || 
             (this.encoding!=null &&
              this.encoding.equals(other.getEncoding())));
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
        if (getHeaders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHeaders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHeaders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getXslContent() != null) {
            _hashCode += getXslContent().hashCode();
        }
        if (getContentType() != null) {
            _hashCode += getContentType().hashCode();
        }
        if (getInputCharset() != null) {
            _hashCode += getInputCharset().hashCode();
        }
        if (getOutputCharset() != null) {
            _hashCode += getOutputCharset().hashCode();
        }
        if (getGenerationType() != null) {
            _hashCode += getGenerationType().hashCode();
        }
        if (getEncoding() != null) {
            _hashCode += getEncoding().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MessageData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MessageData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("headers");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Headers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("contentType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ContentType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputCharset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InputCharset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encoding");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Encoding"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "Encoding"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
