package com.readersdigest.sweepapi.service;

import com.readersdigest.sweepapi.dto.OnePassSweepEntryResponse;
import com.readersdigest.sweepapi.dto.SweepEntryDTO;


// TODO: Auto-generated Javadoc
/**
 * The Interface OnePassSweepApiService.
 */
public interface OnePassSweepApiService {


    /**
     * Creates the sweep entry.
     *
     * @param entry the entry
     * @return the one pass sweep entry response
     */
    OnePassSweepEntryResponse createSweepEntry(SweepEntryDTO entry);
    
    /**
     * Creates the sweep entry.
     *
     * @param entry the entry
     * @return the one pass sweep entry response
     */
    OnePassSweepEntryResponse createSweepEntryWithSubscription(SweepEntryDTO entry);


  

}
