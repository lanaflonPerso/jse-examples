package core.designpattern.creation.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreakSingleton {
    public static void main(String...args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonLazyInitialization singleton = SingletonLazyInitialization.getSingletonInstance();
        singleton.print();
        Constructor[] constructors = SingletonLazyInitialization.class.getDeclaredConstructors();
        for (final Constructor constructor : constructors) {
            constructor.setAccessible(true);
            SingletonLazyInitialization singleton2 = (SingletonLazyInitialization) constructor.newInstance();
            singleton2.print();
        }
    }
}
