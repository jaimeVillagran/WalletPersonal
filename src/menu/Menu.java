package menu;

import java.util.Scanner;

import logic.BusinessLogic;

public class Menu {
    private Scanner sc;
    private BusinessLogic businessLogic;

    // Constructor para crear una instancia de menú con una instancia de lógica de
    // negocio
    public Menu(BusinessLogic businessLogic) {
        this.sc = new Scanner(System.in);
        this.businessLogic = businessLogic;
    }

    // Metodo para mostrar el menu y realizar las acciones correspondientes
    // dependiendo de la opción seleccionada por el usuario.

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

            // Manejar la opción seleccionada por el usuario
            switch (option) {
                case 1:
                    System.out.print("Ingrese monto a depositar: ");
                    double depositAmount = sc.nextDouble();
                    businessLogic.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Ingrese monto a retirar: ");
                    double withdrawAmount = sc.nextDouble();
                    businessLogic.withdraw(withdrawAmount);
                    break;
                case 3:
                    businessLogic.checkBalance();
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

    // Puedes pasar la instancia de Scanner a otras clases o métodos según sea
    // necesario
    public Scanner getScanner() {
        return sc;
    }
}
