package cn.tradewin.angular.persist.services;

import java.util.List;

import cn.tradewin.angular.persist.model.Account;

public interface AccountService {
	int addAccount(Account account);
    int delAccount(String id);
	int updAccount(Account account);
	Account findAccount(String id);
	List<Account> getAllAccounts();
}
