import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****************");
        System.out.println("* Bienvenido a la billetera Wallet Personal *");
        System.out.println("****************");

        // Crear una instancia de Authentication
        Authentication auth = new Authentication();

        // Realizar la autenticación
        if (!auth.authenticate()) {

            // Cerrar el escáner al salir
            auth.closeScanner();
            return;
        }

        // Define the getPredefinedUser() method in the Authentication class
        User predefinedUser = auth.getPredefinedUser(); // Get the predefinedUser

        // Definir tipo de cambio
        double exchangeRate = 950.0; // CLP por USD

        // Obetner instancia de Menu
        Menu menu = new Menu(predefinedUser, exchangeRate);

        // Mostrar el menú
        menu.displayMenu();

        // Cerrar el escáner al salir
        auth.closeScanner();
    }
}
