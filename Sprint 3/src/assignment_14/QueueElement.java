package assignment_14;

public class QueueElement {
    protected String text;
    protected int pri;

    public QueueElement(String text, int pri) {
        this.text = text;
        this.pri = pri;
    }

    public String getText() {
        return text;
    }

    public int getPri() {
        return pri;
    }
}
