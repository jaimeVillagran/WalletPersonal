public class User {
    private String name;
    private String password;
    private Wallet wallet;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.wallet = new Wallet();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

}
