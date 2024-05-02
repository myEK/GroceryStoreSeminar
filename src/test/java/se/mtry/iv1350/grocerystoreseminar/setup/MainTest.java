package se.mtry.iv1350.grocerystoreseminar.setup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MainTest {
    private Main instanceToTest; 
    private ByteArrayOutputStream printBAOS;
    private PrintStream printSTOrg; 
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new Main();
        
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
    public void testUiHasStartad() {
        String[] args = null;
        Main.main(args);
        
        String printout = printBAOS.toString();
        String expTextOutput = "started";
        assertTrue(printout.contains(expTextOutput), "UI  (sale) not start correctly");
    }
}
