/*
 * TCSS 305 - Winter 2016 
 * Assignment 2 - Shopping Cart
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;

import org.junit.Before;
import org.junit.Test;

/**
 * This ItemTest class has unit test methods for Item class and covers all the methods
 * in the Item class.
 * 
 * @author Jieun Lee
 * @version 1.0 (01-21-2016)
 */
public class ItemTest {

    /**
     * A test Item.
     */
    private Item myItemTest;

    /**
     * Sets up new Item for testing.
     * 
     * @throws java.lang.Exception when there is an issue.
     */
    @Before
    public void setUp() throws Exception {
        myItemTest = new Item("test", new BigDecimal("1.00"));
    }

    /**
     * Test of hashCode() method.
     * 
     * Test method for {@link model.Item#hashCode()}.
     */
    @Test
    public void testHashCode() {
        myItemTest = new Item("Java Rules!' bumper sticker", new BigDecimal("0.99"), 20,
                              new BigDecimal("8.95"));
        final Item another = myItemTest;
        assertEquals(another.hashCode(), myItemTest.hashCode());
    }

    /**
     * Test of the constructor that accepts only String for item name and
     * BigDecimal for single-item price.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimal() {
        myItemTest = new Item("Silly Putty", new BigDecimal("4.41"));
        assertEquals(new BigDecimal("4.41"), myItemTest.getPrice());
        assertEquals(0, myItemTest.getBulkQuantity());
        assertEquals(new BigDecimal("0.00"), myItemTest.getBulkPrice());

    }

    /**
     * Test of the overloaded constructor.
     * 
     * Test method for
     * {@link model.Item#Item(java.lang.String, 
     * java.math.BigDecimal, int, java.math.BigDecimal)}.
     */
    @Test
    public void testItemStringBigDecimalIntBigDecimal() {
        myItemTest = new Item("'Java Rules!' bumper sticker", new BigDecimal("0.99"), 20,
                              new BigDecimal("8.95"));
        assertEquals(new BigDecimal("0.99"), myItemTest.getPrice());
        assertEquals(20, myItemTest.getBulkQuantity());
        assertEquals(new BigDecimal("8.95"), myItemTest.getBulkPrice());
    }

    /**
     * Test of getPrice() method.
     * 
     * Test method for {@link model.Item#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(new BigDecimal("1.00"), myItemTest.getPrice());
    }

    /**
     * Test of getBulkQuantity() method.
     * 
     * Test method for {@link model.Item#getBulkQuantity()}.
     */
    @Test
    public void testGetBulkQuantity() {
        assertEquals(0, myItemTest.getBulkQuantity());
    }

    /**
     * Test of getBulkPrice() method.
     * 
     * Test method for {@link model.Item#getBulkPrice()}.
     */
    @Test
    public void testGetBulkPrice() {
        assertEquals(new BigDecimal("0.00"), myItemTest.getBulkPrice());
    }

    /**
     * Test of isBulk() method.
     * 
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulkFalse() {
        myItemTest = new Item("Silly Putty", new BigDecimal("4.41"));
        assertEquals(false, myItemTest.isBulk());
    }
    
    /**
     * Test of isBulk() method.
     * 
     * Test method for {@link model.Item#isBulk()}.
     */
    @Test
    public void testIsBulkTrue() {
        myItemTest = new Item("'Java Rules!' bumper sticker", new BigDecimal("0.99"), 20,
                                          new BigDecimal("8.95"));
        assertEquals(true, myItemTest.isBulk());
    }

    /**
     * Test of toString() method.
     * 
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("test, $1.00", myItemTest.toString());
    }
    
    /**
     * Test of toString() method.
     * 
     * Test method for {@link model.Item#toString()}.
     */
    @Test
    public void testOverloadedToString() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        assertEquals("'Java Rules!' button, $0.95 (10 for $5.00)", myItemTest.toString());
    }

    /**
     * Test of (this == theOter) condition of equals() method.
     * 
     * Test method for
     * {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectTrueSame() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item same = myItemTest;
        assertEquals(same, myItemTest);
    }
    
    /**
     * Test of (this == theOter) condition of equals() method.
     * 
     * Test method for
     * {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectTrueNew() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item sameNew = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                                        new BigDecimal("5.00"));
        assertEquals(sameNew, myItemTest);
    }
    
    /**
     * Test of (this == theOter) condition of equals() method.
     * 
     * Test method for
     * {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectFalse() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item difference = new Item("'Java Rules!' buttons", new BigDecimal("0.95"), 10,
                                        new BigDecimal("5.00"));
        assertFalse(myItemTest.equals(difference));
    }

    /**
     * Test of (theOther == null) condition of equals() method.
     * 
     * Test method for
     * {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectNullFalse() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item nullTest = null;
        assertFalse(myItemTest.equals(nullTest));
    }
    
    /**
     * Test of (getClass() != theOther.getClass()) condition of equals() method.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectGetClassTrue() {
        final Item sameClass = myItemTest;
        assertTrue(myItemTest.getClass().equals(sameClass.getClass()));
    }

    /**
     * Test of (getClass() != theOther.getClass()) condition of equals() method.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectGetClassFalse() {
        final BigDecimal differentClass = myItemTest.getPrice();
        assertFalse(myItemTest.equals(differentClass.getClass()));
    }

    /**
     * Test of equals() method. It compares single-item price.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectPriceFalse() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item priceTest = new Item("'Java Rules!' button", new BigDecimal("0.99"), 10,
                                        new BigDecimal("5.00"));
        assertFalse(myItemTest.equals(priceTest));
    }

    /**
     * Test of equals() method. It compares bulk quantity.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectBulkQuantityFalse() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item bulkQuantityTest =
                        new Item("'Java Rules!' button", new BigDecimal("0.95"), 30,
                                 new BigDecimal("5.00"));
        assertFalse(myItemTest.equals(bulkQuantityTest));
    }

    /**
     * Test of equals() method it compares bulk price.
     * 
     * Test method for {@link model.Item#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectBulkPriceFalse() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("5.00"));
        final Item bulkPriceTest = new Item("'Java Rules!' button", new BigDecimal("0.95"),
                                            10, new BigDecimal("50.00"));
        assertFalse(myItemTest.equals(bulkPriceTest));
    }

    /**
     * Test of IllegalArgumentException for empty item name in constructor that
     * accepts only item name and price.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemIllegalArgumentExceptionForEmptyName() {
        myItemTest = new Item("", new BigDecimal("4.41"));
    }

    /**
     * Test of IllegalArgumentException for negative single-item price in
     * constructor that accepts only item name and price.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemIllegalArgumentExceptionForPrice() {
        myItemTest = new Item("Silly Putty", new BigDecimal("-4.41"));
    }

    /**
     * Test of IllegalArgumentException for empty item name in overloaded
     * constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOverloadedItemIllegalArgumentExceptionForEmptyName() {
        myItemTest = new Item("", new BigDecimal("0.95"), 10, new BigDecimal("4.41"));
    }

    /**
     * Test of IllegalArgumentException for negative single-item price in
     * overloaded constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testOverloadedItemIllegalArgumentExceptionForPrice() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("-0.95"), 10,
                              new BigDecimal("4.41"));
    }

    /**
     * Test of IllegalArgumentException for negative bulk quantity in overloaded
     * constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemIllegalArgumentExceptionForBulkQuantity() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), -10,
                              new BigDecimal("5.00"));
    }

    /**
     * Test of IllegalArgumentException for negative bulk price in overloaded
     * constructor.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testItemIllegalArgumentExceptionForBulkPrice() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10,
                              new BigDecimal("-5.00"));
    }

    /**
     * Test of NullPointerException for item name in constructor that accepts
     * only item name and price.
     */
    @Test(expected = NullPointerException.class)
    public void testItemNullPointerExceptionForName() {
        myItemTest = new Item(null, new BigDecimal("0.95"));
    }

    /**
     * Test of NullPointerException for item price in constructor that accepts
     * only item name and price.
     */
    @Test(expected = NullPointerException.class)
    public void testItemNullPointerExceptionForPrice() {
        myItemTest = new Item("'Java Rules!' button", null);
    }

    /**
     * Test of NullPointerException for item name in overloaded constructor.
     */
    @Test(expected = NullPointerException.class)
    public void testOverloadedItemNullPointerExceptionForName() {
        myItemTest = new Item(null, new BigDecimal("0.95"), 10, new BigDecimal("5.00"));
    }

    /**
     * Test of NullPointerException for item price in overloaded constructor.
     */
    @Test(expected = NullPointerException.class)
    public void testOverloadedItemNullPointerExceptionForPrice() {
        myItemTest = new Item("'Java Rules!' button", null, 10, new BigDecimal("5.00"));
    }

    /**
     * Test of NullPointerException for bulk price in overloaded constructor.
     */
    @Test(expected = NullPointerException.class)
    public void testOverloadedItemNullPointerExceptionForBulkPrice() {
        myItemTest = new Item("'Java Rules!' button", new BigDecimal("0.95"), 10, null);
    }

}
