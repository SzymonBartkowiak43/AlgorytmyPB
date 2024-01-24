import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BYLECO {
        public static void main(String[] args) {
            int[] tab = new int[8];
            int[][] plansza = new int[2][8];
            int[][] czyOdkryte = new int[2][8];

            for (int i = 0; i < 2; i++) {
                Arrays.fill(czyOdkryte[i], 0);
            }

            Random rand = new Random();
            int licznik = 0;
            int rzad = 0;
            int kolumna = 0;
            int liczba;

            char[] znak = {'1', '2', '3', '4', '5', '6', '7', '8'};

            while (licznik < 16) {
                if (rzad == 1 && kolumna == 8) {
                    break;
                } else if (kolumna == 8) {
                    rzad = 1;
                    kolumna = 0;
                    System.out.println();
                }

                liczba = rand.nextInt(8);
                if (czyOdkryte[rzad][kolumna] != 1) {
                    System.out.print(znak[liczba] + " ");
                } else {
                    System.out.print("X ");
                }
                plansza[rzad][kolumna] = liczba;
                tab[liczba] += 1;
                kolumna++;
                licznik++;
            }
        }
}

