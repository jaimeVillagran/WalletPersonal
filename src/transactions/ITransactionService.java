package transactions;

import java.util.List;

/**
 * Interfaz para el servicio de transacciones.
 * Esta interfaz define los métodos que deben ser implementados por cualquier
 * clase que proporcione un servicio de transacciones.
 * Los métodos incluyen depositar, retirar, obtener el saldo actual, obtener el
 * historial de transacciones y obtener el saldo actual en USD.
 */
public interface ITransactionService {

  /**
   * Realiza un depósito en la cuenta del usuario.
   * Este método toma un monto y lo suma al saldo actual del usuario.
   *
   * @param amount el monto a depositar
   */
  void deposit(double amount);

  /**
   * Realiza un retiro de la cuenta del usuario.
   * Este método toma un monto y lo resta del saldo actual del usuario.
   *
   * @param amount el monto a retirar
   */
  void withdraw(double amount);

  /**
   * Obtiene el saldo actual de la cuenta del usuario.
   *
   * @return el saldo actual de la cuenta del usuario
   */
  double getCurrentBalance();

  /**
   * Obtiene el historial de transacciones del usuario.
   *
   * @return una lista de cadenas que representa el historial de transacciones del
   *         usuario
   */
  List<String> getTransactionHistory();

  /**
   * Obtiene el saldo actual de la cuenta del usuario en USD.
   *
   * @return el saldo actual de la cuenta del usuario en USD
   */
  double getCurrentBalanceInUSD();

}