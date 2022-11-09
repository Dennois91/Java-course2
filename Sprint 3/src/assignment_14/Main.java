package assignment_14;

import java.util.Scanner;

public class Main {


    private void run() throws InterruptedException {


        MyQueue prodToConsFlow = new MyQueue();
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of producers: ");
        Producer[] p = new Producer[sc.nextInt()];
        for (int i = 0; i < p.length; i++) {
            System.out.println("Producer n" + (i + 1) + ":");
            System.out.println(" Time per item to produce:");
            int time = sc.nextInt();
            System.out.println("Whats being produced?");
            String item = sc.next();
            System.out.println("Prio of producer");
            int prio = sc.nextInt();
            p[i] = new Producer(item, time, prodToConsFlow,prio);
        }

        System.out.println("Number of consumers: ");
        Consumer[] c = new Consumer[sc.nextInt()];
        for (int i = 0; i < c.length; i++) {
            System.out.println("Time between consumer needs: ");
            int time = sc.nextInt();
            c[i]=new Consumer(time,prodToConsFlow);

        }

        for (int i = 0; i < p.length; i++) {
            p[i].activity.start();
        }
        for (int i = 0; i < c.length; i++) {
            c[i].activity.start();
        }

        Thread.sleep(10000);
        System.out.println("Items left in stock: "+prodToConsFlow.size());
        prodToConsFlow.printQueue();
        System.exit(0);

    }

    public static void main(String[] args) throws InterruptedException {
        new Main().run();
    }
}
