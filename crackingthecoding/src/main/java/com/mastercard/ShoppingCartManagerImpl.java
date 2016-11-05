package com.mastercard;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class ShoppingCartManagerImpl implements ShoppingCartManager {

    private PromoManager promoManager;

    public ShoppingCartManagerImpl(PromoManagerImpl promoManager) {
        this.promoManager = promoManager;
    }

    @Override
    public double calculate(ShopingCart shopingCart) {
        for (Promotion p : promoManager.getAllPromotions()) {
            p.applyPromo(shopingCart);
        }
        return shopingCart.getTotal();
    }

    @Override
    public void checkout(ShopingCart shopingCart) {
        shopingCart.checkOut();
    }

    @Override
    public void addListener(ShoppintCartListener listener) {

    }

}
