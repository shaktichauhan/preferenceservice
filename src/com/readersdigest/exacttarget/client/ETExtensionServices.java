package com.readersdigest.exacttarget.client;

/**
 * @author shsingh
 *
 */

import com.readersdigest.exacttarget.dto.DigitalOrderWithSubscriptionProfile;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.GetSubscriptionPreferencesRequest;
import com.readersdigest.exacttarget.dto.GetUserRoleRequest;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.exacttarget.dto.TriggeredSendMail;
import com.readersdigest.exacttarget.dto.UserRole;


/**
 * The Interface ETExtensionServices.
 */
public interface ETExtensionServices {

	/**
	 * Adds the digital order with sub profile.
	 *
	 * @param applicationName the application name
	 * @param digitalOrderWithSubscriptionProfile the digital order with subscription profile
	 * @return the eT response
	 */
	public ETResponse addDigitalOrderWithSubProfile(String applicationName, DigitalOrderWithSubscriptionProfile digitalOrderWithSubscriptionProfile);
	
	/**
	 * Adds the update digital profile.
	 *
	 * @param applicationName the application name
	 * @param digitalProfile the digital profile
	 * @return the eT response
	 */
	public ETResponse addUpdateDigitalProfile(String applicationName, DigitalProfile digitalProfile);
	
	/**
	 * Adds the update digital profile with subscriptions.
	 *
	 * @param applicationName the application name
	 * @param digitalProfileWithSubscription the digital profile with subscription
	 * @return the eT response
	 */
	public ETResponse addUpdateDigitalProfileWithSubscriptions(String applicationName, DigitalProfileWithSubscription digitalProfileWithSubscription);
	
	/**
	 * Adds the update subscription preferences.
	 *
	 * @param applicationName the application name
	 * @param subscriptionPreferences the subscription preferences
	 * @return the eT response
	 */
	public ETResponse addUpdateSubscriptionPreferences(String applicationName, SubscriptionPreferences subscriptionPreferences);
	
	/**
	 * Adds the update user roles.
	 *
	 * @param applicationName the application name
	 * @param userRole the user role
	 * @return the eT response
	 */
	public ETResponse addUpdateUserRoles(String applicationName, UserRole userRole);
	
	/**
	 * Gets the digital profile.
	 *
	 * @param applicationName the application name
	 * @param emailAddress the email address
	 * @return the digital profile
	 */
	public ETResponse getDigitalProfile(String applicationName, String emailAddress);
	
	/**
	 * Gets the basic profile by email hash.
	 *
	 * @param applicationName the application name
	 * @param hashedEmail the hashed email
	 * @return the basic profile by email hash
	 */
	public ETResponse getBasicProfileByEmailHash(String applicationName, String hashedEmail);
	
	/**
	 * Gets the subscription preferences.
	 *
	 * @param applicationName the application name
	 * @param subscriptionPreferences the subscription preferences
	 * @return the subscription preferences
	 */
	public ETResponse getSubscriptionPreferences(String applicationName, GetSubscriptionPreferencesRequest subscriptionPreferences);
	
	/**
	 * Gets the user roles.
	 *
	 * @param applicationName the application name
	 * @param userRoleRequest the user role request
	 * @return the user roles
	 */
	public ETResponse getUserRoles(String applicationName, GetUserRoleRequest userRoleRequest);
	
	/**
	 * Gets the most recent digital order.
	 *
	 * @param applicationName the application name
	 * @param emailAddress the email address
	 * @return the most recent digital order
	 */
	public ETResponse getMostRecentDigitalOrder(String applicationName, String emailAddress);
	
	/**
	 * Send triggered mail.
	 *
	 * @param applicationName the application name
	 * @param triggeredEmail the triggered email
	 * @return the eT response
	 */
	public ETResponse sendTriggeredMail(String applicationName, TriggeredSendMail triggeredEmail);
	
}
