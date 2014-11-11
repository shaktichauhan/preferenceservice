package com.readersdigest.preference.builder;

import com.readersdigest.preference.dto.AddressDTO;
import com.readersdigest.preference.domain.Address;

/**
 * @author shsingh
 *
 */

public class AddressBuilder {

	public Address buildDomain(AddressDTO dto) {

		if (dto == null)
			return null;

		Address domain = new Address();

		domain.setId(dto.id);
		domain.setAddress1(dto.address1);
		domain.setAddress2(dto.address2);
		domain.setAddress3(dto.address3);
		domain.setCity(dto.city);
		domain.setPostalCode(dto.postalCode);
		domain.setCountryCode(dto.countryCode);
		domain.setVersion(dto.version);

		return domain;

	}

}
