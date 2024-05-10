package se.mtry.iv1350.grocerystoreseminar.integration;

import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.controller.dammyDB.ItemDB;
import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;

/**
 * Kommunuserar med lagersystem
 * @author mtrys
 */
public class ExternalIventorySystem {
    private ItemDB db;
    
    /**
     * Setup kominikationen med databasen, 
     */
    public ExternalIventorySystem(){
        db = new ItemDB();
    }
    
    /**
     * Sert the data in database. 
     * @param itemID IDnummret för produkten
     * @return ItemDTO of the Item or Null if not find.
     * @throws ExceptionItemNotFound
     */
    public ItemDTO serachItem(String itemID) throws ExceptionItemNotFound{
       try {
           return db.get(itemID);
       } catch (ExceptionItemNotFound exc){
           throw exc;
       }
    }
    
    public void loggSale(EndSaleDTO ex){
        System.out.println("Sale logg ExternalIventorySystem ");
        for(int i = 0; i < ex.getItemIntlength(); i++){
            System.out.println("Logg " + ex.getQuantity(i) + " of item: " + ex.getItemID(i));
        }
        System.out.println("...\n\n");
    }
}
