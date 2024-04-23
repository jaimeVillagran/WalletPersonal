import java.util.List;

public class User {
    private String name;
    private String apellido;
    private String email;
    private String password;
    private List<Wallet> accounts;

    public User(String name, String apellido, String email, String password) {
        this.name = name;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.accounts = new List<Wallet>();
    }

    public String getName() {
        return name;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    // Metodo para verificar la contrasenya
    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    // Metodo para agrear una cuenta
    public void addAccount(Wallet account) {
        accounts.add(account);
    }

    // Metodo para selecionar una cuenta (Wllet) por indice
    public Wallet selectAccount(int index) {
        if (index < 0 || index >= accounts.size()) {
            return null;
        }
        return accounts.get(index);
    }
    // Metodo para obtener la lista de cuentas (Wallet)

    public List<Wallet> getAccounts() {
        return accounts;
    }

    // Método para dar la bienvenida al usuario por nombre y apellido

    public String welcomeMessage() {
        return "Bienvenido " + name + " " + apellido;
    }

    public Wallet selectAccount() {
        return accounts.get(0);
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

}
