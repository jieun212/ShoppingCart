/*
 * TCSS 305 - Winter 2016 
 * Assignment 2 - Shopping Cart
 */

package model;

import java.util.Objects;

/**
 * The ItemOrder object stores information about a purchase order for a
 * particular item: namely, a reference to the item itself and the quantity
 * desired.
 * 
 * @author Jieun Lee
 * @version 1.1 (01-20-2016)
 */
public final class ItemOrder {

    /**
     * The item order.
     */
    private final Item myItem;

    /**
     * The quantity of this item order.
     */
    private final int myQuantity;

    /**
     * Constructs that creates an item order for the given quantity of the given
     * item.
     * 
     * @param theItem The item order to assign to this item order.
     * @param theQuantity The quantity to assign to this quantity of this item
     *            order.
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        myItem = Objects.requireNonNull(theItem);
        if (theQuantity < 0) {
            throw new IllegalArgumentException("Quantity shouldn't be negative");
        }
        myQuantity = theQuantity;
    }

    /**
     * Returns a reference to the item.
     * 
     * @return This item order.
     */
    public Item getItem() {
        return myItem;
    }

    /**
     * Returns the quantity of this item order.
     * 
     * @return quantity of this item order.
     */
    public int getQuantity() {
        return myQuantity;
    }

    /**
     * Returns a String representation of this item order.
     */
    @Override
    public String toString() {
        return getClass().getName() + "[" + myQuantity + ", " + myItem + "]";
    }
}
