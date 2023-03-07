package application;

public class Real extends Currency {


    public Real() {
    }

    @Override
    public double conversion() {
        double conversao = 1;
        return conversao * value;
    }

    @Override
    public String toString() {
        return "Real: R$" + value;
    }

}
