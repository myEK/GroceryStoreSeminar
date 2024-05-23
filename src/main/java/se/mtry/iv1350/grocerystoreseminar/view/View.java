package se.mtry.iv1350.grocerystoreseminar.view;

import java.io.IOException;
import se.mtry.iv1350.grocerystoreseminar.controller.Controller;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;
import se.mtry.iv1350.grocerystoreseminar.integration.ExceptionDatabaseFailConnection;
import se.mtry.iv1350.grocerystoreseminar.integration.ExceptionItemNotFound;
import se.mtry.iv1350.grocerystoreseminar.util.loggSystem;
/**
 * User intergration med programet. som berättar för controller vad som ska ordnas. 
 * @author mtrys
 */
public class View {
    private Controller contr;
    private ErrorMessageLogg errMeg = new ErrorMessageLogg();
    private loggSystem logFile;
    
    /**
     * Skapar ett nytt insetut mot prata med controller
     * @param contr Controller för programet.
     * @throws IOException 
     */
    public View(Controller contr) throws IOException{
        this.contr = contr;
        contr.addIncomeObserver(new TotalRevenueView());
        contr.addIncomeObserver(new TotalRevenueFileOutput());
        this.logFile = new loggSystem();
    }
    
    /**
     * Start a new sale.
     */
    private void newSale(){
        contr.newSale();
        System.out.println(" -- New sale started");
    }
    
    private void addItem(String itemID){
        try{
            System.out.println(" -- Add 1 item:");
            printSaleLiveLoggDTO(contr.addItem(itemID));
            
        } catch (ExceptionItemNotFound exc){
            writeErrorLogg("Can not find the itom, NO item with the specified identifier is found", exc);
        } catch (ExceptionDatabaseFailConnection exc){
            writeErrorLogg("Unable to connect to database", exc);
        }
    }
    
    private void printSaleLiveLoggDTO(SaleLiveLoggDTO a){
        System.out.println("Item ID: " + a.getItem().getID() + " Item name: " + a.getItem().getName());
        System.out.println("Description : " + a.getItem().getDescription());
        System.out.println("price : " + a.getTotalPrice() + " SEK ( including VAT: " +
                a.getTotalVAT() + " ) for " + a.getQuantity() + " at " + a.getItem().getPrice() + " piece \n");
        
    }
    
    private void addItem(String itemID, double Quantity){
        try{
        System.out.println(" -- Add " + Quantity + " items");
        printSaleLiveLoggDTO(contr.addItem(itemID,Quantity));
                
        } catch (ExceptionItemNotFound exc){       
            writeErrorLogg("Can not find the itom, NO item with the specified identifier is found", exc);
        } catch (ExceptionDatabaseFailConnection exc){
            writeErrorLogg("Unable to connect to database", exc);
        }
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
        try{
        newSale();
        addItem("005");
        addItem("002");
        addItem("005");
        addItem("007",3);
        addItem("009",2);
        getPay();
        endSale();
        } catch (Exception exc) {
            writeErrorLogg("Failed to rune the program", exc);
        }
        try {
  Thread.sleep(2000);
} catch (InterruptedException e) {
  Thread.currentThread().interrupt();
}
        try{
        newSale();
        addItem("005");
        addItem("002");
        addItem("005");
        addItem("007",3);
        addItem("009",2);
        getPay();
        endSale();
        } catch (Exception exc) {
            writeErrorLogg("Failed to rune the program", exc);
        }
        try {
  Thread.sleep(1000);
} catch (InterruptedException e) {
  Thread.currentThread().interrupt();
}
        try{
        newSale();
        addItem("005");
        addItem("002");
        addItem("005");
        addItem("007",3);
        addItem("009",2);
        getPay();
        endSale();
        } catch (Exception exc) {
            writeErrorLogg("Failed to rune the program", exc);
        }
    }
    
    private void writeErrorLogg(String text, Exception exc){
        errMeg.showError(text);
        logFile.logException(exc);
    }
}
