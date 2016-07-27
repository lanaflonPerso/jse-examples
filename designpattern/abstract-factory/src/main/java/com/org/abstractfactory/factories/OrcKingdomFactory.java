package com.org.abstractfactory.factories;

import com.org.abstractfactory.impl.OrcArmy;
import com.org.abstractfactory.impl.OrcCastle;
import com.org.abstractfactory.impl.OrcKing;
import com.org.abstractfactory.interfaces.Army;
import com.org.abstractfactory.interfaces.Castle;
import com.org.abstractfactory.interfaces.King;
import com.org.abstractfactory.interfaces.KingdomFactory;

/**
 * 
 * Concrete factory.
 * 
 */
public class OrcKingdomFactory implements KingdomFactory {

    public Castle createCastle() {
        return new OrcCastle();
    }

    public King createKing() {
        return new OrcKing();
    }

    public Army createArmy() {
        return new OrcArmy();
    }

}
