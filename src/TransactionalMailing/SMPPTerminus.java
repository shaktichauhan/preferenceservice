/**
 * SMPPTerminus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class SMPPTerminus  implements java.io.Serializable {
    private java.lang.String TON;

    private java.lang.String NPI;

    public SMPPTerminus() {
    }

    public SMPPTerminus(
           java.lang.String TON,
           java.lang.String NPI) {
           this.TON = TON;
           this.NPI = NPI;
    }


    /**
     * Gets the TON value for this SMPPTerminus.
     * 
     * @return TON
     */
    public java.lang.String getTON() {
        return TON;
    }


    /**
     * Sets the TON value for this SMPPTerminus.
     * 
     * @param TON
     */
    public void setTON(java.lang.String TON) {
        this.TON = TON;
    }


    /**
     * Gets the NPI value for this SMPPTerminus.
     * 
     * @return NPI
     */
    public java.lang.String getNPI() {
        return NPI;
    }


    /**
     * Sets the NPI value for this SMPPTerminus.
     * 
     * @param NPI
     */
    public void setNPI(java.lang.String NPI) {
        this.NPI = NPI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMPPTerminus)) return false;
        SMPPTerminus other = (SMPPTerminus) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TON==null && other.getTON()==null) || 
             (this.TON!=null &&
              this.TON.equals(other.getTON()))) &&
            ((this.NPI==null && other.getNPI()==null) || 
             (this.NPI!=null &&
              this.NPI.equals(other.getNPI())));
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
        if (getTON() != null) {
            _hashCode += getTON().hashCode();
        }
        if (getNPI() != null) {
            _hashCode += getNPI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMPPTerminus.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPTerminus"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TON");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TON"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NPI");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NPI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
