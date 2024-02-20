package Zadanie5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//robienie w sql


public class Main {
    public static void main(String[] args) {
        int komnatyN, korytarzeM, wejsciowaW, ksiezniczkaK, pieniadzeS;
        List<Integer> koszt = new ArrayList<>();
        int[][] tabSasiadow;
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

            tabSasiadow = new int [secondLine.length][secondLine.length];
            for (int i = 2; i < lines.size(); i++) {
                String[] korytarzLine = lines.get(i).split(" ");
                int x = Integer.parseInt(korytarzLine[0]) -1;
                int y = Integer.parseInt(korytarzLine[1]) -1;

                tabSasiadow[x][y] = koszt.get(x);
                tabSasiadow[y][x] = koszt.get(y);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < tabSasiadow.length; i++) {
            for (int j = 0; j < tabSasiadow[i].length; j++) {
                System.out.print(tabSasiadow[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> sciezka = new ArrayList<>();
        System.out.println(zwrocCzyMożliwe(tabSasiadow,wejsciowaW,ksiezniczkaK,pieniadzeS -koszt.get(wejsciowaW-1),sciezka));
    }
    static boolean zwrocCzyMożliwe(int[][] tab, int startowa, int koncowa, int pieniadze, List<Integer> sciezka) {
        if (pieniadze == 0 && startowa == koncowa) {
            sciezka.add(koncowa);
            System.out.println("UDAŁO SIĘ! Ścieżka: " + sciezka );
            return true;
        } else if (pieniadze <= 0) {
            return false;
        } else {
            boolean success = false;
            for (int i = 0; i < tab.length; i++) {
                if (tab[i][startowa - 1] != 0) {
                    sciezka.add(startowa);
                    success = zwrocCzyMożliwe(tab, i + 1, koncowa, pieniadze - tab[i][startowa - 1], sciezka);
                    sciezka.remove(sciezka.size() - 1);
                    if (success) {
                        break;
                    }
                }
            }
            return success;
        }
    }
}
