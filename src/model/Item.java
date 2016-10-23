/*
 * TCSS 305 - Winter 2016 
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * The Item object stores information about an individual item.
 * 
 * @author Jieun Lee
 * @version 1.1 (01-21-2016)
 */
public final class Item {

    /**
     * The name of this item.
     */
    private final String myItemName;

    /**
     * The single price of this item.
     */
    private final BigDecimal myItemPrice;

    /**
     * The bulk quantity of this item.
     */
    private final int myBulkQuantity;

    /**
     * The bulk price of this item.
     */
    private final BigDecimal myBulkPrice;

    /**
     * Constructs that takes an item name and an item price as arguments and
     * initializes bulk quantity and bulk price of this item.
     * 
     * @param theName Item name.
     * @param thePrice Single-item price.
     * @throws IllegalArgumentException if theName is empty or if thePrice is less than zero.
     * @throws NullPointerException if theName is null or thePrice is null.
     */
    public Item(final String theName, final BigDecimal thePrice) {
        myItemName = Objects.requireNonNull(theName);
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("should have at least one letter");
        }
        myItemPrice = Objects.requireNonNull(thePrice);
        if (thePrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price can not be negative");
        }
        myBulkQuantity = 0;
        myBulkPrice = new BigDecimal("0.00");
    }

    /**
     * Constructs that takes an item name, a single-item price, a bulk quantity
     * and a bulk price as arguments.
     * 
     * @param theName Item name.
     * @param thePrice Single-item price.
     * @param theBulkQuantity Bulk quantity of the item.
     * @param theBulkPrice Bulk price of the item.
     * @throws IllegalArgumentException if theName is empty, if thePrice or
     *             theBulkPrice is less than zero or if theBulkQuantity is less
     *             than zero.
     * @throws NullPointerException if any one of the parameter is null.
     */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        myItemName = Objects.requireNonNull(theName);
        if (theName.isEmpty()) {
            throw new IllegalArgumentException("Item name should have at least one letter");
        }
        myItemPrice = Objects.requireNonNull(thePrice);
        if (theBulkQuantity < 0) {
            throw new IllegalArgumentException("Bulk quantity shouldn't be negative");
        }
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = Objects.requireNonNull(theBulkPrice);
        if (thePrice.compareTo(BigDecimal.ZERO) < 0
            || theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    /**
     * Returns the single-item price for this item.
     * 
     * @return Price of this item.
     */
    public BigDecimal getPrice() {
        return myItemPrice;
    }

    /**
     * Returns the bulk quantity for this item.
     * 
     * @return Bulk quantity for this item.
     */
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    /**
     * Returns the bulk price for this item.
     * 
     * @return Bulk price for the item.
     */
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    /**
     * Returns true if the item has bulk pricing; false otherwise.
     * 
     * @return True if the item has bulk pricing.
     */
    public boolean isBulk() {
        final boolean isBulk;
        if (myBulkPrice.compareTo(BigDecimal.ZERO) > 0) {
            isBulk = true;
        } else {
            isBulk = false;
        }
        return isBulk;
    }

    /**
     * {@inheritDoc}
     * 
     * The String representation of this item will be formatted as follows:
     * Item name, $single-price.
     * If the item has a bulk price, then:
     * Item name, $single-price (Bulk quantity for $Bulk price).
     */
    @Override
    public String toString() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        final StringBuilder builder = new StringBuilder();
        builder.append(myItemName);
        builder.append(", ");
        builder.append(nf.format(myItemPrice));
        if (isBulk()) {
            builder.append(" (");
            builder.append(myBulkQuantity);
            builder.append(" for ");
            builder.append(nf.format(myBulkPrice));
            builder.append(')');
        }
        return builder.toString();
    }

    /**
     * Returns true if the specified object is equivalent to this item; false
     * otherwise.
     */
    @Override
    public boolean equals(final Object theOther) {
        final boolean result;
        if (this == theOther) {
            result = true;
        } else if (theOther == null || getClass() != theOther.getClass()) { 
            result = false;
        } else {
            final Item other = (Item) theOther;
            result = myItemName.equals(other.myItemName)
                     && myItemPrice.equals(other.myItemPrice)
                     && myBulkQuantity == other.myBulkQuantity
                     && myBulkPrice.equals(other.myBulkPrice);
        }
        return result;
    }

    /**
     * Returns an integer hash code for this item.
     */
    @Override
    public int hashCode() {
        return Objects.hash(myItemName, myItemPrice, myBulkQuantity, myBulkPrice);
    }
}
