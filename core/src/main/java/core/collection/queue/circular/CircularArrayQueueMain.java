package core.collection.queue.circular;

public class CircularArrayQueueMain {

    public static void main(String...args) {
        CircularArrayQueue queue = new CircularArrayQueue();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        //		queue.enqueue("E");
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        queue.enqueue("E");
        System.out.println(queue.size());
        // queue.enqueue("F");
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }

}