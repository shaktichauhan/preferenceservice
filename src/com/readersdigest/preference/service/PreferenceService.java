package com.readersdigest.preference.service;

import com.readersdigest.preference.dto.CreatePreferenceResponseDTO;
import com.readersdigest.preference.dto.PreferenceDTO;

/**
 * @author shsingh
 *
 */

public interface PreferenceService {

	public CreatePreferenceResponseDTO createPreferenceEpid( PreferenceDTO info );
	
	public CreatePreferenceResponseDTO insertOptPreference( PreferenceDTO info );
	
	public CreatePreferenceResponseDTO fetchPreferencebyEmail(PreferenceDTO info);
	
	public CreatePreferenceResponseDTO fetchPreferencebyEpid(PreferenceDTO info);
	
	public String checkAppStatus();
	
	public boolean insertSweeps(String sepId, String slpId, String firstName,
			String lastName, String address1, String address2, String city,
			String state, String postalCode, String country, String phone,
			String email);
 
	public String getEpid(String emailAddress);
	
	public String getSmartMarketingByEmail(String emailAddress);
	
	public String getSmartMarketingByEpid(String epid);

	public String getEpidByLegacyEpid(String epid);
	
	
	
}
