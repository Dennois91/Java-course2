package assignment_10;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public Main() {


        String[] options = {"Toronto", "Stockholm", "Ho Chi Minh" ,"Shanghai"};
        int choice;
        boolean run = true;
        while (run) {
            choice = JOptionPane.showOptionDialog(null, "Choose location to check time",
                    "Options",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);

            switch (choice) {
                case -1 -> run = false;
                case 0 -> toronto();
                case 1 -> stockholm();
                case 2 -> ho_chi_minh();
                case 3 -> shanghai();

            }
        }
    }

    public void toronto() {
        ZoneId toronto = ZoneId.of("America/Toronto");
        LocalDateTime now = LocalDateTime.now(toronto);
        String tid;
        tid = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Toronto: " + tid);
    }

    public void stockholm() {
        LocalDateTime now = LocalDateTime.now();
        String tid;
        tid = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Stockholm: " + tid);
    }

    public void shanghai() {
        ZoneId shanghai = ZoneId.of("Asia/Shanghai");
        LocalDateTime now = LocalDateTime.now(shanghai);
        String tid;
        tid = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Shanghai: " + tid);

    }
    public void ho_chi_minh() {
        ZoneId ho_chi_minh = ZoneId.of("Asia/Ho_Chi_Minh");
        LocalDateTime now = LocalDateTime.now(ho_chi_minh);
        String tid;
        tid = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Ho Chi Minh: " + tid);

    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}