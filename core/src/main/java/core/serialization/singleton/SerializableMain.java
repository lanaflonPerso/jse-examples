package core.serialization.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableMain {

    /**
     * /**
     * 
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static void main(String...args) throws IOException, ClassNotFoundException {
        Singleton singleton = Singleton.getInstance();

        serialized(singleton);
        Singleton singletonA = deSerialized();
        Singleton singletonB = deSerialized();

        System.out.println("singleton : " + singleton.getInstance());
        System.out.println("singletonA : " + singletonA.getInstance());
        System.out.println("singletonB : " + singletonB.getInstance());
        System.out.println("singleton reference : " + singleton);
        System.out.println("singletonA reference : " + singletonA);
        System.out.println("singletonB reference : " + singletonB);
    }

    private static void serialized(Singleton singleton) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("connFactory.ser"));
        oos.writeObject(singleton);
        oos.close();

    }

    private static Singleton deSerialized() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("connFactory.ser"));
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();
        return singleton;
    }

}