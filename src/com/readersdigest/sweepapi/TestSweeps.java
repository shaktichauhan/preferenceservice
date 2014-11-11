package com.readersdigest.sweepapi;

import com.readersdigest.sweepapi.dto.OnePassSweepEntryResponse;
import com.readersdigest.sweepapi.dto.SweepEntryDTO;
import com.readersdigest.sweepapi.service.OnePassSweepApiService;
import com.readersdigest.sweepapi.service.impl.OnePassSweepApiServiceImpl;

public class TestSweeps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SweepEntryDTO entry = new SweepEntryDTO();
		entry.setEmailAddress("shakti123@shakti.shatki");
		//entry.setClaimCode("9H21MD");
		entry.setSepId(59651);
		entry.setSpId(204);
		entry.setFirstName("shakti");
		entry.setLastName("chauhan");
		OnePassSweepApiService onePassSweepApiService = new OnePassSweepApiServiceImpl();
      
		OnePassSweepEntryResponse response= onePassSweepApiService.createSweepEntry(entry);
		
		//ISweepEntryDAO sweepsDAO = new SweepEntryDAO();
		//SweepValidation ent =  sweepsDAO.getListValidationId(4475);
				//findById(new Integer(4));
		
		//boolean flag = ent.validateRequest(ent);
		//System.out.println("\n\n ***** flag **** " + flag);

		
//		   try {
//			System.out.println("\n\n\n ************response " + ent.get(0)[0]);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
