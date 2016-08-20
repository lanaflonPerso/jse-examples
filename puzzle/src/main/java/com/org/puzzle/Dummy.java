package com.org.puzzle;

public class Dummy {
    private String name;

    public Dummy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * @Override public int hashCode() { System.out.println("Inside hashCode()"); final int prime = 31; int result = 1;
     * result = prime * result + ((name == null) ? 0 : name.hashCode()); return result; }
     */

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Inside equal()");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dummy other = (Dummy) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
