package Zadanie4.DrzewoBST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        drzewko.addWezel(10);
        drzewko.addWezel(5);
        drzewko.addWezel(2);
        drzewko.addWezel(3);
        drzewko.addWezel(6);
        drzewko.addWezel(1);
        drzewko.addWezel(4);

        drzewko.print();



        Scanner scanner = new Scanner(System.in);

        int loop = 1;
        while(loop != 0 ) {
            loop = scanner.nextInt();
            drzewko.deleteNood(loop);
        }
        while(loop != 3) {
            loop = scanner.nextInt();
            System.out.println(drzewko.findNood(loop));
        }





        //no i git, potem usun te co maja 1 dziecko





    }
}
