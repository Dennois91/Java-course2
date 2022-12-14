package assignment_6abcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cashier {

    int price;
    int pricePaid;

    int change;

    protected final Money token1000 = new Money(1000, "sedel");
    protected final Money token500 = new Money(500, "sedel");
    protected final Money token200 = new Money(200, "sedel");
    protected final Money token100 = new Money(100, "sedel");
    protected final Money token50 = new Money(50, "sedel");
    protected final Money token20 = new Money(20, "sedel");
    protected final Money token10 = new Money(10, "krona");
    protected final Money token5 = new Money(5, "krona");
    protected final Money token2 = new Money(2, "krona");
    protected final Money token1 = new Money(1, "krona");

    protected final List<Money> money = new ArrayList<>(Arrays.asList
            (token1000, token500, token200, token100, token50, token20, token10, token5, token2, token1));
    protected List<Money> moneyBack = new ArrayList<>();


    public Cashier(int price, int pricePaid) {
        this.price = price;
        this.pricePaid = pricePaid;
    }

    public int calculateChange() {
        change = pricePaid - price;
        return change;
    }

    public List<Money> cashBack(int change) {

        while (change >= 1000) {
            change = change - token1000.value;
            moneyBack.add(token1000);
        }
        while (change >= 500) {
            change = change - token500.value;
            moneyBack.add(token500);
        }
        while (change >= 200) {
            change = change - token200.value;
            moneyBack.add(token200);
        }
        while (change >= 100) {
            change = change - token100.value;
            moneyBack.add(token100);
        }
        while (change >= 50) {
            change = change - token50.value;
            moneyBack.add(token50);
        }
        while (change >= 20) {
            change = change - token20.value;
            moneyBack.add(token20);
        }
        while (change >= 10) {
            change = change - token10.value;
            moneyBack.add(token10);
        }
        while (change >= 5) {
            change = change - token5.value;
            moneyBack.add(token5);
        }
        while (change >= 2) {
            change = change - token2.value;
            moneyBack.add(token2);
        }
        while (change >= 1) {
            change = change - token1.value;
            moneyBack.add(token1);
        }
        return moneyBack;
    }

    public int[] countBills(List<Money> change) {
        int countedBills[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(Money bill : change){
            if (bill.value == 1000){
                countedBills[0]++;
            }
            if (bill.value == 500){
                countedBills[1]++;
            }
            if (bill.value == 200){
                countedBills[2]++;
            }
            if (bill.value == 100){
                countedBills[3]++;
            }
            if (bill.value == 50){
                countedBills[4]++;
            }
            if (bill.value == 20){
                countedBills[5]++;
            }
            if (bill.value == 10){
                countedBills[6]++;
            }
            if (bill.value == 5){
                countedBills[7]++;
            }
            if (bill.value == 2){
                countedBills[8]++;
            }
            if (bill.value == 1){
                countedBills[9]++;
            }
        }
        return countedBills;
    }


}
/*
Innan du s??tter ig??ng, fundera ??ver vad som m??ste h??nda:
??? Du m??ste r??kna ut v??xeln (utifr??n pris och l??mnade pengar)
??? Du m??ste h??lla reda p?? vilka val??rer som finns
??? Rekommendation ??r att l??gga dessa v??rden i en lista som du itererar ??ver n??r du r??knar ut
hur mycket av varje val??r som ska ges tillbaka
??? Du m??ste r??kna ut hur m??nga enheter av en val??r som ska ges i v??xeln
??? N??r du har r??knat ut hur m??nga antal (y) av val??r x som ska ges i v??xel m??ste du subtrahera
dessa fr??n v??xeln inf??r n??sta iteration Ex: antag att v??xeln ??r 654, d?? ska du ge 6st 100-
lappar, sen m??ste du dra av 600 innan du r??knar ut hur m??nga 50-lappar som ska ges
*/
