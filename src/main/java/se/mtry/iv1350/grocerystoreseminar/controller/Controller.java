package se.mtry.iv1350.grocerystoreseminar.controller;

import java.util.List;
import java.util.ArrayList;

import se.mtry.iv1350.grocerystoreseminar.dto.*;
import se.mtry.iv1350.grocerystoreseminar.integration.*;
import se.mtry.iv1350.grocerystoreseminar.model.IncomeObserver;
import se.mtry.iv1350.grocerystoreseminar.model.Sale;

/**
 * Controller for the program, Med data från user, databas & systemet går igen denna. 
 * @author mtrys
 */
public class Controller {
    private Printer printer;
    private ExternalAccountingSystem accountRegisty;
    private ExternalDiscountsSystem discountRegisty;
    private ExternalIventorySystem iventoryRegisty;
    private Sale sale;
    
    private List<IncomeObserver> incomeObservers = new ArrayList<>();
    
    /**
     * Setup controllens anslutningar. 
     * @param exSystem Kommunikation för hämta värdena från exstarna systemet databaserna
     * @param printer Printer anslutningen
     */
    public Controller(ExternalSystem exSystem, Printer printer){ 
        this.printer = printer;
        this.accountRegisty = exSystem.getAccountRegisty();
        this.discountRegisty = exSystem.getDiscountRegisty();
        this.iventoryRegisty = exSystem.getIventoryRegisty();
    }
    
    /**
     * Cerat a new sale to run.
     */
    public void newSale(){
        sale = new Sale();
        sale.addIncomeObserver(incomeObservers);
    }
    
    /**
     * Add a item in the system, To check database and save in sale
     * @param itemID Items Id
     * @return Info at the Item and info of the sale. 
     * @throws ExceptionItemNotFound
     * @throws ExceptionDatabaseFailConnection 
     */
    public SaleLiveLoggDTO addItem(String itemID) throws ExceptionItemNotFound, ExceptionDatabaseFailConnection{
        return addItem(itemID, 1);
        
    }
    
    /**
    * Add a item in the system, 
    * @param itemID Items Id
    * @param Quantity Of the Item
    * @return Info at the Item and info of the sale. 
    * @throws ExceptionItemNotFound
     * @throws ExceptionDatabaseFailConnection 
     */
    public SaleLiveLoggDTO addItem(String itemID, double Quantity) throws ExceptionItemNotFound, ExceptionDatabaseFailConnection {
        ItemDTO item = iventoryRegisty.serachItem(itemID);
        return sale.addItem(item, Quantity);
    }
    
    
    
    /**
     * End sale the value of custmer to pay.
     * @return 
     */
    public double getPay(){
        return sale.getPay();
    }
    
    /**
     * End the sale med avsluta Sale, Skriva kvitto och upptatera de olika exstarna systemen
     * @param pay Kunden betalar kontant
     * @return Växel
     */
    public double endSale(double pay){
        double exchange = sale.addPay(pay);
        EndSaleDTO endSaleData = sale.endSale();
        printer.print(endSaleData);
        accountRegisty.loggSale(endSaleData);
        discountRegisty.loggSale(endSaleData);
        iventoryRegisty.loggSale(endSaleData);
        return exchange;
    }
    
    /**
     * Add the Observer list for income
     * @param obs 
     */
    public void addIncomeObserver(IncomeObserver obs) {
        incomeObservers.add(obs);
    }
}
