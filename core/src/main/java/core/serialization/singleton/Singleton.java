package core.serialization.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable {

    private static Singleton INSTANCE;

    private Singleton() {
    }

    /**
     * Static method for fetching the instance
     * 
     * @return
     */
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null)
                    INSTANCE = new Singleton();
            }
        }

        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}