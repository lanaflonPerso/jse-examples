package core.collection.infix;

public class StackCustom {

    private static final int DEFAULT_CAPACITY = 10;
    private char[] stackArray;
    private int top;
    private int size;

    public StackCustom(int size) {
        size = size;
        stackArray = new char[DEFAULT_CAPACITY];
        top = -1;
    }

    public StackCustom() {
        this(DEFAULT_CAPACITY);
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}