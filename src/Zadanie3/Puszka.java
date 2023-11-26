package Zadanie3;

public class Puszka {
    private double wysokosc;
    private double wartosc;

    public Puszka(Double wysokosc, Double wartosc) {
        this.wysokosc = Math.pow(2,wysokosc);
        this.wartosc = Math.pow(2,wartosc);
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public double getWartosc() {
        return wartosc;
    }
}
