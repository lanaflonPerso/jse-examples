package com.org.abstractfactory.interfaces;

/**
 * 
 * The factory interface.
 * 
 */
public interface KingdomFactory {

    Castle createCastle();

    King createKing();

    Army createArmy();

}
