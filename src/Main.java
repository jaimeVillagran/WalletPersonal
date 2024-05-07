package App;

import user.User;
import user.Wallet;
import authentication.UserAuthenticator;
import logic.BusinessLogic;
import menu.Menu;
import transactions.TransactionManager;
import user.UserAccountManager;

import java.util.Scanner;

public class Main {
    /**
     * La función main de la aplicación Wallet Personal.
     * Esta clase es responsable de iniciar la aplicación, autenticar al usuario,
     * crear cuentas de usuario y depositar, retirar y mostrar el menú para la
     * interacción del usuario.
     *
     * @param args los argumentos de línea de comandos
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Mostrar mensaje de bienvenida
        System.out.println("**********************************************");
        System.out.println("* Bienvenido a la billetera Wallet Personal *");
        System.out.println("**********************************************");

        // Crear instancias de UserAuthenticator y UserAccountManager
        User predefinedUser = new User("Jaime", "Villagran", "jaime@gmail.com", "jaime1234");
        UserAuthenticator authenticator = new UserAuthenticator(predefinedUser, sc, 3);
        UserAccountManager accountManager = new UserAccountManager(sc);

        // Intentar autenticar al usuario o crear una nueva cuenta
        User user = null;
        System.out.println("Tienes una cuenta activa o deseas crear una?");
        System.out.println("* Opción 1 - Cuenta activa");
        System.out.println("* Opción 2 - Crear cuenta");
        System.out.print("Elige una opción (1/2): ");
        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
            // Autenticar al usuario con cuenta activa
            user = authenticator.authenticate();
            if (user == null) {
                System.out.println("No se pudo autenticar al usuario. Cerrando la aplicación.");
                sc.close();
                return;
            }
        } else if (choice.equals("2")) {
            // Crear una nueva cuenta de usuario
            user = accountManager.createUser();
        } else {
            System.out.println("Opción inválida. Cerrando la aplicación.");
            sc.close();
            return;
        }
        // Definir el tipo de cambio (CLP a USD)
        double exchangeRate = 950.0; // CLP por USD

        // Crear instancias de Wallet y TransactionManager
        Wallet wallet = user.getWallet();
        TransactionManager transactionManager = new TransactionManager(wallet);

        // Crear una instancia de BusinessLogic
        BusinessLogic businessLogic = new BusinessLogic(wallet, transactionManager, exchangeRate);

        // Crear una instancia de Menu con BusinessLogic
        Menu menu = new Menu(businessLogic);

        // Mostrar el menú para interactuar con el usuario
        menu.displayMenu();

        // Cerrar el objeto Scanner al salir
        sc.close();

    }
}