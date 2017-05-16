package ru.itpark.service;

import ru.itpark.dao.AccountDao;
import ru.itpark.models.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getAccountById(int owner_Id) {
        return accountDao.find(owner_Id);
    }

    public void register(Account account) {
        accountDao.save(account);
    }

    public void removeAccount(int account) {
        accountDao.delete(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public List<Account> getAccounts(int owner_id) {
        return accountDao.findAllAccounts(owner_id);
    }
}
