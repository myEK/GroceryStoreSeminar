package se.mtry.iv1350.grocerystoreseminar.dto;

/**
 *
 * @author mtrys
 */
public class SaleLiveLoggDTO {
    private ItemDTO item;
    private double quantity;
    private double priceTotal;
    private double vto;
    
    
    public SaleLiveLoggDTO(ItemDTO item, double quantity, double price, double vto){
        this.item = item; 
        this.quantity = quantity;        
        this.vto = vto;
        priceTotal = price + vto;
    }
    
    public double getQuantity(){
        return quantity;
    }
    
    public double getTotalPrice(){
        return priceTotal;
    }
    
    public double getTotalVAT(){
        return vto;
    }
    
    public ItemDTO getItem(){
        return item;
    }
}
