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
    
    public PriceDTO getPrice(){
        return price;
    }
    
    public LocalTime getTimeStartSale(){
        return timeStartSale;
    }
    
    public LocalTime getTimeEndSale(){
        return timeEndSale;
    }
    
    public ItemListDTO[] getItemList() {
        return itemList;
    }
}
