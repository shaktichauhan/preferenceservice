package com.readersdigest.onepass.action;

import java.util.HashSet;
import java.util.Iterator;
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

import com.cds.global.api.Customer;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.dto.AccountDTO;
import com.readersdigest.onepass.dto.AddressDTO;
import com.readersdigest.onepass.dto.EmailDTO;
import com.readersdigest.onepass.dto.HeaderDTO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassServiceETImpl;
import com.readersdigest.onepass.service.impl.OnePassServiceImpl;
import com.readersdigest.onepass.service.impl.ServiceValidator;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassProfileUpdateAction.
 * 
 * @author shsingh
 */
public class OnePassProfileUpdateAction extends Action {

    /** The Constant SUCCESS_KEY. */
    public static final String SUCCESS_KEY = "success";

    /** The one pass service. */
    private OnePassService onePassService;

    /*
     * 
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        EntityManagerHelper.log("Start OnePassProfileUpdateAction.execute() method", Level.INFO, null);

        OnePassRegistrationForm onePassform = (OnePassRegistrationForm) form;
        
        String addressToggle = getBundleStringValue("addressToggle");
  
        if (StringUtils.isETApisCall()) {
			onePassService = new OnePassServiceETImpl();
		} else {
			onePassService = new OnePassServiceImpl();
		}
        
        ActionMessages messages = new ActionMessages();

        UpdateOnePassUserProfileDTO profileDTO = new UpdateOnePassUserProfileDTO();

        profileDTO.header = new HeaderDTO();

        WSGResponse wsgr = null;
        Customer customer = null;
        WSG wsg = new WSG();
        
       //String[] prodAbbrs = getBundleStringValue("cdsProdAbbrs") != null ? getBundleStringValue("cdsProdAbbrs").split(",") : null;

       // OnePassUserProfile profile = new OnePassUserProfile(onePassform.getEmailAddress(), onePassform.getSourceId());

        profileDTO.header.emailAddress = onePassform.getEmailAddress();
        profileDTO.header.token = onePassform.getToken();

        profileDTO.accountFields = new AccountDTO();
        profileDTO.accountFields.sourceId = onePassform.getSourceId();
        profileDTO.accountFields.trackingId = onePassform.getTrackingId();
        profileDTO.accountFields.preferenceFields = new HashSet<PreferenceDTO>();
        
        String strPromotanble = onePassform.getPromotable_unchecked();
                       
        if (onePassform.getPromotable() != null) {
            for (String preferenceId : onePassform.getPromotable()) {
                PreferenceDTO preferenceDTO = new PreferenceDTO();
                preferenceDTO.preferenceId = preferenceId;
                preferenceDTO.optIn = true;
                profileDTO.accountFields.preferenceFields.add(preferenceDTO);
            }
        }
        
        if(strPromotanble != null) {
			String[] promotablesList = strPromotanble.split(":");
			for(int i=0; i<promotablesList.length;i++) {
	        	boolean flag = false;
	        	if(onePassform.getPromotable() != null) {
	        		for (String preferenceId : onePassform.getPromotable()) {
		        		if(promotablesList[i].equals(preferenceId)) {
		        			flag = true;
		        			break;
		        		}
		        	}
	        	}
	        	
	        	
	        	if(!flag) {
	        		 PreferenceDTO preferenceDTO = new PreferenceDTO();
	                 preferenceDTO.preferenceId = promotablesList[i];
	                 preferenceDTO.optIn = false;
	                 profileDTO.accountFields.preferenceFields.add(preferenceDTO);
	        	}
	        }
		}
        

        /*if (profile.getOptStatusTransaction() != null) {
            Set<EmailAddressOptStatus> preferenceSet = profile.getOptStatusTransaction().getEmailAddressOptStatuses();

            // Add the opt out preference list
            if (preferenceSet != null) {
                Iterator<EmailAddressOptStatus> iterator = preferenceSet.iterator();
                while (iterator.hasNext()) {
                    EmailAddressOptStatus preStatus = iterator.next();

                    if (preStatus != null) {
                        if (preStatus.getOptStatus().getOptStatusId().intValue() == 2
                                && !optOutPreference(preStatus.getUserPreference().getUserPreferenceId().toString(), onePassform.getPromotable())) {
                            PreferenceDTO preferenceDTO = new PreferenceDTO();
                            preferenceDTO.preferenceId = preStatus.getUserPreference().getUserPreferenceId().toString();
                            preferenceDTO.optIn = false;
                            profileDTO.accountFields.preferenceFields.add(preferenceDTO);
                        }
                    }
                }
            }
        }*/

        profileDTO.emailFields = new EmailDTO();

        if (onePassform.getNewEmailAddress() != null && !"".equals(onePassform.getNewEmailAddress().trim())) {
            profileDTO.emailFields.newEmailAddress = onePassform.getNewEmailAddress();
        }

        if (onePassform.getPassword() != null && !"".equals(onePassform.getPassword().trim())) {
            profileDTO.emailFields.password = onePassform.getPassword();
            profileDTO.emailFields.confirmPassword = onePassform.getConfirmPassword();

        }
        profileDTO.emailFields.accountNumber = onePassform.getAccountNumber();


        profileDTO.addressFields = new AddressDTO();
        String customerName = onePassform.getCustomerName();
        int index = customerName.indexOf(" ");
        if(index >=0) {
            String firstName = customerName.substring(0, index);
            String lastName = customerName.substring(index+1);
            profileDTO.addressFields.firstName = firstName;
            profileDTO.addressFields.lastName = lastName;
        } else {
            profileDTO.addressFields.firstName = customerName;
        }
       
        if(!"true".equalsIgnoreCase(addressToggle)) { 
            profileDTO.addressFields.city = onePassform.getCity();
            profileDTO.addressFields.countryCode = onePassform.getCountry();
            profileDTO.addressFields.stateCode = onePassform.getState();
            profileDTO.addressFields.address1 = onePassform.getStreet1();
            profileDTO.addressFields.address2 = onePassform.getStreet2();
            profileDTO.addressFields.zip = onePassform.getPostalCode();
        }

        OnePassServiceResponse serviceResponse = null;

        if (onePassform.getAccountNumber() != null && !"".equals(onePassform.getAccountNumber().trim()) && onePassform.getAppId() != null
                && !"".equals(onePassform.getAppId().trim())) {
            try {
                String prodAbbr = StringUtils.getProdId(onePassform.getAppId());
                
                if(prodAbbr == null || "".equals(prodAbbr)) {
                    prodAbbr = StringUtils.getKindleProdId(onePassform.getAppId()); //Getting the APP Id for Kindle
                    wsg.setAppId(getBundleStringValue("cdsKindleAppId"));
                    wsg.setPassword(getBundleStringValue("cdsKindlePassword"));
                } else {
                    wsg.setAppId(getBundleStringValue("cdsIpadAppId"));
                    wsg.setPassword(getBundleStringValue("cdsIpadPassword"));
                }
               
                wsg.setProdAbbr(prodAbbr);
                wsgr = wsg.lookupCustomer(onePassform.getAccountNumber());
                
                if (wsgr.isSuccess()) {
                    customer = (Customer) wsgr.getObjects().get(0);
                }
              
                if (customer != null) {
                    
                    if (onePassform.getNewEmailAddress() != null && !"".equals(onePassform.getNewEmailAddress().trim())
                            && !onePassform.getNewEmailAddress().equalsIgnoreCase(customer.getEmail())) {
                       
                        try {
                            new ServiceValidator().uniqueCDSEmailValidation(onePassform.getNewEmailAddress().trim(), onePassform.getSourceId());
                        } catch (ServiceException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", e.getMessage()));
                            saveErrors(request, messages);
                            EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method, Error", Level.INFO, null);
                            return mapping.getInputForward();
                        }
     
                        customer.setEmail(onePassform.getNewEmailAddress());
                        
                    }
                    
                    if (!onePassform.getCustomerName().equalsIgnoreCase(customer.getName())) {
                        customer.setName(onePassform.getCustomerName());
                    }

                    if(!"true".equalsIgnoreCase(addressToggle)) {
                        if (!onePassform.getStreet1().equalsIgnoreCase(customer.getAddress1())) {
                            customer.setAddress1(onePassform.getStreet1());
                        }
                        if (!onePassform.getCity().equalsIgnoreCase(customer.getCity())) {
                            customer.setCity(onePassform.getCity());
                        }
                        if (!onePassform.getPostalCode().equalsIgnoreCase(customer.getZipCode())) {
                            customer.setZipCode(onePassform.getPostalCode());
                        }
                        
                        if (onePassform.getPassword() != null && !"".equals(onePassform.getPassword().trim())) {
                            customer.setPassword(onePassform.getPassword());
                        }
                        String country = "";
                        if ("UNITED STATES".equalsIgnoreCase(customer.getCountry()) || "USA".equalsIgnoreCase(customer.getCountry())
                                || "US".equalsIgnoreCase(customer.getCountry())) {
                            country = "US";
                        } else if ("CANADA".equalsIgnoreCase(customer.getCountry()) || "CA".equalsIgnoreCase(customer.getCountry())) {
                            country = "CA";
                        }
                        if (!country.equalsIgnoreCase(onePassform.getCountry())) {
                            customer.setCountry(onePassform.getCountry());
                        }
                        if (!"Others".equalsIgnoreCase(onePassform.getState())) {
                            if (!onePassform.getState().substring(3, 5).equalsIgnoreCase(customer.getState())) {
                                   customer.setState(onePassform.getState().substring(3, 5));
                            }
                        }
                    }

                    wsgr = wsg.updateCustomer(customer);

                    boolean updateSuccessfull = false;

                    if (wsgr.getErrorMessages() != null && wsgr.getErrorMessages().size() > 0) {
                        Iterator<String> errorMessages = wsgr.getErrorMessages().iterator();
                        while (errorMessages.hasNext()) {
                            String errorMessage = errorMessages.next();
                            if (errorMessage == null || "".equalsIgnoreCase(errorMessage.trim())) {
                                updateSuccessfull = true;
                            } else {
                                updateSuccessfull = false;
                                messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", errorMessage));

                            }
                        }
                    }

                    if (wsgr.isSuccess() && updateSuccessfull && !wsgr.isSentToOffline()) {
                        customer = (Customer) wsgr.getObjects().get(0);
                        
                        serviceResponse = onePassService.updateUserProfileInfo(profileDTO);
                        
                        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
                            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
                            saveErrors(request, messages);
                            EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method, Error", Level.INFO, null);
                            return mapping.getInputForward();
                        }
                    } else {
                        if (messages.size() == 0) {
                            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", "Fulfillment Update Failed"));
                        }
                        saveErrors(request, messages);
                        EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method, Error", Level.INFO, null);
                        return mapping.getInputForward();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", "Communication Error"));
                saveErrors(request, messages);
                EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method, Error", Level.INFO, null);
                return mapping.getInputForward();
            }
        } else {

            serviceResponse = onePassService.updateUserProfileInfo(profileDTO);
            if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
                messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
                saveErrors(request, messages);
                EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method, Error", Level.INFO, null);
                return mapping.getInputForward();
            }
        }

        EntityManagerHelper.log("End OnePassProfileUpdateAction.execute() method", Level.INFO, null);
         ActionForward forward = new ActionForward();
         // update forward path with the application id
         forward.setPath(mapping.getInputForward().getPath() + "?transactionCompleted=true");
         forward.setRedirect(mapping.getInputForward().getRedirect());
         return forward;
        //return mapping.findForward(SUCCESS_KEY);

    }

    /**
     * Opt out preference.
     * 
     * @param oldPreferenceId
     *            the old preference id
     * @param promotable
     *            the promotable
     * @return true, if successful
     */
    private boolean optOutPreference(final String oldPreferenceId, final String[] promotable) {

        boolean flag = false;

        if (oldPreferenceId != null && promotable != null) {
            for (String preferenceId : promotable) {
                if (oldPreferenceId.equals(preferenceId)) {
                    flag = true;
                }
            }
        }

        return flag;
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
