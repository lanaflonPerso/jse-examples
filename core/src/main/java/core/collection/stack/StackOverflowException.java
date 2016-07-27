package core.collection.stack;

public class StackOverflowException extends RuntimeException {
    private static final long serialVersionUID = 4335539940905655086L;

    public StackOverflowException() {
        super();
    }

    public StackOverflowException(String message) {
        super(message);
    }

    public StackOverflowException(String message, Throwable cause) {
        super(message, cause);
    }
}