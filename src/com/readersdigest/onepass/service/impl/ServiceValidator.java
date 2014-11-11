package com.readersdigest.onepass.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.GenericValidator;

import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IMemberPWDResetDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberPWDReset;
import com.readersdigest.onepass.db.MemberPWDResetDAO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassServiceRequest;
import com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassUserLoginDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceValidator.
 * 
 * @author shsingh
 * 
 *         ServiceValidator is used to validate the request body from client.
 */
public class ServiceValidator {

	/** The Constant STATE_CODE_LENGTH. */
	private static final int STATE_CODE_LENGTH = 7;

	/** The Constant COUNTRY_CODE_LENGTH. */
	private static final int COUNTRY_CODE_LENGTH = 2;

	/** The zip code. */
	private String zipCode;

	/** The name. */
	private String name;

	/** The Constant EXPIRATION_TIME. */
	public static final String EXPIRATION_TIME = StringUtils.getBundleProperty(
			"com.readersdigest.onepass.OnePassResources",
			"passwordResetExpiration");

	/**
	 * Unique email validation.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @param sourceId
	 *            the source id
	 */
	public final void uniqueEmailValidation(final String emailAddress,
			String sourceId) {

		IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();

		String prodAbbr = StringUtils.getProdIdBySource(sourceId);

		List<MemberOnePassInfo> memberOnePassInfoList = null;
		memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
				"emailAddress", "prodId", "active", emailAddress, prodAbbr,
				OnePassServiceImpl.ACTIVE_MEMBER);

		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			throw new ServiceException(
					StringUtils.getBundleProperty("emailAddress.exist"));
		}

	}

	/**
	 * Check email validation.
	 *
	 * @param emailAddress the email address
	 * @param prodAbbr the prod abbr
	 * @return the list
	 */
	public final List<MemberOnePassInfo> checkEmailValidation(
			String[] emailAddress, String prodAbbr) {

		IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();

		List<MemberOnePassInfo> memberOnePassInfoList = null;
		memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
				"emailAddress", "prodId", "active", emailAddress, prodAbbr,
				OnePassServiceImpl.ACTIVE_MEMBER);

		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			return memberOnePassInfoList;
		}
		return null;
	}

	/**
	 * Unique email validation.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @param sourceId
	 *            the source id
	 * @return true, if successful
	 */
	public final boolean uniqueCDSEmailValidation(final String emailAddress,
			String sourceId) {
		
		IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();

		String prodAbbr = StringUtils.getProdIdBySource(sourceId);
	
		List<MemberOnePassInfo> memberOnePassInfoList = null;
		memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
				"emailAddress", "prodId", "active", emailAddress, prodAbbr,
				OnePassServiceImpl.ACTIVE_MEMBER);

		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			MemberOnePassInfo newMemberOnePassInfo = memberOnePassInfoList
					.get(0);
			if (newMemberOnePassInfo.getAccountNumber() != null
					&& !"".equals(newMemberOnePassInfo.getAccountNumber()
							.trim())) {
				throw new ServiceException(
						StringUtils.getBundleProperty("emailAddress.exist"));
			}
		}

		return true;

	}

	public final boolean uniqueAdvocateEmailValidation(
			final String emailAddress, String prodAbbr) {

		IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();

		List<MemberOnePassInfo> memberOnePassInfoList = null;
		memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
				"emailAddress", "prodId", "active", emailAddress, prodAbbr,
				OnePassServiceImpl.ACTIVE_MEMBER);

		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			throw new ServiceException(
					StringUtils.getBundleProperty("emailAddress.exist"));

		}

		return true;

	}
	/**
	 * Unique email validation.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @param accountNumber
	 *            the account number
	 * @param sourceId
	 *            the source id
	 */
	public final void uniqueEmailValidation(String emailAddress,
			String accountNumber, String sourceId) {
		IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();
		String prodAbbr = StringUtils.getProdIdBySource(sourceId);
		List<MemberOnePassInfo> memberOnePassInfoList = null;

		if (accountNumber != null && !"".equals(accountNumber)) {
			for (int i = accountNumber.length(); i < 10; i++) {
				accountNumber = "0" + accountNumber;
			}
			memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
					"emailAddress", "prodId", "accountNumber", "active",
					emailAddress, prodAbbr, accountNumber,
					OnePassServiceImpl.ACTIVE_MEMBER);
		} else {
			memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
					"emailAddress", "prodId", "active", emailAddress, prodAbbr,
					OnePassServiceImpl.ACTIVE_MEMBER);
		}

		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			throw new ServiceException(
					StringUtils.getBundleProperty("emailAddress.exist"));
		}
	}

	/**
	 * Valid service.
	 * 
	 * @param dto
	 *            the dto
	 * @return true, if successful
	 */
	public final boolean validService(final CreateOnePassUserProfileDTO dto) {

		String addressToggle = StringUtils.getBundleProperty(
				"com.readersdigest.onepass.OnePassResources", "addressToggle");

		validateRequired(dto.emailFields.emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		validateRequired(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.required"));
		validateRequired(dto.emailFields.password,
				StringUtils.getBundleProperty("password.required"));
		validEmailAddress(dto.emailFields.emailAddress, "emailAddress.valid");
		validPassword(dto.emailFields.password);

		validateRequired(dto.addressFields.firstName,
				StringUtils.getBundleProperty("customerName.required"));
		// validateRequired(dto.addressFields.lastName,
		// StringUtils.getBundleProperty("lastName.required"));
		if (!"true".equalsIgnoreCase(addressToggle)) {
			validateRequired(dto.addressFields.city,
					StringUtils.getBundleProperty("city.required"));
			validateRequired(dto.addressFields.countryCode,
					StringUtils.getBundleProperty("countryCode.required"));
			validateRequired(dto.addressFields.stateCode,
					StringUtils.getBundleProperty("state.required"));
			validateRequired(dto.addressFields.address1,
					StringUtils.getBundleProperty("address.required"));
			validateRequired(dto.addressFields.zip,
					StringUtils.getBundleProperty("zip.required"));
			validStateCode(dto.addressFields.stateCode);
			validCountryCode(dto.addressFields.countryCode);
			validateInteger(dto.accountFields.sourceId,
					StringUtils.getBundleProperty("sourceId.valid"));
			validateString(dto.addressFields.city,
					StringUtils.getBundleProperty("city.valid"));
			validateSpecialChar(dto.addressFields.zip,
					StringUtils.getBundleProperty("zip.valid"));
		}

		if (!dto.emailFields.password
				.equalsIgnoreCase(dto.emailFields.confirmPassword)) {
			throw new ServiceException(
					StringUtils.getBundleProperty("password.notMatch"));
		}

		if (dto.emailFields.accountNumber != null
				&& !"".equalsIgnoreCase(dto.emailFields.accountNumber.trim())) {
			validateAccountNumber(dto.emailFields.accountNumber,
					dto.emailFields.emailAddress.trim(),
					dto.accountFields.sourceId);
		}

		uniqueEmailValidation(dto.emailFields.emailAddress,
				dto.emailFields.accountNumber, dto.accountFields.sourceId);

		return true;
	}

	/**
	 * Validate account number.
	 * 
	 * @param strAccountNumber
	 *            the str account number
	 * @param emailAddress
	 *            the email address
	 * @param sourceId
	 *            the source id
	 * @return true, if successful
	 */
	public final boolean validateAccountNumber(String strAccountNumber,
			String emailAddress, String sourceId) {
		try {

			System.out.println("\n\n\n ******** account Number "
					+ strAccountNumber);

			int accountLength = strAccountNumber.length();
			for (int i = accountLength; i < 10; i++) {
				strAccountNumber = "0" + strAccountNumber;
			}

			String prodAbbr = StringUtils.getProdIdBySource(sourceId);

			// IMemberInfoDAO memberInfoDAO = new MemberInfoDAO();
			IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();

			if (memberOnePassInfoDAO.findByProperties("accountNumber",
					"prodId", "active", strAccountNumber, prodAbbr,
					OnePassServiceImpl.ACTIVE_MEMBER).size() > 0) {
				throw new ServiceException(
						StringUtils
								.getBundleProperty("accountNumber.isRegistered"));
			}

			return true;

		} catch (NumberFormatException ex) {
			throw new ServiceException(
					StringUtils.getBundleProperty("accountNumber.notValid"));
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage());
		}
	}

	/**
	 * Valid validTummyService.
	 * 
	 * @param dto
	 *            the dto
	 * @return true, if successful
	 */
	public final boolean validTummyService(OnePassTummyUserProfileDTO dto) {
		validateRequired(dto.emailFields.emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		validEmailAddress(dto.emailFields.emailAddress, "emailAddress.valid");
		validateRequired(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.required"));
		validateInteger(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.valid"));
		return true;
	}

	/**
	 * Valid login service.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @return true, if successful
	 */
	public final boolean validEmail(String emailAddress) {
		validateRequired(emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		validEmailAddress(emailAddress, "emailAddress.valid");
		return true;
	}

	/**
	 * Valid Minimal Registration service.
	 * 
	 * @param dto
	 *            the dto
	 * @return true, if successful
	 */
	public final boolean validMinimalRegistrationService(
			final CreateOnePassUserProfileDTO dto) {

		validateRequired(dto.emailFields.emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		validateRequired(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.required"));
		validateRequired(dto.emailFields.password,
				StringUtils.getBundleProperty("password.required"));
		validEmailAddress(dto.emailFields.emailAddress, "emailAddress.valid");
		validPassword(dto.emailFields.password);
		validateInteger(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.valid"));

		uniqueEmailValidation(dto.emailFields.emailAddress,
				dto.accountFields.sourceId);

		return true;
	}

	/**
	 * Valid login service.
	 * 
	 * @param dto
	 *            the dto
	 * @return true, if successful
	 */
	public final boolean validLoginService(final OnePassUserLoginDTO dto) {

		validateRequired(dto.emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		validateRequired(dto.password,
				StringUtils.getBundleProperty("password.required"));
		validEmailAddress(dto.emailAddress, "emailAddress.valid");
		return true;
	}

	/**
	 * Valid update service.
	 * 
	 * @param dto
	 *            the dto
	 * @return true, if successful
	 */
	public final boolean validUpdateService(
			final UpdateOnePassUserProfileDTO dto) {

		String addressToggle = StringUtils.getBundleProperty(
				"com.readersdigest.onepass.OnePassResources", "addressToggle");

		validateRequired(dto.header.emailAddress,
				StringUtils.getBundleProperty("emailAddress.required"));
		// validateRequired(dto.header.token,
		// StringUtils.getBundleProperty("token.required"));

		validateRequired(dto.addressFields.firstName,
				StringUtils.getBundleProperty("customerName.required"));
		// validateRequired(dto.addressFields.lastName,
		// StringUtils.getBundleProperty("lastName.required"));
		if (!"true".equalsIgnoreCase(addressToggle)) {
			validateRequired(dto.addressFields.city,
					StringUtils.getBundleProperty("city.required"));
			validateRequired(dto.addressFields.countryCode,
					StringUtils.getBundleProperty("countryCode.required"));
			validateRequired(dto.addressFields.stateCode,
					StringUtils.getBundleProperty("state.required"));
			validateRequired(dto.addressFields.address1,
					StringUtils.getBundleProperty("address.required"));
			validateRequired(dto.addressFields.zip,
					StringUtils.getBundleProperty("zip.required"));
			validStateCode(dto.addressFields.stateCode);
			validCountryCode(dto.addressFields.countryCode);
			validateString(dto.addressFields.city,
					StringUtils.getBundleProperty("city.valid"));
			validateSpecialChar(dto.addressFields.zip,
					StringUtils.getBundleProperty("zip.valid"));

		}

		validateRequired(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.required"));
		validateInteger(dto.accountFields.sourceId,
				StringUtils.getBundleProperty("sourceId.valid"));

		if (dto.emailFields.newEmailAddress != null
				&& !"".equals(dto.emailFields.newEmailAddress.trim())) {
			validEmailAddress(dto.emailFields.newEmailAddress,
					"newEmailAddress.valid");
		}

		if (dto.emailFields.password != null
				&& !"".equals(dto.emailFields.password.trim())) {
			validPassword(dto.emailFields.password);
		}

		if (dto.emailFields.password != null
				&& !"".equals(dto.emailFields.password.trim())
				&& !dto.emailFields.password
						.equals(dto.emailFields.confirmPassword)) {
			throw new ServiceException(
					StringUtils.getBundleProperty("password.notMatch"));
		}

		return true;
	}

	/**
	 * Valid email address.
	 * 
	 * @param emailAddress
	 *            the email address
	 * @param message
	 *            the message
	 * @return true, if successful
	 */
	public final boolean validEmailAddress(final String emailAddress,
			String message) {
		if (GenericValidator.isEmail(emailAddress.trim())) {
			return true;
		} else {
			throw new ServiceException(StringUtils.getBundleProperty(message));
		}
	}

	/**
	 * Valid state code.
	 * 
	 * @param stateCode
	 *            the state code
	 * @return true, if successful
	 */
	public final boolean validStateCode(final String stateCode) {
		// 7 is the limit in subdivision table for state code
		if (stateCode.length() <= STATE_CODE_LENGTH) {
			return true;
		} else {
			throw new ServiceException(
					StringUtils.getBundleProperty("state.valid"));
		}
	}

	/**
	 * Valid country code.
	 * 
	 * @param countryCode
	 *            the country code
	 * @return true, if successful
	 */
	public final boolean validCountryCode(final String countryCode) {
		// 2 is the limit in country table for country code
		if (countryCode.length() == COUNTRY_CODE_LENGTH) {
			return true;
		} else {
			throw new ServiceException(
					StringUtils.getBundleProperty("country.valid"));
		}
	}

	/**
	 * Valid password.
	 * 
	 * @param password
	 *            the password
	 * @return true, if successful
	 */
	public final boolean validPassword(final String password) {
		// Passwords must be at least 6 characters in length.
		// Inclusion of one or more numerical digits and one alpha
		// Prohibition of words found in a dictionary (ex.: user's personal
		// information, like name or last name)

		String pattern = "((?=.*[0-9])(?=.*[a-zA-Z])(?=[\\S]+$).{6,50})";
		if (password.matches(pattern)) {
			if (password.charAt(0) == '?' || password.charAt(0) == '!') {
				throw new ServiceException(
						StringUtils.getBundleProperty("password.valid"));
			}
			return true;
		} else {
			throw new ServiceException(
					StringUtils.getBundleProperty("password.valid"));

		}

	}

	/**
	 * Validate integer.
	 * 
	 * @param key
	 *            the key
	 * @param message
	 *            the message
	 * @return the long
	 */
	public final long validateInteger(final String key, final String message) {
		try {
			long iKey = Long.parseLong(key);
			return iKey;
		} catch (NumberFormatException e) {
			throw new ServiceException(message);
		}

	}

	/**
	 * Validate String.
	 * 
	 * @param key
	 *            the key
	 * @param message
	 *            the message
	 * @return the long
	 */
	public final boolean validateString(final String key, final String message) {
		String pattern = "^[A-Za-z. '-]+$";
		if (key.matches(pattern)) {
			return true;
		} else {
			throw new ServiceException(message);
		}
	}

	/**
	 * Validate Special Characters.
	 * 
	 * @param key
	 *            the key
	 * @param message
	 *            the message
	 * @return the boolean
	 */
	public final boolean validateSpecialChar(final String key,
			final String message) {
		Pattern pattern = Pattern.compile("[/,:<>!~@#$%^&()+=?()\"|!\\[#$-]");
		Matcher patternMatcher = pattern.matcher(key);
		if (patternMatcher.find() == true) {
			throw new ServiceException(message);
		} else {
			return true;
		}

	}

	/**
	 * Validate required.
	 * 
	 * @param key
	 *            the key
	 * @param message
	 *            the message
	 */
	public final void validateRequired(final String key, final String message) {
		if (key == null || "".equalsIgnoreCase(key.trim())) {
			throw new ServiceException(message);
		}
	}

	/**
	 * Valid forget password token.
	 * 
	 * @param token
	 *            the token
	 * @return true, if successful
	 */
	public final boolean validForgetPasswordToken(String token) {

		IMemberPWDResetDAO memberPWDResetDAO = new MemberPWDResetDAO();
		MemberPWDReset memberPWDReset = memberPWDResetDAO.findByToken(token)
				.get(0);

		if (memberPWDReset == null) {
			throw new ServiceException(
					StringUtils.getBundleProperty("token.invalid"));
		}

		long expirationTime = EXPIRATION_TIME != null
				&& !"".equals(EXPIRATION_TIME.trim()) ? Long
				.parseLong(EXPIRATION_TIME) : 0;

		if (memberPWDReset.getCreateDate().getTime() + expirationTime < System
				.currentTimeMillis()) {
			throw new ServiceException(
					StringUtils.getBundleProperty("token.expired"));
		}

		return true;
	}

	/**
	 * Amazon cds validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonCDSValidation(
			OnePassServiceRequest onePassRequest) {

		if (onePassRequest.accountNumber == null
				&& "".equals(onePassRequest.accountNumber)) {
			validateRequired(onePassRequest.zipCode,
					"Required Parameters are missing in the request xml");
			validateRequired(onePassRequest.firstName,
					"Required Parameters are missing in the request xml");
			validateRequired(onePassRequest.lastName,
					"Required Parameters are missing in the request xml");
			validateRequired(onePassRequest.address1,
					"Required Parameters are missing in the request xml");
			validateRequired(onePassRequest.city,
					"Required Parameters are missing in the request xml");
		}

		return true;
	}

	/**
	 * Amazon registation validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonRegistationValidation(
			OnePassServiceRequest onePassRequest) {

		validateRequired(onePassRequest.accountNumber,
				"Required Parameters are missing in the request xml");
		validateRequired(onePassRequest.emailAddress,
				"Required Parameters are missing in the request xml");
		validateRequired(onePassRequest.password,
				"Required Parameters are missing in the request xml");
		return true;
	}

	/**
	 * Amazon subscription validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonSubscriptionValidation(
			OnePassServiceRequest onePassRequest) {

		validateRequired(onePassRequest.accountNumber,
				"Required Parameters are missing in the request xml");
		return true;
	}

	/**
	 * Amazon sign in validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonSignInValidation(
			OnePassServiceRequest onePassRequest) {

		validateRequired(onePassRequest.emailAddress,
				"Required Parameters are missing in the request xml");
		validateRequired(onePassRequest.password,
				"Required Parameters are missing in the request xml");
		return true;
	}

	/**
	 * Amazon forgot password validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonForgotPasswordValidation(
			OnePassServiceRequest onePassRequest) {

		validateRequired(onePassRequest.emailAddress,
				"Required Parameters are missing in the request xml");
		return true;
	}

	/**
	 * Amazon autherization validation.
	 * 
	 * @param onePassRequest
	 *            the one pass request
	 * @return true, if successful
	 */
	public final boolean amazonAutherizationValidation(
			OnePassServiceRequest onePassRequest) {

		String appId = StringUtils.getBundleProperty(
				"com.readersdigest.onepass.OnePassResources", "amazonAppId");

		if (onePassRequest.appId == null
				|| !appId.equalsIgnoreCase(onePassRequest.appId)) {
			return false;
		}
		System.out.println("\n\n\n **************** "
				+ onePassRequest.brandCode);
		System.out
				.println("\n\n\n **************** StringUtils.getSourceNameByProdabbr(onePassRequest.brandCode) "
						+ StringUtils
								.getSourceNameByProdabbr(onePassRequest.brandCode));
		if (onePassRequest.brandCode == null
				|| StringUtils
						.getSourceNameByProdabbr(onePassRequest.brandCode) == null) {
			return false;
		}

		return true;

	}

}
