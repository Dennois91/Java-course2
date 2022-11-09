package assignment_14;

public class Producer implements Runnable {

    public Thread activity = new Thread(this);
    private int time;
    private MyQueue queue;
    private int prio;
    private QueueElement elem;

    public Producer(String s, int time, MyQueue queue, int prio) {
        this.time = time * 1000;
        this.queue = queue;
        this.prio = prio;
        elem = new QueueElement(s,prio);
    }

    @Override
    public void run() {
        activity.setPriority(prio);
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(time);
                queue.put(elem);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
