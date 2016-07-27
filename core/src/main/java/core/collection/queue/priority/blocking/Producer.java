package core.collection.queue.priority.blocking;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

/*
 * Producer produces message and put it in the PriorityBlockingQueue
 */
public class Producer implements Runnable {

    final PriorityBlockingQueue<Integer> pbq;

    private Random random = new Random();

    public Producer(PriorityBlockingQueue<Integer> pbq) {
        this.pbq = pbq;
    }

    @Override
    public void run() {
        // produce messages
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(i);
                pbq.put(random.nextInt(100));
                System.out.println("Producer " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}