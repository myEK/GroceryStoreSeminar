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
     * Add a new item to the ExternalIventorySystem databas. 
     * @param id
     * @param name
     * @param description
     * @param price
     * @param vto 
     */
    public void addNewItemToDB(String id, String name, String description, double price, double vto){
        db.addnewItem(id, name, description, price, vto);
    }
    
    /**
     * Sert the data in database. 
     * @param itemID IDnummret för produkten
     * @return ItemDTO of the Item or Null if not find.
     * @throws ExceptionItemNotFound if item not find
     * @throws ExceptionDatabaseFailConnection To the conation is bad  
     */
    public ItemDTO serachItem(String itemID) throws ExceptionItemNotFound, ExceptionDatabaseFailConnection{
       if(db.getClass() == null){
           throw new ExceptionDatabaseFailConnection("Can not conect to the databas, (ExternalIventorySystem) ");          
       }
        try {
           return db.get(itemID);
       } catch (ExceptionItemNotFound exc){
           throw exc;
       }
    }
    
    public void loggSale(EndSaleDTO ex){
        System.out.println("Sale logg ExternalIventorySystem ");
        for(int i = 0; i < ex.getItemList().length; i++){
            System.out.println("Logg " + ex.getItemList()[i].getQuantity() + " of item: " + ex.getItemList()[i].getItemID());
        }
        System.out.println("...\n\n");
    }
}
