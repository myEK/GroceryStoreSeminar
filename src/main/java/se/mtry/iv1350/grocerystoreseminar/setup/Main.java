package se.mtry.iv1350.grocerystoreseminar.setup;

import java.io.IOException;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalSystem;
import se.mtry.iv1350.grocerystoreseminar.integration.Printer;
import se.mtry.iv1350.grocerystoreseminar.controller.Controller;
import se.mtry.iv1350.grocerystoreseminar.view.View;

/**
 * startup for the program. The mian metod for applikationen. 
 * @author mtrys
 */
public class Main {
    /**
     * The mian metod for applikationen.
     * @param args programet tar inga start värden. 
     */
    public static void main(String[] args){
        try {
        ExternalSystem exSystem = new ExternalSystem();
        Printer printer = new Printer();
        Controller contr = new Controller(exSystem, printer);
        View view = new View(contr); 

        // run test fake program
        view.runFakeTestDevelop();
        } catch (IOException ex) {
            System.out.println("Error, can not run the program");
            System.out.println(ex);
        }
    }
}
