package menu;

import java.util.Scanner;

import User.User;

public class Menu {
    private Scanner sc;
    private User user;
    private double exchangeRate;

    public Menu(User user, double exchangeRate) {
        this.sc = new Scanner(System.in);
        this.user = user;
        this.exchangeRate = exchangeRate;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("************************");
            System.out.println("\nMenú:");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.println("************************");
            System.out.print("Seleccione una opción: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private void deposit() {
        System.out.println("************************");
        System.out.print("Ingrese monto a depositar: ");
        double depositAmount = sc.nextDouble();
        user.getWallet().deposit(depositAmount);
    }

    private void withdraw() {
        System.out.println("************************");
        System.out.print("Ingrese monto a retirar: ");
        double withdrawAmount = sc.nextDouble();
        user.getWallet().withdraw(withdrawAmount);
    }

    private void checkBalance() {
        System.out.println("********************************");
        System.out.println("* Elija cómo desea ver su saldo: *");
        System.out.println("********************************");
        System.out.println("1. Moneda original (CLP)");
        System.out.println("2. Dólares (USD)");
        System.out.print("Seleccione una opción: ");
        int currencyOption = sc.nextInt();

        if (currencyOption == 1) {
            // Mostrar saldo en moneda original
            System.out.println("********************************");
            user.getWallet().checkBalance();
        } else if (currencyOption == 2) {
            // Convertir saldo a dólares y mostrar
            double balanceInCLP = user.getWallet().getBalance();
            double balanceInUSD = balanceInCLP / exchangeRate;
            System.out.println("********************************");
            System.out.println("Saldo actual en dólares: USD " + String.format("%.2f", balanceInUSD));
            System.out.println("********************************");
        } else {
            System.out.println("Opción inválida.");
        }
    }
}
