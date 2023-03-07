package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //var to start scanning keyboard inputs
    static Scanner kb = new Scanner(System.in);

    //var to start the classes
    static Piggybank piggybank = new Piggybank();
    static Dolar dolar = new Dolar();
    static Euro euro = new Euro();
    static Real real = new Real();

    //vars for the do and while, do to make sure the app doesn't break when an error appears and while to finish the app
    static boolean end = false;
    static boolean err = false;

    public static void main(String[] args) {
        do {
            try {
                System.out.println("--------------------------------------------");
                System.out.println("|             $$ Piggy Bank $$             |");
                System.out.println("--------------------------------------------");
                while (!end) {
                    //menu inicial
                    System.out.println("""
                        Menu:\s
                        1- Add coin\s
                        2- Remove coin\s
                        3- List of coins\s
                        4- Convert to Real(BRL)\s
                        0- Quit""");
                    int option = kb.nextInt();
                    System.out.print("\n");

                    //currency used to check the scanner of keys
                    //value will be used as the input's value
                    int currency;
                    double value;

                    //will keep running till the user presses zero
                    //switching through the menu's options
                    switch (option) {
                        //after choosing the option, the use chooses the currency and then adds the value to the array
                        case 1 -> {
                            System.out.println("Choose the currency: \n1- Real \n2- Euro \n3- Dolar");
                            currency = kb.nextInt();
                            System.out.print("\n");

                            //if it's a valid currency it will go to the next switch, else it will fall back to the menu
                            switch (currency) {
                                //treats the currency var and adds to the right class
                                case 1 -> {
                                    System.out.println("How much would you like to add?");
                                    value = kb.nextDouble();
                                    piggybank.adds(real, value);
                                }
                                case 2 -> {
                                    System.out.println("How much would you like to add?");
                                    value = kb.nextDouble();
                                    piggybank.adds(euro, value);
                                }
                                case 3 -> {
                                    System.out.println("How much would you like to add?");
                                    value = kb.nextDouble();
                                    piggybank.adds(dolar, value);
                                }
                                //fallback message if invalid option
                                default -> System.out.println("Invalid option.\n");
                            }
                        }
                        case 2 -> {
                            piggybank.list();
                            System.out.println("-----------------------------------------------");
                            //same thing as add but now removes the value
                            System.out.println("Choose the currency: \n1- Real \n2- Euro \n3- Dolar");
                            currency = kb.nextInt();
                            System.out.print("\n");



                            switch (currency) {
                                case 1 -> {
                                    System.out.println("How much would you like to removes?");
                                    value = kb.nextDouble();
                                    piggybank.removes(real, value);
                                }
                                case 2 -> {
                                    System.out.println("How much would you like to removes?");
                                    value = kb.nextDouble();
                                    piggybank.removes(euro, value);
                                }
                                case 3 -> {
                                    System.out.println("How much would you like to removes?");
                                    value = kb.nextDouble();
                                    piggybank.removes(dolar, value);
                                }
                                default -> System.out.println("Invalid option.\n");
                            }
                        }
                        case 3 -> //list of coins without conversion
                                piggybank.listarTotal();
                        case 4 -> //list of coin with conversion
                                piggybank.convertAll();
                        case 0 -> {
                            System.out.println("Closing the program...");
                            end = true;
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid option.\n");
                    }
                }
                //catches errors and returns to the main menu
            } catch (InputMismatchException e) {
                System.out.println("Invalid option.\n");
                err = true;
                kb.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                err = true;
                kb.next();
            }
            //keeps the program running
        } while (err);
        kb.close();
    }
}