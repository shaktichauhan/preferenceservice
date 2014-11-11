package com.readersdigest.preference.epipe;

/**
 * @author shsingh
 *
 */

import java.util.List;

import com.readersdigest.preference.domain.Preference;
import com.readersdigest.preference.dto.PreferenceListDTO;

public interface EpipeService {

	public String createPreferenceEpid(Preference preference);

	public boolean updateOptStatus(Preference preference);

	public List<PreferenceListDTO> fetchPreferencebyEmail(Preference preference);

	public List<PreferenceListDTO> fetchPreferencebyEpid(Preference preference);

	public boolean insertSweeps(String sepId, String slpId, String firstName,
			String lastName, String address1, String address2, String city,
			String state, String postalCode, String country, String phone,
			String email);
 
	public String getEpid(String emailAddress);
	
	public String getSmartMarketingByEmail(String emailAddress);
	
	public String getSmartMarketingByEpid(String epid);

	public String getEpidByLegacyEpid(String epid);
	
	
}
