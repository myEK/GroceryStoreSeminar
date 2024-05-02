package se.mtry.iv1350.grocerystoreseminar.model;

import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.PriceDTO;

/**
 * Systemet hanterar priset för köpet
 * @author mtrys
 */
public class Price {
    private double price; 
    private double vto;
    private double total;
    private double pay; 
    
    /**
     * Cerat a new sale price logg
     */
    public Price(){
        this.price = 0.0;
        this.vto = 0.0;
        this.pay = 0.0;
        this.total = price + vto;
    }
    
    /**
     * Add a new itam to the price list
     * @param item
     * @param Quantity 
     */
    public void addItem(ItemDTO item, double Quantity){
        double pr = item.getPrice();
        double vt = item.getVTO();
        price += (pr * Quantity);
        vto += ((vt / 100) * (pr * Quantity));
        total = price + vto;
    }
    
    /**
     * Return the price whid not VTO
     * @return 
     */
    public double getPrice(){
        return price; 
    }
    
    /**
     * Get tha price price + VTO; 
     * @return 
     */
    public double getPriceTotal(){
        return total; 
    }
    
    /**
     * Return the VTO total kr. 
     * @return 
     */
    public double getVto(){
        return vto;
    }
    
    public double addPay(double pay){
        this.pay += pay;
        return this.pay - total;
    }
    
    public PriceDTO getDTO(){
        return new PriceDTO(this.vto, this.total, this.pay);
    }
}
