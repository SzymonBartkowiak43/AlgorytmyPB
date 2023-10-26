package Zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Algorytm1Dsp1 {
    public static void main(String[] args) {

        boolean shouldContinue = true;
        boolean findSomething;
        int[] tab = new int[0];
        String inputFile = "liczby.txt";
        String outputFile= "koncowyWynik.txt";

        int liczbaOperacji = 0;

        try (BufferedReader czytnik = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int tabSize =  Integer.parseInt(czytnik.readLine());
            tab = new int[tabSize];

            while ((line = czytnik.readLine()) != null) {
                int number = Integer.parseInt(line);
                tabSize--;
                tab[tabSize] = number;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Błąd");
        }

        while (shouldContinue) {
            findSomething = false;
            for(int i = 0; i < tab.length; i++) {
                for(int j = 0; j < tab.length; j++) {
                    if(tab[i] == tab[j] && i != j && tab[i] != -2) {
                        tab[i] =  tab[j]*2;
                        tab[j] = -2;
                        findSomething = true;
                    }
                    liczbaOperacji++;
                }
            }
            if(!findSomething) {
                shouldContinue = false;
            }
        }


        int endTabLength = 0;
        for(int number:tab) {
            if(number != -2)  {
                System.out.print(number + ", ");
                endTabLength++;
            }
            liczbaOperacji++;
        }

        try (FileWriter fw = new FileWriter(outputFile, false)) {
            fw.write(endTabLength + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Liczba Operacji: " + liczbaOperacji);

    }
}