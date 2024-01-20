package Zadanie5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int komnatyN, korytarzeM, wejsciowaW, ksiezniczkaK, pieniadzeS;
        List<Integer> koszt = new ArrayList<>();
        int[][] tab;
        try {
            Path path = Paths.get("src/Zadanie5/input.txt");
            List<String> lines = Files.readAllLines(path);
            String []  firstLine= lines.get(0).split(" ");
            komnatyN = Integer.parseInt(firstLine[0]);
            korytarzeM = Integer.parseInt(firstLine[1]);
            wejsciowaW = Integer.parseInt(firstLine[2]);
            ksiezniczkaK = Integer.parseInt(firstLine[3]);
            pieniadzeS = Integer.parseInt(firstLine[4]);

            String [] secondLine = lines.get(1).split(" ");
            for(String wartosc: secondLine) {
                koszt.add(Integer.parseInt(wartosc));
            }

            tab = new int [secondLine.length][secondLine.length];
            for (int i = 2; i < lines.size(); i++) {
                String[] korytarzLine = lines.get(i).split(" ");
                int x = Integer.parseInt(korytarzLine[0]) -1;
                int y = Integer.parseInt(korytarzLine[1]) -1;

                tab[x][y] = koszt.get(x);
                tab[y][x] = koszt.get(y);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
