import authentication.AuthenticationService;
import authentication.Authenticator;
import authentication.UserAuthenticator;
import interaction.UserInteraction;
import logic.BusinessLogic;
import transactions.TransactionManager;
import user.User;
import user.UserAccountManager;
import user.Wallet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Usuario predefinido para autenticación
        User predefinedUser = new User("Jaime", "Villagran", "jaime@gmail.com", "jaime1234");
        Authenticator authenticator = new UserAuthenticator(predefinedUser);

        // Gestionar cuentas de usuario
        UserAccountManager userAccountManager = new UserAccountManager(sc);

        // Crear un Wallet y un TransactionManager
        Wallet wallet = new Wallet(0.0);
        TransactionManager transactionManager = new TransactionManager(wallet);

        // Crear BusinessLogic con la tasa de cambio especificada
        BusinessLogic businessLogic = new BusinessLogic(wallet, transactionManager, 950.0);

        // Crear AuthenticationService y UserInteraction
        AuthenticationService authService = new AuthenticationService(authenticator, sc, userAccountManager);
        UserInteraction userInteraction = new UserInteraction(sc, authService, businessLogic);

        // Iniciar la interacción del usuario
        userInteraction.displayWelcomeMenu();

        sc.close(); // Cerrar el scanner al final para evitar fugas de recursos
    }
}