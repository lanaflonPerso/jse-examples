package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public interface ShopingCart {

    void add(Item item);

    void addDiscount(Discount discount);

    boolean hasUnmarkedItem(Item a);

    CartItem getUnmakredCartItem(Item a);

    double getTotal();

    void checkOut();
}
