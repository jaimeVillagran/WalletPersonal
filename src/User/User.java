package User;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Wallet wallet;

    // Constructor para crear un usuario con nombre, apellido, email y contraseña

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet(); // Crea una nueva billetera para el usuario

    }

    // Getters y setters

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter para la billetera del usuario
    public Wallet getWallet() {
        return wallet;
    }

    // Metodo para verificar la contraseña del usuario

    public boolean checkPassword(String inputpassword) {
        return this.password.equals(password);
    }

}