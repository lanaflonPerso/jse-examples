package core.designpattern.creation.prototype;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;

    boolean equals(Object object);
}
