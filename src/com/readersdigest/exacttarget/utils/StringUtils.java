
package com.readersdigest.exacttarget.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Class StringUtils.
 * 
 *  @author Shakti Chauhan - shakti_singh@consultant.rd.com
 * 
 *         StringUtils is the utility class that contains various methods to get the properties file value
 */
public final class StringUtils {

   
    /**
     * Checks for content.
     * 
     * @param s
     *            the s
     * @return true, if successful
     */
    public static boolean hasContent(final String s) {

        if (s == null) {
            return false;
        }

        if (s.trim().length() == 0) {
            return false;
        }

        return true;

    }
    
    
    
    /**
     * Gets the bundle property.
     * 
     * @param key
     *            the key
     * @param languageCode
     *            the language code
     * @param countryCode
     *            the country code
     * @return the bundle property
     */
    public static String getBundleProperty(final String key, final String languageCode, final String countryCode) {

        Locale locale = new Locale(languageCode, countryCode);
        return getBundleProperty(key, locale);

    }

    /**
     * Gets the bundle property.
     * 
     * @param key
     *            the key
     * @param locale
     *            the locale
     * @return the bundle property
     */
    public static String getBundleProperty(final String key, final Locale locale) {
        return getBundleProperty("com.readersdigest.sweepapi.ApplicationResources", key, locale);
    }

    /**
     * Gets the bundle property.
     * 
     * @param bundleName
     *            the bundle name
     * @param key
     *            the key
     * @param languageCode
     *            the language code
     * @param countryCode
     *            the country code
     * @return the bundle property
     */
    public static String getBundleProperty(final String bundleName, final String key, final String languageCode, final String countryCode) {

        Locale locale = new Locale(languageCode, countryCode);
        return getBundleProperty(bundleName, key, locale);
    }

    /**
     * Gets the bundle property.
     * 
     * @param bundleName
     *            the bundle name
     * @param key
     *            the key
     * @param locale
     *            the locale
     * @return the bundle property
     */
    public static String getBundleProperty(final String bundleName, final String key, final Locale locale) {

        ResourceBundle bundle = null;
        String value = null;

        try {
            bundle = ResourceBundle.getBundle(bundleName, locale);
            value = bundle.getString(key);
        } catch (Exception ex2) {
            try {
                value = ResourceBundle.getBundle(bundleName).getString(key);
            } catch (Exception ex3) {
                ex3.printStackTrace();
            }
        }

        return value;
    }

    /**
     * Gets the bundle property.
     * 
     * @param bundleName
     *            the bundle name
     * @param key
     *            the key
     * @return the bundle property
     */
    public static String getBundleProperty(final String bundleName, final String key) {

        String value = null;
        try {
            value = ResourceBundle.getBundle(bundleName).getString(key);
        } catch (Exception ex3) {
            ex3.printStackTrace();
        }
        return value;
    }

    /**
     * Gets the bundle property.
     * 
     * @param key
     *            the key
     * @return the bundle property
     */
    public static String getBundleProperty(final String key) {

        String value = null;
        String bundleName = "com.readersdigest.sweepapi.ApplicationResources";
        try {
            value = ResourceBundle.getBundle(bundleName).getString(key);
        } catch (Exception ex3) {
            ex3.printStackTrace();
        }
        return value;
    }

    
   
}
