package core.casting;

class Animal {
    String name = "Animal";
}

class Mammal extends Animal {
    String name = "Mammal";
}

class Cat extends Mammal {
    String name = "Cat";
}

class Dog extends Mammal {
    String name = "Dog";
}

public class Casting {
    public static void main(String...args) {
        Cat cat = new Cat();
        System.out.println(cat.name);
        Dog dog = new Dog();
        System.out.println(dog.name);

        //upcasting
        Mammal mammal = cat;
        System.out.println(mammal.name);

        //downcasting
        Animal animal = dog;
        if(animal instanceof Dog) {
            dog = (Dog) animal;
        }
        System.out.println(dog.name);
    }
}