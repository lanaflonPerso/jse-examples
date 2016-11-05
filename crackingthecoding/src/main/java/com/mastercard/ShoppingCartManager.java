package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public interface ShoppingCartManager {

    double calculate(ShopingCart shopingCart);

    void checkout(ShopingCart shopingCart);

    void addListener(ShoppintCartListener listener);
}
