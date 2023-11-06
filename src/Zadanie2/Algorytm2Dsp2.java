package Zadanie2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Algorytm2Dsp2 {
    public static void main(String[] args) {

        int tab[][] = new int[0][];
        List<Punkt> punkty = new ArrayList<>();
        int liczbaOperacji = 0;
        String [] tym;
        Path path = Paths.get("szymonBartkowiakPS1.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            tab = new int[Integer.parseInt(lines.get(0))][2];
            int i = 0;
            for(String line : lines) {
                tym = line.split(" ");
                tab[i][0] = Integer.parseInt(tym[0]);
                tab[i][1] = Integer.parseInt(tym[1]);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e ){
            //
        }
        //Algorytm dziel i zwyciezaj
        int[][] tabX = tab.clone();
    }
}
