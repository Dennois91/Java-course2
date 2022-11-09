package assignment_13;

public class Medicin extends Thread {

    String medsName;
    int intervall;

    public Medicin(String medsName, int intervall) {
        this.medsName = medsName;
        this.intervall = intervall;
    }

    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(intervall);
                System.out.println("Time to take you're "+medsName);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
