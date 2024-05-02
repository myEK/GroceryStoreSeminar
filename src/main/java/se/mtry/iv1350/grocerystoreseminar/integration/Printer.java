package se.mtry.iv1350.grocerystoreseminar.integration;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;

/**
 * printing kvitto
 * @author mtrys
 */
public class Printer {
    public void print(EndSaleDTO recipt){
        System.out.println(" -- Printer -> recipt");
        System.out.println(recipt.toString());
        System.out.println(" -- End Printer");
    }
}
