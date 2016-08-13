package core.designpattern.creation.singleton;

//Variant 1
public enum SingletonVariantMain {
    SINGLETON;
    public static void main(String...args) {
        SingletonVariantMain.SINGLETON.print();
    }

    public boolean print() {
        System.out.println("Singleton using Enum");
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

    public static void main(String... args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Inside print Singleton");
    }
}

// Variant 3
class SingletonLazyInitialization {
    private static SingletonLazyInitialization singleton;

    public static SingletonLazyInitialization getSingletonInstance() {
        if (null == singleton) {
            singleton = new SingletonLazyInitialization();
        }
        return singleton;
    }

    public static void main(String... args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Inside print Singleton");
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

    public static void main(String... args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Inside print Singleton");
    }
}

// Variant 5
class SingletonBillPugh {
    private SingletonBillPugh() {

    }

    public static SingletonBillPugh getSingletonInstance() {
        return NestedClass.instance;
    }

    public static void main(String... args) {
        getSingletonInstance().print();
    }

    public void print() {
        System.out.println("Inside print Singleton");
    }

    static class NestedClass {

        static final SingletonBillPugh instance = new SingletonBillPugh();

        NestedClass() {
        }
    }

}