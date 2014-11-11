package com.readersdigest.preference.test;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.readersdigest.preference.dto.AddressDTO;
import com.readersdigest.preference.dto.CreatePreferenceRequestDTO;
import com.readersdigest.preference.dto.CreatePreferenceResponseDTO;

public class PreferenceTester extends Thread {

	public static void main(String[] args) {

		Thread a1 = new PreferenceTester();
		a1.setName("createMethod");
		a1.start();

		Thread a2 = new PreferenceTester();
		a2.setName("createExistEmailMethod");
		a2.start();

		Thread a3 = new PreferenceTester();
		a3.setName("getEpidMethodUsingEmail");
		a3.start();

		Thread a4 = new PreferenceTester();
		a4.setName("getEpidMethodUsingEpid");
		a4.start();

	}

	public void run() {
		if (this.getName().equalsIgnoreCase("createMethod")) {
			System.out.println("\n\n\n ***** in A1 createMethod thread ");
			for (int i = 0; i <= 10000; i++) {
				createMethod(
						"http://test.services.rd.com/preference/services/createPreferenceEpid",
						i);
			}
		}

		if (this.getName().equalsIgnoreCase("insertOptPreference")) {
			System.out.println("\n\n\n ***** in A1 createMethod thread ");
			for (int i = 0; i <= 10000; i++) {
				insertOptPreference("http://test.services.rd.com/preference/services/insertOptPreference");

			}
		}

		if (this.getName().equalsIgnoreCase("getEpidMethodUsingEmail")) {
			System.out.println("\n\n\n ***** in A1 createMethod thread ");
			for (int i = 0; i <= 10000; i++) {

				getEpidMethodUsingEmail("http://test.services.rd.com/preference/services/fetchPreferencebyEmail");
			}
		}

		if (this.getName().equalsIgnoreCase("getEpidMethodUsingEpid")) {
			System.out.println("\n\n\n ***** in A1 createMethod thread ");
			for (int i = 0; i <= 10000; i++) {
				getEpidMethodUsingEpid("http://test.services.rd.com/preference/services/fetchPreferencebyEpid");
			}
		}
	}

	public void createMethod(String url, int in) {

		CreatePreferenceRequestDTO preference = new CreatePreferenceRequestDTO();

		preference.sourceId = "140";
		preference.preferenceId = "10050";
		preference.optIn = "true";
		preference.firstName = "Shakti";
		preference.lastName = "Chauhan";
		preference.email = "shaktipeter.waibel" + in + "@supervisor.com";
		preference.billingAddress = new AddressDTO();

		preference.billingAddress.address1 = "140 E 223rd St";
		preference.billingAddress.address2 = "140 E 223rd St";
		preference.billingAddress.address3 = "140 E 223rd St";
		preference.billingAddress.city = "Bronx";
		preference.billingAddress.postalCode = "10466";
		preference.billingAddress.countryCode = "CA";
		String username = "preferencerd";
		String password = "rd123";

		String data = null;
		try {

			JAXBContext context = JAXBContext
					.newInstance(preference.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(preference, sw);
			data = sw.toString();

			PostMethod postMethod;
			HttpClient httpClient = new HttpClient();
			httpClient.getParams().setAuthenticationPreemptive(true);
			Credentials defaultcreds = new UsernamePasswordCredentials(
					username, password);
			httpClient.getState().setCredentials(AuthScope.ANY, defaultcreds);

			postMethod = new PostMethod(url);
			postMethod.setDoAuthentication(true);

			RequestEntity requestEntity = new StringRequestEntity(data,
					"application/xml", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			if (200 != executeResult) {
				System.out
						.println("\n\n ********* 200 != executeResult ********\n\n ");
			}

			InputStream stream = postMethod.getResponseBodyAsStream();
			CreatePreferenceResponseDTO paymentResponse = new CreatePreferenceResponseDTO();
			context = JAXBContext.newInstance(paymentResponse.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setSchema(null);
			paymentResponse = CreatePreferenceResponseDTO.class
					.cast(unmarshaller.unmarshal(stream));

			System.out.println("1111 ***EPID : " + paymentResponse.epid);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void insertOptPreference(String url) {

		CreatePreferenceRequestDTO preference = new CreatePreferenceRequestDTO();

		preference.sourceId = "140";
		preference.preferenceId = "10050";
		preference.optIn = "false";
		preference.firstName = "Shakti";
		preference.lastName = "Chauhan";
		preference.epid = "1701CD08-626E-4D16-AD39-EF757EB46BAD";
		preference.billingAddress = new AddressDTO();
		preference.billingAddress.address1 = "140 E 223rd St";
		preference.billingAddress.city = "Bronx";
		preference.billingAddress.postalCode = "10466";
		preference.billingAddress.countryCode = "CA";
		String username = "preferencerd";
		String password = "rd123";

		String data = null;
		try {

			JAXBContext context = JAXBContext
					.newInstance(preference.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(preference, sw);
			data = sw.toString();

			PostMethod postMethod;
			HttpClient httpClient = new HttpClient();
			httpClient.getParams().setAuthenticationPreemptive(true);
			Credentials defaultcreds = new UsernamePasswordCredentials(
					username, password);
			httpClient.getState().setCredentials(AuthScope.ANY, defaultcreds);

			postMethod = new PostMethod(url);
			postMethod.setDoAuthentication(true);

			RequestEntity requestEntity = new StringRequestEntity(data,
					"application/xml", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			if (200 != executeResult) {
				System.out
						.println("\n\n ********* 200 != executeResult ********\n\n ");
			}

			InputStream stream = postMethod.getResponseBodyAsStream();
			CreatePreferenceResponseDTO paymentResponse = new CreatePreferenceResponseDTO();
			context = JAXBContext.newInstance(paymentResponse.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setSchema(null);
			paymentResponse = CreatePreferenceResponseDTO.class
					.cast(unmarshaller.unmarshal(stream));

			System.out.println("****222 EPID : "
					+ paymentResponse.responseMessage);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void getEpidMethodUsingEmail(String url) {

		CreatePreferenceRequestDTO preference = new CreatePreferenceRequestDTO();

		preference.sourceId = "140";
		preference.preferenceId = "10050";
		preference.optIn = "true";
		preference.email = "peter.waibel@supervisor.com";

		String username = "preferencerd";
		String password = "rd123";

		String data = null;
		try {

			JAXBContext context = JAXBContext
					.newInstance(preference.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(preference, sw);
			data = sw.toString();

			PostMethod postMethod;
			HttpClient httpClient = new HttpClient();
			httpClient.getParams().setAuthenticationPreemptive(true);
			Credentials defaultcreds = new UsernamePasswordCredentials(
					username, password);
			httpClient.getState().setCredentials(AuthScope.ANY, defaultcreds);

			postMethod = new PostMethod(url);
			postMethod.setDoAuthentication(true);

			RequestEntity requestEntity = new StringRequestEntity(data,
					"application/xml", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			if (200 != executeResult) {
				System.out
						.println("\n\n ********* 200 != executeResult ********\n\n ");
			}

			InputStream stream = postMethod.getResponseBodyAsStream();
			CreatePreferenceResponseDTO paymentResponse = new CreatePreferenceResponseDTO();
			context = JAXBContext.newInstance(paymentResponse.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setSchema(null);
			paymentResponse = CreatePreferenceResponseDTO.class
					.cast(unmarshaller.unmarshal(stream));

			System.out.println(paymentResponse.responseMessage);
			System.out.println(paymentResponse.preference);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void getEpidMethodUsingEpid(String url) {

		CreatePreferenceRequestDTO preference = new CreatePreferenceRequestDTO();

		preference.sourceId = "140";
		preference.preferenceId = "10050";
		preference.epid = "1701CD08-626E-4D16-AD39-EF757EB46BAD";

		String username = "preferencerd";
		String password = "rd123";

		String data = null;
		try {

			JAXBContext context = JAXBContext
					.newInstance(preference.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);

			StringWriter sw = new StringWriter();
			marshaller.marshal(preference, sw);
			data = sw.toString();

			PostMethod postMethod;
			HttpClient httpClient = new HttpClient();
			httpClient.getParams().setAuthenticationPreemptive(true);
			Credentials defaultcreds = new UsernamePasswordCredentials(
					username, password);
			httpClient.getState().setCredentials(AuthScope.ANY, defaultcreds);

			postMethod = new PostMethod(url);
			postMethod.setDoAuthentication(true);

			RequestEntity requestEntity = new StringRequestEntity(data,
					"application/xml", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			if (200 != executeResult) {
				System.out
						.println("\n\n ********* 200 != executeResult ********\n\n ");
			}

			InputStream stream = postMethod.getResponseBodyAsStream();
			CreatePreferenceResponseDTO paymentResponse = new CreatePreferenceResponseDTO();
			context = JAXBContext.newInstance(paymentResponse.getClass());
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setSchema(null);
			paymentResponse = CreatePreferenceResponseDTO.class
					.cast(unmarshaller.unmarshal(stream));

			System.out.println(paymentResponse.responseMessage);
			System.out.println(paymentResponse.preference);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
