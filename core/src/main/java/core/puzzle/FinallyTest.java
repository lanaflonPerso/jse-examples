package core.puzzle;

public class FinallyTest {
    @SuppressWarnings("deprecation")
    public static void main(String... args) {
        System.out.println("Inside InterruptThreadMain");
        Runtime.runFinalizersOnExit(true);
    }

    public void finalize() {
        System.out.println("Inside Finalize");
    }
}
