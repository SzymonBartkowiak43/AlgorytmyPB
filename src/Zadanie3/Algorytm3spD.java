package Zadanie3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Algorytm3spD {
    public static void main(String[] args) {
        Path path = Paths.get("src/Zadanie3/Zadanie3DWejsciowy");
        String []tym;
        int [][] godzinyZajete;

        try {
            List<String> lines = Files.readAllLines(path);
            int size = Integer.parseInt(lines.get(0));
            godzinyZajete = new int[size][2];
            lines.remove(0);
            for(int i =0;i < size;i++) {
                tym = lines.get(0).split(" ");
                lines.remove(0);
                godzinyZajete[i][0] = Integer.parseInt(tym[0]);
                godzinyZajete[i][1] = Integer.parseInt(tym[1]);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        MergeS merge = new MergeS();
        merge.mergeSort(godzinyZajete,0,godzinyZajete.length-1,1);

        int []tab = new int[25];
        Arrays.fill(tab,0);
        int poczatek = 0;
        int koniec = 0;
        int dlugosc = 0;
        int godzina = 1;

        for(int i = 0; i < godzinyZajete.length; i++) {
            poczatek = godzinyZajete[i][0];
            koniec = godzinyZajete[i][1];

            dlugosc = koniec-poczatek;

            while(godzina < koniec && godzina-1 >= 0) {
                if(tab[godzina] < tab[godzina-1]) {
                    tab[godzina] = tab[godzina-1];
                }
                godzina++;
            }

            if(tab[godzina-1] > dlugosc + tab[godzina-dlugosc]) {
                tab[godzina] = tab[godzina-1];
            } else {
                tab[godzina] = dlugosc + tab[godzina-dlugosc];
            }
        }
        while(godzina < 25) {
            tab[godzina] = tab[godzina-1];
            godzina++;
        }
        System.out.println(tab[godzina-1]);
    }
}
