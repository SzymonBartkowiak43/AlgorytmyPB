package Zadanie4.DrzewoBST;

public class Main {
    public static void main(String[] args) {
        Tree drzewko = new Tree(null);

        Abonent uztkownik = new Abonent("Kamil Kozak, Polna 25", "796455447");
        Abonent uztkownik2 = new Abonent("Jan Paleta, Polna 21", "11111");
        Abonent uztkownik3 = new Abonent("Wanda Wódka, Polna 25", "22222");
        Abonent uztkownik4 = new Abonent("Maks Świr, Polna 26", "333333");
        Abonent uztkownik5 = new Abonent("Adam Paleta, Polna 27", "444444");
        Abonent uztkownik6 = new Abonent("Ewa Laptop, Polna 28", "5555555");
        Abonent uztkownik7 = new Abonent("Bartek Drzewo, Polna 29", "66666");
        Abonent uztkownik8 = new Abonent("Karolina Książka, Polna 30", "777777777");
        Abonent uztkownik9 = new Abonent("Robert Rower, Polna 31", "8888888888");
        Abonent uztkownik10 = new Abonent("Magdalena Myszka, Polna 32", "99999999");
        Abonent uztkownik11 = new Abonent("Tomasz Telefon, Polna 33", "000000");
        Abonent uztkownik12 = new Abonent("Alicja Auto, Polna 34", "12121212");
        Abonent uztkownik13 = new Abonent("Piotr Piłka, Polna 35", "232323");
        Abonent uztkownik14 = new Abonent("Anna Ananas, Polna 36", "3434437");
        Abonent uztkownik15 = new Abonent("Krzysztof Kawa, Polna 37", "454545");
        Abonent uztkownik16 = new Abonent("Monika Młot, Polna 38", "56565656");
        Abonent uztkownik17 = new Abonent("Jan Język, Polna 39", "67676667");
        Abonent uztkownik18 = new Abonent("Zofia Zamek, Polna 40", "787878887");
        Abonent uztkownik19 = new Abonent("Rafał Rower, Polna 41", "898989898");
        Abonent uztkownik20 = new Abonent("Elżbieta Ekran, Polna 42", "090909090");

        drzewko.addNood(uztkownik);
        drzewko.addNood(uztkownik2);
        drzewko.addNood(uztkownik3);
        drzewko.addNood(uztkownik4);
        drzewko.addNood(uztkownik5);
        drzewko.addNood(uztkownik6);
        drzewko.addNood(uztkownik7);
        drzewko.addNood(uztkownik8);
        drzewko.addNood(uztkownik9);
        drzewko.addNood(uztkownik10);
        drzewko.addNood(uztkownik11);
        drzewko.addNood(uztkownik12);
        drzewko.addNood(uztkownik13);
        drzewko.addNood(uztkownik14);
        drzewko.addNood(uztkownik15);
        drzewko.addNood(uztkownik16);
        drzewko.addNood(uztkownik17);
        drzewko.addNood(uztkownik18);
        drzewko.addNood(uztkownik19);
        drzewko.addNood(uztkownik20);

        System.out.println(drzewko.counter());
        System.out.println();


        drzewko.deleteNood("Wanda Wódka, Polna 25");
        drzewko.deleteNood("Maks Świr, Polna 26");

        System.out.println(drzewko.counter());


    }
}
