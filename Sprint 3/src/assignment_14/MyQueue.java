package assignment_14;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    private List<QueueElement> l = new ArrayList<>();

    public int size() {
        return l.size();
    }

    public synchronized void put(QueueElement obj) {
        System.out.println("Putting " + obj.getText());
        int p = Thread.currentThread().getPriority();
        int i;

        for (i = size() - 1; i >= 0 && p > l.get(i).pri; i--) ;
        {
            l.add(i + 1, obj);
            notify();
        }
    }

    public synchronized QueueElement take() {
        while (l.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        QueueElement e = l.get(0);
        l.remove(0);
        return e;
    }

    public void printQueue() {
        l.forEach(o -> System.out.println(o.getText()));
    }
}

