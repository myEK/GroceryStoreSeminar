package se.mtry.iv1350.grocerystoreseminar.controller;

import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;
import se.mtry.iv1350.grocerystoreseminar.integration.Printer;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalSystem;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalAccountingSystem;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalDiscountsSystem;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalIventorySystem;

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
     * Cerat a new sale to run. Denna metod måste anroppas för programet ska kunna hantera en nytt köp.
     */
    public void newSale(){
        sale = new Sale(); 
    }
    
    /**
     * Add a item in the system, To check database and save in sale
     * @param itemID Items Id
     * @return Info at the Item and info of the sale. 
     */
    public SaleLiveLoggDTO addItem(String itemID){
        return addItem(itemID, 1);
    }
    
    /**
    * Add a item in the system, To check database and save in sale
    * @param itemID Items Id
    * @param Quantity Of the Item
    * @return Info at the Item and info of the sale. 
    */
    public SaleLiveLoggDTO addItem(String itemID, double Quantity){
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
}
