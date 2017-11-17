package cz.ucl.jee.mybank.accounts;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HardcodedAccountBlackList implements AccountBlackList {
	
	private static final Set<Account> blackList;
	
	static {
		blackList = new HashSet<Account>();
		blackList.add(new Account.Builder()
				.prefix(0).number(123456)
				.bankCode("0100")
				.build());
		blackList.add(new Account.Builder()
				.prefix(0)
				.number(123456)
				.bankCode("0800")
				.build());
	}

	public boolean isAccountOnList(Account account) {
		return blackList.contains(account);
	}

}
