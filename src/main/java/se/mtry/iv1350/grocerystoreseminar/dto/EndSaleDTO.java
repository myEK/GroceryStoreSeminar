package se.mtry.iv1350.grocerystoreseminar.dto;

import java.time.LocalTime;

/**
 *
 * @author mtrys
 */
public class EndSaleDTO {
    private ItemListDTO[] itemList;
    private PriceDTO price;
    private LocalTime timeStartSale;
    private LocalTime timeEndSale;
    
    
    public EndSaleDTO(PriceDTO price, ItemListDTO[] itemList, LocalTime timeStart, LocalTime timeEnd){
        this.itemList = itemList;
        this.price = price;
        this.timeStartSale = timeStart;
        this.timeEndSale = timeEnd;
    }
    
    public double getChange(){
        return price.getChange();
    }
    
    public String getItemID(int i){
        return itemList[i].getItemID(); 
    }
    
    public double getQuantity(int i){
        return itemList[i].getQuantity(); 
    }
    
    public int getItemIntlength(){
        return itemList.length; 
    }
    
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Time satar of sale: " + this.timeStartSale + "\n");
        builder.append("Time end of sale: " + this.timeEndSale + "\n\n");
        
        builder.append("Itemlist: \n");
        for(int i = 0; i < itemList.length; i++){
            builder.append(this.itemList[i].toString() + "\n");
        }
                
        builder.append("\n"
                + "Total cost (incl VAT): " + this.price.getPrice() + " SEK \n" );
        builder.append("Total VAT: " + this.price.getVAT() + " SEK \n\n");
        
        builder.append("Pay Cash: " + this.price.getPay() + " SEK \n" );
        builder.append("Change: " + this.price.getChange() + " SEK \n\n");
        return builder.toString();
    }
    
}
