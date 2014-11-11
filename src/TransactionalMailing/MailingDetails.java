/**
 * MailingDetails.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public class MailingDetails  implements java.io.Serializable {
    private java.lang.String messageId;

    private java.lang.String mailSubject;

    private java.lang.String[] virtualServerGroup;

    private TransactionalMailing.Priority priority;

    private TransactionalMailing.MailingType mailingType;

    private TransactionalMailing.EmailDetails from;

    private TransactionalMailing.EmailDetails replyTo;

    private TransactionalMailing.EmailDetails bounceAddress;

    private TransactionalMailing.SchemaDetails[] schemas;

    private java.lang.String parameterSeparator;

    private java.lang.String parameterSetSeparator;

    private java.lang.String recipientParameter;

    private java.lang.Boolean BCCEnable;

    private java.lang.String CCAddressField;

    private java.lang.Boolean CCEnable;

    private java.lang.String BCCAddressField;

    private java.lang.String addressDelimiter;

    private java.lang.String userIdColumn;

    private java.lang.String outputHeaderCharset;

    private java.lang.String[] messageHeaders;

    private TransactionalMailing.MessageData[] messageTemplates;

    private TransactionalMailing.LogDetails logging;

    private TransactionalMailing.FileDetails[] tokenFiles;

    private TransactionalMailing.FileDetails[] attachments;

    private java.lang.String id;

    private java.lang.String messageFormatParameter;

    private java.lang.String[] wrapCDATA;

    private java.lang.String targetID;

    private java.lang.String programID;

    public MailingDetails() {
    }

    public MailingDetails(
           java.lang.String messageId,
           java.lang.String mailSubject,
           java.lang.String[] virtualServerGroup,
           TransactionalMailing.Priority priority,
           TransactionalMailing.MailingType mailingType,
           TransactionalMailing.EmailDetails from,
           TransactionalMailing.EmailDetails replyTo,
           TransactionalMailing.EmailDetails bounceAddress,
           TransactionalMailing.SchemaDetails[] schemas,
           java.lang.String parameterSeparator,
           java.lang.String parameterSetSeparator,
           java.lang.String recipientParameter,
           java.lang.Boolean BCCEnable,
           java.lang.String CCAddressField,
           java.lang.Boolean CCEnable,
           java.lang.String BCCAddressField,
           java.lang.String addressDelimiter,
           java.lang.String userIdColumn,
           java.lang.String outputHeaderCharset,
           java.lang.String[] messageHeaders,
           TransactionalMailing.MessageData[] messageTemplates,
           TransactionalMailing.LogDetails logging,
           TransactionalMailing.FileDetails[] tokenFiles,
           TransactionalMailing.FileDetails[] attachments,
           java.lang.String id,
           java.lang.String messageFormatParameter,
           java.lang.String[] wrapCDATA,
           java.lang.String targetID,
           java.lang.String programID) {
           this.messageId = messageId;
           this.mailSubject = mailSubject;
           this.virtualServerGroup = virtualServerGroup;
           this.priority = priority;
           this.mailingType = mailingType;
           this.from = from;
           this.replyTo = replyTo;
           this.bounceAddress = bounceAddress;
           this.schemas = schemas;
           this.parameterSeparator = parameterSeparator;
           this.parameterSetSeparator = parameterSetSeparator;
           this.recipientParameter = recipientParameter;
           this.BCCEnable = BCCEnable;
           this.CCAddressField = CCAddressField;
           this.CCEnable = CCEnable;
           this.BCCAddressField = BCCAddressField;
           this.addressDelimiter = addressDelimiter;
           this.userIdColumn = userIdColumn;
           this.outputHeaderCharset = outputHeaderCharset;
           this.messageHeaders = messageHeaders;
           this.messageTemplates = messageTemplates;
           this.logging = logging;
           this.tokenFiles = tokenFiles;
           this.attachments = attachments;
           this.id = id;
           this.messageFormatParameter = messageFormatParameter;
           this.wrapCDATA = wrapCDATA;
           this.targetID = targetID;
           this.programID = programID;
    }


    /**
     * Gets the messageId value for this MailingDetails.
     * 
     * @return messageId
     */
    public java.lang.String getMessageId() {
        return messageId;
    }


    /**
     * Sets the messageId value for this MailingDetails.
     * 
     * @param messageId
     */
    public void setMessageId(java.lang.String messageId) {
        this.messageId = messageId;
    }


    /**
     * Gets the mailSubject value for this MailingDetails.
     * 
     * @return mailSubject
     */
    public java.lang.String getMailSubject() {
        return mailSubject;
    }


    /**
     * Sets the mailSubject value for this MailingDetails.
     * 
     * @param mailSubject
     */
    public void setMailSubject(java.lang.String mailSubject) {
        this.mailSubject = mailSubject;
    }


    /**
     * Gets the virtualServerGroup value for this MailingDetails.
     * 
     * @return virtualServerGroup
     */
    public java.lang.String[] getVirtualServerGroup() {
        return virtualServerGroup;
    }


    /**
     * Sets the virtualServerGroup value for this MailingDetails.
     * 
     * @param virtualServerGroup
     */
    public void setVirtualServerGroup(java.lang.String[] virtualServerGroup) {
        this.virtualServerGroup = virtualServerGroup;
    }


    /**
     * Gets the priority value for this MailingDetails.
     * 
     * @return priority
     */
    public TransactionalMailing.Priority getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this MailingDetails.
     * 
     * @param priority
     */
    public void setPriority(TransactionalMailing.Priority priority) {
        this.priority = priority;
    }


    /**
     * Gets the mailingType value for this MailingDetails.
     * 
     * @return mailingType
     */
    public TransactionalMailing.MailingType getMailingType() {
        return mailingType;
    }


    /**
     * Sets the mailingType value for this MailingDetails.
     * 
     * @param mailingType
     */
    public void setMailingType(TransactionalMailing.MailingType mailingType) {
        this.mailingType = mailingType;
    }


    /**
     * Gets the from value for this MailingDetails.
     * 
     * @return from
     */
    public TransactionalMailing.EmailDetails getFrom() {
        return from;
    }


    /**
     * Sets the from value for this MailingDetails.
     * 
     * @param from
     */
    public void setFrom(TransactionalMailing.EmailDetails from) {
        this.from = from;
    }


    /**
     * Gets the replyTo value for this MailingDetails.
     * 
     * @return replyTo
     */
    public TransactionalMailing.EmailDetails getReplyTo() {
        return replyTo;
    }


    /**
     * Sets the replyTo value for this MailingDetails.
     * 
     * @param replyTo
     */
    public void setReplyTo(TransactionalMailing.EmailDetails replyTo) {
        this.replyTo = replyTo;
    }


    /**
     * Gets the bounceAddress value for this MailingDetails.
     * 
     * @return bounceAddress
     */
    public TransactionalMailing.EmailDetails getBounceAddress() {
        return bounceAddress;
    }


    /**
     * Sets the bounceAddress value for this MailingDetails.
     * 
     * @param bounceAddress
     */
    public void setBounceAddress(TransactionalMailing.EmailDetails bounceAddress) {
        this.bounceAddress = bounceAddress;
    }


    /**
     * Gets the schemas value for this MailingDetails.
     * 
     * @return schemas
     */
    public TransactionalMailing.SchemaDetails[] getSchemas() {
        return schemas;
    }


    /**
     * Sets the schemas value for this MailingDetails.
     * 
     * @param schemas
     */
    public void setSchemas(TransactionalMailing.SchemaDetails[] schemas) {
        this.schemas = schemas;
    }


    /**
     * Gets the parameterSeparator value for this MailingDetails.
     * 
     * @return parameterSeparator
     */
    public java.lang.String getParameterSeparator() {
        return parameterSeparator;
    }


    /**
     * Sets the parameterSeparator value for this MailingDetails.
     * 
     * @param parameterSeparator
     */
    public void setParameterSeparator(java.lang.String parameterSeparator) {
        this.parameterSeparator = parameterSeparator;
    }


    /**
     * Gets the parameterSetSeparator value for this MailingDetails.
     * 
     * @return parameterSetSeparator
     */
    public java.lang.String getParameterSetSeparator() {
        return parameterSetSeparator;
    }


    /**
     * Sets the parameterSetSeparator value for this MailingDetails.
     * 
     * @param parameterSetSeparator
     */
    public void setParameterSetSeparator(java.lang.String parameterSetSeparator) {
        this.parameterSetSeparator = parameterSetSeparator;
    }


    /**
     * Gets the recipientParameter value for this MailingDetails.
     * 
     * @return recipientParameter
     */
    public java.lang.String getRecipientParameter() {
        return recipientParameter;
    }


    /**
     * Sets the recipientParameter value for this MailingDetails.
     * 
     * @param recipientParameter
     */
    public void setRecipientParameter(java.lang.String recipientParameter) {
        this.recipientParameter = recipientParameter;
    }


    /**
     * Gets the BCCEnable value for this MailingDetails.
     * 
     * @return BCCEnable
     */
    public java.lang.Boolean getBCCEnable() {
        return BCCEnable;
    }


    /**
     * Sets the BCCEnable value for this MailingDetails.
     * 
     * @param BCCEnable
     */
    public void setBCCEnable(java.lang.Boolean BCCEnable) {
        this.BCCEnable = BCCEnable;
    }


    /**
     * Gets the CCAddressField value for this MailingDetails.
     * 
     * @return CCAddressField
     */
    public java.lang.String getCCAddressField() {
        return CCAddressField;
    }


    /**
     * Sets the CCAddressField value for this MailingDetails.
     * 
     * @param CCAddressField
     */
    public void setCCAddressField(java.lang.String CCAddressField) {
        this.CCAddressField = CCAddressField;
    }


    /**
     * Gets the CCEnable value for this MailingDetails.
     * 
     * @return CCEnable
     */
    public java.lang.Boolean getCCEnable() {
        return CCEnable;
    }


    /**
     * Sets the CCEnable value for this MailingDetails.
     * 
     * @param CCEnable
     */
    public void setCCEnable(java.lang.Boolean CCEnable) {
        this.CCEnable = CCEnable;
    }


    /**
     * Gets the BCCAddressField value for this MailingDetails.
     * 
     * @return BCCAddressField
     */
    public java.lang.String getBCCAddressField() {
        return BCCAddressField;
    }


    /**
     * Sets the BCCAddressField value for this MailingDetails.
     * 
     * @param BCCAddressField
     */
    public void setBCCAddressField(java.lang.String BCCAddressField) {
        this.BCCAddressField = BCCAddressField;
    }


    /**
     * Gets the addressDelimiter value for this MailingDetails.
     * 
     * @return addressDelimiter
     */
    public java.lang.String getAddressDelimiter() {
        return addressDelimiter;
    }


    /**
     * Sets the addressDelimiter value for this MailingDetails.
     * 
     * @param addressDelimiter
     */
    public void setAddressDelimiter(java.lang.String addressDelimiter) {
        this.addressDelimiter = addressDelimiter;
    }


    /**
     * Gets the userIdColumn value for this MailingDetails.
     * 
     * @return userIdColumn
     */
    public java.lang.String getUserIdColumn() {
        return userIdColumn;
    }


    /**
     * Sets the userIdColumn value for this MailingDetails.
     * 
     * @param userIdColumn
     */
    public void setUserIdColumn(java.lang.String userIdColumn) {
        this.userIdColumn = userIdColumn;
    }


    /**
     * Gets the outputHeaderCharset value for this MailingDetails.
     * 
     * @return outputHeaderCharset
     */
    public java.lang.String getOutputHeaderCharset() {
        return outputHeaderCharset;
    }


    /**
     * Sets the outputHeaderCharset value for this MailingDetails.
     * 
     * @param outputHeaderCharset
     */
    public void setOutputHeaderCharset(java.lang.String outputHeaderCharset) {
        this.outputHeaderCharset = outputHeaderCharset;
    }


    /**
     * Gets the messageHeaders value for this MailingDetails.
     * 
     * @return messageHeaders
     */
    public java.lang.String[] getMessageHeaders() {
        return messageHeaders;
    }


    /**
     * Sets the messageHeaders value for this MailingDetails.
     * 
     * @param messageHeaders
     */
    public void setMessageHeaders(java.lang.String[] messageHeaders) {
        this.messageHeaders = messageHeaders;
    }


    /**
     * Gets the messageTemplates value for this MailingDetails.
     * 
     * @return messageTemplates
     */
    public TransactionalMailing.MessageData[] getMessageTemplates() {
        return messageTemplates;
    }


    /**
     * Sets the messageTemplates value for this MailingDetails.
     * 
     * @param messageTemplates
     */
    public void setMessageTemplates(TransactionalMailing.MessageData[] messageTemplates) {
        this.messageTemplates = messageTemplates;
    }


    /**
     * Gets the logging value for this MailingDetails.
     * 
     * @return logging
     */
    public TransactionalMailing.LogDetails getLogging() {
        return logging;
    }


    /**
     * Sets the logging value for this MailingDetails.
     * 
     * @param logging
     */
    public void setLogging(TransactionalMailing.LogDetails logging) {
        this.logging = logging;
    }


    /**
     * Gets the tokenFiles value for this MailingDetails.
     * 
     * @return tokenFiles
     */
    public TransactionalMailing.FileDetails[] getTokenFiles() {
        return tokenFiles;
    }


    /**
     * Sets the tokenFiles value for this MailingDetails.
     * 
     * @param tokenFiles
     */
    public void setTokenFiles(TransactionalMailing.FileDetails[] tokenFiles) {
        this.tokenFiles = tokenFiles;
    }


    /**
     * Gets the attachments value for this MailingDetails.
     * 
     * @return attachments
     */
    public TransactionalMailing.FileDetails[] getAttachments() {
        return attachments;
    }


    /**
     * Sets the attachments value for this MailingDetails.
     * 
     * @param attachments
     */
    public void setAttachments(TransactionalMailing.FileDetails[] attachments) {
        this.attachments = attachments;
    }


    /**
     * Gets the id value for this MailingDetails.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this MailingDetails.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the messageFormatParameter value for this MailingDetails.
     * 
     * @return messageFormatParameter
     */
    public java.lang.String getMessageFormatParameter() {
        return messageFormatParameter;
    }


    /**
     * Sets the messageFormatParameter value for this MailingDetails.
     * 
     * @param messageFormatParameter
     */
    public void setMessageFormatParameter(java.lang.String messageFormatParameter) {
        this.messageFormatParameter = messageFormatParameter;
    }


    /**
     * Gets the wrapCDATA value for this MailingDetails.
     * 
     * @return wrapCDATA
     */
    public java.lang.String[] getWrapCDATA() {
        return wrapCDATA;
    }


    /**
     * Sets the wrapCDATA value for this MailingDetails.
     * 
     * @param wrapCDATA
     */
    public void setWrapCDATA(java.lang.String[] wrapCDATA) {
        this.wrapCDATA = wrapCDATA;
    }


    /**
     * Gets the targetID value for this MailingDetails.
     * 
     * @return targetID
     */
    public java.lang.String getTargetID() {
        return targetID;
    }


    /**
     * Sets the targetID value for this MailingDetails.
     * 
     * @param targetID
     */
    public void setTargetID(java.lang.String targetID) {
        this.targetID = targetID;
    }


    /**
     * Gets the programID value for this MailingDetails.
     * 
     * @return programID
     */
    public java.lang.String getProgramID() {
        return programID;
    }


    /**
     * Sets the programID value for this MailingDetails.
     * 
     * @param programID
     */
    public void setProgramID(java.lang.String programID) {
        this.programID = programID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MailingDetails)) return false;
        MailingDetails other = (MailingDetails) obj;
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
            ((this.mailSubject==null && other.getMailSubject()==null) || 
             (this.mailSubject!=null &&
              this.mailSubject.equals(other.getMailSubject()))) &&
            ((this.virtualServerGroup==null && other.getVirtualServerGroup()==null) || 
             (this.virtualServerGroup!=null &&
              java.util.Arrays.equals(this.virtualServerGroup, other.getVirtualServerGroup()))) &&
            ((this.priority==null && other.getPriority()==null) || 
             (this.priority!=null &&
              this.priority.equals(other.getPriority()))) &&
            ((this.mailingType==null && other.getMailingType()==null) || 
             (this.mailingType!=null &&
              this.mailingType.equals(other.getMailingType()))) &&
            ((this.from==null && other.getFrom()==null) || 
             (this.from!=null &&
              this.from.equals(other.getFrom()))) &&
            ((this.replyTo==null && other.getReplyTo()==null) || 
             (this.replyTo!=null &&
              this.replyTo.equals(other.getReplyTo()))) &&
            ((this.bounceAddress==null && other.getBounceAddress()==null) || 
             (this.bounceAddress!=null &&
              this.bounceAddress.equals(other.getBounceAddress()))) &&
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
            ((this.BCCEnable==null && other.getBCCEnable()==null) || 
             (this.BCCEnable!=null &&
              this.BCCEnable.equals(other.getBCCEnable()))) &&
            ((this.CCAddressField==null && other.getCCAddressField()==null) || 
             (this.CCAddressField!=null &&
              this.CCAddressField.equals(other.getCCAddressField()))) &&
            ((this.CCEnable==null && other.getCCEnable()==null) || 
             (this.CCEnable!=null &&
              this.CCEnable.equals(other.getCCEnable()))) &&
            ((this.BCCAddressField==null && other.getBCCAddressField()==null) || 
             (this.BCCAddressField!=null &&
              this.BCCAddressField.equals(other.getBCCAddressField()))) &&
            ((this.addressDelimiter==null && other.getAddressDelimiter()==null) || 
             (this.addressDelimiter!=null &&
              this.addressDelimiter.equals(other.getAddressDelimiter()))) &&
            ((this.userIdColumn==null && other.getUserIdColumn()==null) || 
             (this.userIdColumn!=null &&
              this.userIdColumn.equals(other.getUserIdColumn()))) &&
            ((this.outputHeaderCharset==null && other.getOutputHeaderCharset()==null) || 
             (this.outputHeaderCharset!=null &&
              this.outputHeaderCharset.equals(other.getOutputHeaderCharset()))) &&
            ((this.messageHeaders==null && other.getMessageHeaders()==null) || 
             (this.messageHeaders!=null &&
              java.util.Arrays.equals(this.messageHeaders, other.getMessageHeaders()))) &&
            ((this.messageTemplates==null && other.getMessageTemplates()==null) || 
             (this.messageTemplates!=null &&
              java.util.Arrays.equals(this.messageTemplates, other.getMessageTemplates()))) &&
            ((this.logging==null && other.getLogging()==null) || 
             (this.logging!=null &&
              this.logging.equals(other.getLogging()))) &&
            ((this.tokenFiles==null && other.getTokenFiles()==null) || 
             (this.tokenFiles!=null &&
              java.util.Arrays.equals(this.tokenFiles, other.getTokenFiles()))) &&
            ((this.attachments==null && other.getAttachments()==null) || 
             (this.attachments!=null &&
              java.util.Arrays.equals(this.attachments, other.getAttachments()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.messageFormatParameter==null && other.getMessageFormatParameter()==null) || 
             (this.messageFormatParameter!=null &&
              this.messageFormatParameter.equals(other.getMessageFormatParameter()))) &&
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
        if (getMailSubject() != null) {
            _hashCode += getMailSubject().hashCode();
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
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        if (getMailingType() != null) {
            _hashCode += getMailingType().hashCode();
        }
        if (getFrom() != null) {
            _hashCode += getFrom().hashCode();
        }
        if (getReplyTo() != null) {
            _hashCode += getReplyTo().hashCode();
        }
        if (getBounceAddress() != null) {
            _hashCode += getBounceAddress().hashCode();
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
        if (getBCCEnable() != null) {
            _hashCode += getBCCEnable().hashCode();
        }
        if (getCCAddressField() != null) {
            _hashCode += getCCAddressField().hashCode();
        }
        if (getCCEnable() != null) {
            _hashCode += getCCEnable().hashCode();
        }
        if (getBCCAddressField() != null) {
            _hashCode += getBCCAddressField().hashCode();
        }
        if (getAddressDelimiter() != null) {
            _hashCode += getAddressDelimiter().hashCode();
        }
        if (getUserIdColumn() != null) {
            _hashCode += getUserIdColumn().hashCode();
        }
        if (getOutputHeaderCharset() != null) {
            _hashCode += getOutputHeaderCharset().hashCode();
        }
        if (getMessageHeaders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMessageHeaders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMessageHeaders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
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
        if (getLogging() != null) {
            _hashCode += getLogging().hashCode();
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
        if (getAttachments() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAttachments());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAttachments(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMessageFormatParameter() != null) {
            _hashCode += getMessageFormatParameter().hashCode();
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
        new org.apache.axis.description.TypeDesc(MailingDetails.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingDetails"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailSubject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MailSubject"));
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
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "Priority"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mailingType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MailingType"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MailingType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from");
        elemField.setXmlName(new javax.xml.namespace.QName("", "From"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "EmailDetails"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replyTo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReplyTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "EmailDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bounceAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BounceAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "EmailDetails"));
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
        elemField.setFieldName("BCCEnable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BCCEnable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCAddressField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CCAddressField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCEnable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CCEnable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BCCAddressField");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BCCAddressField"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressDelimiter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AddressDelimiter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("outputHeaderCharset");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OutputHeaderCharset"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageHeaders");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageHeaders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageTemplates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageTemplates"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "MessageData"));
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
        elemField.setFieldName("tokenFiles");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TokenFiles"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("attachments");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Attachments"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:TransactionalMailing", "FileDetails"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageFormatParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageFormatParameter"));
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
