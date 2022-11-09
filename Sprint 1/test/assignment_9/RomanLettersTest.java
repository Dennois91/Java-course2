package assignment_9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanLettersTest {

    int I = RomanLetters.I.getValue();
    int V = RomanLetters.V.getValue();
    int X = RomanLetters.X.getValue();
    int L = RomanLetters.L.getValue();
    int C = RomanLetters.C.getValue();
    int D = RomanLetters.D.getValue();
    int M = RomanLetters.M.getValue();


    @Test
    public final void getValue() {
        assert I == 1;
        assert I != 2;
        assert V == 5;
        assert V != 6;
        assert X == 10;
        assert X != 11;
        assert L == 50;
        assert L != 51;
        assert C == 100;
        assert C != 101;
        assert D == 500;
        assert D != 501;
        assert M == 1000;
        assert M != 1001;



    }
}