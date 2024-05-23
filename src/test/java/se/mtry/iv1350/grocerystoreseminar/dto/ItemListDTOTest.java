package se.mtry.iv1350.grocerystoreseminar.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mtrys
 */
public class ItemListDTOTest {
    private static double quantity = 5;
    private ItemListDTO db;
    
    private static String itemid = "ItemIsOK"; 
    private static String itemname = "ItemNameIsOK";
    private static String itemdescription = "Item description is OK, for this test";
    private static double itemprice = 100; 
    private static double itemvto = 25;
    private ItemDTO testItem;
    
    @BeforeEach
    public void setUp() {
        testItem = new ItemDTO(itemid, itemname, itemdescription, itemprice, itemvto);
        db = new ItemListDTO(testItem, quantity);
    }
    
    @AfterEach
    public void tearDown() {
        testItem = null;
        db = null;
    }

    @Test
    public void testGetItemID() {
        String expResult = itemid;
        String result = db.getItemID();
        assertEquals(expResult, result, "the item ID is not equals");
    }

    @Test
    public void testGetQuantity() {
        double expResult = quantity;
        double result = db.getQuantity();
        assertEquals(expResult, result, "the quantity is not the same");
    }
    
    public void testGetName() {
        String expResult = itemname;
        String result = db.getName();
        assertEquals(expResult, result, "the item name is not the same");
    }
    
    public void testGetItem() {
        ItemDTO expResult = testItem;
        ItemDTO result = db.getItem();
        assertEquals(expResult, result, "the itemDTO is not the same");
    }
    
    public void TestGetPrice(){
        double expResult = (itemprice*(1 + (itemvto / 100))) *quantity;
        double result = db.getPrice();
        assertEquals(expResult, result, "the priec is not equals");
    }
    
    public void TestGetTotalVAT(){
        double expResult = (itemprice*(itemvto / 100)) *quantity;
        double result = db.GetTotalVAT();
        assertEquals(expResult, result, "the total VAT is not equals");
    }

    
}
