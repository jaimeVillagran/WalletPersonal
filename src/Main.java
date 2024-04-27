import java.util.Scanner;
import com.example.wallet.*;
import currencyManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear CurrencyManager y agregar monedas disponibles
        CurrencyManager currencyManager = new CurrencyManager();
        currencyManager.addCurrency(new USD());
        currencyManager.addCurrency(new EUR());
        currencyManager.addCurrency(new GBP());
        currencyManager.addCurrency(new CLP());

        // Crear la billetera del usuario en CLP
        Wallet wallet = new ChileanWallet(currencyManager);

        // Crear un usuario
        User user = new User("Juan", "1234", wallet);

        // Crear un escáner para leer la entrada del usuario
        Scanner sc = new sc(System.in);

        // Crear una instancia de autenticación
        Authentication authentication = new Authentication(user, sc);

        // Realizar la autenticación
        if (authentication.authenticate()) {
            // Crear el menú de operaciones
            OperationsMenu operationsMenu = new OperationsMenu(user, wallet, currencyManager, sc);
            // Mostrar el menú de operaciones
            operationsMenu.showMenu();
        }

        // Cerrar el escáner al salir
        sc.close();
    }
}
