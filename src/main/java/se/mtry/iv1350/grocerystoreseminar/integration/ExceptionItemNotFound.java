package se.mtry.iv1350.grocerystoreseminar.integration;

/**
 * error handling if not find the item.
 * 
 * @author mtrys
 */
public class ExceptionItemNotFound extends Exception {
    /**
     * Thrown when an Item Not Found.
     */
    public ExceptionItemNotFound(String text) {
        super(text);
    }
}
