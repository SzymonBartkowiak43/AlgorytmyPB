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
        Wypisz wypisz = new Wypisz();
        MergeS merge = new MergeS();
        merge.mergeSort(godzinyZajete,0,godzinyZajete.length-1,1);
        wypisz.print(godzinyZajete);

        int []tab = new int[25];
        Arrays.fill(tab,0);
        int poczatek = 0;
        int koniec = 0;

        for(int i = 0; i < godzinyZajete.length; i++) {

            poczatek = godzinyZajete[i][0];
            koniec = godzinyZajete[i][1];

            ///jest lipa


        }

        for(int liczba: tab) {
            System.out.print(liczba+ " ");
        }



    }

}
