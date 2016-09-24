package core.thread.waitnotifynotifyall;

public class WaitNotifyMain {

    public static void main(String...args) {
        Message message = new Message("process it");
        WaitThread waitThread = new WaitThread(message);
        new Thread(waitThread, "firstThread").start();

        WaitThread secondThread = new WaitThread(message);
        new Thread(secondThread, "secondThread").start();

        NotifierThread notifierThread = new NotifierThread(message);
        new Thread(notifierThread, "notifier").start();
    }

}