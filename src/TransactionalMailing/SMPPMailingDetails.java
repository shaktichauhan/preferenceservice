/**
 * SMPPMailingDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class SMPPMailingDetails  implements java.io.Serializable {
    private java.lang.String messageId;

    private java.lang.String[] virtualServerGroup;

    private java.lang.String from;

    private TransactionalMailing.SchemaDetails[] schemas;

    private java.lang.String parameterSeparator;

    private java.lang.String parameterSetSeparator;

    private java.lang.String recipientParameter;

    private java.lang.String userIdColumn;

    private TransactionalMailing.SMPPMessageData[] messageTemplates;

    private TransactionalMailing.Priority priority;

    private TransactionalMailing.FileDetails[] tokenFiles;

    private TransactionalMailing.LogDetails logging;

    private java.lang.String id;

    private java.lang.String serviceProvider;

    private TransactionalMailing.SMPPTerminus receiverTerminal;

    private TransactionalMailing.SMPPTerminus senderTerminal;

    private java.lang.String SMSPriority;

    private java.lang.Boolean replaceUndelivered;

    private java.lang.String scheduledDeliveryTime;

    private java.lang.String[] wrapCDATA;

    private java.lang.String targetID;

    private java.lang.String programID;

    public SMPPMailingDetails() {
    }

    public SMPPMailingDetails(
           java.lang.String messageId,
           java.lang.String[] virtualServerGroup,
           java.lang.String from,
           TransactionalMailing.SchemaDetails[] schemas,
           java.lang.String parameterSeparator,
           java.lang.String parameterSetSeparator,
           java.lang.String recipientParameter,
           java.lang.String userIdColumn,
           TransactionalMailing.SMPPMessageData[] messageTemplates,
           TransactionalMailing.Priority priority,
           TransactionalMailing.FileDetails[] tokenFiles,
           TransactionalMailing.LogDetails logging,
           java.lang.String id,
           java.lang.String serviceProvider,
           TransactionalMailing.SMPPTerminus receiverTerminal,
           TransactionalMailing.SMPPTerminus senderTerminal,
           java.lang.String SMSPriority,
           java.lang.Boolean replaceUndelivered,
           java.lang.String scheduledDeliveryTime,
           java.lang.String[] wrapCDATA,
           java.lang.String targetID,
           java.lang.String programID) {
           this.messageId = messageId;
           this.virtualServerGroup = virtualServerGroup;
           this.from = from;
           this.schemas = schemas;
           this.parameterSeparator = parameterSeparator;
           this.parameterSetSeparator = parameterSetSeparator;
           this.recipientParameter = recipientParameter;
           this.userIdColumn = userIdColumn;
           this.messageTemplates = messageTemplates;
           this.priority = priority;
           this.tokenFiles = tokenFiles;
           this.logging = logging;
           this.id = id;
           this.serviceProvider = serviceProvider;
           this.receiverTerminal = receiverTerminal;
           this.senderTerminal = senderTerminal;
           this.SMSPriority = SMSPriority;
           this.replaceUndelivered = replaceUndelivered;
           this.scheduledDeliveryTime = scheduledDeliveryTime;
           this.wrapCDATA = wrapCDATA;
           this.targetID = targetID;
           this.programID = programID;
    }


    /**
     * Gets the messageId value for this SMPPMailingDetails.
     * 
     * @return messageId
     */
    public java.lang.String getMessageId() {
        return messageId;
    }


    /**
     * Sets the messageId value for this SMPPMailingDetails.
     * 
     * @param messageId
     */
    public void setMessageId(java.lang.String messageId) {
        this.messageId = messageId;
    }


    /**
     * Gets the virtualServerGroup value for this SMPPMailingDetails.
     * 
     * @return virtualServerGroup
     */
    public java.lang.String[] getVirtualServerGroup() {
        return virtualServerGroup;
    }


    /**
     * Sets the virtualServerGroup value for this SMPPMailingDetails.
     * 
     * @param virtualServerGroup
     */
    public void setVirtualServerGroup(java.lang.String[] virtualServerGroup) {
        this.virtualServerGroup = virtualServerGroup;
    }


    /**
     * Gets the from value for this SMPPMailingDetails.
     * 
     * @return from
     */
    public java.lang.String getFrom() {
        return from;
    }


    /**
     * Sets the from value for this SMPPMailingDetails.
     * 
     * @param from
     */
    public void setFrom(java.lang.String from) {
        this.from = from;
    }


    /**
     * Gets the schemas value for this SMPPMailingDetails.
     * 
     * @return schemas
     */
    public TransactionalMailing.SchemaDetails[] getSchemas() {
        return schemas;
    }


    /**
     * Sets the schemas value for this SMPPMailingDetails.
     * 
     * @param schemas
     */
    public void setSchemas(TransactionalMailing.SchemaDetails[] schemas) {
        this.schemas = schemas;
    }


    /**
     * Gets the parameterSeparator value for this SMPPMailingDetails.
     * 
     * @return parameterSeparator
     */
    public java.lang.String getParameterSeparator() {
        return parameterSeparator;
    }


    /**
     * Sets the parameterSeparator value for this SMPPMailingDetails.
     * 
     * @param parameterSeparator
     */
    public void setParameterSeparator(java.lang.String parameterSeparator) {
        this.parameterSeparator = parameterSeparator;
    }


    /**
     * Gets the parameterSetSeparator value for this SMPPMailingDetails.
     * 
     * @return parameterSetSeparator
     */
    public java.lang.String getParameterSetSeparator() {
        return parameterSetSeparator;
    }


    /**
     * Sets the parameterSetSeparator value for this SMPPMailingDetails.
     * 
     * @param parameterSetSeparator
     */
    public void setParameterSetSeparator(java.lang.String parameterSetSeparator) {
        this.parameterSetSeparator = parameterSetSeparator;
    }


    /**
     * Gets the recipientParameter value for this SMPPMailingDetails.
     * 
     * @return recipientParameter
     */
    public java.lang.String getRecipientParameter() {
        return recipientParameter;
    }


    /**
     * Sets the recipientParameter value for this SMPPMailingDetails.
     * 
     * @param recipientParameter
     */
    public void setRecipientParameter(java.lang.String recipientParameter) {
        this.recipientParameter = recipientParameter;
    }


    /**
     * Gets the userIdColumn value for this SMPPMailingDetails.
     * 
     * @return userIdColumn
     */
    public java.lang.String getUserIdColumn() {
        return userIdColumn;
    }


    /**
     * Sets the userIdColumn value for this SMPPMailingDetails.
     * 
     * @param userIdColumn
     */
    public void setUserIdColumn(java.lang.String userIdColumn) {
        this.userIdColumn = userIdColumn;
    }


    /**
     * Gets the messageTemplates value for this SMPPMailingDetails.
     * 
     * @return messageTemplates
     */
    public TransactionalMailing.SMPPMessageData[] getMessageTemplates() {
        return messageTemplates;
    }


    /**
     * Sets the messageTemplates value for this SMPPMailingDetails.
     * 
     * @param messageTemplates
     */
    public void setMessageTemplates(TransactionalMailing.SMPPMessageData[] messageTemplates) {
        this.messageTemplates = messageTemplates;
    }


    /**
     * Gets the priority value for this SMPPMailingDetails.
     * 
     * @return priority
     */
    public TransactionalMailing.Priority getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this SMPPMailingDetails.
     * 
     * @param priority
     */
    public void setPriority(TransactionalMailing.Priority priority) {
        this.priority = priority;
    }


    /**
     * Gets the tokenFiles value for this SMPPMailingDetails.
     * 
     * @return tokenFiles
     */
    public TransactionalMailing.FileDetails[] getTokenFiles() {
        return tokenFiles;
    }


    /**
     * Sets the tokenFiles value for this SMPPMailingDetails.
     * 
     * @param tokenFiles
     */
    public void setTokenFiles(TransactionalMailing.FileDetails[] tokenFiles) {
        this.tokenFiles = tokenFiles;
    }


    /**
     * Gets the logging value for this SMPPMailingDetails.
     * 
     * @return logging
     */
    public TransactionalMailing.LogDetails getLogging() {
        return logging;
    }


    /**
     * Sets the logging value for this SMPPMailingDetails.
     * 
     * @param logging
     */
    public void setLogging(TransactionalMailing.LogDetails logging) {
        this.logging = logging;
    }


    /**
     * Gets the id value for this SMPPMailingDetails.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this SMPPMailingDetails.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the serviceProvider value for this SMPPMailingDetails.
     * 
     * @return serviceProvider
     */
    public java.lang.String getServiceProvider() {
        return serviceProvider;
    }


    /**
     * Sets the serviceProvider value for this SMPPMailingDetails.
     * 
     * @param serviceProvider
     */
    public void setServiceProvider(java.lang.String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


    /**
     * Gets the receiverTerminal value for this SMPPMailingDetails.
     * 
     * @return receiverTerminal
     */
    public TransactionalMailing.SMPPTerminus getReceiverTerminal() {
        return receiverTerminal;
    }


    /**
     * Sets the receiverTerminal value for this SMPPMailingDetails.
     * 
     * @param receiverTerminal
     */
    public void setReceiverTerminal(TransactionalMailing.SMPPTerminus receiverTerminal) {
        this.receiverTerminal = receiverTerminal;
    }


    /**
     * Gets the senderTerminal value for this SMPPMailingDetails.
     * 
     * @return senderTerminal
     */
    public TransactionalMailing.SMPPTerminus getSenderTerminal() {
        return senderTerminal;
    }


    /**
     * Sets the senderTerminal value for this SMPPMailingDetails.
     * 
     * @param senderTerminal
     */
    public void setSenderTerminal(TransactionalMailing.SMPPTerminus senderTerminal) {
        this.senderTerminal = senderTerminal;
    }


    /**
     * Gets the SMSPriority value for this SMPPMailingDetails.
     * 
     * @return SMSPriority
     */
    public java.lang.String getSMSPriority() {
        return SMSPriority;
    }


    /**
     * Sets the SMSPriority value for this SMPPMailingDetails.
     * 
     * @param SMSPriority
     */
    public void setSMSPriority(java.lang.String SMSPriority) {
        this.SMSPriority = SMSPriority;
    }


    /**
     * Gets the replaceUndelivered value for this SMPPMailingDetails.
     * 
     * @return replaceUndelivered
     */
    public java.lang.Boolean getReplaceUndelivered() {
        return replaceUndelivered;
    }


    /**
     * Sets the replaceUndelivered value for this SMPPMailingDetails.
     * 
     * @param replaceUndelivered
     */
    public void setReplaceUndelivered(java.lang.Boolean replaceUndelivered) {
        this.replaceUndelivered = replaceUndelivered;
    }


    /**
     * Gets the scheduledDeliveryTime value for this SMPPMailingDetails.
     * 
     * @return scheduledDeliveryTime
     */
    public java.lang.String getScheduledDeliveryTime() {
        return scheduledDeliveryTime;
    }


    /**
     * Sets the scheduledDeliveryTime value for this SMPPMailingDetails.
     * 
     * @param scheduledDeliveryTime
     */
    public void setScheduledDeliveryTime(java.lang.String scheduledDeliveryTime) {
        this.scheduledDeliveryTime = scheduledDeliveryTime;
    }


    /**
     * Gets the wrapCDATA value for this SMPPMailingDetails.
     * 
     * @return wrapCDATA
     */
    public java.lang.String[] getWrapCDATA() {
        return wrapCDATA;
    }


    /**
     * Sets the wrapCDATA value for this SMPPMailingDetails.
     * 
     * @param wrapCDATA
     */
    public void setWrapCDATA(java.lang.String[] wrapCDATA) {
        this.wrapCDATA = wrapCDATA;
    }


    /**
     * Gets the targetID value for this SMPPMailingDetails.
     * 
     * @return targetID
     */
    public java.lang.String getTargetID() {
        return targetID;
    }


    /**
     * Sets the targetID value for this SMPPMailingDetails.
     * 
     * @param targetID
     */
    public void setTargetID(java.lang.String targetID) {
        this.targetID = targetID;
    }


    /**
     * Gets the programID value for this SMPPMailingDetails.
     * 
     * @return programID
     */
    public java.lang.String getProgramID() {
        return programID;
    }


    /**
     * Sets the programID value for this SMPPMailingDetails.
     * 
     * @param programID
     */
    public void setProgramID(java.lang.String programID) {
        this.programID = programID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SMPPMailingDetails)) return false;
        SMPPMailingDetails other = (SMPPMailingDetails) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.messageId==null && other.getMessageId()==null) || 
             (this.messageId!=null &&
              this.messageId.equals(other.getMessageId()))) &&
            ((this.virtualServerGroup==null && other.getVirtualServerGroup()==null) || 
             (this.virtualServerGroup!=null &&
              java.util.Arrays.equals(this.virtualServerGroup, other.getVirtualServerGroup()))) &&
            ((this.from==null && other.getFrom()==null) || 
             (this.from!=null &&
              this.from.equals(other.getFrom()))) &&
            ((this.schemas==null && other.getSchemas()==null) || 
             (this.schemas!=null &&
              java.util.Arrays.equals(this.schemas, other.getSchemas()))) &&
            ((this.parameterSeparator==null && other.getParameterSeparator()==null) || 
             (this.parameterSeparator!=null &&
              this.parameterSeparator.equals(other.getParameterSeparator()))) &&
            ((this.parameterSetSeparator==null && other.getParameterSetSeparator()==null) || 
             (this.parameterSetSeparator!=null &&
              this.parameterSetSeparator.equals(other.getParameterSetSeparator()))) &&
            ((this.recipientParameter==null && other.getRecipientParameter()==null) || 
             (this.recipientParameter!=null &&
              this.recipientParameter.equals(other.getRecipientParameter()))) &&
            ((this.userIdColumn==null && other.getUserIdColumn()==null) || 
             (this.userIdColumn!=null &&
              this.userIdColumn.equals(other.getUserIdColumn()))) &&
            ((this.messageTemplates==null && other.getMessageTemplates()==null) || 
             (this.messageTemplates!=null &&
              java.util.Arrays.equals(this.messageTemplates, other.getMessageTemplates()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.tokenFiles==null && other.getTokenFiles()==null) || 
             (this.tokenFiles!=null &&
              java.util.Arrays.equals(this.tokenFiles, other.getTokenFiles()))) &&
            ((this.logging==null && other.getLogging()==null) || 
             (this.logging!=null &&
              this.logging.equals(other.getLogging()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.serviceProvider==null && other.getServiceProvider()==null) || 
             (this.serviceProvider!=null &&
              this.serviceProvider.equals(other.getServiceProvider()))) &&
            ((this.receiverTerminal==null && other.getReceiverTerminal()==null) || 
             (this.receiverTerminal!=null &&
              this.receiverTerminal.equals(other.getReceiverTerminal()))) &&
            ((this.senderTerminal==null && other.getSenderTerminal()==null) || 
             (this.senderTerminal!=null &&
              this.senderTerminal.equals(other.getSenderTerminal()))) &&
            ((this.SMSPriority==null && other.getSMSPriority()==null) || 
             (this.SMSPriority!=null &&
              this.SMSPriority.equals(other.getSMSPriority()))) &&
            ((this.replaceUndelivered==null && other.getReplaceUndelivered()==null) || 
             (this.replaceUndelivered!=null &&
              this.replaceUndelivered.equals(other.getReplaceUndelivered()))) &&
            ((this.scheduledDeliveryTime==null && other.getScheduledDeliveryTime()==null) || 
             (this.scheduledDeliveryTime!=null &&
              this.scheduledDeliveryTime.equals(other.getScheduledDeliveryTime()))) &&
            ((this.wrapCDATA==null && other.getWrapCDATA()==null) || 
             (this.wrapCDATA!=null &&
              java.util.Arrays.equals(this.wrapCDATA, other.getWrapCDATA()))) &&
            ((this.targetID==null && other.getTargetID()==null) || 
             (this.targetID!=null &&
              this.targetID.equals(other.getTargetID()))) &&
            ((this.programID==null && other.getProgramID()==null) || 
             (this.programID!=null &&
              this.programID.equals(other.getProgramID())));
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
        if (getMessageId() != null) {
            _hashCode += getMessageId().hashCode();
        }
        if (getVirtualServerGroup() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVirtualServerGroup());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVirtualServerGroup(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFrom() != null) {
            _hashCode += getFrom().hashCode();
        }
        if (getSchemas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSchemas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSchemas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParameterSeparator() != null) {
            _hashCode += getParameterSeparator().hashCode();
        }
        if (getParameterSetSeparator() != null) {
            _hashCode += getParameterSetSeparator().hashCode();
        }
        if (getRecipientParameter() != null) {
            _hashCode += getRecipientParameter().hashCode();
        }
        if (getUserIdColumn() != null) {
            _hashCode += getUserIdColumn().hashCode();
        }
        if (getMessageTemplates() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessageTemplates());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessageTemplates(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getTokenFiles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTokenFiles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTokenFiles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLogging() != null) {
            _hashCode += getLogging().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getServiceProvider() != null) {
            _hashCode += getServiceProvider().hashCode();
        }
        if (getReceiverTerminal() != null) {
            _hashCode += getReceiverTerminal().hashCode();
        }
        if (getSenderTerminal() != null) {
            _hashCode += getSenderTerminal().hashCode();
        }
        if (getSMSPriority() != null) {
            _hashCode += getSMSPriority().hashCode();
        }
        if (getReplaceUndelivered() != null) {
            _hashCode += getReplaceUndelivered().hashCode();
        }
        if (getScheduledDeliveryTime() != null) {
            _hashCode += getScheduledDeliveryTime().hashCode();
        }
        if (getWrapCDATA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWrapCDATA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWrapCDATA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTargetID() != null) {
            _hashCode += getTargetID().hashCode();
        }
        if (getProgramID() != null) {
            _hashCode += getProgramID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SMPPMailingDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMailingDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("virtualServerGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VirtualServerGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from");
        elemField.setXmlName(new javax.xml.namespace.QName("", "From"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("schemas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Schemas"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SchemaDetails"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameterSeparator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ParameterSeparator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parameterSetSeparator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ParameterSetSeparator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RecipientParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userIdColumn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "UserIdColumn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageTemplates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageTemplates"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPMessageData"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "Priority"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tokenFiles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TokenFiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logging");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Logging"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "LogDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceProvider");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ServiceProvider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiverTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReceiverTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPTerminus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senderTerminal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SenderTerminal"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "SMPPTerminus"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SMSPriority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SMSPriority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replaceUndelivered");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReplaceUndelivered"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scheduledDeliveryTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ScheduledDeliveryTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wrapCDATA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WrapCDATA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TargetID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProgramID"));
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
