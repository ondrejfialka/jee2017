package cz.ucl.jee.accounts;

public interface AccountService {
	
	boolean accountExists(String accountNumber);
	
	void moneyTransfer(Account sourceAccount, Account targetAccount);

}
