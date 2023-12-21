package Zadanie4.DrzewoBST;

public class Abonent {
    private String nameAndAdres;
    private String number;

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
