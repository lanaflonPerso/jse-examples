package core.java7.arm;

public class CustomAutomaticResourceManagement2 implements AutoCloseable {
    public void CustomAutomaticResourceManagement2() {
        System.out.println("Accessing the resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("CustomResource closed automatically arm2");
    }
}