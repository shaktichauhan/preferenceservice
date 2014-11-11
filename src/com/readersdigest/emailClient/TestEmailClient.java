package com.readersdigest.emailClient;

import java.rmi.RemoteException;

import TransactionalMailing.AuthenticationError;
import TransactionalMailing.ConnectionError;
import TransactionalMailing.DatabaseSpecificationError;
import TransactionalMailing.Exception;
import TransactionalMailing.FeatureUnavailabilityError;
import TransactionalMailing.MailingCreationError;
import TransactionalMailing.MailingOperationError;
import TransactionalMailing.VSGError;

public class TestEmailClient {
	
	EmailClient emailClient;
	TransactionRecord txRecord;
	String mailingName;
	
	public void sendEmail() {
		try {
			emailClient = new StrongMailClient();
			mailingName = "Mailing.2321306.7959"; // Need to put the dynamic templete
			txRecord = createTransactionRecord();
			emailClient.send(txRecord, mailingName);
			System.out.println("\n\n *** MAIL SENT ****");
		} catch (MailingCreationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailingOperationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeatureUnavailabilityError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VSGError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseSpecificationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Dummy values need to create your own dynamic value passing method
	private TransactionRecord createTransactionRecord() {
		
		txRecord = new TransactionRecord();
		txRecord.setFirstName("Shakti");
		txRecord.setLastName("Chauhan");
		txRecord.setEmail("shakti_singh@consultant.rd.com");
		txRecord.setTopic("Readers Digest ");
		txRecord.setId("Mailing.2321306.7959");
		return txRecord;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestEmailClient().sendEmail();

	}

}
