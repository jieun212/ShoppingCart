/*
 * TCSS 305 - Winter 2016 
 * Assignment 2 - Shopping Cart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;
import model.ItemOrder;

import org.junit.Before;
import org.junit.Test;

/**
 * This ItemOrderTest class has unit test methods for ItemOrder class and covers
 * all the methods in the ItemOrder class.
 * 
 * (It is not a requirement of the assignment.)
 * 
 * @author Jieun Lee
 * @version 1.0 (01-20-2016) 
 */
public class ItemOrderTest {
    
    /**
     * A test ItemOrder. 
     */
    private ItemOrder myOrderTest;
    
    /**
     * A default Item.
     */
    private Item myItem;
    

    /**
     * Sets Up new ItemOrer for testing.
     * 
     * @throws java.lang.Exception when there is an issue
     */
    @Before
    public void setUp() throws Exception {
        myItem = new Item("test", new BigDecimal("1.11"));
        myOrderTest = new ItemOrder(myItem, 0);
    }

    /**
     * Test of constructor .
     * 
     * Test method for {@link model.ItemOrder#ItemOrder(model.Item, int)}.
     */
    @Test
    public void testItemOrder() {
        myOrderTest = new ItemOrder(myItem, 7);
        assertEquals(new Item("test", new BigDecimal("1.11")), myOrderTest.getItem());
        assertEquals(7, myOrderTest.getQuantity());
    }

    /**
     * Test of getItem() method.
     * 
     * Test method for {@link model.ItemOrder#getItem()}.
     */
    @Test
    public void testGetItem() {
        assertEquals(new Item("test", new BigDecimal("1.11")), myOrderTest.getItem());
    }

    /**
     * Test of getQuantity() method.
     * 
     * Test method for {@link model.ItemOrder#getQuantity()}.
     */
    @Test
    public void testGetQuantity() {
        assertEquals(0, myOrderTest.getQuantity());
    }

    /**
     * Test method for {@link model.ItemOrder#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("model.ItemOrder[0, test, $1.11]", myOrderTest.toString());
    }
    
    //THROW EXCEPTION TESTS
    
    //ILLEGALARGUMENT
    /**
     * Test of IllegalArgumentException for negative value of quantity in constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemOrderIllegalArgumentException() {
        myOrderTest = new ItemOrder(myItem, -3);
    }
    
    //NULLPOINTER
    /**
     * Test of NullPointerException for Item in constructor.
     */
    @Test(expected = NullPointerException.class)
    public void testItemOrderNullPointerExceptionForItem() {
        myOrderTest = new ItemOrder(null, 5);
    }
}
