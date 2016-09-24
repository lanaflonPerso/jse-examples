package core.callbyvalue;

/**
 * http://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value.
 */
public class CallByValue {

    public static void main(String...args) {
        Dog dog = new Dog("Max");

        System.out.println(dog.getName());
        changeReference(dog);
        System.out.println(dog.getName());

        if (dog.getName().equals("Max")) {
            System.out.println("Java passes by value.");

        } else if (dog.getName().equals("Tommy")) {
            System.out.println("Java passes by reference.");
        }
    }

    public static void changeReference(Dog dog) {
        dog = new Dog("Tommy");
    }
}
