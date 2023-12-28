package Zadanie4.DrzewoBST;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        Path path = Paths.get("src/Zadanie4/DrzewoBST/Abonenci.csv");

        try {
            List<String> lines = Files.readAllLines(path);
            String[] tym;

            for(String line: lines) {
                tym = line.split(";");
                drzewko.addNood(new Abonent(tym[0],tym[1]));
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }



        System.out.println(drzewko.counter());
        System.out.println();


        System.out.println(drzewko.counter());
        System.out.println(drzewko.getNumer("Jan Paleta, Polnae 21"));


       drzewko.save();


    }
}
