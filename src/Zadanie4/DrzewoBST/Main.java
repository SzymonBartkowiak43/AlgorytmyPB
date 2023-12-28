package Zadanie4.DrzewoBST;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        Path path = Paths.get("src/Zadanie4/DrzewoBST/Abonenci.csv");

        try {
            List<String> lines = Files.readAllLines(path);
            String[] tym;

            for (String line : lines) {
                tym = line.split(";");
                drzewko.addNood(new Abonent(tym[0], tym[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1- Dodaj, 2- Znajdz, 3- Usun, 4- Wypisz, 5- Wyjdz");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Podaj imie i adres: ");
                    String name = scanner.nextLine();
                    System.out.println("Numer telefonu: ");
                    String phoneNumber = scanner.nextLine();
                    drzewko.addNood(new Abonent(name, phoneNumber));
                    System.out.println("Dodano");
                    drzewko.save();
                    break;

                case 2:
                    System.out.print("Podaj imie i adres: ");
                    String nameToFind = scanner.nextLine();
                    System.out.print("Numer Telefonu: " +  drzewko.getNumer(nameToFind) + "\n");
                    drzewko.save();
                    break;

                case 3:
                    System.out.println("Podaj imie i adres: ");
                    String nameToDelete = scanner.nextLine();
                    drzewko.deleteNood(nameToDelete);
                    drzewko.save();
                    break;

                case 4:
                    drzewko.print();
                    drzewko.save();
                    break;

                case 5:
                    System.out.println("Koniec programu.");
                    drzewko.save();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }
}