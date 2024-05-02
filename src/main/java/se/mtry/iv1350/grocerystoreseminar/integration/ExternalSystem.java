package se.mtry.iv1350.grocerystoreseminar.integration;

/**
 * System att prata med det olika exstarna databasserna. 
 *   
 * @author mtrys
 */
public class ExternalSystem {
    private ExternalAccountingSystem accountRegisty = new ExternalAccountingSystem();
    private ExternalDiscountsSystem discountRegisty = new ExternalDiscountsSystem();
    private ExternalIventorySystem iventoryRegisty = new ExternalIventorySystem();
    
    
    /**
     * ExternalAccountingSystem kommunikation
     * 
     * @return accountRegisty of the ExternalAccountingSystem
     */
    public ExternalAccountingSystem getAccountRegisty(){
        return accountRegisty;
    }
    
    /**
     * ExternalDiscountsSystem kommunikation
     * 
     * @return discountRegisty of the ExternalDiscountsSystem
     */
    public ExternalDiscountsSystem getDiscountRegisty(){
        return discountRegisty;
    }
    
    /**
     * ExternalIventorySystem kommunikation
     * 
     * @return iventoryRegisty of the ExternalIventorySystem
     */
    public ExternalIventorySystem getIventoryRegisty(){
        return iventoryRegisty;
    }

}
