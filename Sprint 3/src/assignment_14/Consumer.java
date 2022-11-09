package assignment_14;

public class  Consumer implements Runnable {

    public Thread activity = new Thread(this);

    private int time;
    private MyQueue queue;

    public Consumer(int time, MyQueue queue) {
        this.time = time * 1000;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(time);
                QueueElement e = queue.take();
                System.out.println("Consumer took " + e.getText());

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
