package core.serialization;

import java.io.*;

class Employee implements Serializable {
    private int id;
    private String username;
    private String email;

    public Employee(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        //	    out.defaultWriteObject();
        out.writeInt(id);
        out.writeObject(username);
        out.writeObject(email);
    }

    public void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        id = in.readInt();
        username = (String) in.readObject();
        email = (String) in.readObject();
    }

}

public class SerializationMain {

    public static void main(String...args) throws IOException, ClassNotFoundException {
        Employee person = new Employee();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("testfile"));
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fis = new FileInputStream("testfile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee person2 = (Employee) ois.readObject();
        ois.close();

        System.out.println("username: " + person.getUsername());

    }

}
