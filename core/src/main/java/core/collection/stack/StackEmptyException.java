package core.collection.stack;

public class StackEmptyException extends RuntimeException {

    private static final long serialVersionUID = -6818418718299911144L;

    public StackEmptyException() {
        super();
    }

    public StackEmptyException(String message) {
        super(message);
    }

    public StackEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}