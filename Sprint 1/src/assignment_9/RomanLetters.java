package assignment_9;

public enum RomanLetters {
    I (1),
    V (5),
    X (10),
    L (50),
    C (100),
    D (500),
    M (1000);

    private final int value;

    RomanLetters(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/*
Uppgift 9 – Enums
De romerska siffrorna anges med bokstäverna I, V, X, L, C, D och M som
står för 1, 5, 10, 50, 100, 500 resp. 1000.
Deklarera en uppräkningstyp Romersksiffra som innehåller uppräkningsvärdena I, V, X, L, C, D och
M. För varje uppräkningsvärde ska det finnas en instansvariabel som innehåller motsvarande
siffervärde.
I ditt huvudprogram, iterera över konstanterna i uppräkningen och skriv ut vad varje romersk siffra har
för värde.
 */
