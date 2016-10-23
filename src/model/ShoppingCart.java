/*
 * TCSS 305 - Winter 2016 
 * Assignment 2 - Shopping Cart
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * The ShoppingCart object stores information about the customer's overall purchase.
 * 
 * @author Jieun Lee
 * @version 1.1 (01-21-2016)
 */
public final class ShoppingCart {

    /**
     * The list of item orders.
     */
    private final List<ItemOrder> myOrder;

    /**
     * This shopping cart has membership.
     */
    private boolean myMembership;

    /**
     * Constructs that creates an empty shopping cart.
     */
    public ShoppingCart() {
        myOrder = new ArrayList<ItemOrder>();
        myMembership = false;
    }

    /**
     * Adds an order to the shopping cart, replacing any previous order for an
     * equivalent item with the new order.
     * 
     * @param theOrder New item order.
     * @throws theOrder if theOrder is null.
     */
    public void add(final ItemOrder theOrder) {
        for (int i = 0; i < myOrder.size(); i++) {
            if (myOrder.get(i).getItem().equals(Objects.requireNonNull(theOrder).getItem())) {
                myOrder.remove(i);
            }
        }
        myOrder.add(theOrder);
    }

    /**
     * Sets whether or not the customer for this shopping cart has a store
     * membership.
     * 
     * @param theMembership Membership discount.
     */
    public void setMembership(final boolean theMembership) {
        myMembership = theMembership;
    }

    /**
     * Returns the total cost of this shopping cart.
     * 
     * @return Total cost of this shopping cart.
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < myOrder.size(); i++) {
            final BigDecimal getQuantity = new BigDecimal(myOrder.get(i).getQuantity());
            final BigDecimal getSinglePrice = myOrder.get(i).getItem().getPrice();
            final BigDecimal subTotal;
            if (myMembership) {
                final BigDecimal getBulkQuantity =
                                new BigDecimal(myOrder.get(i).getItem().getBulkQuantity());
                if (myOrder.get(i).getItem().isBulk()) {
                    subTotal = getQuantity.divide(getBulkQuantity, 0, RoundingMode.DOWN).
                                    multiply(myOrder.get(i).getItem().getBulkPrice()).
                                    add(getQuantity.remainder(getBulkQuantity).
                                                    multiply(getSinglePrice));
                    total = total.add(subTotal);
                } else {
                    subTotal = getQuantity.multiply(getSinglePrice);
                    total = total.add(subTotal);
                }
            } else {
                subTotal = getQuantity.multiply(getSinglePrice);
                total = total.add(subTotal);
            }
        }
        total = total.setScale(2, RoundingMode.HALF_EVEN);
        return total;
    }

    /**
     * Removes all orders from this shopping cart.
     */
    public void clear() {
        myOrder.removeAll(myOrder);
    }

    /**
     * Returns a String representation of this shopping cart.
     */
    @Override
    public String toString() {
        final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        final StringBuilder builder = new StringBuilder(128);
        builder.append(getClass().getName() + '\n');
        for (int i = 0; i < myOrder.size(); i++) {
            builder.append("[Quantity = ");
            builder.append(myOrder.get(i).getQuantity());
            builder.append(", Item = ");
            builder.append(myOrder.get(i).getItem().toString());
            builder.append("]\n");
        }
        builder.append("Total = ");
        builder.append(nf.format(calculateTotal()));
        return builder.toString();
    }
}
