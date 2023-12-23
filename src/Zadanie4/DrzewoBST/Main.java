package Zadanie4.DrzewoBST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        Abonent uztkownik = new Abonent("Kamil Kozak, Polna 25", "796455447");
        Abonent uztkownik2 = new Abonent("Jan Paleta, Polna 21", "796455447");
        Abonent uztkownik3 = new Abonent("Wanda Wódka, Polna 25", "796455447");
        Abonent uztkownik4 = new Abonent("Maks Świr, Polna 26", "796455447");
        Abonent uztkownik5 = new Abonent("Adam Paleta, Polna 27", "796455447");

        drzewko.addWezel(uztkownik);
        drzewko.addWezel(uztkownik2);
        drzewko.addWezel(uztkownik3);
        drzewko.addWezel(uztkownik4);
        drzewko.addWezel(uztkownik5);

        drzewko.print();
        System.out.println();


        drzewko.deleteNood("Wanda Wódka, Polna 25");
        drzewko.deleteNood("Maks Świr, Polna 26");

        drzewko.print();


    }
}
