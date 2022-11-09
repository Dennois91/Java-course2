package assignment_6abcd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {

    Cashier cashier = new Cashier(100, 5555);
    @Test
    void calculateChange() {
        assert cashier.calculateChange() == 5455;
    }
    @Test
    void cashBack(){
        assert cashier.cashBack(5455).contains(cashier.token1000);
        assert !cashier.cashBack(5455).contains(cashier.token500);
        assert cashier.cashBack(5455).contains(cashier.token200);
        assert cashier.cashBack(5455).contains(cashier.token50);
        assert cashier.cashBack(5455).contains(cashier.token5);
        assert !cashier.cashBack(5455).contains(cashier.token1);
    }
    @Test
    void countBills(){
        int countedBills [] = cashier.countBills(cashier.cashBack(1001));
        assert countedBills[0] == 1;
        assert countedBills[1] != 1;
        assert countedBills.length == 10;
        assert countedBills[9] == 1;

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
lappar, sen måste du dra av 600 innan du räknar ut hur många 50-lappar som ska ges
*/