package com.readersdigest.onepass.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *Encryptor is used to get Encrypted text with the encryptionAlgorithm provided.
 *It uses MessageDigest in the JDK hence supports all the encryption algorithms
 *supported by JDK.
 *
 *This is one way encryption. To match with the clear text you can call the encrypt method once more and match the values or use
 *isClearStringMatchingWithEncryptedString method
 *
 *Other encryption Algorithms: MD5 : 128 bit SHA-1 : 160 bit SHA-256 : 256 bit SHA-384 : 384 bit SHA-512 : 512 bit 
 *[Size and Time will be more for higher
 *encryption algorithm]
 *
 *@author shsingh
 *@version 1.0
 *@since August 15, 2012
 *
 *
 */
public class OneWayEncrypter {

    /**
     * encryptString: Takes input of clear text String and returns encrypted string with MD5 encryption algorithm.
     *
     * @param stringToEncrypt the string to encrypt
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */

    public static String encryptString(final String stringToEncrypt) throws NoSuchAlgorithmException {
        return OneWayEncrypter.encryptString(stringToEncrypt, "MD5");
    }

    /**
     * encryptString: Takes input of clear text String and Encryption Algorithm. And return the encrypted String
     *
     * @param stringToEncrypt the string to encrypt
     * @param encryptionAlgorithm the encryption algorithm
     * @return String Encrypted String
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static String encryptString(final String stringToEncrypt, final String encryptionAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest md = null;
        md = MessageDigest.getInstance(encryptionAlgorithm);
        md.update(stringToEncrypt.getBytes());
        byte[] rawEncryptedBytes = md.digest();
        return OneWayEncrypter.getHexString(rawEncryptedBytes);
    }

    /**
     * isClearStringMatchingWithEncryptedString: Returns true if the clear Text and the encrypted string match.
     *
     * @param clearText the clear text
     * @param encryptedString the encrypted string
     * @param encryptionAlgorithm the encryption algorithm
     * @return boolean True if match else false
     */
    public static boolean isClearStringMatchingWithEncryptedString(final String clearText, final String encryptedString, final String encryptionAlgorithm) {

        boolean stringsMatch = false;

        try {
            if (encryptedString.equals(OneWayEncrypter.encryptString(clearText, encryptionAlgorithm))) {
                stringsMatch = true;
            }
        } catch (Exception e) {
            stringsMatch = false;
        }

        return stringsMatch;
    }

    /**
     * Calls isClearStringMatchingWithEncryptedString with MD5 encryption Algorithm.
     *
     * @param clearText the clear text
     * @param encryptedString the encrypted string
     * @return true, if is clear string matching with encrypted string
     */

    public static boolean isClearStringMatchingWithEncryptedString(final String clearText, final String encryptedString) {
        return OneWayEncrypter.isClearStringMatchingWithEncryptedString(clearText, encryptedString, "MD5");
    }

    /**
     * getHexString: replaces special characters with 0 to make the encrypted text database safe.
     *
     * @param rawBytes the raw bytes
     * @return the hex string
     */
    private static String getHexString(final byte rawBytes[]) {
        StringBuffer stringbuffer = new StringBuffer(rawBytes.length *2);
        for (int i = 0; i < rawBytes.length; i++) {
            if ((rawBytes[i] & 0xff) < 16)
                stringbuffer.append("0");
            stringbuffer.append(Integer.toHexString(rawBytes[i] & 0xff));
        }
        return stringbuffer.toString();
    }

    
}
