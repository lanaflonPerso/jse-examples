package core.java7;

public class CustomAutoCloseable implements AutoCloseable {

    public void accessResource() {
        System.out.println("Access Resource");
    }

    @Override
    public void close() throws RuntimeException {
        System.out.println("Resource close succefully");

    }

}
