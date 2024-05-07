package menu;

import logic.BusinessLogic;
import java.util.Scanner;

public class Menu {
    private BusinessLogic businessLogic;
    private Scanner scanner;

    public Menu(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Realizar depósito");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double depositAmount = scanner.nextDouble();
                    businessLogic.performDeposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double withdrawalAmount = scanner.nextDouble();
                    businessLogic.performWithdrawal(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}