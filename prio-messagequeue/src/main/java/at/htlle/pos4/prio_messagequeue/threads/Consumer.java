package at.htlle.pos4.prio_messagequeue.threads;

import at.htlle.pos4.prio_messagequeue.PriorityMessageQueue;
import at.htlle.pos4.prio_messagequeue.data.Message;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends Thread {
    private final PriorityMessageQueue queue;
    private String name;

    public Consumer(String name, PriorityMessageQueue queue) {
        super(name);
        this.name = name;
        this.queue = queue;
    }

    // Produce at random time Messages
    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5001));
            Message msg = queue.receiveMessage();
            System.out.printf("%s : Message received: %s\n", this.name, msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
