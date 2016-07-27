package com.org.abstractfactory.factories;

import com.org.abstractfactory.impl.ElfArmy;
import com.org.abstractfactory.impl.ElfCastle;
import com.org.abstractfactory.impl.ElfKing;
import com.org.abstractfactory.interfaces.Army;
import com.org.abstractfactory.interfaces.Castle;
import com.org.abstractfactory.interfaces.King;
import com.org.abstractfactory.interfaces.KingdomFactory;

/**
 * 
 * Concrete factory.
 * 
 */
public class ElfKingdomFactory implements KingdomFactory {

    public Castle createCastle() {
        return new ElfCastle();
    }

    public King createKing() {
        return new ElfKing();
    }

    public Army createArmy() {
        return new ElfArmy();
    }

}
