package se.mtry.iv1350.grocerystoreseminar.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mtrys
 */
public class ItemDTOTest {
    private static String id = "ItemIsOK"; 
    private static String name = "ItemNameIsOK";
    private static String description = "Item description is OK, for this test";
    private static double price = 100; 
    private static double vto = 25;
    
    private ItemDTO db;
    
    @BeforeEach
    public void setUp() {
        db = new ItemDTO(id, name, description, price, vto);
    }
    
    @AfterEach
    public void tearDown() {
        db = null; 
    }

    @Test
    public void testGetID() {
        String expResult = id;
        String result = db.getID();
        assertEquals(expResult, result, "The id is not the same");
    }

    @Test
    public void testGetPrice() {
        double expResult = price;
        double result = db.getPrice();
        assertEquals(expResult, result, "The price is not the equals");
    }

    @Test
    public void testGetVTO() {
        double expResult = vto;
        double result = db.getVTO();
        assertEquals(expResult, result, "The VTO is not the equals");
    }
    

    @Test
    public void testGetName() {
        String expResult = name;
        String result = db.getName();
        assertEquals(expResult, result, "The items name is not the equals");
    }

    @Test
    public void testGetDescription() {
        String expResult = description;
        String result = db.getDescription();
        assertEquals(expResult, result, "The items Description is not the equals");
    }
    
}
