package assignment_13;

import java.util.Scanner;

public class Main {

    public Main() throws InterruptedException {
        System.out.println("Name your medicine");
        Scanner sc = new Scanner(System.in);
        String medsName = sc.nextLine();
        System.out.println("how many times a minute to take meds?");
        int medsIntervall = sc.nextInt();
        sc.nextLine();
        medsIntervall = 60000 / medsIntervall;
        Medicin meds = new Medicin(medsName.trim(), medsIntervall);

        System.out.println("Name of next medicine");
        medsName = sc.nextLine();
        System.out.println("times a minute to take medicine?");
        medsIntervall = sc.nextInt();
        medsIntervall = 60000 / medsIntervall;
        Medicin meds2 = new Medicin(medsName.trim(), medsIntervall);

        meds.start();
        meds2.start();
        Thread.sleep(10000);
        meds.interrupt();
        meds2.interrupt();

    }

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
    }
}
