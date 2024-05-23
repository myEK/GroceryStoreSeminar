package se.mtry.iv1350.grocerystoreseminar.model;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Hanterar det beräkningar för köpet Sale
 * @author mtrys
 */
public class Sale {
    private SaleLogg salelogg;
    private List<IncomeObserver> incomeObservers = new ArrayList<>();
    
    /**
     * Cerate the data for a new sale. 
     */
    public Sale(){
        salelogg = new SaleLogg();
    }
    
    private void notifyObservers() {
        for (IncomeObserver obs : incomeObservers){
            obs.newAddToTotalIncome(salelogg.getPay());
        }
    }
    
    /**
     * the list of IncomeObserver
     * @param obsList IncomeObserver
     */
    public void addIncomeObserver(List<IncomeObserver> obsList) {
        for(IncomeObserver obs : obsList){
            incomeObservers.add(obs);
        }
    }
    
    /**
     * Check if the item value is OK to add in the lits, 
     * Or return rerror info
     * @param item The new ItemDTO
     * @param Quantity of the new item
     * @return Sale live update info.
     */
    public SaleLiveLoggDTO addItem(ItemDTO item, double Quantity){      
        return salelogg.addItem(item, Quantity);
       
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
    
    /**
     * To get the EndSaleDTO of the sale
     * @return EndSaleDTO
     */
    public EndSaleDTO endSale(){
        notifyObservers();
        return salelogg.endSale();
    }
    
    
}
