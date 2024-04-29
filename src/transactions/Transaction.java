package transactions;

import java.time.LocalDateTime;

public interface Transaction {

    // Métodos para obtener los atributos de la transacción
    String getType();

    double getAmount();

    LocalDateTime getDate();

    String getDescription(); // Agregamos un nuevo método que retorna una descripción
}