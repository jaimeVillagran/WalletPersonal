package initialization;

import user.User;
import transactions.TransactionManager;
import logic.BusinessLogic;
import user.Wallet;

public class ApplicationInitializer {

  public BusinessLogic initializeComponents(User user) {
    Wallet wallet = user.getWallet();
    TransactionManager transactionManager = new TransactionManager(wallet);
    // Crea una instancia de BusinessLogic con una tasa de cambio de 950.0
    return new BusinessLogic(wallet, transactionManager, 950.0);

  }
}
