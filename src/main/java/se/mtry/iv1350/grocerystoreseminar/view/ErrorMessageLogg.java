package se.mtry.iv1350.grocerystoreseminar.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
