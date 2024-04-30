package App;

import logic.BusinessLogic;
import menu.Menu;
import menu.UserInteraction;
import transactions.TransactionManager;
import User.User;
import User.Wallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Mostrar mensaje de bienvenida
        System.out.println("**********************************************");
        System.out.println("* Bienvenido a la billetera Wallet Personal *");
        System.out.println("**********************************************");

        // Crear una instancia de UserInteraction para manejar la interacción inicial
        // con el usuario
        UserInteraction userInteraction = new UserInteraction(sc);

        // Pedir al usuario que ingrese si tiene una cuenta existente o desea crear una
        // nueva
        User user = userInteraction.getUser();

        if (user == null) {
            // Si no se pudo obtener un usuario válido, salir de la aplicación
            System.out.println("No se pudo obtener un usuario válido. Cerrando la aplicación.");
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

        /*
         * Crear una instancia de Menu con BusinessLogic
         * 
         * Menu menu = new Menu(businessLogic);
         */

        // Mostrar el menú para interactuar con el usuario

        Menu menu = new Menu(businessLogic);

        // Mostrar el menú para interactuar con el usuario

        menu.displayMenu();

        // Cerrar el objeto Scanner al salir
        sc.close();

    }

}