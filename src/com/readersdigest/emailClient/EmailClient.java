package com.readersdigest.emailClient;


public interface EmailClient {

	public void send(TransactionRecord txRecord, String mailingName)  throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;
	public void send(String strtxRecord, String mailingName)  throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError;

}
