/**
 * Sm_tmailingPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package TransactionalMailing;

public interface Sm_tmailingPortType extends java.rmi.Remote {

    /**
     * Service definition of function ns__Load
     */
    public long load(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, java.lang.String _class) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Resume
     */
    public long resume(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Pause
     */
    public long pause(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__ResumeOutbound
     */
    public long resumeOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__PauseOutbound
     */
    public long pauseOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Cancel
     */
    public long cancel(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Close
     */
    public long close(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__GetState
     */
    public TransactionalMailing.MailingStates getState(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Save
     */
    public long save(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.MailingDetails SMTPMailing, TransactionalMailing.SMPPMailingDetails SMPPMailing, boolean overwrite) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__GetStatus
     */
    public void getStatus(TransactionalMailing.AuthDetails credentials, javax.xml.rpc.holders.StringHolder mailingName, javax.xml.rpc.holders.LongWrapperHolder serialNumber, TransactionalMailing.holders.MailingStatesHolder state, javax.xml.rpc.holders.StringHolder mailingID, javax.xml.rpc.holders.StringHolder startTime, javax.xml.rpc.holders.StringHolder endTime, javax.xml.rpc.holders.LongHolder elapsedTime, javax.xml.rpc.holders.StringHolder lastRestartTime, javax.xml.rpc.holders.LongHolder restarts, javax.xml.rpc.holders.LongHolder totalDatabaseRecords, javax.xml.rpc.holders.LongHolder messagesDelivered, javax.xml.rpc.holders.LongHolder messagesFailed, javax.xml.rpc.holders.LongHolder messagesDeferred, javax.xml.rpc.holders.LongHolder messagesInvalid) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

    /**
     * Service definition of function ns__Send
     */
    public void send(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.FileDetails fileInfo, javax.xml.rpc.holders.StringHolder databaseId, javax.xml.rpc.holders.LongHolder count) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;
}
