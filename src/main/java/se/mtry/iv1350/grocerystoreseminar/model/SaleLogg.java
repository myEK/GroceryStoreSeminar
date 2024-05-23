package se.mtry.iv1350.grocerystoreseminar.model;

import java.time.LocalTime;
import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemListDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;

/**
 * Loggar datan för köpet
 * 
 * @author mtrys
 */
public class SaleLogg {
    private LocalTime timeStartSale;
    private Price price;
    private ItemList[] itemList;
    private DiscountList[] discountList;

    /**
     * Logg för allt som ska sparas för köpet
     */
    public SaleLogg() {
        timeStartSale = LocalTime.now();
        price = new Price();
        itemList = new ItemList[0];
        discountList = new DiscountList[0];
    }
     

    
    /**
     * add and update the Itema and Quantity. last update price.  
     * @param item the new item 
     * @param Quantity of the new item. 
     * @return 
     */
    public SaleLiveLoggDTO addItem(ItemDTO item, double Quantity){
        
            int pos = itemPos(item); 
            if(pos < itemList.length){
                itemList[pos].addQuantity(Quantity);
            } else {
                addItemNewList(item, Quantity);
            }
            
            price.addItem(item, Quantity);
            return new SaleLiveLoggDTO(item, Quantity, price.getPrice(), price.getVto()); 
    }
    
    /**
     * Return the item pos in the shoppinglist, if the item is not find the pos last in the array. 
     * @param item Of the new item to add
     * @return int of the pos at the array of shoppinglist. 
     */
    private int itemPos(ItemDTO item){
        for(int i = 0; i < itemList.length; i++){
            try {
                if(itemList[i].getItemID().equals(item.getID())){
                    return i;
                }
            } catch(Exception e) {
                // Not Itam in the pos of the array
                System.err.println("Missing a value in the array");
            } 
        }
        return itemList.length;
    }
    
    /**
     * Cerat a new list whid the old valu and add the new. 
     * @param item the new item. 
     * @param Quantity Of the new item. 
     */
    private void addItemNewList(ItemDTO item, double Quantity){
        ItemList[] newList = new ItemList[itemList.length + 1];
        for(int i = 0; i < itemList.length; i++){
            newList[i] = itemList[i];
        }
        newList[itemList.length] = new ItemList(item, Quantity);
        itemList = newList;
    }
    
    /**
     * Get the prise to endSale
     * @return double
     */
    public double getPay(){
        return price.getPriceTotal();
    }
    
    /**
     * exchange
     * @param pay
     * @return exchange 
     */
    public double addPay(double pay){
        return price.addPay(pay);
    }
    
    /**
     * End sale and cerata a DTO 
     * @return DTO of the sale
     */
    public EndSaleDTO endSale(){
        ItemListDTO[] list = new ItemListDTO[itemList.length];
        for(int i = 0; i < itemList.length; i++){
            list[i] = itemList[i].getDTO();
        }
        return new EndSaleDTO(price.getDTO(), list, timeStartSale, LocalTime.now());
        
    }
}
