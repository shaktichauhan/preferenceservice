package com.readersdigest.preference.epipe.impl;

/**
 * @author shsingh
 *
 */

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.readersdigest.preference.domain.Preference;
import com.readersdigest.preference.dto.PreferenceListDTO;
import com.readersdigest.preference.epipe.EpipeService;
import com.readersdigest.preferences.EmailAddressOptStatusManager;
import com.readersdigest.preferences.PreferenceException;
import com.readersdigest.preferences.PreferenceManager;
import com.readersdigest.preferences.bean.EmailAddressOptStatus;
import com.readersdigest.preferences.bean.OptStatus;
import com.readersdigest.profile.bean.Address;
import com.readersdigest.profile.bean.AddressType;
import com.readersdigest.profile.bean.Country;
import com.readersdigest.profile.bean.Email;
import com.readersdigest.profile.dao.EmailManager;
import com.readersdigest.profile.dao.ProfileManagerException;
import com.readersdigest.profile.dao.SmartMarketingManager;
import com.readersdigest.sweeps.SweepsEntry;
import com.readersdigest.sweeps.SweepsEntryHandler;
import com.readersdigest.util.SHA1Encrypt;
import com.readersdigest.util.hibernate.HibernateUtil;

public class EpipeServiceImpl implements EpipeService {

	public String createPreferenceEpid(Preference preference) {

		String epid = null;

		try {
			Address address = createAddress(preference);
			int optInStatus = OptStatus.OUT;

			if (Boolean.valueOf(preference.getOptIn())) {
				optInStatus = OptStatus.IN;
			}

			PreferenceManager preferenceManager = new PreferenceManager();

			epid = preferenceManager.getEpidUserOptPreferences(preference
					.getEmail(), address, preference.getPreferenceId(),
					optInStatus, preference.getTrackingId(), Integer
							.parseInt(preference.getSourceId()));

			if (epid == null) {
				HibernateUtil.commitTransaction();
				HibernateUtil.closeSession();
				epid = getNewSessionEpid(preference.getEmail());
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (PreferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return epid;

	}

	public String getNewSessionEpid(String email_address) {
		EmailManager emailManager = new EmailManager();

		String epid = null;
		try {
			HibernateUtil.beginTransaction();
			Email email = emailManager.getEmailForAddress(email_address);
			epid = email.getEpid();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfileManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				HibernateUtil.closeSession();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return epid;

	}

	public boolean updateOptStatus(Preference preference) {

		PreferenceManager preferenceManager = new PreferenceManager();
		boolean status = false;

		int optInStatus = OptStatus.OUT;

		if (Boolean.valueOf(preference.getOptIn())) {
			optInStatus = OptStatus.IN;
		}

		try {
			status = preferenceManager.insertOptStatus(preference.getEpid(),
					preference.getPreferenceId(), optInStatus, preference
							.getTrackingId(), Integer.parseInt(preference
							.getSourceId()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;

	}

	public List<PreferenceListDTO> fetchPreferencebyEmail(Preference preference) {

		EmailAddressOptStatusManager emailAddressOptStatusManager = new EmailAddressOptStatusManager();

		List<PreferenceListDTO> preferencesList = new ArrayList<PreferenceListDTO>();
		PreferenceListDTO preferenceList = null;

		try {

			List<EmailAddressOptStatus> emailAddressoptStatusList = emailAddressOptStatusManager
					.getCurrentOptStatusFromEmail(preference.getEmail());

			for (EmailAddressOptStatus emailAddressOptStatus : emailAddressoptStatusList) {
				preferenceList = new PreferenceListDTO();
				preferenceList.preference_id = String
						.valueOf(emailAddressOptStatus
								.getEmailAddressOptStatusCompositeId()
								.getUserPreference().getUserPreferenceId());

				preferenceList.optIn = (OptStatus.IN == emailAddressOptStatus
						.getOptStatus().getOptStatusId()) ? "TRUE" : "FALSE";

				preferencesList.add(preferenceList);
			}
		} catch (PreferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return preferencesList;

	}

	public List<PreferenceListDTO> fetchPreferencebyEpid(Preference preference) {

		EmailAddressOptStatusManager emailAddressOptStatusManager = new EmailAddressOptStatusManager();

		List<PreferenceListDTO> preferencesList = new ArrayList<PreferenceListDTO>();
		PreferenceListDTO preferenceList = null;

		try {
			List<EmailAddressOptStatus> emailAddressoptStatusList = emailAddressOptStatusManager
					.getCurrentOptStatusFromEpid(preference.getEpid());

			for (EmailAddressOptStatus emailAddressOptStatus : emailAddressoptStatusList) {
				preferenceList = new PreferenceListDTO();
				preferenceList.preference_id = String
						.valueOf(emailAddressOptStatus
								.getEmailAddressOptStatusCompositeId()
								.getUserPreference().getUserPreferenceId());

				preferenceList.optIn = (OptStatus.IN == emailAddressOptStatus
						.getOptStatus().getOptStatusId()) ? "TRUE" : "FALSE";

				preferencesList.add(preferenceList);
			}
		} catch (PreferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return preferencesList;

	}
	
	public boolean insertSweeps(String sepId, String slpId, String firstName,
			String lastName, String address1, String address2, String city,
			String state, String postalCode, String country, String phone,
			String email) {
		
			SweepsEntry se = new SweepsEntry();
	        se.setSepId(new Integer(sepId));
	        se.setFirstName(firstName);
	        se.setLastName(lastName);
	        se.setAddress1(address1);
	        se.setAddress2(address2);
	        se.setCity(city);
	        se.setState(state);
	        se.setZipCode(postalCode);
	        se.setCountry(country);
	        se.setPhone(phone);
	        se.setEmailAddress(email);
	        
	        SweepsEntryHandler seh = new SweepsEntryHandler();
	        return seh.insertSweeps(se, Integer.parseInt(slpId));
    	
	}
	
	public String getEpid(String emailAddress) {
		
		SHA1Encrypt sha1Encrypt = new SHA1Encrypt();
    	return sha1Encrypt.getSHA1EncryptValue(emailAddress);
    }
	
	public String getSmartMarketingByEmail(String emailAddress) {
		
		SmartMarketingManager smartMktManager = new SmartMarketingManager();
		String smartMktProps = null;
		
		try {
			smartMktProps = smartMktManager.getSmartMarketingPropertiesForEmail(emailAddress);
		} catch (ProfileManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smartMktProps;
	}
	
	public String getSmartMarketingByEpid(String epid) {
		
		SmartMarketingManager smartMktManager = new SmartMarketingManager();
		String smartMktProps = null;
		
		try {
			smartMktProps = smartMktManager.getSmartMarketingPropertiesForEpid(epid);
		} catch (ProfileManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return smartMktProps;
	}

	public String getEpidByLegacyEpid(String epid) {
		
		EmailManager emailManager  = new EmailManager();
		Email email = null;
		try {
			email = emailManager.getEmailFromEpid(epid);
		} catch (ProfileManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (email!=null?email.getEpid():null);
	}
	
	
	private Address createAddress(Preference preference) {

		Address address = new Address();
		Country country = new Country();
		AddressType addressType = new AddressType();
		addressType.setAddressTypeId(3);
		address.setType(addressType);
		
		address.setFirstName(preference.getFirstName());
		address.setMiddleName(preference.getMiddleName());
		address.setLastName(preference.getLastName());
	
		if(preference.getBillingAddress() != null) {
			address.setAddress1(preference.getBillingAddress().getAddress1());
			address.setAddress2(preference.getBillingAddress().getAddress2());
			address.setAddress3(preference.getBillingAddress().getAddress3());
			address.setCity(preference.getBillingAddress().getCity());
			address.setPostalCode(preference.getBillingAddress().getPostalCode());
			country.setCountryCode(preference.getBillingAddress().getCountryCode());
			address.setCountry(country);
	
		}
	
		return address;

	}


}
