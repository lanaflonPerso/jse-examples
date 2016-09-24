package core.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String...args) {
        Person obj3 = new Person("abc");
        Person obj1 = new Person("bcd");
        Person obj2 = new Person("cde");
        Person obj4 = new Person("abc");

        Set<Person> sset = new HashSet<Person>();

        sset.add(obj1);
        sset.add(obj4);
        sset.add(obj4);
        sset.add(obj2);
        sset.add(obj3);

        System.out.println(sset.size());
    }
}

class Person {
    String name;

    Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object arg0) {

        System.out.println("in equals");

        Person obj = (Person) arg0;

        System.out.println("1st " + getName());
        System.out.println("2nd " + obj.getName());

        if (this.getName().equals(obj.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println(" value is " + Integer.valueOf(name.charAt(0)));
        return Integer.valueOf(name.charAt(0));
    }
}
