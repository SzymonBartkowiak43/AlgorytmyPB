package Zadanie2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


//argorytm scoremana
public class Algorytm2Dsp1 {

    public static void main(String[] args) {

        double x;
        double y;
        List<Punkt> punkty = new ArrayList<>();
        int liczbaOperacji = 0;
        String [] tym;
        Path path = Paths.get("szymonBartkowiakPS1.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines.remove(0);

            for(String line : lines) {
                tym = line.split(" ");
                x = Double.parseDouble(tym[0]);
                y = Double.parseDouble(tym[1]);
                punkty.add(new Punkt(x,y));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e ){
            //
        }


        double minOdl = 1000;
        Punkt bliki1 = null;
        Punkt bliki2 = null;

        for(int i =0; i < punkty.size(); i++) {
            for(int j =0; j < punkty.size(); j++) {
                Punkt punkt1 = punkty.get(i);
                Punkt punkt2 = punkty.get(j);
                liczbaOperacji++;
                if(punkt1.odleglosc(punkt2) < minOdl && i != j) {
                    minOdl = punkt1.odleglosc(punkt2);
                    bliki1 = punkt1;
                    bliki2 = punkt2;
                    liczbaOperacji++;
                }
            }
        }
        System.out.println("Punkty na ktorych najlepiej zawiesic hamak to: (" + bliki1.getX() + "," +
                bliki1.getY()+ ") i (" + bliki2.getX() + "," +  bliki2.getY() + ").");
        System.out.println("Liczba Operacji: " + liczbaOperacji);
    }
}
