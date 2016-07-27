package core.thread.synchronize.method;

public class Message {
    private String message = null;

    public Message(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
