package com.readersdigest.preference.builder;

import com.readersdigest.preference.domain.Preference;
import com.readersdigest.preference.dto.PreferenceDTO;

/**
 * @author shsingh
 *
 */

public class PreferenceBuilder {

	public Preference buildDomain(PreferenceDTO dto, String serviceMethod) {

		if (dto == null)
			return null;

		Preference domain = new Preference();
		domain.setId(dto.id);

		domain.setFirstName(dto.firstName);
		domain.setMiddleName(dto.middleName);
		domain.setLastName(dto.lastName);
		domain.setEmail(dto.email);
		domain.setSourceId(dto.sourceId);
		domain.setPreferenceId(dto.preferenceId);
		domain.setTrackingId(dto.trackingId);
		domain.setOptIn(dto.optIn);
		domain.setDateOfBirth(dto.dateOfBirth);
		domain.setEpid(dto.epid);
		domain.setServiceMethod(serviceMethod);
		domain.setBillingAddress(new AddressBuilder()
				.buildDomain(dto.billingAddress));
		return domain;

	}

}
