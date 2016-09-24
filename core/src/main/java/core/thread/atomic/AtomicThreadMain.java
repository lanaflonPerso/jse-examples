package core.thread.atomic;

public class AtomicThreadMain {

    /**
     * @param args
     */
    public static void main(String...args) {

        AtomicThread atomicThread = new AtomicThread();
        Thread t1 = new Thread(atomicThread, "t1");
        t1.start();
        Thread t2 = new Thread(atomicThread, "t2");
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Processing count=" + atomicThread.getCount());

    }

}
