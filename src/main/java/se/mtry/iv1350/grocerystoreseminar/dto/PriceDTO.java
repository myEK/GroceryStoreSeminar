package se.mtry.iv1350.grocerystoreseminar.dto;

/**
 *
 * @author mtrys
 */
public class PriceDTO { 
    private double vto;
    private double total;
    private double pay;
    private double change;
    
    /**
     * Cerat a new sale price logg
     */
    public PriceDTO(double vto, double total, double pay){
        this.vto = vto;
        this.pay = pay;
        this.total = total;
        this.change = this.pay - this.total;
    }
    
    public double getPrice(){
        return total;
    }
    
    public double getVAT(){
        return vto;
    }
    
    public double getPay(){
        return pay;
    }
    
    public double getChange(){
        return change;
    }
}
