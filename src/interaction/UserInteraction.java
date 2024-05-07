package interaction;

import authentication.AuthenticationService;
import logic.BusinessLogic;

import java.util.Scanner;

public class UserInteraction {
    private Scanner sc;
    private AuthenticationService authService;
    private BusinessLogic businessLogic;

    public UserInteraction(Scanner sc, AuthenticationService authService, BusinessLogic businessLogic) {
        this.sc = sc;
        this.authService = authService;
        this.businessLogic = businessLogic;
    }

    public void displayWelcomeMenu() {
        System.out.println("**********************************************");
        System.out.println("* Bienvenido a la billetera Wallet Personal *");
        System.out.println("**********************************************");
        System.out.println("Tienes una cuenta activa o deseas crear una?");
        System.out.println("* Opción 1 - Cuenta activa");
        System.out.println("* Opción 2 - Crear cuenta");
        System.out.print("Elige una opción (1/2): ");

        int choice = sc.nextInt();
        sc.nextLine(); // Importante para consumir el salto de línea después de leer un número

        switch (choice) {
            case 1:
                // Aquí invocarías el método para iniciar sesión
                authService.authenticateUser();
                displayOperationsMenu(); // Muestra el menú de operaciones después de la autenticación
                break;
            case 2:
                // Aquí invocarías el método para crear una nueva cuenta
                authService.createAccount();
                displayOperationsMenu(); // Muestra el menú de operaciones después de la creación de cuenta
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                displayWelcomeMenu(); // Recursivamente se llama a sí mismo hasta que se elija una opción válida
        }

    }

    private void displayOperationsMenu() {
        while (true) {
            System.out.println("\nMenu de Operaciones:");
            System.out.println("1. Realizar depósito");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Consultar saldo en CLP");
            System.out.println("4. Consultar saldo en USD");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int operation = sc.nextInt();
            sc.nextLine(); // Nuevamente importante después de leer un número

            switch (operation) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    double depositAmount = sc.nextDouble();
                    businessLogic.performDeposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    double withdrawalAmount = sc.nextDouble();
                    businessLogic.performWithdrawal(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Su saldo actual en CLP es: " + businessLogic.checkBalanceCLP());
                    break;
                case 4:
                    System.out.println("Su saldo actual en USD es: " + businessLogic.getBalanceUSD());
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    sc.close(); // Cierra el Scanner solo cuando se salga del sistema para evitar problemas
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}