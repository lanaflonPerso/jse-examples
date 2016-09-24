package core.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializableClassMain {
    public static void main(String...args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        SerializableClass serialiazableObject = (SerializableClass) ois.readObject();
        System.out.println(serialiazableObject);
    }
}