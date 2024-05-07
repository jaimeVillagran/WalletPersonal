package menu;

import transactions.ITransactionService;
import user.User;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import authentication.IUserService;

/**
 * La clase Menu representa el menú principal de la aplicación Wallet Personal.
 * Proporciona opciones para iniciar sesión, crear una cuenta, realizar
 * transacciones y consultar el saldo.
 */
public class Menu {
    private IUserService userService;
    private ITransactionService transactionService;
    private Scanner sc;
    private PrintStream out;

    /**
     * Clase que representa el menú de la aplicación.
     * 
     * Esta clase se encarga de manejar las opciones del menú y realizar las
     * operaciones correspondientes.
     * 
     * @param userService        el servicio de usuarios utilizado para realizar
     *                           operaciones relacionadas con los usuarios
     * @param transactionService el servicio de transacciones utilizado para
     *                           realizar operaciones relacionadas con las
     *                           transacciones
     * @param in                 el flujo de entrada utilizado para leer las
     *                           opciones del usuario
     * @param out                el flujo de salida utilizado para mostrar los
     *                           mensajes al usuario
     */
    public Menu(IUserService userService, ITransactionService transactionService, InputStream in, PrintStream out) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.sc = new Scanner(in);
        this.out = out;
    }

    /**
     * Muestra el menú inicial de la billetera personal.
     * El usuario puede elegir entre tener una cuenta activa o crear una nueva
     * cuenta.
     * Si elige tener una cuenta activa, se procesa la opción seleccionada.
     * Si elige crear una cuenta, se le solicitará más información al usuario.
     */
    public void initialMenu() {
        out.println("\u001B[34m**********************************************");
        out.println("* Bienvenido a la billetera Wallet Personal *");
        out.println("**********************************************\u001B[0m");
        out.println("Tienes una cuenta activa o deseas crear una?");
        out.println("* Opción 1 - Cuenta activa");
        out.println("* Opción 2 - Crear cuenta");
        out.print("Elija una opción (1/2): ");
        int choice = getUserInputAsInt();
        processInitialOption(choice);
    }

    /**
     * Método privado que obtiene la entrada del usuario como un entero.
     * 
     * @return el número entero ingresado por el usuario.
     */
    private int getUserInputAsInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            out.println("\u001B[31mPor favor, ingrese un número válido.\u001B[0m");
            return getUserInputAsInt(); // Recursively call until a valid number is entered
        }
    }

    /**
     * Procesa la opción inicial seleccionada por el usuario.
     * 
     * @param choice La opción seleccionada por el usuario.
     */
    private void processInitialOption(int choice) {
        if (choice == 1) {
            handleLogin();
        } else if (choice == 2) {
            handleCreateAccount();
        } else {
            out.println("\u001B[31mOpción inválida, intente de nuevo.\u001B[0m");
            initialMenu(); // Recursive call to handle incorrect options
        }
    }

    /**
     * Maneja el proceso de inicio de sesión.
     * El usuario tiene tres intentos para ingresar su correo electrónico y
     * contraseña correctamente.
     * Si el inicio de sesión es exitoso, se muestra un mensaje de bienvenida y se
     * muestra el menú principal.
     * Si el inicio de sesión falla después de tres intentos, se muestra un mensaje
     * de error y se cierra el programa.
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
                out.println("\u001B[32mAutenticación exitosa.\u001B[0m");
                displayWelcomeAndMenu(user);
                return;
            } else {
                out.println("\u001B[31m=====================================");
                out.println("* Autenticación fallida. Verifique sus credenciales. *");
                out.println("=====================================\u001B[0m");
                attempts++;
            }
        }
        out.println("\u001B[31m========================================");
        out.println("Autenticación fallida. Inténtelo más tarde....");
        out.println("========================================\u001B[0m");
        System.exit(0);
    }

    /**
     * Maneja la creación de una cuenta de usuario.
     * Solicita al usuario ingresar su nombre, apellido, email y contraseña.
     * Si alguno de los campos está vacío, muestra un mensaje de error y vuelve a
     * solicitar los datos.
     * Luego, llama al método createNewUser del servicio de usuarios para crear un
     * nuevo usuario.
     * Si se crea exitosamente, muestra un mensaje de éxito y muestra el menú
     * principal.
     * Si no se puede crear la cuenta, muestra un mensaje de error y vuelve a
     * solicitar los datos.
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
            out.println("\u001B[31m***************************************");
            out.println("* Los campos no pueden estar vacíos *");
            out.println("****************************************\u001B[0m");
            handleCreateAccount(); // Volver a intentar crear cuenta
            return;
        }

        User user = userService.createNewUser(firstName, lastName, email, password);
        if (user != null) {
            out.println("\u001B[32mCuenta creada exitosamente.\u001B[0m");
            displayWelcomeAndMenu(user);
        } else {
            out.println("\u001B[31mNo se pudo crear la cuenta. Intente nuevamente.\u001B[0m");
            handleCreateAccount();
        }
    }

    /**
     * Muestra un mensaje de bienvenida y el menú principal para el usuario.
     * 
     * @param user el objeto User que representa al usuario actual
     */
    private void displayWelcomeAndMenu(User user) {
        out.println("\u001B[34m************************************");
        out.println("*          Wallet Personal         *");
        out.println("*     Bienvenido " + user.getFirstName() + " " + user.getLastName() + " *");
        out.println("************************************\u001B[0m");
        displayMenu();
    }

    /**
     * Muestra el menú de opciones para el usuario.
     * Las opciones incluyen: Depositar, Retirar, Consultar Movimientos y Saldo en
     * CLP $, Consultar saldo en USD y Salir.
     * Llama al método handleUserChoice() para manejar la elección del usuario.
     */
    private void displayMenu() {
        out.println("1. Depositar");
        out.println("2. Retirar");
        out.println("3. Consultar Movimientos y Saldo en CLP $");
        out.println("4. Consultar saldo en USD");
        out.println("5. Salir");
        handleUserChoice();
    }

    /**
     * Maneja la elección del usuario en el menú.
     * Muestra las opciones disponibles al usuario y ejecuta la acción
     * correspondiente
     * según la opción seleccionada.
     * El bucle se repite hasta que el usuario elija la opción de salir.
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
                    out.println("\u001B[34mSaliendo del sistema...\u001B[0m");
                    sc.close();
                    return; // Salir correctamente
                default:
                    out.println("\u001B[31mOpción inválida. Intente nuevamente.\u001B[0m");
            }
        }
    }

    /**
     * Realiza un depósito en la billetera personal.
     * 
     * Muestra un mensaje solicitando al usuario que ingrese el monto a depositar.
     * Si el monto ingresado es mayor que cero, se realiza el depósito llamando al
     * método deposit() del servicio de transacciones.
     * Luego, muestra un mensaje de éxito con el nuevo saldo actualizado.
     * Si el monto ingresado es menor o igual a cero, muestra un mensaje de error.
     * Finalmente, vuelve a mostrar el menú principal.
     */
    private void handleDeposit() {
        out.println("\u001B[34mIngrese el monto a depositar:\u001B[0m");
        double amount = getUserInputAsDouble();
        if (amount > 0) {
            transactionService.deposit(amount);
            out.println("\u001B[32m***************************************************************");
            out.printf(" * Depósito realizado con éxito. Nuevo saldo: $ %.2f\n",
                    transactionService.getCurrentBalance());
            out.println("*****************************************************************\u001B[0m");
        } else {
            out.println("\u001B[31mEl monto a depositar debe ser mayor que cero.\u001B[0m");
        }
        displayMenu(); // Redisplay the menu
    }

    /**
     * Maneja la operación de retiro de dinero de la billetera personal.
     * Solicita al usuario ingresar el monto a retirar y verifica si es válido y si
     * hay suficientes fondos.
     * Si el monto es válido y hay suficientes fondos, realiza el retiro y muestra
     * el saldo restante.
     * Si el monto no es válido o no hay suficientes fondos, muestra un mensaje de
     * error.
     * Después de realizar la operación, muestra nuevamente el menú.
     */
    private void handleWithdraw() {
        out.println("\u001B[34mIngrese el monto a retirar:\u001B[0m");
        double amount = getUserInputAsDouble();
        if (amount > 0 && transactionService.getCurrentBalance() >= amount) {
            transactionService.withdraw(amount);
            out.printf("\u001B[32mRetiro realizado con éxito. Saldo restante: $%.2f\u001B[0m\n",
                    transactionService.getCurrentBalance());
        } else {
            out.println("\u001B[31mFondos insuficientes o monto inválido.\u001B[0m");
        }
        displayMenu(); // Redisplay the menu
    }

    /**
     * Muestra el historial de transacciones en la pantalla.
     * Obtiene el historial de transacciones utilizando el servicio de transacciones
     * y lo muestra en la consola.
     * Luego vuelve a mostrar el menú principal.
     */
    private void displayTransactionHistory() {
        List<String> history = transactionService.getTransactionHistory();
        out.println("\u001B[34mHistorial de Transacciones:\u001B[0m");
        for (String transaction : history) {
            out.println(transaction);
        }
        displayMenu(); // Redisplay the menu
    }

    /**
     * Muestra el saldo actual en dólares estadounidenses.
     * Calcula el saldo actual en dólares estadounidenses utilizando el servicio de
     * transacciones y lo muestra en la consola.
     * Después de mostrar el saldo, vuelve a mostrar el menú principal.
     */
    private void displayBalanceInUSD() {
        double balanceInUSD = transactionService.getCurrentBalanceInUSD();
        out.println("\u001B[34m************************************");
        out.printf("Su saldo actual es USD $%.2f\n", balanceInUSD);
        out.println("************************************\u001B[0m");
        displayMenu(); // Mostrar el menú principal nuevamente
    }

    /**
     * Obtiene la entrada del usuario como un número decimal.
     * 
     * @return El número decimal ingresado por el usuario.
     */
    private double getUserInputAsDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                out.println("\u001B[31mPor favor, ingrese un número válido.\u001B[0m");
            }
        }
    }
}