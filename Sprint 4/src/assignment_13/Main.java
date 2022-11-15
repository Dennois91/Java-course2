package assignment_13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {
    private void Run() throws IOException {

        URL u = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        BufferedReader buf = new BufferedReader(new InputStreamReader(u.openStream()));
        String temp;

        int total = 0;
        int max = 100;

        int[] countOf = new int[max];
        while ((temp = buf.readLine()) != null) {
            int lenght = temp.length();
            countOf[lenght]++;
            total++;
        }
        System.out.println("Number of times words of certain length appear");
        for (int i = 0; i < countOf.length; i++) {
            if (countOf[i] != 0)
                System.out.println(countOf[i]+" Words with length " + i);

        }
        System.out.println("Total number of words = " +total);
    }

    public static void main(String[] args) throws IOException {
        new Main().Run();
    }
}
