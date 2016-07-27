package core.immutable;

import java.util.Date;

/**
 * Why would one declare an immutable class final in Java?
 */
public class Immutable {
    private final int value;
    private final Date date = null;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Date getDate(){
        return new Date(this.date.getTime());
    }
}