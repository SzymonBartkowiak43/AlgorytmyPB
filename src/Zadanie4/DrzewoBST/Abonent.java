package Zadanie4.DrzewoBST;

public class Abonent {
    private String name;
    private String adres;
    private String number;

    public Abonent(String name, String adres, String number) {
        this.name = name;
        this.adres = adres;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAdres() {
        return adres;
    }

    public String getNumber() {
        return number;
    }
}
