package menu;

import authentication.IUserService;
import models.User;
import transactions.ITransactionService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Menu maneja la interacción del usuario con la aplicación.
 * Proporciona un menú de opciones para que el usuario interactúe con la
 * aplicación.
 * Las opciones del menú incluyen depositar, retirar, consultar el historial de
 * transacciones y consultar el saldo en USD.
 */
public class Menu {
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_AZUL = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final IUserService userService;
    private final ITransactionService transactionService;
    private final Scanner sc;
    private final PrintStream out;

    /**
     * Constructor de Menu.
     * Inicializa el servicio de usuario, el servicio de transacciones, el escáner y
     * la salida de impresión.
     *
     * @param userService        el servicio de usuario
     * @param transactionService el servicio de transacciones
     * @param in                 la entrada de datos
     * @param out                la salida de datos
     */
    public Menu(IUserService userService, ITransactionService transactionService, InputStream in, PrintStream out) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.sc = new Scanner(in);
        this.out = out;
    }

    /**
     * Muestra el menú inicial.
     * Proporciona opciones para iniciar sesión o crear una cuenta.
     */
    public void initialMenu() {
        out.println(ANSI_AZUL + "______________________________________" + ANSI_RESET);
        out.println(ANSI_AZUL + "* Bienvenido a la billetera Wallet Personal *" + ANSI_RESET);
        out.println(ANSI_AZUL + "______________________________________" + ANSI_RESET);
        out.println(ANSI_AZUL + "Tienes una cuenta activa o deseas crear una?" + ANSI_RESET);
        out.println(ANSI_AZUL + "* Opción 1 - Cuenta activa" + ANSI_RESET);
        out.println(ANSI_AZUL + "* Opción 2 - Crear cuenta" + ANSI_RESET);
        out.print(ANSI_AZUL + "Elija una opción (1/2): " + ANSI_RESET);
        int choice = getUserInputAsInt();
        processInitialOption(choice);
    }

    /**
     * Obtiene la entrada del usuario como un entero.
     * Si la entrada no es un número válido, solicita al usuario que ingrese un
     * número válido.
     *
     * @return la entrada del usuario como un entero
     */
    private int getUserInputAsInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            out.println(ANSI_RED + "Por favor, ingrese un número válido." + ANSI_RESET);
            return getUserInputAsInt(); // Recursively call until a valid number is entered
        }
    }

    /**
     * Procesa la opción inicial seleccionada por el usuario.
     * Si el usuario selecciona la opción 1, maneja el inicio de sesión.
     * Si el usuario selecciona la opción 2, maneja la creación de una cuenta.
     * Si el usuario selecciona una opción no válida, muestra el menú inicial
     * nuevamente.
     *
     * @param choice la opción seleccionada por el usuario
     */
    private void processInitialOption(int choice) {
        if (choice == 1) {
            handleLogin();
        } else if (choice == 2) {
            handleCreateAccount();
        } else {
            out.println(ANSI_RED + "Opción inválida, intente de nuevo." + ANSI_RESET);
            initialMenu();  // Recursive call to handle incorrect options
        }
    }

    /**
     * Maneja el inicio de sesión del usuario.
     * Solicita al usuario que ingrese su correo electrónico y contraseña.
     * Si la autenticación es exitosa, muestra el menú de bienvenida.
     * Si la autenticación falla, permite al usuario intentar iniciar sesión hasta
     * tres veces antes de salir del sistema.
     */
    private void handleLogin() {
        int attempts = 0;
        while (attempts < 3) {
            out.print("Email: ");
            String email = sc.nextLine();
            out.print("Contraseña: ");
            String password = sc.nextLine();
            User user = userService.authenticateUser(email, password);
            if (user != null) {
                out.println(ANSI_GREEN + "Autenticación exitosa." + ANSI_RESET);
                displayWelcomeAndMenu(user);
                return;
            } else {
                out.println(ANSI_RED + "_____________________________________________" + ANSI_RESET);
                out.println(ANSI_RED + " |  Autenticación fallida. Verifique sus credenciales.  |" + ANSI_RESET);
                out.println(ANSI_RED + "_____________________________________________" + ANSI_RESET);
                attempts++;
            }
        }
        out.println(ANSI_RED + "____________________________________" + ANSI_RESET);
        out.println(ANSI_RED + "Autenticación fallida. Inténtelo más tarde...." + ANSI_RESET);
        out.println(ANSI_RED + "____________________________________" + ANSI_RESET);
        System.exit(0);
    }

    /**
     * Maneja la creación de una cuenta de usuario.
     * Solicita al usuario que ingrese su nombre, apellido, correo electrónico y
     * contraseña.
     * Si la creación de la cuenta es exitosa, muestra el menú de bienvenida.
     * Si la creación de la cuenta falla, permite al usuario intentar crear una
     * cuenta nuevamente.
     */
    private void handleCreateAccount() {
        out.print("Nombre: ");
        String firstName = sc.nextLine();
        out.print("Apellido: ");
        String lastName = sc.nextLine();
        out.print("Email: ");
        String email = sc.nextLine();
        out.print("Contraseña: ");
        String password = sc.nextLine();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            out.println(ANSI_RED + "____________________________________" + ANSI_RESET);
            out.println(ANSI_RED + " |  Los campos no pueden estar vacíos  |" + ANSI_RESET);
            out.println(ANSI_RED + "____________________________________" + ANSI_RESET);
            handleCreateAccount();
            return;
        }

        User user = userService.createNewUser(firstName, lastName, email, password);
        if (user != null) {
            out.println(ANSI_GREEN + "  Cuenta creada exitosamente  " + ANSI_RESET);
            displayWelcomeAndMenu(user);
        } else {
            out.println(ANSI_RED + " No se pudo crear la cuenta. Intente nuevamente. " + ANSI_RESET);
            handleCreateAccount();
        }
    }

    /**
     * Muestra el menú de bienvenida y el menú de opciones.
     *
     * @param user el usuario que ha iniciado sesión o creado una cuenta
     */
    private void displayWelcomeAndMenu(User user) {
        out.println(ANSI_AZUL + "_________________________________" + ANSI_RESET);
        out.println(ANSI_AZUL + "            Wallet Personal         " + ANSI_RESET);
        out.println(ANSI_AZUL + user.getFirstName() + " " + user.getLastName() + "    " + ANSI_RESET);
        out.println(ANSI_AZUL + "_________________________________" + ANSI_RESET);
        displayMenu();
    }


    /**
     * Muestra el menú de opciones.
     * Las opciones incluyen depositar, retirar, consultar el historial de
     * transacciones y consultar el saldo en USD.
     */
    private void displayMenu() {
        out.println(ANSI_AZUL + "1. Depositar" + ANSI_RESET);
        out.println(ANSI_AZUL + "2. Retirar" + ANSI_RESET);
        out.println(ANSI_AZUL + "3. Historial de transacciones" + ANSI_RESET);
        out.println(ANSI_AZUL + "4. Saldo en USD" + ANSI_RESET);
        out.println(ANSI_AZUL + "5. Salir" + ANSI_RESET);
        handleUserChoice();
    }


    /**
     * Maneja la opción seleccionada por el usuario en el menú de opciones.
     * Si el usuario selecciona una opción no válida, solicita al usuario que
     * seleccione una opción válida.
     */
    private void handleUserChoice() {
        boolean exit = false;
        while (!exit) {
            out.print("Seleccione una opción: ");
            int choice = getUserInputAsInt();
            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    displayTransactionHistory();
                    break;
                case 4:
                    displayBalanceInUSD();
                    break;
                case 5:
                    out.println(ANSI_AZUL + "_____________________" + ANSI_RESET);
                    out.println(ANSI_AZUL + "Saliendo del sistema..." + ANSI_RESET);
                    sc.close();
                    return;  // Salir correctamente
                default:
                    out.println(ANSI_RED + "__________________________________" + ANSI_RESET);
                    out.println(ANSI_RED + "Opción inválida. Intente nuevamente. " + ANSI_RESET);
                    out.println(ANSI_RED + "__________________________________" + ANSI_RESET);
            }
        }
    }

    /**
     * Maneja el depósito de dinero en la cuenta del usuario.
     * Solicita al usuario que ingrese el monto a depositar.
     * Si el monto es válido, realiza el depósito y muestra el nuevo saldo.
     * Si el monto no es válido, solicita al usuario que ingrese un monto válido.
     */
    private void handleDeposit() {
        out.println(ANSI_AZUL + " Ingrese el monto a depositar: " + ANSI_RESET);
        double amount = getUserInputAsDouble();
        if (amount > 0) {
            transactionService.deposit(amount);
            out.println(ANSI_AZUL + "__________________________________________" + ANSI_RESET);
            out.printf(" * Depósito realizado con éxito. Nuevo saldo: $ %.2f\n", transactionService.getCurrentBalance());
            out.println(ANSI_AZUL + "__________________________________________" + ANSI_RESET);
        } else {
            out.println(ANSI_RED + "El monto a depositar debe ser mayor que cero." + ANSI_RESET);
        }
        displayMenu();
    }

    /**
     * Maneja el retiro de dinero de la cuenta del usuario.
     * Solicita al usuario que ingrese el monto a retirar.
     * Si el monto es válido y el saldo es suficiente, realiza el retiro y muestra
     * el saldo restante.
     * Si el monto no es válido o el saldo no es suficiente, informa al usuario.
     */
    private void handleWithdraw() {
            out.println(ANSI_AZUL + "________________________" + ANSI_RESET);
            out.println(ANSI_AZUL + " Ingrese el monto a retirar: " + ANSI_RESET);
            double amount = getUserInputAsDouble();
            if (amount > 0 && transactionService.getCurrentBalance() >= amount) {
                transactionService.withdraw(amount);
                out.printf("\u001B[32mRetiro realizado con éxito. Saldo restante: $%.2f\u001B[0m\n", transactionService.getCurrentBalance());
            } else {
                out.println("\u001B[31mFondos insuficientes o monto inválido.\u001B[0m");
            }
            displayMenu(); // Redisplay the menu
        }

    /**
     * Muestra el historial de transacciones del usuario.
     */
    private void displayTransactionHistory() {
        List<String> history = transactionService.getTransactionHistory();
        out.println(ANSI_AZUL + "____________________________________" + ANSI_RESET);
        out.println(ANSI_AZUL + "------- Historial de Transacciones--------" + ANSI_RESET);
        for (String transaction : history) {
            out.println(transaction);
        }
    }

    /**
     * Muestra el saldo del usuario en USD.
     */
    private void displayBalanceInUSD() {
        double balanceInUSD = transactionService.getCurrentBalanceInUSD();
        out.println(ANSI_AZUL + "__________________________________" + ANSI_RESET);
        out.printf("Su saldo actual es USD $%.2f\n", balanceInUSD);
        out.println(ANSI_AZUL + "__________________________________" + ANSI_RESET);
        displayMenu();
    }

    /**
     * Obtiene la entrada del usuario como un double.
     * Si la entrada no es un número válido, solicita al usuario que ingrese un
     * número válido.
     *
     * @return la entrada del usuario como un double
     */
    private double getUserInputAsDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                out.println(ANSI_RED + "Por favor, ingrese un número válido." + ANSI_RESET);
            }
        }
    }
}