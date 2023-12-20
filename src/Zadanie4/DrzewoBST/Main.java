package Zadanie4.DrzewoBST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        Abonent kamilKozak = new Abonent("Kamil Kozak", "Polna 21", "796455447");

        drzewko.addWezel(kamilKozak);
        drzewko.addWezel(kamilKozak);

        drzewko.print();








    }
}
