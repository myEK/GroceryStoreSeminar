package se.mtry.iv1350.grocerystoreseminar.integration;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;

/**
 * kommunikationen med Ekonomi System 
 * @author mtrys
 */
public class ExternalAccountingSystem {
    public void loggSale(EndSaleDTO ex){
        System.out.println("Sale logg ExternalAccountingSystem ");
        System.out.println("logg Change: " + ex.getChange());
        System.out.println("...\n\n");
    }
    
}
