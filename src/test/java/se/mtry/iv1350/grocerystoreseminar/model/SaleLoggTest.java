package se.mtry.iv1350.grocerystoreseminar.model;

import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.mtry.iv1350.grocerystoreseminar.dto.EndSaleDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemListDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.SaleLiveLoggDTO;

/**
 *
 * @author mtrys
 */
public class SaleLoggTest {
    private SaleLogg db;
    
    @BeforeEach
    public void setUp() {
        db = new SaleLogg();
    }
    
    @AfterEach
    public void tearDown() {
        db = null;
    }

    @Test
    public void testAddItem() {
        ItemDTO item = new ItemDTO("Test000", "Sand", "des", 25.0, 25.0);
        double Quantity = 1.0;
        SaleLiveLoggDTO expResult = new SaleLiveLoggDTO(item, Quantity, item.getPrice(), item.getPrice() * ((item.getVTO())/100));
        SaleLiveLoggDTO result = db.addItem(item, Quantity);
        assertEquals(expResult.getItem().getID(), result.getItem().getID(), "The item id is not the same");
        assertEquals(expResult.getQuantity(), result.getQuantity(), "The Quantity is not the same");
        assertEquals(expResult.getTotalPrice(), result.getTotalPrice(), "The total price is not the same");
    }

    @Test
    public void testGetPay() {
        double expResult = 0.0;
        double result = db.getPay();
        assertEquals(expResult, result, "the price is not 0 to start");
    }

    @Test
    public void testAddPay() {
        double pay = 10.0;
        double expResult = 10.0;
        double result = db.addPay(pay);
        assertEquals(expResult, result, "The pay and Return is not the same");
        expResult = expResult + pay;
        result = db.addPay(pay);
        assertEquals(expResult, result, "The pay and Return is not the same, after 2 pay");
    }

    @Test
    public void testEndSale() {
        Price price = new Price();
        ItemListDTO[] list = new ItemListDTO[0];
        EndSaleDTO expResult = new EndSaleDTO(price.getDTO(), list, LocalTime.now(), LocalTime.now());
        EndSaleDTO result = db.endSale();
        assertEquals(expResult.getPrice().getChange(), result.getPrice().getChange(), "the pay is not the same");
    }
    
}
