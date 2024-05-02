package se.mtry.iv1350.grocerystoreseminar.controller.dammyDB;

import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;

/**
 *
 * @author mtrys
 */
public class ItemDB {
    private ItemDTO[] data;
    
    public ItemDB(){
        data = new ItemDTO[10];
        
        data[1] = new ItemDTO("001", "Tomat", "från Skåne", 1.0, 12.0);
        data[2] = new ItemDTO("002", "Gurka", "från Skåne", 2.0, 12.0);
        data[3] = new ItemDTO("003", "Steklök", "från Skåne", 3.0, 12.0);
        data[4] = new ItemDTO("004", "Paprika", "från Skåne", 4.0, 12.0);
        data[5] = new ItemDTO("005", "Annansa", "från Skåne", 5.0, 12.0);
        data[6] = new ItemDTO("006", "Champinjoner", "från Skåne", 6.0, 12.0);
        data[7] = new ItemDTO("007", "Purjelök", "från Skåne", 7.0, 12.0);
    }

    public ItemDTO get(String itemID){
        for(int i = 0; i < data.length; i++){
            try {
                if(itemID.equals(data[i].getID())){
                    return data[i];
                }
            } catch(Exception e) {
                // Not Find; 
            }
        }
        return null; 
    }
}


