package core.designpattern.creation.prototype;

public class Fruits implements Prototype {

    @Override
    public Fruits clone() throws CloneNotSupportedException {
        return (Fruits) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        return this.getClass() == object.getClass();
    }
}
