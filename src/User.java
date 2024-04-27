public class User {
    private String name;
    private String password;
    private Wallet wallet;

    public User(String name, String password, Wallet wallet) {
        this.name = name;
        this.password = password;
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
}