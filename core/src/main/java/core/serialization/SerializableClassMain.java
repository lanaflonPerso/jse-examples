package core.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableClassMain {
    public static void main(String...args) throws IOException, ClassNotFoundException {
        ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("test.ser"));
        SerializableClass serialiazableObject = new SerializableClass();
        fos.writeObject(serialiazableObject);
        System.out.println("Serialized succefully");
    }
}
