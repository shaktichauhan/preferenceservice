package com.readersdigest.onepass.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.readersdigest.onepass.db.PostalAddress;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class PMDdServiceManager.
 * 
 * @author shsingh
 * 
 *         ServiceValidator is used to validate the request body from client.
 */
public class PMDBServiceManager {

    public boolean AddMember(String prodAbbr, String emailAddress, PostalAddress address) {

        try {
            String pmCode = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", ("pmCode_" + prodAbbr));
            StringBuffer serviceUrl = new StringBuffer(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources",
                    ("pmAddMemberServiceURL_" + prodAbbr)));
            serviceUrl.append("eMail=" + emailAddress);
            serviceUrl.append("&pmCode=" + pmCode);
            if (address == null) {
                address = new PostalAddress();
            }
            serviceUrl.append("&firstName=" + address.getFirstName());
            serviceUrl.append("&lastName=" + URLEncoder.encode((address.getLastName() == null ? "" : address.getLastName()), "UTF-8"));
            serviceUrl.append("&address1=" + address.getAddress1());
            serviceUrl.append("&address2=" + address.getAddress2());
            serviceUrl.append("&city=" + address.getCity());
            serviceUrl.append("&state=" + address.getSubdivision());
            serviceUrl.append("&zipPostal=" + address.getZip());
            serviceUrl.append("&country=" + address.getCountry());

            System.out.println("\n\n **** add member serviceUrl : " + serviceUrl.toString());

            URL url = new URL(serviceUrl.toString());
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(conn.getInputStream());
            NodeList listOfEmployee = doc.getElementsByTagName("int");
            String result = listOfEmployee.item(0).getTextContent();

            System.out.println("\n\n **** Result " + result);

            if (result != null && !"".equals(result.trim())) {
                return true;
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public boolean AddOptIn(String prodAbbr, String emailAddress, Set<PreferenceDTO> preferenceFields) {

        try {
            String pmCode = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", ("pmCode_" + prodAbbr));
            String preServiceUrl = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", ("pmOptInServiceURL_" + prodAbbr));
            for (PreferenceDTO preferenceDTO : preferenceFields) {
                StringBuffer serviceUrl = new StringBuffer(preServiceUrl);
                serviceUrl.append("optInID=" + preferenceDTO.preferenceId);
                serviceUrl.append("&eMail=" + emailAddress);
                serviceUrl.append("&optIn=true"); // adding only selected preference no opt out need now
                serviceUrl.append("&pmCode=" + pmCode);

                System.out.println("\n\n **** opt in serviceUrl : " + serviceUrl.toString());

                URL url = new URL(serviceUrl.toString());
                URLConnection conn = url.openConnection();
                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(conn.getInputStream());
                NodeList listOfEmployee = doc.getElementsByTagName("int");
                String result = listOfEmployee.item(0).getTextContent();
                System.out.println("\n\n **** Result " + result);

            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DOMException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String a[]) {
        Set<PreferenceDTO> preferenceFields = new HashSet<PreferenceDTO>();
        PreferenceDTO dto = new PreferenceDTO();
        dto.preferenceId = "20";
        preferenceFields.add(dto);
        dto = new PreferenceDTO();
        dto.preferenceId = "30";
        preferenceFields.add(dto);
        new PMDBServiceManager().AddMember("FHO", "sss@dd.com", null);
        // new PMDBServiceManager().AddOptIn("FHO", "sss@dd.com", preferenceFields);
    }
}
