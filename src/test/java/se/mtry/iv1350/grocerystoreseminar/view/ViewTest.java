package se.mtry.iv1350.grocerystoreseminar.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.mtry.iv1350.grocerystoreseminar.controller.Controller;
import se.mtry.iv1350.grocerystoreseminar.integration.Printer;
import se.mtry.iv1350.grocerystoreseminar.integration.ExternalSystem;

public class ViewTest {
    private View instanceToTest; 
    private ByteArrayOutputStream printBAOS;
    private PrintStream printSTOrg; 
    
    @BeforeEach
    public void setUp() {
        Printer printer = new Printer();
        ExternalSystem exSystem = new ExternalSystem();
        Controller contr = new Controller(exSystem, printer);
        instanceToTest = new View(contr);
        
        printBAOS = new ByteArrayOutputStream();
        PrintStream printOut = new PrintStream(printBAOS);
        printSTOrg = System.out;
        System.setOut(printOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        printBAOS = null;
        System.setOut(printSTOrg);
    }
    
    @Test
    public void newSale() {
        instanceToTest.runFakeTestDevelop();
        String printout = printBAOS.toString();
        
        String expTextOutput = "started";
        assertTrue(printout.contains(expTextOutput), "UI  (sale) not start correctly");
    }
    
}
