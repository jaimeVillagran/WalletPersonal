public class Wallet {
    private double balance;

    public Wallet() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: El monto a depositar debe ser mayor que cero.");
            System.out.println("Ingrese un monto válido");
        } else {
            balance += amount;
            System.out.println("Deposito realizado: CLP " + amount);
            System.out.println("Nuevo saldo: CLP " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor que cero.");
            System.out.println("Ingrese un monto válido");
        } else if (balance >= amount) {
            balance -= amount;
            System.out.println("Retiro realizado: CLP " + amount);
            System.out.println("Nuevo saldo: CLP " + balance);
        } else {
            System.out.println("Errot: Fondos insuficientes");
        }
    }

    // Método para obtener el saldo actual
    public double getBalance() {
        return balance;
    }

    // Método para consultar el saldo actual
    public void checkBalance() {
        System.out.println("Saldo actual: CLP " + balance);
    }
}