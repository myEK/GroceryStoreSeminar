package se.mtry.iv1350.grocerystoreseminar.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.mtry.iv1350.grocerystoreseminar.dto.ItemDTO;
import se.mtry.iv1350.grocerystoreseminar.dto.PriceDTO;

public class PriceTest {
    private Price pr;
    private static ItemDTO itemA = new ItemDTO("A", "Tomat", "testar A", 100.0, 25.0);
    private static ItemDTO itemB = new ItemDTO("B", "Gurka", "testar B", 25.0, 12.0);
    
    @BeforeEach
    public void setUp() {
        pr = new Price();
    }
    
    @AfterEach
    public void tearDown() {
        pr = null; 
    }


    @Test
    public void testGetPrice() {
        
        double ep = 0.0;
        assertEquals(ep, pr.getPrice(), "The prise is not "  + ep + " on start" );
        pr.addItem(itemA, 1);
        assertEquals(pr.getPrice(), itemA.getPrice(), "The prise is not equals, for get price on one item");
        pr.addItem(itemA, 1);
        assertEquals(pr.getPrice(), (itemA.getPrice() * 2), "The prise is not equals, for mor of same item");
    }

    @Test
    public void testGetPriceTotal() {
        double ep = 0.0;
        assertEquals(ep, pr.getPriceTotal(), "The prise is not "  + ep + " on start" );
        pr.addItem(itemA, 1);
        double ep1 = itemA.getPrice() + (itemA.getPrice() * (itemA.getVTO()/100));
        assertEquals(pr.getPriceTotal(), ep1, "The tottal prise is not equals, for GetPriceTotal on one item");
        pr.addItem(itemA, 1);
        assertEquals(pr.getPriceTotal(), (ep1 * 2), "The totall prise is not equals, for mor of same item");
    }

    @Test
    public void testGetVto() {
        double ep = 0.0;
        assertEquals(ep, pr.getVto(), "The VTO is not "  + ep + " on start" );
        pr.addItem(itemA, 1);
        double ep1 = (itemA.getPrice() * itemA.getVTO()/100);
        assertEquals(pr.getVto(), ep1, "The tottal VTO is not equals, for GetVto on one item");
        pr.addItem(itemA, 1);
        assertEquals(pr.getVto(), (ep1 * 2), "The totall VTO is not equals, for mor of same item");
    }

    @Test
    public void testAddPay() {
        double ep = 0.0;
        assertEquals(ep, pr.addPay(ep), "The return is not "  + ep + " on start" );
        double ep1 = 50.0;
        assertEquals(ep1, pr.addPay(ep1), "The return is not good, if pay to: when the tottal is 0 " );
        pr.addItem(itemA, 1);
        double ep2 = 150 - pr.getPriceTotal();
        assertEquals(ep2, pr.addPay(100), "The return is not good when item is reg" );
    }    
}
