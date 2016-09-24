package core.thread.atomic;

public class NonAtomicMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        NonAtomicThread pt = new NonAtomicThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processing count=" + pt.getCount());

    }

}
