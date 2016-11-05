package com.mastercard;

import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class ShoppingCartImpl implements ShopingCart {

    private List<CartItem> items;

    private double total;
    private boolean checkout;

    @Override
    public void add(Item item) {
        items.add(new CartItem(item));
        total += item.getCurrentPrice();
    }

    @Override
    public void addDiscount(Discount discount) {
        total -= discount.getDiscount();
    }

    @Override
    public boolean hasUnmarkedItem(Item a) {
        return false;
    }

    @Override
    public CartItem getUnmakredCartItem(Item a) {
        return null;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void checkOut() {
        checkout = true;
    }
}
