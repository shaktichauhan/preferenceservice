package com.readersdigest.emailClient;

import javax.xml.rpc.holders.LongHolder;
import javax.xml.rpc.holders.StringHolder;

import TransactionalMailing.AuthDetails;
import TransactionalMailing.FileDetails;
import TransactionalMailing.FormatType;
import TransactionalMailing.Sm_tmailingPortType;
import TransactionalMailing.Sm_tmailingPortTypeProxy;

public class StrongMailClient implements EmailClient {

	Sm_tmailingPortType port;
	AuthDetails authDetails;
	FileDetails fileInfo;

	public static String USERNAME = "";
	public static String PASSWORD = "";

	public StrongMailClient() {
	    port = new Sm_tmailingPortTypeProxy();
	    authDetails = new AuthDetails(USERNAME,PASSWORD);
		fileInfo = new FileDetails();
	}

	public void send(TransactionRecord txRecord, String mailingName)  throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{

  		fileInfo.setData(txRecord.getRecordAsString());
		fileInfo.setFormat(FormatType.Data);
		port.send(authDetails, mailingName, fileInfo, new StringHolder(), new LongHolder());

	}

	public void send(String strRecord, String mailingName)  throws java.rmi.RemoteException, TransactionalMailing.Exception, TransactionalMailing.MailingCreationError, TransactionalMailing.ConnectionError, TransactionalMailing.MailingOperationError, TransactionalMailing.FeatureUnavailabilityError, TransactionalMailing.VSGError, TransactionalMailing.AuthenticationError, TransactionalMailing.DatabaseSpecificationError{

		fileInfo.setData(strRecord);
		fileInfo.setFormat(FormatType.Data);
		port.send(authDetails, mailingName, fileInfo, new StringHolder(), new LongHolder());

		}


}
