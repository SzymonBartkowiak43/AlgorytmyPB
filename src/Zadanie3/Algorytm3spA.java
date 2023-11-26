package Zadanie3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//        5 //liczba puszek w magazynie
//        1 4 //najpierw wysokosc 2 do 1 2 do 4 wartosc puszki
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
        try {
            List<String> lines = Files.readAllLines(path);
            int start = 1;
            tab[lines.get(0)][] = new Integer
            List<Puszka> puszki = new  ArrayList<>();
            lines.remove(0);

            for(String line:lines) {
                tym = line.split(" ");
                puszki.add(new Puszka(Double.parseDouble(tym[0]) ,Double.parseDouble(tym[1])));

            }
            puszki.stream()
                    .sorted()
                    .map(puszka -> puszka.getWysokosc())
                    .forEach(System.out::println);


        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
