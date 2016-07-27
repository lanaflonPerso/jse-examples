package core.collection.queue.priority.blocking;

import java.util.concurrent.PriorityBlockingQueue;

/*
 * Producer produces message and put it in the PriorityBlockingQueue
 */
public class Consumer implements Runnable {

    final PriorityBlockingQueue<Integer> pbq;

    public Consumer(PriorityBlockingQueue<Integer> pbq) {
        this.pbq = pbq;
    }

    public void run() {
        try {
            Integer task;
            while ((task = pbq.take()) <= 100) {
                Thread.sleep(10);
                System.out.println("Consumed " + task);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}