package transactions;

import java.util.List;

public interface ITransactionService {

  void deposit(double amount);

  void withdraw(double amount);

  double getCurrentBalance();

  List<String> getTransactionHistory();

  double getCurrentBalanceInUSD();

}
