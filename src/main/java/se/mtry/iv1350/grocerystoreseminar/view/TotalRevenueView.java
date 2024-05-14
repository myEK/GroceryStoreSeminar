package se.mtry.iv1350.grocerystoreseminar.view;

import se.mtry.iv1350.grocerystoreseminar.model.IncomeObserver;

/**
 * 
 * @author mtrys
 */
public class TotalRevenueView implements IncomeObserver {
    private double totalIncome;
    
    /**
     * Add the income to the tottal incomesum
     * @param income 
     */
    @Override
    public void newAddToTotalIncome(double income){
        this.totalIncome += income;
        System.out.println(" -- Total Income of all sale is: " + totalIncome);
    }   
}
