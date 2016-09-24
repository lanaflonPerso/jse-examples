package com.org.java8;


interface Cat {
    default void meow() {
        System.out.println("Cat.meow");
    }
}

interface Dog {
    default void bark() {
        System.out.println("Dog.bark");
    }
}

public class Type {
    public static void main(String...args) {
        class DogCat implements Dog, Cat {
        }

    }
}


