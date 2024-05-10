package se.mtry.iv1350.grocerystoreseminar.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logg the program error
 * @author mtrys
 */
public class loggSystem {
    private PrintWriter file;

    /**
     * Cerata a logg error file
     * @throws IOException 
     */
    public loggSystem() throws IOException {
        file = new PrintWriter(new FileWriter("Error-log.txt", true), true);
    }

    /**
     * Logg the error to the file
     * @param exc 
     */
    public void logException(Exception exc) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("Error, Exception was thrown: ");
        logMsgBuilder.append(exc.getMessage());
        file.println(logMsgBuilder);
        exc.printStackTrace(file);
        file.println("\n");
    }
}
