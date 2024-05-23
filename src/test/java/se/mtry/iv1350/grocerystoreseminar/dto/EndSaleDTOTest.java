package se.mtry.iv1350.grocerystoreseminar.dto;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mtrys
 */
public class EndSaleDTOTest {
    private LocalTime timeS;
    private LocalTime timeE;
    
    @BeforeEach
    public void setUp() {
        timeS = LocalTime.now();
        timeE = timeS.plusMinutes(30);
    }
    
    @AfterEach
    public void tearDown() {
        timeS = null;
        timeE = null;
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        EndSaleDTO instance = null;
        PriceDTO expResult = null;
        PriceDTO result = instance.getPrice();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTimeStartSale() {
        System.out.println("getTimeStartSale");
        EndSaleDTO instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getTimeStartSale();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTimeEndSale() {
        System.out.println("getTimeEndSale");
        EndSaleDTO instance = null;
        LocalTime expResult = null;
        LocalTime result = instance.getTimeEndSale();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetItemList() {
        System.out.println("getItemList");
        EndSaleDTO instance = null;
        ItemListDTO[] expResult = null;
        ItemListDTO[] result = instance.getItemList();
        assertArrayEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
