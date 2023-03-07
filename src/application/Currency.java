package application;

abstract class Currency {

    double value;

    public Currency(Double value) {
        this.value = value;
    }

    public Currency() {
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    abstract double conversion();
}