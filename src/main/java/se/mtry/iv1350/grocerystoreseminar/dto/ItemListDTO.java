package se.mtry.iv1350.grocerystoreseminar.dto;

/**
 *
 * @author mtrys
 */
public class ItemListDTO {
    private ItemDTO item;
    private double quantity;
    private double Prise;
            
    public ItemListDTO(ItemDTO item, double quantity){
        this.item = item;
        this.quantity = quantity;
        this.Prise = item.getPrice() * quantity + ((item.getPrice() * quantity) * (item.getVTO()/100));
    }
    
    public String getItemID(){
        return item.getID();
    }
    
    public double getQuantity(){
        return quantity;
    }
    
    public String toString(){
        return item.getName() + " \t\t " + this.quantity + " * " + this.item.getPrice() + " \t\t " + this.Prise + " SEK";  
    }
}
