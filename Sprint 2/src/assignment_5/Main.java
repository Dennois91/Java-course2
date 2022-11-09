package assignment_5;

import static javax.swing.JOptionPane.*;
import java.util.*;

public class Main {
    public static void main(String[] arg) {
        String indata = showInputDialog("Ange antal dagar, pris per dag samt bilmodell");

        int antalDagar = 0;
        double dagsPris = 0;
        String bil = "";
        boolean klar = false;

        while (!klar) {
            if (indata == null) {
                System.exit(0);
            }
            Scanner sc = new Scanner(indata);

            String felText = "";
            try {
                antalDagar = sc.nextInt();
                dagsPris = sc.nextDouble();
                bil = sc.next();
                klar = true;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                felText = "Felaktigt tal!";
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                felText = "Indata saknas";
            } catch (Exception e) {
                e.printStackTrace();
                felText = "Ospecificerat fel";
            }
            if (!klar) {
                indata = showInputDialog(felText + "\nAnge antal dagar, pris per dag samt bilmodell");
            }
        }

        double totPris = dagsPris * antalDagar;
        String s = String.format("Totalt pris för %s: %.2f", bil, totPris);
        showMessageDialog(null, s);
        System.exit(0);
    }
}
/*
  Fel som behöver fångas upp är
• Om användaren skriver in något annat än siffror där programmet läser in int eller double
• Om användaren skriver in för få parametrar och trycker ”OK”.
  Använd exceptions.
*/