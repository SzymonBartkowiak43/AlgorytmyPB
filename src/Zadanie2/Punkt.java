package Zadanie2;

public class Punkt {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double odleglosc(Punkt p) {
        return ((Math.pow((p.getX()-x),2))+(Math.pow((p.getY()-y),2)));
    }
}
