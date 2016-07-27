package core.thread.factory;

public class ThreadFactoryMain {

    public static void main(String... strings) {
        Task task = new Task();
        Factory factory = new Factory();
        System.out.println("Inside : " + Thread.currentThread().getName());
        for (int i = 1; i <= 10; i++) {
            Thread thread = factory.newThread(task);
            thread.start();
        }
    }

}