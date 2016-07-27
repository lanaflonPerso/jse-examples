package core.designpattern.creation.prototype;

public class Vegetables implements Prototype {

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Vegetables) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        return this.getClass() == object.getClass();
    }

}
