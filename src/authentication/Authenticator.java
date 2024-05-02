package authentication;

import user.User;

import java.util.Scanner;

public class Authenticator {
    private User predefinedUser;

    /**
     * Constructor de la clase Authenticator.
     * @param predefinedUser el usuario predefinido que se utilizará para la autenticación.
     */
    public Authenticator(User predefinedUser) {
        this.predefinedUser = predefinedUser;
    }

    /**
     * Método para autenticar al usuario basado en credenciales proporcionadas.
     * @param inputEmail el email introducido por el usuario.
     * @param inputPassword la contraseña introducida por el usuario.
     * @return true si las credenciales son correctas, false de lo contrario.
     */
    public boolean authenticate(String inputEmail, String inputPassword) {
        if (predefinedUser.getEmail().equals(inputEmail) && predefinedUser.checkPassword(inputPassword)) {
            System.out.println("¡Bienvenido, " + predefinedUser.getFirstName() + " " + predefinedUser.getLastName() + "!");
            return true;
        } else {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
            return false;
        }
    }

    /**
     * Método para manejar el proceso de autenticación con intentos y entrada del usuario.
     */
    public void authenticateUser() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Ingrese su email: ");
            String inputEmail = sc.nextLine().trim();
            System.out.print("Ingrese su contraseña: ");
            String inputPassword = sc.nextLine().trim();

            if (authenticate(inputEmail, inputPassword)) {
                return;
            } else {
                attempts++;
                if (attempts >= 3) {
                    System.out.println("******************************************************************************");
                    System.out.println("* Se han agotado los intentos. Por favor, vuelva a intentarlo más tarde. *");
                    System.out.println("******************************************************************************");
                }
            }
        }
        sc.close(); // Es importante cerrar el Scanner para evitar fugas de recursos
    }
}
