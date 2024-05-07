package models;

public class User {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Wallet wallet;

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.wallet = new Wallet(0); // Asume que existe un constructor en Wallet.
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Wallet getWallet() {
    return wallet;
  }

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }

}
