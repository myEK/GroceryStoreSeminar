package se.mtry.iv1350.grocerystoreseminar.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mtrys
 */
public class PriceDTOTest {
    private static double pay = 120.5;
    private static double total = 100;
    private static double vto = 70.0;
    private PriceDTO db;
    
    @BeforeEach
    public void setUp() {
        db = new PriceDTO(vto, total, pay);
    }
    
    @AfterEach
    public void tearDown() {
        db = null;
    }

    @Test
    public void testGetPrice() {
        double expResult = total;
        double result = db.getPrice();
        assertEquals(expResult, result, "The totall price is not the samne");
    }

    @Test
    public void testGetVAT() {
        double expResult = vto;
        double result = db.getVAT();
        assertEquals(expResult, result, "The totall VAT is not the samne");
    }

    @Test
    public void testGetPay() {
        double expResult = pay;
        double result = db.getPay();
        assertEquals(expResult, result, "The totall custmer pay is not the samne");
    }

    @Test
    public void testGetChange() {
        double expResult = pay - total;
        double result = db.getChange();
        assertEquals(expResult, result, "The totall change is not equals");
    }
    
}
