package com.mastercard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class BuyAnyCheapestFree implements Promotion {

    private int minimum;

    private List<Item> itemsRequired = new ArrayList<>();

    public BuyAnyCheapestFree(int minimum, List<Item> itemsRequired) {
        this.minimum = minimum;
        this.itemsRequired = itemsRequired;
    }

    @Override
    public void applyPromo(ShopingCart shopingCart) {
        int count = 0;
        Item cheepest = null;
        List<Item> mark = new ArrayList<>();
        for (Item i : itemsRequired) {
            if (shopingCart.hasUnmarkedItem(i)) {
                count++;
                mark.add(i);
                if (cheepest == null || cheepest.getCurrentPrice() < i.getCurrentPrice()) {
                    cheepest = i;
                }
            }
        }
        if (count >= minimum) {
            for (int i = 0; i < minimum - 1; minimum++) {
                shopingCart.getUnmakredCartItem(mark.get(i)).markedForPromo(this);
            }
            shopingCart.addDiscount(new PromotionDiscount(cheepest.getCurrentPrice()));
        }
    }

}
