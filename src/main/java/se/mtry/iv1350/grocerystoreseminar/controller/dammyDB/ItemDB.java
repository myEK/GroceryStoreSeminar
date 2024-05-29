package se.mtry.iv1350.grocerystoreseminar.controller.dammyDB;

import java.util.ArrayList;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.integration.ExceptionItemNotFound;

/**
 *
 * @author mtrys
 */
public class ItemDB {
    
    private ArrayList<ItemDTO> data;

    public ItemDB() {
        data = new ArrayList<ItemDTO>();
        data.add(new ItemDTO("Test000", "Sand", "des", 25.0, 25.0));
        data.add(new ItemDTO("001", "Tomat", "från Skåne", 1.0, 12.0));
        data.add(new ItemDTO("002", "Gurka", "från Skåne", 2.0, 12.0));
        data.add(new ItemDTO("003", "Steklök", "från Skåne", 3.0, 12.0));
        data.add(new ItemDTO("004", "Paprika", "från Skåne", 4.0, 12.0));
        data.add(new ItemDTO("005", "Annansa", "från Skåne", 5.0, 12.0));
        data.add(new ItemDTO("006", "Champinjoner", "från Skåne", 6.0, 12.0));
        data.add(new ItemDTO("007", "Purjelök", "från Skåne", 7.0, 12.0));
    }

    public void addnewItem(String id, String name, String description, double price, double vto){
        data.add(new ItemDTO(id,name, description, price, vto));
        
    }
    
    /**
     * Return the Item of the item equals ID. 
     * @param itemID item searches for
     * @return the itemDTO of the itomDTO
     * @throws ExceptionItemNotFound 
     */
    public ItemDTO get(String itemID) throws ExceptionItemNotFound{
        for (ItemDTO item : data) {
            if(itemID.equals(item.getID())) {
                return item;
            }
        }
        throw new ExceptionItemNotFound("Item could not be retrieved with (ItemDB) ID: " + itemID);
    }
    
    /**
     * // Test if the user can conect to databas
     */
    public void checkOK(){
        // Test if the user can conect to databas
    }
}
