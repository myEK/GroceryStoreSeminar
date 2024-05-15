package se.mtry.iv1350.grocerystoreseminar.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logg the program error
 * @author mtrys
 */
public class loggSystem {
    private PrintWriter logfile;
    private String fileLoggName = "Error-log.txt";
    private double totalIncome;

    /**
     * Cerata a logg error file
     * @throws IOException 
     */
    public loggSystem() throws IOException {
            FileWriter file = new FileWriter(fileLoggName);
            logfile = new PrintWriter(file, true);
    }

    /**
     * Logg the error to the file
     * @param exc 
     */
    public void logException(Exception exc) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("Error, Exception was thrown: ");
        logMsgBuilder.append(exc.getMessage());
        logfile.println(logMsgBuilder);
        exc.printStackTrace(logfile);
        logfile.println("\n");
    }
}
