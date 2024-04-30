package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deposit implements Transaction {
    private double amount;
    private LocalDateTime date;

    // Constructor para crear una transacción de depósito con una cantidad
    // específica
    public Deposit(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    // Implementaciones de los métodos de la interfaz Transaction
    @Override
    public String getType() {
        return "Depósito";
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' HH:mm");
        String formattedDateTime = date.format(formatter);
        return String.format("%s de CLP %.2f el %s", getType(), amount, formattedDateTime);
    }
}