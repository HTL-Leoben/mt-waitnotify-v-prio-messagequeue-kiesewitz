package at.htlle.pos4.prio_messagequeue;

import at.htlle.pos4.prio_messagequeue.threads.Consumer;
import at.htlle.pos4.prio_messagequeue.threads.Producer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App {
    public static final int QUEUE_SIZE = 30;

    public static void main( String[] args ) {
        PriorityMessageQueue queue = new PriorityMessageQueue(QUEUE_SIZE);

        int totalMessages = (int) Math.round(QUEUE_SIZE * 2);  // doppelte Anzahl der maximalen Messages
        for (int i = 1; i <= totalMessages; i++) {
            boolean isPrio = ThreadLocalRandom.current().nextDouble() < 0.3; // ~30% der Nachrichten sollten Priority haben
            new Producer("Producer-" + i, queue, isPrio).start();
            new Consumer("Consumer-" + i, queue).start();
        }
    }
}
