package com.readersdigest.onepass.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class PromotionalRegistrationAction.
 *
 * @author shsingh
 */
public class PromotionalZinioRegistrationAction extends Action {

    /*
     * (non-Javadoc)
     *
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        EntityManagerHelper.log("Start PromotionalZinioRegistrationAction.execute() method", Level.INFO, null);
        
        try {
        	
        	       	
        	String zinioURL = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "zinio_url");
        	
			String emailAddress = request.getParameter("emailAddress");
			
     
			System.out.println("\n\n **** add zinioURL : " + zinioURL);
			
			System.out.println("\n\n **** add emailAddress : " + emailAddress);
			
			StringBuffer serviceUrl = new StringBuffer(zinioURL+emailAddress);
		
			System.out.println("\n\n **** add member serviceUrl : " + serviceUrl.toString());

			URL url = new URL(serviceUrl.toString());
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.6) Gecko/20100625 Firefox/3.6.6");
      
			System.out.println("\n **** connection.getResponseCode()" + connection.getResponseCode());
      
			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while ((line = reader.readLine()) != null) {
			    builder.append(line);
			    builder.append("\n"); 
			}
			
			String redirURL = builder.toString();
			
			System.out.println("\n ***redirURL " + redirURL);
			
			response.sendRedirect( redirURL );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
          
    }

}
