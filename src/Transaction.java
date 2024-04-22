import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private double amount;
    private LocalDateTime date;
    private String description;
    private double balanceAfter;


    public Transaction(String type, double amount, String description, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.description = description;
        this.balanceAfter = balanceAfter;
    }

    // Métodos getters para los campos
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }
}
