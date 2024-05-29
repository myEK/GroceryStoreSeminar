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
    void testSerachItemThrowsExceptionNotIfItemFound(){      
        try {
            ItemDTO ex = new ItemDTO("Test000", "Sand", "des", 25.0, 25.0);
            ItemDTO re = instanceToTest.serachItem("Test000");
            assertTrue(ex.getID().equals(re.getID()), "Item ID is not return equals");
            assertEquals(ex.getName(), re.getName(), "Item Name is not return equals");
        } catch(Exception e) {
            fail("Should not thrown exception");
        } 
    }          

    @Test      
    void testSerachItemThrowsExceptionItemNotFound(){      
        assertThrows(ExceptionItemNotFound.class, () -> {
            instanceToTest.serachItem("NotFound");
        });
    }
    
    @Test
    void testtestSerachItemInDBThrowsExceptionDatabaseNotIfConnectionFound(){      
        try {
            ItemDTO ex = new ItemDTO("Test000", "Sand", "des", 25.0, 25.0);
            ItemDTO re = instanceToTest.serachItem("Test000");
            assertTrue(ex.getID().equals(re.getID()), "Connection is not OK");
        } catch(Exception e) {
            fail("Should not thrown exception");
        } 
    }
    
    @Test
    void testtestSerachItemInDBThrowsExceptionDatabaseFailConnection(){
        assertThrows(ExceptionDatabaseFailConnection.class, () -> {
            instanceToTest.serachItemInDB("009", null);            
        });
    }
}
