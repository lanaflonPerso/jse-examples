package core.serialization;

import java.io.*;

class Person implements Externalizable {
    private int id;
    private String username;
    private String email;

    public Person(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Person() {

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(username);
        out.writeObject(email);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        username = (String) in.readObject();
        email = (String) in.readObject();
    }

}

public class ExternalizationMain {

    public static void main(String...args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("testfile"));
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fis = new FileInputStream("testfile");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person2 = (Person) ois.readObject();
        ois.close();

        /*
         * Person person3 = person2; System.out.println(person); System.out.println(person2);
         * System.out.println(person3); System.out.println(person.hashCode()); System.out.println(person2.hashCode());
         * 
         * if (person == person2) { System.out.println("p1 == p2"); }
         * 
         * if (person.hashCode() == person2.hashCode()) { System.out.println("p1 hascode == p2 hashcode"); }
         */

        System.out.println("username: " + person.getUsername());

    }

}
