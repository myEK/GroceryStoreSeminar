package se.mtry.iv1350.grocerystoreseminar.dto;

/**
 *
 * @author mtrys
 */
public class ItemListDTO {
    private ItemDTO item;
    private double quantity;
    private double prise;
            
    public ItemListDTO(ItemDTO item, double quantity){
        this.item = item;
        this.quantity = quantity;
        this.prise = (item.getPrice() * quantity) * (1 + (item.getVTO()/100));
    }
    
    public String getItemID(){
        return item.getID();
    }
    
    public double getQuantity(){
        return quantity;
    }
    
    public String getName() {
        return item.getName();
    }
    
    public ItemDTO getItem() {
        return item;
    }
    
    public double GetTotalVAT(){
        return (item.getPrice() * quantity) * (item.getVTO()/100);
    }
    
    public double getPrice(){
        return prise;
    }
}
