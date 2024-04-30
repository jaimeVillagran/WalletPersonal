package User;

public class Wallet {
  private double balance;

  // Constructor para crear una billetera con saldo inicial cero
  public Wallet(double initialBalance) {
    this.balance = initialBalance;
  }

  // Getter para obtener el balance actual de la billetera

  public double getBalance() {
    return balance;
  }

  // Setter para modificar el balance de la billetera

  public void setBalance(double balance) {
    this.balance = balance;
  }

  // Método para mostrar el saldo actual de la billetera

  public void checkBalance() {
    System.out.println("********************************");
    System.out.println("Saldo actual: CLP " + String.format("%.2f", balance));
    System.out.println("********************************");
  }

  // Método para depositar una cantidad de dinero en la billetera
  public void deposit(double amount) {
    if (amount > 0) {
      // Verifica que la cantidad a depositar sea mayor a 0
      balance += amount; // Suma la cantidad al saldo actual
      // Imprime el mensaje de exito
      System.out.println("Depósito exitoso con éxito. Nuevo saldo: CLP" + String.format("%.2f", balance));
    } else {
      System.out.println("El monto a depositar debe ser mayor a cero"); // Imprime el mensaje de error
    }

  }

  // Método para retirar una cantidad de dinero de la billetera
  public void withdraw(double amount) {
    if (amount > 0 && balance >= amount) {
      // Verifica que la cantidad a retirar sea mayor a 0 y haya saldo suficiente
      balance -= amount;
      System.out.println("Retiro realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", balance));
    } else if (amount <= 0) {
      System.out.println("El monto a retirar debe ser mayor que cero.");
    } else {
      System.out.println("No hay saldo suficiente para realizar el retiro.");
    }
  }
}