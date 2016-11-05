package com.mastercard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class Main {

    public static void main(String[] args) {
        ShoppingCartImpl shoppingCart = new ShoppingCartImpl();

        PromoManagerImpl promoManager = new PromoManagerImpl();
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();
        Item item6 = new Item();
        Item item7 = new Item();
        List<Item> buy3ItemList = new ArrayList<>();
        buy3ItemList.add(item1);
        buy3ItemList.add(item2);
        buy3ItemList.add(item3);
        buy3ItemList.add(item4);
        final BuyAnyCheapestFree buyAny3GetCheapest = new BuyAnyCheapestFree(3, buy3ItemList);
        final BuyOneGetHalf buyOneGetHalf = new BuyOneGetHalf(item5, item6);

        promoManager.addPromo(buyAny3GetCheapest);
        promoManager.addPromo(buyOneGetHalf);

        ShoppingCartManagerImpl shoppingCartManager = new ShoppingCartManagerImpl(promoManager);
        shoppingCart.add(item1);
        shoppingCart.add(item2);
        shoppingCart.add(item3);
        shoppingCart.add(item5);
        shoppingCart.add(item6);

        shoppingCartManager.calculate(shoppingCart);

        System.out.println(shoppingCart.getTotal());

    }
}
