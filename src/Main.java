import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el Scanner
        Scanner sc = new Scanner(System.in);

        //User user = new User("Juan", "1234");
        User predefinedUser = new User("Juan", "1234");

        // Crear un Map para almacenar los tipos de cambio
        Map<String, Double> exchangeRates = new HashMap<>();
        // CLP a USD (1 USD = 900 CLP)
        exchangeRates.put("USD", 900.0);
        // CLP a EUR (1 EUR = 1000 CLP)
        exchangeRates.put("EUR", 1000.0);
        // CLP a GBP (1 GBP = 1200 CLP)
        exchangeRates.put("GBP", 1200.0);

        // Realizar autenticación
        boolean isAuthenticated = authenticateUser(sc, predefinedUser);

        if (!isAuthenticated) {
            System.out.println("Se han agotado los intentos de inicio de sesión. Por favor, vuelva a intentarlo más tarde.");
            sc.close();
            return;
        }

        // Operar billetera si la autenticación es exitosa
        operateWallet(sc, predefinedUser, exchangeRates);

        // Cerrar el Scanner al final del programa
        sc.close();
    }

    // Función para autenticar al usuario
    private static boolean authenticateUser(Scanner sc, User predefinedUser) {
        //Process to authenticate
        System.out.println("Bienvenido a la aplicación Wallet Personal");
        System.out.println("Por favor, inicie sesión para continuar.");
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Ingrese su nombre de usuario: ");
            String inputName = sc.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String inputPassword = sc.nextLine();

            if (predefinedUser.getName().equals(inputName) && predefinedUser.checkPassword(inputPassword)) {
                System.out.println("¡Bienvenido, " + predefinedUser.getName() + "!");
                System.out.println("¡Estas en tu Wallet Personal");
                System.out.println("¿Qué deseas hacer?");
                return true;
            } else {
                attempts++;
                System.out.println("Nombre de usuario o contraseña incorrectos. Intento ");
            }
}
        return false;
    }
    // Función para operar la billetera del usuario
    private static void operateWallet(Scanner sc, User predefinedUser, Map<String, Double> exchangeRates) {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Depositar dinero en su cuenta.");
            System.out.println("2. Retirar dinero de su cuenta.");
            System.out.println("3. Consultar saldo actual.");
            System.out.println("4. Salir de la aplicación.");
            System.out.print("Seleccione una opción (1-4): ");
            int option = sc.nextInt();
            sc.nextLine();  // Limpiar el búfer de entrada

            switch (option) {
                case 1:
                    // Código para la opción de depositar
                    System.out.print("Ingrese monto a depositar: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();  // Limpiar el búfer de entrada
                    predefinedUser.getWallet().deposit(depositAmount);
                    break;

                case 2:
                    // Código para la opción de retirar
                    System.out.print("Ingrese monto a retirar: ");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine();  // Limpiar el búfer de entrada
                    predefinedUser.getWallet().withdraw(withdrawAmount);
                    break;

                case 3:
                    // Código para la opción de consultar saldo
                    consultarSaldo(sc, predefinedUser, exchangeRates);
                    break;

                case 4:
                    // Salir de la aplicación
                    System.out.println("Saliendo de la aplicación. ¡Gracias por usar nuestra billetera personal!");
                    return;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 4.");
                    break;
            }
        }
    }

    // Función para consultar saldo
    private static void consultarSaldo(Scanner sc, User predefinedUser, Map<String, Double> exchangeRates) {
        System.out.println("Elija cómo desea ver su saldo:");
        System.out.println("1. Moneda original (CLP)");
        System.out.println("2. Dólares (USD)");
        System.out.println("3. Euros (EUR)");
        System.out.println("4. Libras esterlinas (GBP)");
        System.out.print("Seleccione una opción: ");
        int currencyOption = sc.nextInt();
        sc.nextLine();  // Limpiar el búfer de entrada

        // Obtener el saldo actual en CLP
        double balanceInCLP = predefinedUser.getWallet().getBalance();

        switch (currencyOption) {
            case 1:
                // Mostrar saldo en CLP
                System.out.println("Saldo actual en CLP: " + balanceInCLP);
                break;
            case 2:
                // Convertir saldo a USD y mostrar
                double balanceInUSD = balanceInCLP / exchangeRates.get("USD");
                System.out.println("Saldo actual en USD: " + String.format("%.2f", balanceInUSD));
                break;
            case 3:
                // Convertir saldo a EUR y mostrar
                double balanceInEUR = balanceInCLP / exchangeRates.get("EUR");
                System.out.println("Saldo actual en EUR: " + String.format("%.2f", balanceInEUR));
                break;
            case 4:
                // Convertir saldo a GBP y mostrar
                double balanceInGBP = balanceInCLP / exchangeRates.get("GBP");
                System.out.println("Saldo actual en GBP: " + String.format("%.2f", balanceInGBP));
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }
}
