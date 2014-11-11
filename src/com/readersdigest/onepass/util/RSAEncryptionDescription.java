package com.readersdigest.onepass.util;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.KeyTransRecipientInformation;
import org.bouncycastle.cms.RecipientId;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.RecipientInformationStore;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientId;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RSAEncryptionDescription {
     private static final String BC = "BC";
     
     private static final String PUBLIC_KEY_FILE = "/rdappls/sites/preferenceService/mycert.der";  
     private static final String PRIVATE_KEY_FILE = "/rdappls/sites/preferenceService/private-key.der";    
     
//     public static void main(String a[]) {
//    	 
//    	String encData  =encryptData("abc123");//"MIICJgYJKoZIhvcNAQcDoIICFzCCAhMCAQAxggHOMIIBygIBADCBsTCBozELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAk5ZMRUwEwYDVQQHEwxXaGl0ZSBQbGFpbnMxGDAWBgNVBAoTD1JlYWRlcidzIERpZ2VzdDENMAsGA1UECxMEUkRBaTEYMBYGA1UEAxMPc2VydmljZXMucmQuY29tMS0wKwYJKoZIhvcNAQkBFh5zaGFrdGlfc2luZ2hAY29uc3VsdGFudC5yZC5jb20CCQCVN8dOQ4aFfTANBgkqhkiG9w0BAQEFAASCAQAkRhbjOhv/KeHCfIVFCjpwjoUg0pZOUAVYq826fK1BUUto1rBM/lRh/pMDeAvK1HfzwV7Rx1soXa3qruxARjOHg4SLGbB1VYgsNoDeEWSdzl8HSN1Bzt3TEecAXpkL87SVxRNIpPFUOFj1D/Y+4iKEPtME8VhufyiSG5V3E/4S8FR/1c+pck7peKb+6BvTn1YvCrfkxNKmnhy08yRx+2UqFCs9U7So+6FWmM+mZUDJhtt0IVbWYC/+j94KZO2kQK+AhjUW/AA/ZZxVNuxOpt9AZWwT5LELE4MAEUZNAm+8zObp4LvlgP3iyw1QeG9vJyg54fkLgso6XRJ8v6XoiBJmMDwGCSqGSIb3DQEHATAdBglghkgBZQMEASoEENaRQX9L6K0pLjtX5O4Ll0KAEEABV+hVsmhETyjJuFkPLA0=";
//    	 //encryptData("xyz123"); //"a38fd6a12f19769ceb3462db6c5f1c50MIICJgYJKoZIhvcNAQcDoIICFzCCAhMCAQAxggHOMIIBygIBADCBsTCBozELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAk5ZMRUwEwYDVQQHEwxXaGl0ZSBQbGFpbnMxGDAWBgNVBAoTD1JlYWRlcidzIERpZ2VzdDENMAsGA1UECxMEUkRBaTEYMBYGA1UEAxMPc2VydmljZXMucmQuY29tMS0wKwYJKoZIhvcNAQkBFh5zaGFrdGlfc2luZ2hAY29uc3VsdGFudC5yZC5jb20CCQCVN8dOQ4aFfTANBgkqhkiG9w0BAQEFAASCAQA4P/Ll2RbL84OAEsvCA6GHcVcQhzeWwkPHy/vUtNpw860lydMpeg1LRzhoUhvB3Ds4wj3mDhpVU0e/giMgqkFprg+emMfL24bukGKNxgXD4cWqKu3h6ccZteyFMgQlhB54npcQoUZo+PV+qF/OGSz2OicJbJiIMq/I3QMGyna0cZrz5kxAcEtyPN2tUuzOPLfH36MT5znFcdvINAqdn4JP9AyXcDiZF3q8g+3n2HreQX2tGW+AUxdP5HbvCi9tt2QXn7epN6eSIOjtGfr3CnqOsK6Rc4OepjFWflzHykxomIx2dR8uTkdHqjcntlV0hEdoMmuGCDKcmm1tiHxNUIUaMDwGCSqGSIb3DQEHATAdBglghkgBZQMEASoEEOBzt6w1hG3gVgk/XE7m9HKAEH1/lgP0ABPU7D9BJx4nLpc=";
//    			//
//    	//"MIAGCSqGSIb3DQEHA6CAMIACAQAxggHOMIIBygIBADCBsTCBozELMAkGA1UEBhMCVVMxCzAJBgNVBAgTAk5ZMRUwEwYDVQQHEwxXaGl0ZSBQbGFpbnMxGDAWBgNVBAoTD1JlYWRlcidzIERpZ2VzdDENMAsGA1UECxMEUkRBaTEYMBYGA1UEAxMPc2VydmljZXMucmQuY29tMS0wKwYJKoZIhvcNAQkBFh5zaGFrdGlfc2luZ2hAY29uc3VsdGFudC5yZC5jb20CCQCVN8dOQ4aFfTANBgkqhkiG9w0BAQEFAASCAQCCa1xbEdMR7s2GFJUjwj+cgq3eIj3eatcGZsiPgP9IF1kpy9uouNA5zoxYuoFRtIUUbyn6ullxeVui9WtYjitBddwEsdcS3oRS8vdxi/jZ2Ctm9yUMuroNG/sUn5LYEtEr0gdemli/HFR2r0t5KaHQtrPucq2DrMH3n1p1gABk+3kGsjHMoHSiycPB4SlCh6Y6leGbvwGP5gUJrT2AjQApyxNn8UiP/p3A26b4H0+y9sQUzjDeIVfJR7ziCk9jHBx56xrVL4GY7x8KrQhZn2RL9OOa3QDZ/xtDkRuzsQg0v8i2GeesdzVJTeTTe0jTH+Fb2dR991xUn0nZBKPC+JDaMIAGCSqGSIb3DQEHATAdBglghkgBZQMEASoEEPYAHMpaIiTHdTLXeENnyJiggAQQNR23CH+9TUCr+X/jiZFJ5wAAAAAAAAAAAAA=";
//    	 		
//     	System.out.println("\n\n\n &&&& encrypt data " + encData);
//     	
//     	String decryptData = decryptData(encData);
//     	
//     	System.out.println("\n\n\n &&&& decrypt data " + decryptData);
//     }
     
     
     public static String encryptData(String value) {
    	 String encData = null;
    	 try{
    		 X509Certificate cert =  getCertificate(PUBLIC_KEY_FILE);
    		 encData = encrypt(value, cert);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    	 
    	 return encData;
     }
     
     public static byte[] cmsDecrypt(byte[] cipherbytes, PrivateKey pk) throws CMSException, IllegalStateException, IllegalArgumentException {
         final CMSEnvelopedData envData = new CMSEnvelopedData(cipherbytes);
         final String algOID = envData.getEncryptionAlgOID();
         final RecipientInformationStore recipients = envData.getRecipientInfos();
         final Collection<?> col = recipients.getRecipients();
         final Iterator<?> itr = col.iterator();
         final KeyTransRecipientInformation ktri = (KeyTransRecipientInformation) itr.next();
  
         if (!CMSEnvelopedDataGenerator.AES256_CBC.equalsIgnoreCase(algOID)
                 && !CMSEnvelopedDataGenerator.AES256_WRAP.equalsIgnoreCase(algOID)
                 && !CMSEnvelopedDataGenerator.AES128_CBC.equalsIgnoreCase(algOID)
                 && !CMSEnvelopedDataGenerator.AES128_WRAP.equalsIgnoreCase(algOID))
             throw new IllegalArgumentException("Only AES-128 or AES-256 cipher text is allowed");
  
         try {
             return ktri.getContent(pk, "BC");
         } catch (NoSuchProviderException e) {
             throw new IllegalStateException(e);
         }
     }
     
     public static String decryptData(String value) throws FileNotFoundException, NoSuchAlgorithmException,InvalidKeySpecException, IllegalStateException,
     InvalidAlgorithmParameterException, CMSException, CertificateEncodingException, IOException,IllegalArgumentException {
    	 
    	 Security.addProvider(new BouncyCastleProvider());
    	 
        	/*
 			 *  Read the payload data as an array of bytes
 			 */
            // FileInputStream fsin = new FileInputStream(inFileName);
             byte[] inDataRaw = IOUtils.toByteArray(value);
  
             String inText = new String(inDataRaw);
 			int blobEnd = inText.length();
  
             StringBuffer blob = new StringBuffer();
  
             /*
              * CMS Envelope is Base64 encoded to be transportable over HTTP.
              * Encryption strips away the newlines so we need to add them back
              * before we have a valid Base64 block. Line width is 64 chars.
              */
             for (int i = 0; i < blobEnd; i += 64) {
                 int span = 64 > blobEnd - i ? blobEnd - i : 64;
                 blob.append(inText.substring(i, i + span));
                 if (span == 64) {
                     blob.append('\n');
                 }
             }
  
             byte[] inData = blob.toString().getBytes();
             inData = org.bouncycastle.util.encoders.Base64.decode(inData); // Decode the data from Base64
  
             /*
              *  Prepare private key from PKCS#8 encoded file
              *  (supplied on the command line)
              */
             FileInputStream pkin = new FileInputStream(PRIVATE_KEY_FILE);
             byte[] keyData = IOUtils.toByteArray(pkin);
             PKCS8EncodedKeySpec pkspec = new PKCS8EncodedKeySpec(keyData);
             KeyFactory kf = KeyFactory.getInstance("RSA");
             PrivateKey pk = kf.generatePrivate(pkspec);
  
             /*
              * Finally call the cmsDecrypt method on the CocoonCryptoUtil
              * either with a byte array or a base64 encoded string to 
              * perform the actual decryption. CocoonCryptoUtil only contains
              * class methods so you don't need to instantiate it.
              */
  
             byte[] data = cmsDecrypt(inData, pk);
  
             /*
              * Preview the decrypted data
              */
             System.out.println("Result: ".concat(new String(data)));
             return new String(data);
         
     }

    /**
     *
     * @param data - byte array to encrypt
     * @param cert
     * @return base64 encoded envelope
     */
    public static String encrypt(String data, X509Certificate cert) throws InvalidAlgorithmParameterException, CMSException, CertificateEncodingException, IOException {
  	
    	Security.addProvider(new BouncyCastleProvider());
        final CMSEnvelopedDataGenerator envGen = new CMSEnvelopedDataGenerator();
        InputStream password = new ByteArrayInputStream(data.getBytes("UTF-8"));
        envGen.addRecipientInfoGenerator(new JceKeyTransRecipientInfoGenerator(cert).setProvider(BC));
        final CMSProcessableByteArray procbyteArray = new CMSProcessableByteArray(IOUtils.toByteArray(password));
        final CMSEnvelopedData envData = envGen.generate(procbyteArray,
                                                      new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC).setProvider("BC").build());
        String base64cryptoText = new String(Base64.encodeBase64(envData.getEncoded()));
        String base64nonewlines = base64cryptoText.replace("\r", "").replace("\n", "");
        return base64nonewlines;
        
    }

    /**
     *
     * @param encryptedEncodedData  - base64 encoded, encrypted data
     * @param privateKey - RSA private key to decrypt with
     * @param cert
     * @return  plaintext password
     * @throws CMSException
     */
    public static String decrypt(String encryptedEncodedData, PrivateKey privateKey, X509Certificate cert) throws CMSException {
        Security.addProvider(new BouncyCastleProvider());
        byte[] encryptedData = Base64.decodeBase64(encryptedEncodedData.getBytes());
        CMSEnvelopedData enveloped = new CMSEnvelopedData(encryptedData);
        RecipientId recId = new JceKeyTransRecipientId(cert);
        RecipientInformationStore recipients = enveloped.getRecipientInfos();
        RecipientInformation recipient = recipients.get(recId);
        byte[] recData = recipient.getContent(new JceKeyTransEnvelopedRecipient(privateKey).setProvider(BC));
        return new String(recData);
    }
    
    public static X509Certificate getCertificate(String fileName) {
    	InputStream inStream = null;
    	 try {
    	     inStream = new FileInputStream(fileName);
    	     CertificateFactory cf = CertificateFactory.getInstance("X.509");
    	     X509Certificate cert = (X509Certificate)cf.generateCertificate(inStream);
    	     System.out.println("\n\n ***** cert " +  cert.getPublicKey());
    	     return cert;
    	 } catch(Exception ex) {
    		 ex.printStackTrace();
    	 } finally {
    	     if (inStream != null) {
    	         try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	     }
    	 }
         
    	 return null;
    }
    
    
}


