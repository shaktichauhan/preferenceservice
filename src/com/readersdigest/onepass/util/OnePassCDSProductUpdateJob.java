package com.readersdigest.onepass.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.readersdigest.onepass.db.EntitlementsFho;
import com.readersdigest.onepass.db.EntitlementsFhoDAO;
import com.readersdigest.onepass.db.EntitlementsRdo;
import com.readersdigest.onepass.db.EntitlementsRdoDAO;
import com.readersdigest.onepass.db.EntitlementsToh;
import com.readersdigest.onepass.db.EntitlementsTohDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IEntitlementsFhoDAO;
import com.readersdigest.onepass.db.IEntitlementsRdoDAO;
import com.readersdigest.onepass.db.IEntitlementsTohDAO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.service.impl.OnePassAuthServiceImpl;

public class OnePassCDSProductUpdateJob {
    
    OnePassAuthServiceImpl onePassService;
    
    private IEntitlementsFhoDAO entitlementsFhoDAO;
    private IEntitlementsRdoDAO entitlementsRdoDAO;
    private IEntitlementsTohDAO entitlementsTohDAO;
    
    private final static String APP_VERION = "1.0.13";
    private final static String UUID = "onepasscdsentitlementsupdatejob";
    
    public OnePassCDSProductUpdateJob() {
        onePassService = new OnePassAuthServiceImpl();
        entitlementsFhoDAO = new EntitlementsFhoDAO();
        entitlementsRdoDAO = new EntitlementsRdoDAO();
        entitlementsTohDAO = new EntitlementsTohDAO();
    }
    
    public String updateCDSProducts() {
        
        StringBuffer message = new StringBuffer();
        try {
            String[] prodAbbrs = { "com.rd.readersdigest","com.rd.toh","com.rd.familyhandyman"};
            
            for (String prodAbbr : prodAbbrs) {
                String accountNumber = StringUtils.getRdSuperAccountNumber(StringUtils.getProdId(prodAbbr));
                String zipCode = StringUtils.getRdSuperZipCode(StringUtils.getProdId(prodAbbr));
                OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();
                adobeServiceResponse = onePassService.authenticateCDSUser(accountNumber,zipCode,prodAbbr,
                        APP_VERION,UUID,adobeServiceResponse);
                String authToken = adobeServiceResponse.authToken;
                
                System.out.println("\n\n\n ******* prodAbbr " + prodAbbr);
                System.out.println("\n\n\n ******* authToken " + authToken);
                
                adobeServiceResponse = onePassService.entitlements(authToken, prodAbbr, APP_VERION);
                
                List<String> cdsEntitleMents = adobeServiceResponse.entitlements.productId;
                System.out.println("\n\n\n ******* cdsEntitleMents.size() " + cdsEntitleMents.size());
                
                Set<String> cdsEntitleMentsSet = new HashSet<String>(cdsEntitleMents);
                
                List<String> onePassEntitleMents = onePassService.getEntitlements(prodAbbr);
                System.out.println("\n\n\n ******* onePassEntitleMents.size() " + onePassEntitleMents.size());
                Set<String> onePassEntitleMentsSet = new HashSet<String>(onePassEntitleMents);
                
                cdsEntitleMentsSet.removeAll(onePassEntitleMentsSet);
                
                System.out.println("\n\n\n ******* cdsEntitleMents.size() " + cdsEntitleMentsSet.size());
                
                String retMessage = saveEntitlements(prodAbbr, cdsEntitleMentsSet.iterator());
                message.append(retMessage).append(" Updated Records of " +prodAbbr + " product : " + cdsEntitleMentsSet.size() + " | ");
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return "Failed message : " + e.getMessage();
        }
        System.out.println("message.toString() " +message.toString());
        return message.toString();
    }
    
    public String saveEntitlements(String appId,  Iterator<String> iterator) {
       
        String prodAbbr = StringUtils.getProdId(appId);
        
        if(prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); //Getting the APP Id for Kindle
        }
        
        if(prodAbbr == null || "".equals(prodAbbr)) {
            return "FAILED";
        }
        
        try {
            EntityManagerHelper.beginTransaction();
            
            while(iterator.hasNext()) {
                
                String productId = iterator.next();
                System.out.println("\n\n\n ******* productId " + productId);
                
                if("RDO".equals(prodAbbr)) {
                    EntitlementsRdo entity = new EntitlementsRdo(productId);
                    entitlementsRdoDAO.save(entity);
                } else if("TOO".equals(prodAbbr)){
                    EntitlementsToh entity = new EntitlementsToh(productId);
                    entitlementsTohDAO.save(entity);
                } else if("FHO".equals(prodAbbr)){
                    EntitlementsFho entity = new EntitlementsFho(productId);
                    entitlementsFhoDAO.save(entity);
                }
            }
            EntityManagerHelper.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            EntityManagerHelper.rollback();
            return "FAILED";
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }
        
        return "SUCCESS";
      
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new OnePassCDSProductUpdateJob().updateCDSProducts();

    }

}
