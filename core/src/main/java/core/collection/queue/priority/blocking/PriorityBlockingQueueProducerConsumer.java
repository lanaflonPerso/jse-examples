package core.collection.queue.priority.blocking;

import java.util.concurrent.PriorityBlockingQueue;

/*
 * http://java-latte.blogspot.de/2013/10/priorityblockingqueue-in-java.html
 */
public class PriorityBlockingQueueProducerConsumer {
    public static void main(String...args) {
        final PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>(101,
                ComparatorPriority.sortByPriority);
        Producer producer = new Producer(pbq);
        Thread producerThread1 = new Thread(producer);
        producerThread1.setName("Producer Thread 1");
        producerThread1.start();

        Thread producerThread2 = new Thread(producer);
        producerThread2.setName("Producer Thread 2");
        producerThread2.start();

        Thread producerThread3 = new Thread(producer);
        producerThread3.setName("Producer Thread 3");
        producerThread3.start();

        Consumer consumer = new Consumer(pbq);
        Thread consumerThread1 = new Thread(consumer);
        consumerThread1.setName("Consumer Thread 1");
        consumerThread1.start();

        Thread consumerThread2 = new Thread(producer);
        consumerThread2.setName("Consumer Thread 2");
        consumerThread2.start();

        Thread consumerThread3 = new Thread(producer);
        consumerThread3.setName("Consumer Thread 3");
        consumerThread3.start();
        System.out.println("Producer and Consumer Threads has been started");
    }
}
