package com.org.serviceloader;

public class HelloWorldImpl implements Greeting {

    /**
     * Add default constructor only if you already define another constructor. public parameterless constructor needed
     * for creating new instance via reflection service.cast(Class.forName(cn, true, loader).newInstance());
     */
    /*
     * public HelloWorldImpl() {
     * 
     * }
     */

    @Override
    public String greeting() {
        return "Hello World";
    }
}
