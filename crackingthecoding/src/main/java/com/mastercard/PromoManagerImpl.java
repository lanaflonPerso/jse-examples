package com.mastercard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public class PromoManagerImpl implements PromoManager {

    List<Promotion> promotions = new ArrayList<>();

    @Override
    public List<Promotion> getAllPromotions() {

        return promotions;
    }

    @Override
    public void addPromo(Promotion promotion) {
        promotions.add(promotion);
    }
}
