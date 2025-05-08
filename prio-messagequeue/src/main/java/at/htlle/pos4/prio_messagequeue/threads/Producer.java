package at.htlle.pos4.prio_messagequeue.threads;

import at.htlle.pos4.prio_messagequeue.PriorityMessageQueue;
import at.htlle.pos4.prio_messagequeue.data.Message;
import java.util.concurrent.ThreadLocalRandom;

public class Producer extends Thread {
    private final PriorityMessageQueue queue;
    private String name;
    private boolean isPriority;

    public Producer(String name, PriorityMessageQueue queue, boolean isPriority) {
        super(name);
        this.name = name;
        this.queue = queue;
        this.isPriority = isPriority;
    }

    // Produce at random time Messages
    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5001));
            Message msg = new Message(isPriority, ThreadLocalRandom.current().nextInt(100) + "");
            queue.sendMessage(msg);
            System.out.printf("%s : Message sent: %s\n", this.name, msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
