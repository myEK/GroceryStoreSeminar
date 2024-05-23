package se.mtry.iv1350.grocerystoreseminar.integration;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemListDTO;

/**
 * printing kvitto
 * @author mtrys
 */
public class Printer {
    /**
     * Print to consol logg the recipt
     * @param recipt 
     */
    public void print(EndSaleDTO recipt){
        System.out.println(" -- Printer -> recipt");
        System.out.println("Sale time start: " + recipt.getTimeStartSale());
        System.out.println("Sale time end: " + recipt.getTimeEndSale());
        
        System.out.println("\n Itemlist:");
        printItemLopp(recipt.getItemList());
        
        System.out.println("\n --- pay ---:"); 
       
        System.out.println("Total pay: " + recipt.getPrice().getPrice() + " SEK ( including VAT: " + recipt.getPrice().getVAT() + " )");
        System.out.println("The Change is: " + recipt.getPrice().getChange());
        System.out.println("End Printer");
    }
    
    private void printItemLopp(ItemListDTO[] itemList){
        for(int i = 0; i < itemList.length; i++){
            printItem(itemList[i]);
        }
    }
    
    private void printItem(ItemListDTO itemList){
        System.out.println("Item ID: " + itemList.getItem().getID() + " Item name: " + itemList.getItem().getName());
        System.out.println("Description : " + itemList.getItem().getDescription());
        System.out.println("price : " + itemList.getPrice() + " SEK ( including VAT: " +
                itemList.GetTotalVAT() + " ) for " + itemList.getQuantity() + " at " + itemList.getItem().getPrice() + " piece \n"); 
    }
}
