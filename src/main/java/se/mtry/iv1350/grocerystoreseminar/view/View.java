package se.mtry.iv1350.grocerystoreseminar.view;

import se.mtry.iv1350.grocerystoreseminar.controller.Controller;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;
/**
 * User intergration med programet. som berättar för controller vad som ska ordnas. 
 * @author mtrys
 */
public class View {
    private Controller contr; 
    
    /**
     * Skapar ett nytt insetut mot prata med controller
     * @param contr Controller för programet.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /**
     * Start a new sale.
     */
    private void newSale(){
        contr.newSale();
        System.out.println(" -- New sale started");
    }
    
    private void addItem(String itemID){
        SaleLiveLoggDTO a = contr.addItem(itemID);
        System.out.println(" -- Add 1 item of id " + itemID + ": \n" + a.toString());
    }
    
    private void addItem(String itemID, double Quantity){
        SaleLiveLoggDTO a = contr.addItem(itemID, Quantity);
        System.out.println(" -- Add " + Quantity + " item of id " + itemID + ": \n" + a.toString());
    }
    
    private void getPay(){
        double pay = contr.getPay();
        System.out.println(" -- End sale: \n" + "Total cost (incl VAT): " + pay + " SEK ");
    }
    
    private void endSale(){
        System.out.println(" -- End logg sale system");
        double change = contr.endSale(70);
        System.out.println(" -- End logg sale: \n" + "change to give the customer: " + change + " SEK ");
    }
    
    /**
     * Code to run and test the program in develop step. 
     */
    public void runFakeTestDevelop(){
        newSale();
        addItem("005");
        addItem("002");
        addItem("005");
        addItem("007",3);
        addItem("009",2);
        getPay();
        endSale();
    }
}
