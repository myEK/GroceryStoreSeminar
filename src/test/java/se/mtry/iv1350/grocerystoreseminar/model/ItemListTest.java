package se.mtry.iv1350.grocerystoreseminar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemListDTO;

/**
 *
 * @author mtrys
 */
public class ItemListTest {
    private ItemDTO item;
    private double antal;
    private ItemList db;
    
    @BeforeEach
    public void setUp() {
        item = new ItemDTO("idTest", "na", "de", 25, 5);
        antal = 1;
        db = new ItemList(item, antal);
        
    }
    
    @AfterEach
    public void tearDown() {
        item = null;
        db = null;
    }

    @Test
    public void testGetItemID() {
        String expResult = "idTest";
        String result = db.getItemID();
        assertEquals(expResult, result, "The get not the samme ID for the item");
    }

    @Test
    public void testGetDTO() {
        ItemListDTO expResult = new ItemListDTO(item, antal);
        ItemListDTO result = db.getDTO();
        assertEquals(expResult.getItemID(), result.getItemID(), "Is not returning the same ItemListDTO on item ID");
        assertEquals(expResult.getName(), result.getName(), "Is not returning the same ItemListDTO on Name");
        assertEquals(expResult.getPrice(), result.getPrice(), "Is not returning the same ItemListDTO on price");
        assertEquals(expResult.getQuantity(), result.getQuantity(), "Is not returning the same ItemListDTO on Quantity");
    }
    
}
