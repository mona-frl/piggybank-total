package application;

public class Euro extends Currency {

    public Euro() {
    }

    @Override
    public double conversion() {
        double convRate = 5.53;
        return convRate * value;
    }

    @Override
    public String toString() {
        return "Euro: €" + value;
    }
}
