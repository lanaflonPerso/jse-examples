package core.casting;

interface Animal {
    String name = "Animal";
}

class Mammal implements Animal {
    String name = "Mammal";

    public String getName(){
        return name;
    }
}

class Cat extends Mammal {
    String name = "paspartu";

    public String getName(){
        return name;
    }
}

class Dog extends Mammal {
    String name = "Dingo";

    public String getName(){
        return name;
    }
}

public class Casting {
    public static void main(String...args) {
        Cat cat = new Cat();
        System.out.println(cat.getName());
        Dog dog = new Dog();
        System.out.println(dog.getName());

        //upcasting
        Mammal mammal = cat;
        System.out.println(mammal.getName());

        cat.name = "penelope";
        System.out.println(mammal.getName());

        //downcasting
        Animal animal = dog;
        if(animal instanceof Dog) {
            dog = (Dog) animal;
        }
        System.out.println(dog.getName());
    }
}