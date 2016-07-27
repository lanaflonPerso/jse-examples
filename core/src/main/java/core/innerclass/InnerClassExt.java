package core.innerclass;

/**
 * Created by ehimnay on 13/06/2016.
 */
public class InnerClassExt extends OuterClass.InnerClass {
    public InnerClassExt(OuterClass outerClass, String nestedValue) {
        outerClass.super(nestedValue);
        System.out.println("InnerClassExt: " + nestedValue);
    }
}