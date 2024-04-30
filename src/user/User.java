package user;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Wallet wallet;

    // Constructor para crear un usuario con nombre, apellido, email y contraseña
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet(0.0); // Crea una nueva billetera para el usuario
    }

    public String getFirstName() {
        return firstName;
    }

    // Getter para el apellido del usuario
    public String getLastName() {
        return lastName;
    }

    // Getter para el correo electrónico del usuario
    public String getEmail() {
        return email;
    }

    // Getter para la contraseña del usuario
    public String getPassword() {
        return password;
    }


    // Método para verificar la contraseña del usuario
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Getter para la billetera del usuario
    public Wallet getWallet() {
        return wallet;
    }

}