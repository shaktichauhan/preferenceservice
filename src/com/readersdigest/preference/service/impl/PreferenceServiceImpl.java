package com.readersdigest.preference.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.readersdigest.preference.builder.PreferenceBuilder;
import com.readersdigest.preference.dao.PreferenceDao;
import com.readersdigest.preference.domain.Preference;
import com.readersdigest.preference.dto.CreatePreferenceResponseDTO;
import com.readersdigest.preference.dto.PreferenceDTO;
import com.readersdigest.preference.dto.PreferenceListDTO;
import com.readersdigest.preference.epipe.EpipeService;
import com.readersdigest.preference.epipe.impl.EpipeServiceImpl;
import com.readersdigest.preference.service.PreferenceService;

/**
 * @author shsingh
 *
 */

public class PreferenceServiceImpl implements PreferenceService {

	public static String SUCCES_MESSAGE = "Transaction Successfull";
	public static String FAILED_MESSAGE = "Transaction FAILED";
	public static String SUCCES_CODE = "0";
	public static String FAILED_CODE = "1";

	private EpipeService epipeService;

	private PreferenceDao preferecneDao;

	public PreferenceServiceImpl() {
		epipeService = new EpipeServiceImpl();
		preferecneDao = new PreferenceDao();
	}

	@SuppressWarnings("unchecked")
	public CreatePreferenceResponseDTO createPreferenceEpid(PreferenceDTO dto) {

		Preference preference = buildPreference(dto, "createPreferenceEpid");

		preferecneDao.savePreference(preference);

		CreatePreferenceResponseDTO responseDTO = new CreatePreferenceResponseDTO();

		if (!validRequest(preference.getEmail(), preference.getPreferenceId(),
				preference.getSourceId())) {
			responseDTO.responseCode = FAILED_CODE;
			responseDTO.responseMessage = FAILED_MESSAGE;
			return responseDTO;
		} else {
			String epid = epipeService.createPreferenceEpid(preference);
			if (epid != null && !"".equals(epid.trim())) {
				responseDTO.epid = epid;
				responseDTO.responseCode = SUCCES_CODE;
				responseDTO.responseMessage = SUCCES_MESSAGE;
			} else {
				responseDTO.responseCode = FAILED_CODE;
				responseDTO.responseMessage = FAILED_MESSAGE;
				return responseDTO;
			}

		}

		return responseDTO;

	}

	@SuppressWarnings("unchecked")
	public CreatePreferenceResponseDTO insertOptPreference(PreferenceDTO dto) {

		Preference preference = buildPreference(dto, "insertOptPreference");

		preferecneDao.savePreference(preference);

		CreatePreferenceResponseDTO responseDTO = new CreatePreferenceResponseDTO();

		if (!validRequest(preference.getEpid(), preference.getPreferenceId(),
				preference.getSourceId())) {
			responseDTO.responseCode = FAILED_CODE;
			responseDTO.responseMessage = FAILED_MESSAGE;
			return responseDTO;
		} else {
			boolean success = epipeService.updateOptStatus(preference);
			if (success) {
				responseDTO.responseCode = SUCCES_CODE;
				responseDTO.responseMessage = SUCCES_MESSAGE;
			} else {
				responseDTO.responseCode = FAILED_CODE;
				responseDTO.responseMessage = FAILED_MESSAGE;
				return responseDTO;
			}

		}

		return responseDTO;

	}

	@SuppressWarnings("unchecked")
	public CreatePreferenceResponseDTO fetchPreferencebyEmail(PreferenceDTO dto) {

		Preference preference = buildPreference(dto, "fetchPreferencebyEmail");

		preferecneDao.savePreference(preference);

		CreatePreferenceResponseDTO responseDTO = new CreatePreferenceResponseDTO();

		List<PreferenceListDTO> preferencesList = epipeService
				.fetchPreferencebyEmail(preference);

		if (!validRequest(preference.getEmail())) {
			responseDTO.responseCode = FAILED_CODE;
			responseDTO.responseMessage = FAILED_MESSAGE;
		} else {
			responseDTO.preference = new ArrayList<PreferenceListDTO>();
			if (preferencesList != null && preferencesList.size() > 0) {
				for (PreferenceListDTO preferenceList : preferencesList) {
					responseDTO.preference.add(preferenceList);
					responseDTO.responseCode = SUCCES_CODE;
					responseDTO.responseMessage = SUCCES_MESSAGE;
				}
			} else {
				responseDTO.responseCode = FAILED_CODE;
				responseDTO.responseMessage = FAILED_MESSAGE;
			}
		}

		return responseDTO;

	}

	@SuppressWarnings("unchecked")
	public CreatePreferenceResponseDTO fetchPreferencebyEpid(PreferenceDTO dto) {

		Preference preference = buildPreference(dto, "fetchPreferencebyEpid");

		preferecneDao.savePreference(preference);

		CreatePreferenceResponseDTO responseDTO = new CreatePreferenceResponseDTO();

		List<PreferenceListDTO> preferencesList = epipeService
				.fetchPreferencebyEpid(preference);

		if (!validRequest(preference.getEpid())) {
			responseDTO.responseCode = FAILED_CODE;
			responseDTO.responseMessage = FAILED_MESSAGE;
		} else {
			responseDTO.preference = new ArrayList<PreferenceListDTO>();
			if (preferencesList != null && preferencesList.size() > 0) {
				for (PreferenceListDTO preferenceList : preferencesList) {
					responseDTO.preference.add(preferenceList);
					responseDTO.responseCode = SUCCES_CODE;
					responseDTO.responseMessage = SUCCES_MESSAGE;
				}
			} else {
				responseDTO.responseCode = FAILED_CODE;
				responseDTO.responseMessage = FAILED_MESSAGE;
			}
		}

		return responseDTO;

	}
	
	public boolean insertSweeps(String sepId, String slpId, String firstName,
			String lastName, String address1, String address2, String city,
			String state, String postalCode, String country, String phone,
			String email) {
		
			return epipeService.insertSweeps(sepId, slpId, firstName, lastName,
					address1, address2, city, state, postalCode, country, phone,
					email);
		
	}
	
    public String getEpid(String emailAddress) {
    	return epipeService.getEpid(emailAddress);
    }
	
	public String getSmartMarketingByEmail(String emailAddress) {
		return epipeService.getSmartMarketingByEmail(emailAddress); 
	}
	
	public String getSmartMarketingByEpid(String epid) {
		return epipeService.getSmartMarketingByEpid(epid); 
	}

	public String getEpidByLegacyEpid(String epid) {
		return epipeService.getEpidByLegacyEpid(epid); 
	}
	
	
	private boolean validRequest(String... requiredFields) {
		boolean requestFlag = false;

		for (String rField : requiredFields) {
			if (rField != null && !"".equals(rField.trim())) {
				requestFlag = true;
			} else {
				requestFlag = false;
				break;
			}
		}

		return requestFlag;
	}

	public String checkAppStatus() {

		String result = "Preference ervice is alive";
		return result;

	}

	private Preference buildPreference(PreferenceDTO dto, String serviceMethod) {

		Preference preference = new PreferenceBuilder().buildDomain(dto,
				serviceMethod);
		preference.setCreatedOn(new Date());
		preference.setUpdatedOn(new Date());

		return preference;
	}

}
