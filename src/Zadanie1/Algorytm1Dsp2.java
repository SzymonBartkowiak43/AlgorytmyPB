import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class Algorytm1Dsp2 {
    public static void main(String[] args) {

        HashSet<Integer> liczby = new HashSet<>();

        String inputFile = "liczby.txt";
        String outputFile= "koncowyWynik.txt";
        int number;
        int hashSetSize;

        try (BufferedReader czytnik = new BufferedReader(new FileReader(inputFile))) {
            String line = czytnik.readLine(); //1 liczba jest mi niepotrzebna

            while ((line = czytnik.readLine()) != null) {
                number = Integer.parseInt(line);
                while(true) {
                    if(liczby.contains(number)) {
                        liczby.remove(number);
                        number *= 2;
                    } else {
                        liczby.add(number);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Błąd");
        }

        hashSetSize = liczby.size();
        for(int liczba: liczby) {
            System.out.print(liczba + ", ");
        }

        try (FileWriter fileWriter = new FileWriter(outputFile, false)) {
            fileWriter.write(hashSetSize + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}