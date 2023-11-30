package Zadanie3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.exit;

public class Algorytm3spA {
    public static void main(String[] args) {
        Path path = Paths.get("src/Zadanie3/Zadanie3AWejsciowy.txt");
        String tym[];
        int [][]puszki;
        List<Integer> rury = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(path);

            int size = Integer.parseInt(lines.get(0));
            puszki = new int[size][2];
            lines.remove(0);
            //wczytuje puszki
            for(int i =0;i < size;i++) {
                tym = lines.get(0).split(" ");
                lines.remove(0);
                puszki[i][0] = (int)(Math.pow(2,Double.parseDouble(tym[0])));
                puszki[i][1] = Integer.parseInt(tym[1]);
            }

            lines.remove(0);
            for(String line: lines) {
                tym = line.split(" ");
                for(int i = 0; i < Integer.parseInt(tym[1]);i++) {
                    rury.add((int)(Math.pow(2,Double.parseDouble(tym[0]))));
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        Wypisz wypisz = new Wypisz();
        Collections.sort(rury);
        int max = 0;
        int liczbaPuszek;

        for (int rozmiarRury : rury) {
            int aktualnyMaksRury = 0;
            liczbaPuszek = puszki.length;
            int[][] tab = new int[liczbaPuszek + 1][rozmiarRury + 1];

            for (int i = 0; i <= rozmiarRury; i++)
                tab[0][i] = 0;
            for (int i = 0; i <= liczbaPuszek; i++)
                tab[i][0] = 0;

            for (int j = 1; j <= rozmiarRury; j++) {
                int wysokoscPuszki = puszki[0][0];
                int wartoscPuszki = puszki[0][1];
                if (wysokoscPuszki <= rozmiarRury && wysokoscPuszki <= j) {
                    tab[1][j] = wartoscPuszki;
                }
            }

            for (int i = 2; i <= liczbaPuszek; i++) {
                int wysokoscPuszki = puszki[i-1][0];
                int wartoscPuszki = puszki[i-1][1];

                for (int j = 1; j <= rozmiarRury; j++) {
                    if ( j < wysokoscPuszki) {
                        tab[i][j] = tab[i-1][j];
                    } else {
                        tab[i][j] = Math.max(wartoscPuszki + tab[i - 1][j - wysokoscPuszki], tab[i - 1][j]);
                    }
                }
            }
            max += tab[liczbaPuszek][rozmiarRury];


            if(tab[liczbaPuszek][rozmiarRury-1] == tab[liczbaPuszek][rozmiarRury]) {
                System.out.println("NIE");
                exit(0);
            }


            while(liczbaPuszek != 0 || rozmiarRury != 0) {
                if(tab[liczbaPuszek][rozmiarRury] == tab[liczbaPuszek-1][rozmiarRury]) {
                    liczbaPuszek--;
                } else {
                    rozmiarRury -= puszki[liczbaPuszek-1][0];
                    puszki[liczbaPuszek-1][0] = 0;
                    puszki[liczbaPuszek-1][1] = 0;
                }
            }
            wypisz.print(tab);
            System.out.println();
        }
        System.out.println(max);
    }
}
