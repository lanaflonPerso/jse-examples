package core.collection.queue.circular;

public class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = -7305590664701566439L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

    public QueueFullException(String message, Throwable cause) {
        super(message, cause);
    }
}