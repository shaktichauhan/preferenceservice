
package com.readersdigest.onepass.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;

/**
 * The Class StringUtils.
 * 
 * @author shsingh
 * 
 *         StringUtils is the utility class that contains various methods to get the properties file value
 */
public final class StringUtils {

    public static Map<String, String> prodKeyMap = new HashMap<String, String>();
    public static Map<String, String> prodKindleKeyMap = new HashMap<String, String>();
    public static Map<String, String> prodKeyMapBySource = new HashMap<String, String>();

    public static Map<String, String> rdSuperAccountNumberMap = new HashMap<String, String>();
    public static Map<String, String> rdSuperZipCodeMap = new HashMap<String, String>();

    public static Set<String> iPadSource = new HashSet<String>();

    public static Set<String> pmDBPublication = new HashSet<String>();
    
    public static Map<String, String> sourceNameKeyMap = new HashMap<String, String>();
    
    public static Map<String, String> sourceNameProbAbbr = new HashMap<String, String>();
    
    public static Map<String, String> brandNameSourceIdMap = new HashMap<String, String>();
    
    public static Map<String, String> etsubscriptionIdMap = new HashMap<String, String>();


    static {
        prodKeyMap.put("com.rd.readersdigest", "RDO");
        prodKeyMap.put("com.rd.readersdigest.samsung", "RDO");
        prodKeyMap.put("com.rd.familyhandyman", "FHO");
        prodKeyMap.put("com.rd.toh", "TOO");
        prodKeyMap.put("com.rd.birdsandblooms", "BNO");

        prodKindleKeyMap.put("com.readersdigest.usrd", "RDO");
        prodKindleKeyMap.put("com.amazon.usrd", "RDO");

        prodKeyMapBySource.put("769", "RDO");
        prodKeyMapBySource.put("1027", "RDO");
        prodKeyMapBySource.put("770", "RDO");
        prodKeyMapBySource.put("852", "TOO");
        prodKeyMapBySource.put("853", "TOO");
        prodKeyMapBySource.put("913", "FHO");
        prodKeyMapBySource.put("914", "FHO");
        prodKeyMapBySource.put("967", "TUMMY");

        iPadSource.add("769");
        iPadSource.add("852");
        iPadSource.add("913");

        // Add the prod if for P&M DB update publication
        pmDBPublication.add("TOO");
        pmDBPublication.add("FHO");

        rdSuperAccountNumberMap.put("RDO", "813283454");
        rdSuperAccountNumberMap.put("TOO", "797968773");
        rdSuperAccountNumberMap.put("FHO", "103949624");
        rdSuperAccountNumberMap.put("BNO", "797968773");

        rdSuperZipCodeMap.put("RDO", "10601");
        rdSuperZipCodeMap.put("TOO", "10601");
        rdSuperZipCodeMap.put("FHO", "10601");
        rdSuperZipCodeMap.put("BNO", "10601");
        
        sourceNameKeyMap.put("769", "RD from OnePass");
        sourceNameKeyMap.put("1027", "RD from OnePass");
        sourceNameKeyMap.put("770", "RD from OnePass");
        sourceNameKeyMap.put("852", "TOH from OnePass");
        sourceNameKeyMap.put("853", "TOH from OnePass");
        sourceNameKeyMap.put("913", "TFH from OnePass");
        sourceNameKeyMap.put("914", "TFH from OnePass");
        sourceNameKeyMap.put("967", "RD from OnePass");
                
        sourceNameProbAbbr.put("RDO", "RD from OnePass");
        sourceNameProbAbbr.put("TOO", "TOH from OnePass");
        sourceNameProbAbbr.put("FHO", "TFH from OnePass");
        sourceNameProbAbbr.put("BNO", "BNB from OnePass");
        
        brandNameSourceIdMap.put("769", "Reader's Digest");
        brandNameSourceIdMap.put("1027", "Reader's Digest");
        brandNameSourceIdMap.put("770", "Reader's Digest");
        brandNameSourceIdMap.put("852", "Taste of Home");
        brandNameSourceIdMap.put("853", "Taste of Home");
        brandNameSourceIdMap.put("913", "Family Handyman");
        brandNameSourceIdMap.put("914", "Family Handyman");
        brandNameSourceIdMap.put("967", "Reader's Digest");
        brandNameSourceIdMap.put("1000", "Reader's Digest");
               
        etsubscriptionIdMap.put("20", "10");
        etsubscriptionIdMap.put("30", "11");
        etsubscriptionIdMap.put("4", "48");
        etsubscriptionIdMap.put("5", "49");
        etsubscriptionIdMap.put("10125", "9");
       
    }

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
     * Gets the rd super zip code.
     * 
     * @param key
     *            the key
     * @return the rd super zip code
     */
    public static String getBrandName(String sourceId) {
        return brandNameSourceIdMap.get(sourceId);
    }
    
    /**
     * Gets the rd super zip code.
     * 
     * @param key
     *            the key
     * @return the rd super zip code
     */
    public static String getETSubscriptionId(String preferenceId) {
        return etsubscriptionIdMap.get(preferenceId);
    }
    
    /**
     * Gets the rd super zip code.
     * 
     * @param key
     *            the key
     * @return the rd super zip code
     */
    public static String getSourceName(String sourceId) {
        return sourceNameKeyMap.get(sourceId);
    }
    
    /**
     * Gets the rd super zip code.
     * 
     * @param key
     *            the key
     * @return the rd super zip code
     */
    public static String getSourceNameByProdabbr(String prodAbbr) {
        return sourceNameProbAbbr.get(prodAbbr);
    }

    /**
     * Gets the rd super account number.
     * 
     * @param key
     *            the key
     * @return the rd super account number
     */
    public static String getRdSuperAccountNumber(String key) {
        return rdSuperAccountNumberMap.get(key);
    }

    /**
     * Gets the rd super zip code.
     * 
     * @param key
     *            the key
     * @return the rd super zip code
     */
    public static String getRdSuperZipCode(String key) {
        return rdSuperZipCodeMap.get(key);
    }

    /**
     * Gets the prod id.
     * 
     * @param key
     *            the key
     * @return the prod id
     */
    public static String getProdId(String key) {
        return prodKeyMap.get(key);
    }

    /**
     * Gets the kindle prod id.
     * 
     * @param key
     *            the key
     * @return the kindle prod id
     */
    public static String getKindleProdId(String key) {
        return prodKindleKeyMap.get(key);
    }

    /**
     * Gets the source id.
     * 
     * @param key
     *            the key
     * @return the prod id
     */
    public static String getProdIdBySource(String key) {
        return prodKeyMapBySource.get(key);
    }

    public static boolean isIpadDevice(String key) {

        if (iPadSource.contains(key)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPmDBPublication(String key) {

        if (pmDBPublication.contains(key)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean isETApisCall() {
    	return ("true".equalsIgnoreCase(getBundleStringValue("isETApisCall")));
    }
    
    
    public static boolean isPreAndETUpdate() {
    	return ("true".equalsIgnoreCase(getBundleStringValue("preandetupdate")));
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
        return getBundleProperty("com.readersdigest.onepass.ApplicationResources", key, locale);
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
        String bundleName = "com.readersdigest.onepass.ApplicationResources";
        try {
            value = ResourceBundle.getBundle(bundleName).getString(key);
        } catch (Exception ex3) {
            ex3.printStackTrace();
        }
        return value;
    }

    public static WSGResponse getCustomerInfo(String appId, String emailAddress) {
        WSGResponse wsgr = null;
        WSG wsg = null;

        String prodAbbr = getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = getKindleProdId(appId); // Getting the APP Id for Kindle
            wsg = new WSG(getBundleStringValue("cdsKindleAppId"), getBundleStringValue("cdsKindlePassword"), prodAbbr);
        } else {
            wsg = new WSG(getBundleStringValue("cdsIpadAppId"), getBundleStringValue("cdsIpadPassword"), prodAbbr);
        }
        wsgr = wsg.lookupCustomer(emailAddress);
        return wsgr;

    }

    public static String getBundleStringValue(String key) {
        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
    }
    

}
