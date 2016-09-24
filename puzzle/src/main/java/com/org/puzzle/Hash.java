package com.org.puzzle;

class Name implements Cloneable {
    private String name;

    Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalize of Sub Class");
        } catch (Throwable t) {
            throw t;
        } finally {
            System.out.println("Calling finalize of Super Class");
            super.finalize();
        }

    }

}

public class Hash {

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String...args) throws CloneNotSupportedException {
        Name name = new Name("Himansu");
        System.out.println(name);
        System.out.println(name.hashCode());
        name.clone();

    }
}
