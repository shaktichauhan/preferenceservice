package TransactionalMailing;

public class Sm_tmailingPortTypeProxy implements TransactionalMailing.Sm_tmailingPortType {
  private String _endpoint = null;
  private TransactionalMailing.Sm_tmailingPortType sm_tmailingPortType = null;
  
  public Sm_tmailingPortTypeProxy() {
    _initSm_tmailingPortTypeProxy();
  }
  
  public Sm_tmailingPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSm_tmailingPortTypeProxy();
  }
  
  private void _initSm_tmailingPortTypeProxy() {
    try {
      sm_tmailingPortType = (new TransactionalMailing.Sm_tmailingLocator()).getsm_tmailing();
      if (sm_tmailingPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sm_tmailingPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sm_tmailingPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sm_tmailingPortType != null)
      ((javax.xml.rpc.Stub)sm_tmailingPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public TransactionalMailing.Sm_tmailingPortType getSm_tmailingPortType() {
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType;
  }
  
  public long load(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, java.lang.String _class) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.load(credentials, mailingName, _class);
  }
  
  public long resume(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.resume(credentials, mailingName);
  }
  
  public long pause(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.pause(credentials, mailingName);
  }
  
  public long resumeOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.resumeOutbound(credentials, mailingName);
  }
  
  public long pauseOutbound(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.pauseOutbound(credentials, mailingName);
  }
  
  public long cancel(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.cancel(credentials, mailingName);
  }
  
  public long close(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.close(credentials, mailingName);
  }
  
  public TransactionalMailing.MailingStates getState(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.getState(credentials, mailingName);
  }
  
  public long save(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.MailingDetails SMTPMailing, TransactionalMailing.SMPPMailingDetails SMPPMailing, boolean overwrite) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    return sm_tmailingPortType.save(credentials, mailingName, SMTPMailing, SMPPMailing, overwrite);
  }
  
  public void getStatus(TransactionalMailing.AuthDetails credentials, javax.xml.rpc.holders.StringHolder mailingName, javax.xml.rpc.holders.LongWrapperHolder serialNumber, TransactionalMailing.holders.MailingStatesHolder state, javax.xml.rpc.holders.StringHolder mailingID, javax.xml.rpc.holders.StringHolder startTime, javax.xml.rpc.holders.StringHolder endTime, javax.xml.rpc.holders.LongHolder elapsedTime, javax.xml.rpc.holders.StringHolder lastRestartTime, javax.xml.rpc.holders.LongHolder restarts, javax.xml.rpc.holders.LongHolder totalDatabaseRecords, javax.xml.rpc.holders.LongHolder messagesDelivered, javax.xml.rpc.holders.LongHolder messagesFailed, javax.xml.rpc.holders.LongHolder messagesDeferred, javax.xml.rpc.holders.LongHolder messagesInvalid) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    sm_tmailingPortType.getStatus(credentials, mailingName, serialNumber, state, mailingID, startTime, endTime, elapsedTime, lastRestartTime, restarts, totalDatabaseRecords, messagesDelivered, messagesFailed, messagesDeferred, messagesInvalid);
  }
  
  public void send(TransactionalMailing.AuthDetails credentials, java.lang.String mailingName, TransactionalMailing.FileDetails fileInfo, javax.xml.rpc.holders.StringHolder databaseId, javax.xml.rpc.holders.LongHolder count) throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{
    if (sm_tmailingPortType == null)
      _initSm_tmailingPortTypeProxy();
    sm_tmailingPortType.send(credentials, mailingName, fileInfo, databaseId, count);
  }
  
  
}