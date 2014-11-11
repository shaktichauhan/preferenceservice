package com.cds.global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;


public class TestClient {
    
    public void updateOnePass(String emailAddress) {
        try {
            //please replace the production url inplace of staging url
            String request = "http://staging.services.rd.com/preference/publicOnePass/service/createOnePassBHEUser?emailAddress="+emailAddress;

            HttpClient client = new HttpClient();

            GetMethod method = new GetMethod(request);

            int statusCode = client.executeMethod(method);
            System.out.println("\n\n **** staus Code " + statusCode);
            
            InputStream rstream = null;

            rstream = method.getResponseBodyAsStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(rstream));

            String line;

            while ((line = br.readLine()) != null) {

                System.out.println(line);

            }

             br.close();
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }


	public static void main(String args[]) {
    
	    new TestClient().updateOnePass("shaktitest@rd.com");
	    
	 }
}
