/**
 * GC does not invoke finalize() methods. There is separate thread for it in JVM whose single responsibility
 * is to execute finalize() methods for all objects. Objects with finalizers that become eligible
 * for garbage collection are not collected immediately but, with the hotspot JVM, are first put
 * onto a queue where a single finalizer thread(responsibility of JVM) calls the finalizers on each object
 * in the queue in turn.
**/

package core.finalize;

public class FinallyTest {
    public static void main(String...args) {
        FinallyTest finallyTest = new FinallyTest();
        try {
            System.out.println("Inside InterruptThreadMain");

            Runtime.runFinalizersOnExit(true);
            Runtime.getRuntime().runFinalization();
        } finally {
            finallyTest.finalize();
        }
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Inside Finalize");
    }
}
