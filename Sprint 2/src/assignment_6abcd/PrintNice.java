package assignment_6abcd;

import java.util.List;

public class PrintNice {
    private List<Money> tokens;
    private int countedBills[];

    public void setTokens(List<Money> tokens) {
        this.tokens = tokens;
    }

    public void setCountedBills(int[] countedBills) {
        this.countedBills = countedBills;
    }

    public void printtokens() {
        for (int i = 0; i < countedBills.length; i++) {
            if (countedBills[i] > 0) {
                System.out.println("Antal " + tokens.get(i).value + "-" + tokens.get(i).token +": " + countedBills[i]);
            }
        }
    }
}
