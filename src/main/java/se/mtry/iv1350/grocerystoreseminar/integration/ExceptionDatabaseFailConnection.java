package se.mtry.iv1350.grocerystoreseminar.integration;

/**
 * Database Connection
 * @author mtrys
 */
public class ExceptionDatabaseFailConnection extends Exception {
    /**
     * Thrown when an Item Not Found.
     */
    public ExceptionDatabaseFailConnection(String text) {
        super(text);
    }
}
