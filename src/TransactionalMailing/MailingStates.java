/**
 * MailingStates.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class MailingStates implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected MailingStates(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _ACTIVE = "ACTIVE";
    public static final java.lang.String _COMPLETING = "COMPLETING";
    public static final java.lang.String _COMPLETED = "COMPLETED";
    public static final java.lang.String _PAUSED = "PAUSED";
    public static final java.lang.String _PAUSEDOUTBOUND = "PAUSEDOUTBOUND";
    public static final java.lang.String _CANCELLED = "CANCELLED";
    public static final MailingStates ACTIVE = new MailingStates(_ACTIVE);
    public static final MailingStates COMPLETING = new MailingStates(_COMPLETING);
    public static final MailingStates COMPLETED = new MailingStates(_COMPLETED);
    public static final MailingStates PAUSED = new MailingStates(_PAUSED);
    public static final MailingStates PAUSEDOUTBOUND = new MailingStates(_PAUSEDOUTBOUND);
    public static final MailingStates CANCELLED = new MailingStates(_CANCELLED);
    public java.lang.String getValue() { return _value_;}
    public static MailingStates fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        MailingStates enumeration = (MailingStates)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static MailingStates fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MailingStates.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingStates"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
