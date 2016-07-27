package core.collection.queue.circular;

public class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = -7201093476565629016L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

    public QueueEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}