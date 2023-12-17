package Zadanie4.DrzewoBST;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        drzewko.addWezel(10);
        drzewko.addWezel(5);
        drzewko.addWezel(15);
        drzewko.addWezel(17);
        drzewko.addWezel(7);
        drzewko.addWezel(8);


        System.out.println(drzewko.findNood(8));

        drzewko.deleteNood(8);

        System.out.println(drzewko.findNood(8));

        //no i git, potem usun te co maja 1 dziecko





    }
}
