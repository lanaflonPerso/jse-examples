package core.innerclass;

/**
 * Created by ehimnay on 13/06/2016.
 */
public class Main {
    public static void main(String...args) {
        InnerClassExt extension = new InnerClassExt(new OuterClass("main"), "nested");
    }
}