package menu;

import java.util.Scanner;
import logic.BusinessLogic;

/**
 * This class represents a Menu for a banking application.
 * It provides options to deposit, withdraw, check balance in different currencies, and exit the application.
 */
public class Menu {
    private Scanner sc;
    private BusinessLogic businessLogic;

    /**
     * Constructs a new Menu instance with a given BusinessLogic instance.
     * @param businessLogic the BusinessLogic instance to be used for banking operations.
     */
    public Menu(BusinessLogic businessLogic) {
        this.sc = new Scanner(System.in);
        this.businessLogic = businessLogic;
    }

    /**
     * Displays the menu and handles user input to perform corresponding actions.
     * The menu is displayed in a loop until the user chooses to exit.
     */
    public void displayMenu() {
        while (true) {
            System.out.println("************************");
            System.out.println("\nMenú:");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar saldo en CLP");
            System.out.println("4. Consultar saldo en USD");
            System.out.println("5. Salir");
            System.out.println("************************");
            System.out.print("Seleccione una opción: ");
            int option = sc.nextInt();

            // Handle the option selected by the user
            switch (option) {
                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double depositAmount = sc.nextDouble();
                    businessLogic.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double withdrawAmount = sc.nextDouble();
                    try {
                        businessLogic.withdraw(withdrawAmount);
                        System.out.println("Retiro exitoso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Por favor, ingrese un monto válido para retirar.");
                    }
                    break;
                case 4:
                    businessLogic.checkBalanceInUSD();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }

    /**
     * Returns the Scanner instance used by this Menu.
     * @return the Scanner instance used by this Menu.
     */
    public Scanner getScanner() {
        return sc;
    }
}
