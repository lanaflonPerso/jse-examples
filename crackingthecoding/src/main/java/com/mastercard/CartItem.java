package com.mastercard;

import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class CartItem {

    private Item item;
    private List<Promotion> appliedPromos;
    private boolean markedForPromo;

    public CartItem(Item item) {
        this.item = item;
    }

    public void markedForPromo(Promotion promotion) {
        markedForPromo = true;
        appliedPromos.add(promotion);
    }

    public boolean isMarkedForPromo() {
        return markedForPromo;
    }

    public void setMarkedForPromo(boolean markedForPromo) {
        this.markedForPromo = markedForPromo;
    }
}
