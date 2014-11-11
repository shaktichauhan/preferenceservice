/**
*
* Reader's Digest Digital Business Group
*
* Copyright 2003 Reader's Digest, Inc. All Rights Reserved.
*
* This software is the proprietary information of Reader's Digest, Inc.
* Use is subject to license terms.
*
* Created by: Shakti Singh
* Date: 14-Nov-2012
*
*/
package com.readersdigest.onepass.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
* @author Shakti Singh
* @version 1.0
*/
public class DESEncrypter {
   Cipher ecipher;
   Cipher dcipher;

   // 8-byte Salt
   byte[] salt = {
       (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
       (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
   };

   // Iteration count
   int iterationCount = 19;

   public DESEncrypter(String passPhrase) {
       try {
           // Create the key
           KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
           SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
           ecipher = Cipher.getInstance(key.getAlgorithm());
           dcipher = Cipher.getInstance(key.getAlgorithm());

           // Prepare the parameter to the ciphers
           AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);

           // Create the ciphers
           ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
           dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
       } catch (java.security.InvalidAlgorithmParameterException e) {
       } catch (java.security.spec.InvalidKeySpecException e) {
       } catch (javax.crypto.NoSuchPaddingException e) {
       } catch (java.security.NoSuchAlgorithmException e) {
       } catch (java.security.InvalidKeyException e) {
       }
   }

   public String encrypt(String str) {
       try {
           // Encode the string into bytes using utf-8
           byte[] utf8 = str.getBytes("UTF8");

           // Encrypt
           byte[] enc = ecipher.doFinal(utf8);

           // Encode bytes to base64 to get a string
           return new sun.misc.BASE64Encoder().encode(enc);
           
       } catch (javax.crypto.BadPaddingException e) {
       } catch (IllegalBlockSizeException e) {
       } catch (UnsupportedEncodingException e) {
       }
       return null;
   }

   public String decrypt(String str) {
       try {
           // Decode base64 to get bytes
           //str = URLDecoder.decode(str);
           byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

           // Decrypt
           byte[] utf8 = dcipher.doFinal(dec);

           // Decode using utf-8
           return new String(utf8, "UTF8");
       } catch (javax.crypto.BadPaddingException e) {
           e.printStackTrace();
       } catch (IllegalBlockSizeException e) {
           e.printStackTrace();
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       } catch (java.io.IOException e) {
           e.printStackTrace();
       }
       return null;
   }
   
   public static void main(String a[]) {
       String email = "71dd@dsds.co";
       DESEncrypter desEncrypt = new DESEncrypter("onepass");
       String enc = desEncrypt.encrypt(email);
       System.out.println(enc);
       System.out.println(desEncrypt.decrypt(enc));
   }
   
   
}

