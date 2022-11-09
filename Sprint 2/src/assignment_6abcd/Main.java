package assignment_6abcd;

import java.util.List;

public class Main {

    public Main(boolean test) {

        if (test) {
            int change;
            List<Money> allChange;

            PrintNice printNice = new PrintNice();
            Cashier cashier = new Cashier(2469, 4440);

            change = cashier.calculateChange();
            allChange = cashier.cashBack(change);
            System.out.println(change + " Total växel");

            printNice.setTokens(cashier.money);
            printNice.setCountedBills(cashier.countBills(allChange));

            printNice.printtokens();
        }
        else System.out.println("hehe");
    }

    public static void main(String[] args) {
        Main main = new Main(true);
    }
}
/*
Innan du sätter igång, fundera över vad som måste hända:
• Du måste räkna ut växeln (utifrån pris och lämnade pengar)
• Du måste hålla reda på vilka valörer som finns
• Rekommendation är att lägga dessa värden i en lista som du itererar över när du räknar ut
hur mycket av varje valör som ska ges tillbaka
• Du måste räkna ut hur många enheter av en valör som ska ges i växeln
• När du har räknat ut hur många antal (y) av valör x som ska ges i växel måste du subtrahera
dessa från växeln inför nästa iteration Ex: antag att växeln är 654, då ska du ge 6st 100-
tokenar, sen måste du dra av 600 innan du räknar ut hur många 50-tokenar som ska ges

Skriv ett program som beräknar hur mycket växel som ska ges tillbaka.
Indata till programmet är det pris man ska betala samt det belopp man betalar med. Läs och skriv
till/från kommandoraden.
man ska få tillbaka utifrån, av användaren, givna belopp.
Växeln ska alltid innehålla så mycket som möjligt av högsta möjliga valörer
Skriv helst testerna först, koden sen. Om det känns väldigt svårt är det bättre att fuska med detta än att
inte skriva nån kod alls

Alla dessa punkter lämpar sig väl för att skriva enhetstester på!!!
 */