package core.designpattern.creation.prototype;

public class Flowers implements Prototype {

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Flowers) super.clone();
    }

    @Override
    public boolean equals(Object object) {
        return this.getClass() == object.getClass();
    }

}
