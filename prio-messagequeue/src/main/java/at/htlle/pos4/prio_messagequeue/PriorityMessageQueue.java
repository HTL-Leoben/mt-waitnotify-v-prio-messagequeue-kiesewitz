package at.htlle.pos4.prio_messagequeue;

import at.htlle.pos4.prio_messagequeue.data.Message;

import java.util.LinkedList;
import java.util.List;

public class PriorityMessageQueue {
    List<Message> messages;
    int capacity;

    public PriorityMessageQueue(int capacity) {
        messages = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void sendMessage(Message msg) throws InterruptedException {
        while(messages.size() == capacity) {
            wait();
        }

        if(msg.isPriority()) {
            int id = 0;
            for(Message m : messages) {
                if(m.isPriority()) {
                    id++;
                }
            }
            messages.add(id, msg);
        } else {
            messages.add(msg);
        }
    }

    public synchronized Message receiveMessage() throws InterruptedException {
        while(messages.isEmpty()) {
            wait();
        }

        Message msg = messages.remove(0);
        return msg;
    }
}
