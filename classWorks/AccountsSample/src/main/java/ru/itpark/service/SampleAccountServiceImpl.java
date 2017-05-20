package ru.itpark.service;

import ru.itpark.model.Account;
import ru.itpark.repository.AccountRepository;

/**
 * Created by Student9 on 17.05.2017.
 */
public class SampleAccountServiceImpl implements AccountService {
    private AccountRepository repository;

    public void setRepository(AccountRepository repository) {
        this.repository = repository;
    }

    public void addAccount(Account account) {
        repository.add(account);
    }

    public void deposit(Account account, int sum) {
        account.setBalance(account.getBalance() + sum);
        repository.save(account);
    }

    public void withdraw(Account account, int sum) {
        account.setBalance(account.getBalance() - sum);
        repository.save(account);
    }

    public void transfer(Account sender, Account recipient, int sum) {
        withdraw(sender, sum);
        deposit(recipient, sum);
    }
}
