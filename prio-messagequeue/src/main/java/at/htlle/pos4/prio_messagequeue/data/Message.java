package at.htlle.pos4.prio_messagequeue.data;

public class Message {
    boolean isPriority = false;
    String content;

    public Message(boolean priority, String content) {
        this.isPriority = priority;
        this.content = content;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MSG{" +
                "isPriority=" + isPriority +
                ", content='" + content + '\'' +
                '}';
    }
}
