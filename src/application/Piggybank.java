package application;

import java.util.ArrayList;

public class Piggybank {

    ArrayList<Currency> currencyArrayList = new ArrayList<>();

    public void adds(Currency currency, double value) {
        //boolean to check if the currency already has any value, begins with false
        boolean currencyExists = false;

        if (value > 0) {
            //does the loop to check if the class exists then treats it correctly, checks the value to see if it
            for (Currency m : currencyArrayList) {
                if (m.getClass().equals(currency.getClass())) {
                    double existentValue = m.getValue();
                    m.setValue(existentValue + value);
                    currencyExists = true;
                }
            }
            //if the currency doesn't exist, it will "create" it
            if (!currencyExists) {
                currency.setValue(value);
                currencyArrayList.add(currency);
            }
            System.out.println("--------------------------------------------");
            System.out.println("Amount was succesfully added to your piggy bank!");
            System.out.println("--------------------------------------------\n");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Invalid value!");
            System.out.println("--------------------------------------------\n");
        }
    }

    //removes the value from the array, works the same way as the add
    // value que estão solicitando é maior que existe.
    public void removes(Currency currency, double value) {
        boolean moedaExiste = false;

        if (value > 0) {
            for (Currency m : currencyArrayList) {
                if (m.getClass().equals((currency.getClass()))) {
                    if (value <= m.getValue()) {
                        m.setValue((m.getValue() - value));
                        moedaExiste = true;
                        System.out.println("--------------------------------------------");
                        System.out.println("Amount was succesfully removed from your piggy bank!");
                        System.out.println("--------------------------------------------\n");
                    } else {
                        moedaExiste = true;
                        System.out.println("--------------------------------------------");
                        System.out.println("Invalid value!");
                        System.out.println("--------------------------------------------\n");
                    }
                }
                //if a currency has no value falls here
                if (!moedaExiste) {
                    System.out.println("--------------------------------------------");
                    System.out.println("You have no coins in that currency in your piggy bank!");
                    System.out.println("--------------------------------------------\n");
                }
            }
        }
    }

    //lists the coins added using a forloop, it will show all coins add without the total (used this method to
    //list before the removes method
    public void list() {
        System.out.print("\n");
        System.out.println("Piggy Bank's coins:");
        for (Currency currency : currencyArrayList) {
            System.out.println(currency);
        }
        System.out.print("\n");
    }


    //lists all the coins and adds the total of ALL coins without conversion rate
    public void listarTotal() {
        double total = 0;
        System.out.print("\n");
        System.out.println("Piggy Bank's coins:");
        for (Currency currency : currencyArrayList) {
            System.out.println(currency);
            total += currency.value;
        }
        System.out.print("\n");
        System.out.println("-----------------------------------------------");
        System.out.println("Total (without conversion rate): " + total);
        System.out.println("-----------------------------------------------\n");
    }


    //lists all the coins and adds the total of ALL coins with conversion rate
    public void convertAll() {
        double total = 0;
        System.out.print("\n");
        System.out.println("Piggy Bank's coins:");
        for (Currency currency : currencyArrayList) {
            double convertedCoin = currency.conversion();
            total += convertedCoin;
            System.out.println(currency + " => BRL: " + convertedCoin);
        }
        System.out.print("\n");
        System.out.println("-----------------------------------------------");
        System.out.println("Total (with conversion rate): " + total);
        System.out.println("-----------------------------------------------\n");
    }
}
