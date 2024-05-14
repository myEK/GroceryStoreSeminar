package se.mtry.iv1350.grocerystoreseminar.model;

/**
 *
 * @author mtrys
 */
public interface IncomeObserver {
    /**
     * totaled the total income for the program run
     * @param Income the new incom
     */
    void newAddToTotalIncome(double Income);
}
