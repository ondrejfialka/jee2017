package cz.ucl.jee.accounts;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InMemoryAccountService implements AccountService {

	@Override
	public boolean accountExists(String accountNumber) {
		return "1234567890".equals(accountNumber);
	}

	@Override
	public void moneyTransfer(Account sourceAccount, Account targetAccount) {
		targetAccount.getBankCode();
		
	}

}
