package se.mtry.iv1350.grocerystoreseminar.controller.dammyDB;

import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.integration.ExceptionItemNotFound;

/**
 *
 * @author mtrys
 */
public class ItemDB {
    private ItemDTO[] data;

    public ItemDB() {
        data = new ItemDTO[8];

        data[0] = new ItemDTO("000", "Sand", "från Skåne, lösvikt", 25.0, 25.0);
        data[1] = new ItemDTO("001", "Tomat", "från Skåne", 1.0, 12.0);
        data[2] = new ItemDTO("002", "Gurka", "från Skåne", 2.0, 12.0);
        data[3] = new ItemDTO("003", "Steklök", "från Skåne", 3.0, 12.0);
        data[4] = new ItemDTO("004", "Paprika", "från Skåne", 4.0, 12.0);
        data[5] = new ItemDTO("005", "Annansa", "från Skåne", 5.0, 12.0);
        data[6] = new ItemDTO("006", "Champinjoner", "från Skåne", 6.0, 12.0);
        data[7] = new ItemDTO("007", "Purjelök", "från Skåne", 7.0, 12.0);
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
}
