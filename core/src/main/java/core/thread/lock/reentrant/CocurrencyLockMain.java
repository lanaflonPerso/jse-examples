package core.thread.lock.reentrant;

public class CocurrencyLockMain {
    public static void main(String...args) {
        Resource resource = new Resource();
        new Thread(new ConcurrencyLock(resource)).start();
        new Thread(new ConcurrencyLock(resource)).start();
    }
}