package com.readersdigest.onepass.action;

import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.service.impl.OnePassETUserProfile;
import com.readersdigest.onepass.service.impl.OnePassUserProfile;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassProfileUpdate.
 * 
 * @author shsingh - shakti_singh@consutant.rd.com
 */
public class OnePassProfileUpdate extends Action {

    /** The Constant SUCCESS_KEY. */
    public static final String SUCCESS_KEY = "success";

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        EntityManagerHelper.log("Start OnePassProfileUpdate.execute() method", Level.INFO, null);

        String userName = request.getParameter("userName");
        String sourceId = request.getParameter("sourceId");
        String appId = request.getParameter("appId");
        
        String acNumber = request.getParameter("accountNumber");        
        StringBuilder params = new StringBuilder();
        //DESEncrypter desEncrypt = new DESEncrypter(getBundleStringValue("passPhase"));
        String prodAbbr = StringUtils.getProdIdBySource(sourceId);
        
        if (userName == null || "".equals(userName.trim())) {
            ActionMessages messages = new ActionMessages();
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", "Please use valid user name"));
            saveErrors(request, messages);
            EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
            if(prodAbbr == null || "".equals(prodAbbr)) {
                return mapping.findForward(SUCCESS_KEY);
            } else {
                return mapping.findForward(SUCCESS_KEY+"_"+prodAbbr);
            }
         
            
        } 

        System.out.println("\n\n\n ******* emailAddress : " + userName);

        OnePassUserProfile profile = null;
        OnePassETUserProfile etProfile = null;
        
        
        if(StringUtils.isETApisCall()) {
        	if(acNumber != null && !"".equals(acNumber.trim())) {
        		etProfile = new OnePassETUserProfile(acNumber, sourceId);
            } else {
            	etProfile = new OnePassETUserProfile(userName, sourceId);
            }
        	 
        	MemberOnePassInfo memberOnePassInfo =  etProfile.getMemberOnePassInfo();
        	if(memberOnePassInfo == null) {
        		 ActionMessages messages = new ActionMessages();
                 messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", "Please use valid user name "));
                 saveErrors(request, messages);
                 EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
                 if(prodAbbr == null || "".equals(prodAbbr)) {
                     return mapping.findForward(SUCCESS_KEY);
                 } else {
                     return mapping.findForward(SUCCESS_KEY+"_"+prodAbbr);
                 }
        	 }
        	 
        	 ETResponse etResponse = etProfile.getEtResponse();
        	 params.append("?customerName=").append(memberOnePassInfo.getFullName()!= null?memberOnePassInfo.getFullName():"");
        	 if(memberOnePassInfo.getAccountNumber() != null && !"".equalsIgnoreCase(memberOnePassInfo.getAccountNumber().trim())) {
                 params.append("&accountNumber=").append(memberOnePassInfo.getAccountNumber());
             }
        	 
        	 params.append("&emailAddress=").append(memberOnePassInfo.getEmailAddress());
             params.append("&token=").append(memberOnePassInfo.getPassword());
             if (etResponse.getSubscriptionPreferences() != null && etResponse.getSubscriptionPreferences().size()>0) {
                 request.setAttribute("PREFERENCES", etResponse.getSubscriptionPreferences());
             }
        	
        } else {
        	if(acNumber != null && !"".equals(acNumber.trim())) {
                profile = new OnePassUserProfile(acNumber, sourceId);
            } else {
                profile = new OnePassUserProfile(userName, sourceId);
            }
           
           

            String addressToggle = getBundleStringValue("addressToggle");
            System.out.println("profile.getMemberInfoList() : " + profile.getMemberOnePassInfoList());
            if (profile.getMemberOnePassInfoList() != null && profile.getMemberOnePassInfoList().size() > 0) {
                MemberOnePassInfo memberOnePassInfo = profile.getMemberOnePassInfoList().get(0);
                params.append("?customerName=").append(memberOnePassInfo.getFullName()!= null?memberOnePassInfo.getFullName():"");
                if(!"true".equalsIgnoreCase(addressToggle)) {
                    params.append("&country=").append(profile.getAddress().getCountry());
                    params.append("&street1=").append(profile.getAddress().getAddress1());
                    params.append("&city=").append(profile.getAddress().getCity());
                    if ("US".equalsIgnoreCase(profile.getAddress().getCountry()) || "CA".equalsIgnoreCase(profile.getAddress().getCountry())) {
                         params.append("&state=").append(profile.getAddress().getSubdivision());
                    } else {
                       // Pass state value others for all country except USA and Canada
                        params.append("&state=").append("Others");
                    }
                    params.append("&postalCode=").append(profile.getAddress().getZip());
                }
                
                if(memberOnePassInfo.getAccountNumber() != null && !"".equalsIgnoreCase(memberOnePassInfo.getAccountNumber().trim())) {
                    params.append("&accountNumber=").append(memberOnePassInfo.getAccountNumber());
                }
                
                params.append("&emailAddress=").append(memberOnePassInfo.getEmailAddress());
                params.append("&token=").append(memberOnePassInfo.getPassword());
                
                if (profile.getOptStatusTransaction() != null) {
                    request.setAttribute("PREFERENCES", profile.getOptStatusTransaction().getEmailAddressOptStatuses());
                }
                
            } else {
                ActionMessages messages = new ActionMessages();
                messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", "Please use valid user name "));
                saveErrors(request, messages);
                EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
                if(prodAbbr == null || "".equals(prodAbbr)) {
                    return mapping.findForward(SUCCESS_KEY);
                } else {
                    return mapping.findForward(SUCCESS_KEY+"_"+prodAbbr);
                }
            }
        }
        
        params.append("&userName=").append(userName);
        params.append("&appId=").append(appId);
        params.append("&sourceId=").append(sourceId);

        ActionForward copyFromForward = null;
        
        if(prodAbbr == null || "".equals(prodAbbr)) {
            copyFromForward = mapping.findForward(SUCCESS_KEY);
        } else {
            copyFromForward = mapping.findForward(SUCCESS_KEY+"_"+prodAbbr);
        }
     
        ActionForward forward = new ActionForward();

        forward.setPath(copyFromForward.getPath() + params.toString());
        forward.setRedirect(copyFromForward.getRedirect());

        EntityManagerHelper.log("End OnePassProfileUpdate.execute() method", Level.INFO, null);

        return forward;

    }

    /**
     * Gets the bundle string value.
     * 
     * @param key
     *            the key
     * @return the bundle string value
     */
    public static String getBundleStringValue(String key) {
        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
    }

}
