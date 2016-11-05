package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class BuyOneGetHalf implements Promotion {

    private Item a;
    private Item b;

    public BuyOneGetHalf(Item a, Item b) {
        this.a = a;
        this.b = b;
    }

    public void applyPromo(ShopingCart shopingCart) {
        if (shopingCart.hasUnmarkedItem(a) && shopingCart.hasUnmarkedItem(b)) {
            shopingCart.getUnmakredCartItem(a).markedForPromo(this);
            shopingCart.getUnmakredCartItem(b).markedForPromo(this);
            shopingCart.addDiscount(new PromotionDiscount(b.getCurrentPrice() / 2));

        }
    }

}
