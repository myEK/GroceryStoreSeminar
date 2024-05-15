package se.mtry.iv1350.grocerystoreseminar.view;

/**
 * Handles execution of error messages
 * @author mtrys
 */
public class ErrorMessageLogg {
    
    /**
     * Displays the specified error message.
     * @param msg The error message.
     */
    void showError(String msg) {
        StringBuilder errMsg = new StringBuilder();
        errMsg.append(" -- ERROR: ");
        errMsg.append(msg);
        System.out.println(errMsg + "\n");
    }    
}
