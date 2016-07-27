package core.generic;

/**
 * Created by ehimnay on 01/12/2015.
 */
public class GenericClassMain<T> {
    Class theClass = null;

    public GenericClassMain(Class theClass) {
        this.theClass = theClass;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return (T) this.theClass.newInstance();
    }
}
