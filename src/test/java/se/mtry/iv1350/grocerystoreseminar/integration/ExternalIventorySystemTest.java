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
        ItemDTO ex = new ItemDTO("Test000", "Sand", "från Skane, lösvikt", 25.0, 25.0);
        
        try {
            ItemDTO re = instanceToTest.serachItem("Test000");
            assertTrue(ex.getID().equals(re.getID()), "Item ID is not return equals");
            assertTrue(ex.getName().equals(re.getName()), "Item Name is not return equals");
        } catch (Exception e){
            System.out.print("Error, Can not cerat the file to logg, " + e.getMessage());
        }
        
    }
    
    @Test
    void testSerachItemThrowsExceptionItemNotFound(){      
        assertThrows(ExceptionItemNotFound.class, () -> {
            instanceToTest.serachItem("NotFound");
        });
    }

    @Test
    void testSerachItemThrowsExceptionDatabaseFailConnection(){
        /* 
        TODO: Ingen bra lösning för testa deta. 
        */
        fail("TODO");
        
    }
}
