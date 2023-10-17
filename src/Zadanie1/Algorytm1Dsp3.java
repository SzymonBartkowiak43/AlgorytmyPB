package Zadanie1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Algorytm1Dsp3 {
    public static void main(String[] args) {


        int[] tab = new int[0];
        String inputFile = "liczby.txt";
        String outputFile= "koncowyWynik.txt";
        int number;
        int liczbaOperacji = 0;

        try (BufferedReader czytnik = new BufferedReader(new FileReader(inputFile))) {
            String line = czytnik.readLine();
            number = Integer.parseInt(line);
            tab = new int[number];
            int licznik = 0;
            int lastPosition = -1;

            while ((line = czytnik.readLine()) != null) {
                number = Integer.parseInt(line);

                for(int i = 0; i < tab.length; i++) {
                    liczbaOperacji++;
                    if(i == lastPosition) {
                        continue;
                    }
                    if(tab[i] == number) {
                        number *= 2;
                        tab[i] = 0;
                        lastPosition = i;
                        i = -1;
                    }
                }
                    tab[licznik] = number;
                    licznik++;
                    lastPosition = -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Błąd");
        }

        int endTabLength = 0;
        for(int numberr:tab) {
            if(numberr != 0)  {
                System.out.print(numberr + ", ");
                endTabLength++;
            }
        }

        try (FileWriter fw = new FileWriter(outputFile, false)) {
            fw.write(endTabLength + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Liczba Operacji: " + liczbaOperacji);
    }
}
