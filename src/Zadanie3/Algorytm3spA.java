package Zadanie3;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//        5 //liczba puszek w magazynie
//        1 4 //najpierw wysokosc 2 do 1 a  wartosc puszki 4
//        2 6
//        1 3
//        2 2
//        1 5
//        2 //liczba rur
//        1 1 // najpierw wysokosc 2 do potegi 1 rury potem ile takich rur
//        2 2
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
        MargeSort mergeSort = new MargeSort();
        mergeSort.mergeSort(puszki,0,puszki.length-1,0);

        int lowIndex =0;
        int highIndex = 0;
        int puszkaSize = 1;
        for(int i = 0;i < puszki.length;i++) {
            if(puszki[i][0] == puszkaSize) {
                while(puszki[i][0] == puszkaSize && i!= puszki.length-1) {
                    i++;
                    highIndex++;
                }
                mergeSort.mergeSort(puszki,lowIndex,highIndex,1);
                lowIndex = highIndex;
            }
                puszkaSize*= 2;
        }
        mergeSort.print(puszki);
        Collections.sort(rury);
        rury.forEach(System.out::println);
        int max = 0;

        int[] indexyDoKasacji = new int[puszki.length];

        for(int j = 0; j < puszki.length;j++) {
            indexyDoKasacji[j] = 0;
        }


        for(int i = 0; i < rury.size();i++) {
            int rozmiarRury = rury.get(i);
            int aktualnyMaksRury = 0;

            //Wybieram najlepsza opcje
            for(int j = 0; j < puszki.length;j++) {
                if(rozmiarRury >= puszki[j][0] && puszki[j][0] != 0) {
                    aktualnyMaksRury = puszki[j][1];
                    indexyDoKasacji[0] = j;
                }
            }
            max += aktualnyMaksRury;
            System.out.println(aktualnyMaksRury+ " chwilowy dla" + rozmiarRury);

            for(int j = 0;j < indexyDoKasacji.length;j++) {
                if(indexyDoKasacji[j] != 0){
                    puszki[indexyDoKasacji[j]][0] = 0;
                }
            }
        }
        System.out.println(max);

    }

}
