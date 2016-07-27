package core.innerclass;

/**
 * Created by ehimnay on 13/06/2016.
 */
public class OuterClass {
    public OuterClass(String value) {
        System.out.println("OuterClass: " + value);
    }

    public class InnerClass {

        public InnerClass(String nestedValue) {
            System.out.println("InnerClass: " + nestedValue);
        }
    }
}
