package user;

/**
 * Esta clase representa un Usuario para una aplicación bancaria.
 * Proporciona métodos para obtener información del usuario y verificar la contraseña.
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Wallet wallet;

    /**
     * Construye una nueva instancia de User con un nombre, apellido, correo electrónico y contraseña dados.
     * @param firstName el nombre del usuario.
     * @param lastName el apellido del usuario.
     * @param email el correo electrónico del usuario.
     * @param password la contraseña del usuario.
     */
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet(0.0); // Crea una nueva billetera para el usuario
    }

    /**
     * Devuelve el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Devuelve el apellido del usuario.
     * @return el apellido del usuario.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Devuelve el correo electrónico del usuario.
     * @return el correo electrónico del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Devuelve la contraseña del usuario.
     * @return la contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Verifica la contraseña del usuario.
     * @param inputPassword la contraseña a verificar.
     * @return verdadero si la contraseña es correcta, falso en caso contrario.
     */
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    /**
     * Devuelve la billetera del usuario.
     * @return la billetera del usuario.
     */
    public Wallet getWallet() {
        return wallet;
    }
}