package assignment_9;

public class MainProgram {

    public MainProgram() {

      for (RomanLetters letters : RomanLetters.values()){
          System.out.println(letters + " is " + letters.getValue());
      }

    }

    public static void main(String[] args) {
        MainProgram mainProgram = new MainProgram();

    }
}

/*
Uppgift 9 – Enums
De romerska siffrorna anges med bokstäverna I, V, X, L, C, D och M som står för 1, 5, 10, 50, 100,
500 resp. 1000.
Deklarera en uppräkningstyp Romersksiffra som innehåller uppräkningsvärdena I, V, X, L, C, D och
M. För varje uppräkningsvärde ska det finnas en instansvariabel som innehåller motsvarande
siffervärde.
I ditt huvudprogram, iterera över konstanterna i uppräkningen och skriv ut vad varje romersk siffra har
för värde.
 */