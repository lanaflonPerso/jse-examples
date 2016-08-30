package core.thread.lock.reentrant;

public class SynchronizedReentrant {
    public static void main(String...args) {
        new SynchronizedReentrant().methodA();
    }

    public synchronized void methodA(){
        System.out.println("SynchronizedReentrant.methodA");
        methodB();
    }

    public synchronized void methodB(){
        System.out.println("SynchronizedReentrant.methodB");
    }
}
