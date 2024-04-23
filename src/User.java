import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String apellido;
    private String email;
    private String password;
    private List<Wallet> accounts;

    // Constructor
    public User(String name, String apellido, String email, String password) {
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    // Métodos para obtener los atributos del usuario
    public String getNombre() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return email;
    }

    // Método para verificar la contraseña
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Método para agregar una cuenta (Wallet) al usuario
    public void addAccount(Wallet wallet) {
        accounts.add(wallet);
    }

    // Método para seleccionar una cuenta (Wallet) por índice
    public Wallet selectAccount(int index) {
        if (index < 0 || index >= accounts.size()) {
            throw new IllegalArgumentException("Índice de cuenta inválido");
        }
        return accounts.get(index);
    }

    // Método para obtener la lista de cuentas (Wallets)
    public List<Wallet> getAccounts() {
        return accounts;
    }

    // Método para dar la bienvenida al usuario por nombre y apellido
    public void welcomeUser() {
        System.out.println("¡Bienvenido, " + name + " " + apellido + "!");
    }

    // Método para cerrar la sesión del usuario
    public void exitUser() {
        System.out.println("Hasta pronto, " + name + " " + apellido + "!");
    }
}
