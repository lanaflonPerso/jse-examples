package core.callbyvalue;

/**
 * http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value.
 */
public class CallByValue {

    public static void main(String... args) {
        Dog dog = new Dog("Max");
        foo(dog);

        System.out.println(dog.getName());

        if (dog.getName().equals("Max")) { //true
            System.out.println("Java passes by value.");

        } else if (dog.getName().equals("Fifi")) {
            System.out.println("Java passes by reference.");
        }
    }

    public static void foo(Dog dog) {
        dog.getName().equals("Max"); // true

        //        dog = new Dog("Fifi");
        dog.getName().equals("Fifi"); // true

        dog.setName("Tommy");
    }
}
