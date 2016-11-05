package com.mastercard;

import java.util.List;

/**
 * Created by ehimnay on 9/7/2016.
 */
public interface PromoManager {

    List<Promotion> getAllPromotions();

    void addPromo(Promotion promotion);
}
