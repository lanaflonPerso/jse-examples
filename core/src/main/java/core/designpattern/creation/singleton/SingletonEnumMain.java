package core.designpattern.creation.singleton;

//Variant 1
public enum SingletonEnumMain {
    SINGLETON;
    private String name = "Singleton Using Enum";


    public static void main(String...args) {
        SingletonEnumMain.SINGLETON.print();
    }

    public boolean print() {
        System.out.println(name);
        return true;
    }

}

// Variant 2
class SingletonEagerInitialization {
    private static final SingletonEagerInitialization singleton = new SingletonEagerInitialization();

    private SingletonEagerInitialization() {
    }

    public static SingletonEagerInitialization getSingletonInstance() {
        return singleton;
    }

    public static void main(String...args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Eager Singleton");
    }
}

// Variant 3
class SingletonLazyInitialization {
    private static SingletonLazyInitialization singleton;

    private SingletonLazyInitialization(){

    }

    public static SingletonLazyInitialization getSingletonInstance() {
        if (null == singleton) {
            singleton = new SingletonLazyInitialization();
        }
        return singleton;
    }

    public static void main(String...args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Lazy Singleton");
    }
}

// Variant 4
class SingletonDoubleCheck {
    private static SingletonDoubleCheck singleton;

    public static SingletonDoubleCheck getSingletonInstance() {
        if (null == singleton) {
            synchronized (SingletonDoubleCheck.class) {
                if (null == singleton) {
                    singleton = new SingletonDoubleCheck();
                }
            }
        }
        return singleton;
    }

    public static void main(String...args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Double Check Lazy Singleton");
    }
}

// Variant 5
class SingletonBillPugh {
    private SingletonBillPugh() {

    }

    public static SingletonBillPugh getSingletonInstance() {
        return NestedClass.singleton;
    }

    public static void main(String...args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("BillPugh Singleton - NestedClass get load only after getSingletonInstance() is called");
    }

    static class NestedClass {
        static final SingletonBillPugh singleton = new SingletonBillPugh();
    }

}