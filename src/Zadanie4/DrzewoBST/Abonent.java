package Zadanie4.DrzewoBST;

public class Abonent {
    private final String nameAndAdres;
    private final String number;

    public Abonent(String name,  String number) {
        this.nameAndAdres = name;
        this.number = number;
    }

    public String getName() {
        return nameAndAdres;
    }

    public String getNumber() {
        return number;
    }
}
