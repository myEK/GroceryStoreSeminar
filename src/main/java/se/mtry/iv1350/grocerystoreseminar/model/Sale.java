package se.mtry.iv1350.grocerystoreseminar.model;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;

/**
 * Hanterar det beräkningar för köpet Sale
 * @author mtrys
 */
public class Sale {
    private SaleLogg salelogg;
    
    /**
     * Cerate the data for a new sale. 
     */
    public Sale(){
        salelogg = new SaleLogg();
    }
    
    /**
     * Check if the item value is OK to add in the lits, 
     * Or return rerror info
     * @param item The new ItemDTO
     * @param Quantity of the new item
     * @return Sale live update info.
     */
    public SaleLiveLoggDTO addItem(ItemDTO item, double Quantity){
        if(!errorCheck(item)){
            // Error at the Item.
            // System.err.println("Item is invalid");
            return salelogg.itemNotFind(); 
        }
        
        return salelogg.addItem(item, Quantity);
       
    }
    
    /**
     * Chech if the itam is OK
     * @param item of the new itemDTO
     * @return True or false.
     */
    private boolean errorCheck(ItemDTO item){
        try {
            if(item != null){
                return true; 
            }
        } catch(Exception e) {
            // Item is not find,
            return false;
        }
        return false;
    } 
    
    /**
     * End sale the value of custmer to pay.
     * @return 
     */
    public double getPay(){
        return salelogg.getPay();
    }
    
    /**
     * exchange
     * @param pay
     * @return 
     */
    public double addPay(double pay){
        return salelogg.addPay(pay);
    }
    
    public EndSaleDTO endSale(){
        return salelogg.endSale();
    }
    
    
}
