package menu;

import java.util.Scanner;
import logic.BusinessLogic;

/**
 * Esta clase representa un Menú para una aplicación bancaria.
 * Proporciona opciones para depositar, retirar, consultar el saldo en diferentes monedas y salir de la aplicación.
 */
public class Menu {
    private Scanner sc;
    private BusinessLogic businessLogic;

    /**
     * Construye una nueva instancia de Menu con una instancia de BusinessLogic dada.
     * @param businessLogic la instancia de BusinessLogic que se utilizará para las operaciones bancarias.
     */
    public Menu(BusinessLogic businessLogic) {
        this.sc = new Scanner(System.in);
        this.businessLogic = businessLogic;
    }

    /**
     * Muestra el menú y maneja la entrada del usuario para realizar las acciones correspondientes.
     * El menú se muestra en un bucle hasta que el usuario elige salir.
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

            // Maneja la opción seleccionada por el usuario
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
     * Devuelve la instancia de Scanner utilizada por este Menú.
     * @return la instancia de Scanner utilizada por este Menú.
     */
    public Scanner getScanner() {
        return sc;
    }
}