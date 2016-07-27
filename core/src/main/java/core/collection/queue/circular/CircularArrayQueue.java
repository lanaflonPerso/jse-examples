package core.collection.queue.circular;

public class CircularArrayQueue {

    private static final int DEFAULT_SIZE = 2;
    private final int size;
    private int front = -1;
    private int rear = -1;
    private Object[] queue;

    public CircularArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularArrayQueue(int capacity) {
        size = capacity;
        queue = new Object[size];
    }

    public int size() {
        if (rear > front)
            return rear - front;
        return size - (front + rear);
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1) || (rear < front) ? true : false;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear == front - 1) ? true : false;
    }

    public void enqueue(Object element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Queue is Full.");
        } else {
            if (rear == -1 && front == -1)
                front = rear = 0;
            else
                rear++;
            if (rear == size)
                rear = 0;
            queue[rear] = element;
        }
    }

    public Object dequeue() throws QueueEmptyException {
        Object item;
        if (isEmpty()) {
            throw new QueueEmptyException();
        } else {
            item = queue[front];
            front++;
            if (front == rear + 1)
                front = rear = -1;
            if (front == size) {
                front = 0;
            }
            return item;
        }
    }

}