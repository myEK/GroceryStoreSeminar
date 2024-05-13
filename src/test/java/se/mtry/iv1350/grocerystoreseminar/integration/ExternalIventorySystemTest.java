package se.mtry.iv1350.grocerystoreseminar.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;

/**
 *
 * @author mtrys
 */
public class ExternalIventorySystemTest {
    private ExternalIventorySystem instanceToTest; 
    
    @BeforeEach
    public void setUp() {
        instanceToTest = new ExternalIventorySystem();
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
    }
    
    @Test
    void testSerachItemThrowsExceptionItemNotFound(){      
        assertThrows(ExceptionItemNotFound.class, () -> {
            instanceToTest.serachItem("TestNotFoundID");
        });
    }

    @Test
    void testSerachItemThrowsExceptionDatabaseFailConnection(){
        /* 
        TODO:
        
        Ingen bra lösning för testa deta. 
        
        assertThrows(ExceptionDatabaseFailConnection.class, () -> {
            instanceToTest.serachItem("DatabaseFailID");
        });
        */
        fail("TODO");
        
    }
}
