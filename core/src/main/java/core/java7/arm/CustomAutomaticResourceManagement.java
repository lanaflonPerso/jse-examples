package core.java7.arm;

public class CustomAutomaticResourceManagement implements AutoCloseable {
    public void CustomAutomaticResourceManagement() {
        System.out.println("Accessing the resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("CustomResource closed automatically arm");
    }
}