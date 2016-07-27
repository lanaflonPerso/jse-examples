package core.annotation;

public class AnnotatedImpl {
    @Annotated(name = "Himansu")
    public void get(String param) {
        System.out.println("This is " + param);
    }
}
