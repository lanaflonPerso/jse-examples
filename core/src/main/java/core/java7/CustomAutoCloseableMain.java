package core.java7;

public class CustomAutoCloseableMain {

    public static void main(String...args) {
        try (CustomAutoCloseable cac = new CustomAutoCloseable()) {
            cac.accessResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}