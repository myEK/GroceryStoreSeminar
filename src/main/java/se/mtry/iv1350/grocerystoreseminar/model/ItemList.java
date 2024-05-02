package se.mtry.iv1350.grocerystoreseminar.model;

import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemListDTO;

/**
 * Listen med varor som ska köppas
 * @author mtrys
 */
public class ItemList {
    private ItemDTO item;
    private double Quantity;
    
    /**
     * Cerate a new itam to the shoppinglis 
     * @param item
     * @param Quantity 
     */
    public ItemList(ItemDTO item, double Quantity){
        this.item = item;
        this.Quantity = Quantity;
    }
    
    /**
     * Add the Quantity of the bying item. 
     * @param Quantity to add in the Quantity, in double.
     */
    public void addQuantity(double Quantity){
        this.Quantity += Quantity; 
    }
    
    /**
     * Get the item of the item
     * @return ItemID
     */
    public String getItemID(){
        return this.item.getID();
    }
    
    public ItemListDTO getDTO(){
        return new ItemListDTO(this.item, this.Quantity);
    } 
}
