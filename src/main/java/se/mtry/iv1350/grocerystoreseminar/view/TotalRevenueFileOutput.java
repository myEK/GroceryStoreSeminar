package se.mtry.iv1350.grocerystoreseminar.view;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import se.mtry.iv1350.grocerystoreseminar.model.IncomeObserver;


/**
 * logg to the file
 * @author mtrys
 */
public class TotalRevenueFileOutput implements IncomeObserver{
    private PrintWriter logfile;
    private String fileLoggName = "TotalRevenueFileOutputLogg.txt";
    private double totalIncome;
    
    /**
     * Sett up the fill to logg the totall sum to the file. 
     */
    public TotalRevenueFileOutput(){
        try {
            FileWriter file = new FileWriter(fileLoggName);
            logfile = new PrintWriter(file, true);
        } catch (Exception e){
            System.out.print("Error, Can not cerat the file to logg, " + e.getMessage());
        }
    }
    

    /**
     * Add the income to the tottal incomesum logg file
     * @param income 
     */
    @Override
    public void newAddToTotalIncome(double income){
        totalIncome += income;
        
        
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM-yyyy");
        
        logfile.println(dateTime.format(date) + " on time logg: " + dateTime.format(time));
        logfile.println(" Add sale to incress total income of: " + income);
        logfile.println(" Total Income of all sale is: " + totalIncome + "\n");
        
    }
}
