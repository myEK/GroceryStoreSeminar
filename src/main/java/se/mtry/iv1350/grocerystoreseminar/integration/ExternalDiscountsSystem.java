package se.mtry.iv1350.grocerystoreseminar.integration;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;

/**
 * Kommunuserar med discounts databas systemet
 * @author mtrys
 */
public class ExternalDiscountsSystem {
    public void loggSale(EndSaleDTO ex){
        System.out.println("Sale logg ExternalDiscountsSystem ");
        System.out.println("logg Discounts: No one logg");
        System.out.println("...\n\n");
    }
}
