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
    private String error;
    
    
    
    public SaleLiveLoggDTO(String error, double price, double vto){
        this.error = error;
        this.vto = vto;
        priceTotal = price + vto;
    }
    
    public SaleLiveLoggDTO(ItemDTO item, double quantity, double price, double vto){
        
        this.item = item; 
        this.quantity = quantity;        
        this.vto = vto;
        priceTotal = price + vto;
    }
    
    @Override
    public String toString() {
        if(error != null){
          StringBuilder builder = new StringBuilder();
        builder.append(" " + this.error + "\n" );
        builder.append("Total cost (incl VAT): " + this.priceTotal + " SEK \n" );
        builder.append("Total VAT: " + this.vto + " SEK \n\n");
        return builder.toString();  
        }
        
        
        StringBuilder builder = new StringBuilder();
        builder.append("Item ID: " + this.item.getID() + "\n");
        builder.append("Item Name: " + this.item.getName() + "\n");
        builder.append("Item Price: " + this.item.getPrice() + " SEK \n");
        builder.append("Item VAT: " + this.item.getVTO() + "%\n");
        builder.append("Item description: " + this.item.getDescription() + " \n\n");
        
        builder.append("Total cost (incl VAT): " + this.priceTotal + " SEK \n" );
        builder.append("Total VAT: " + this.vto + " SEK \n\n");
        return builder.toString();
    }
}
