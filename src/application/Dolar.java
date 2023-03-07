package application;

public class Dolar extends Currency {

    public Dolar() {
        super();
    }

    @Override
    public double conversion() {
        double convRate = 5.20;
        return convRate * value;
    }

    @Override
    public String toString() {
        return "Dolar: $" + value;
    }

}
