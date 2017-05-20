package ru.itpark.service;

import ru.itpark.model.Account;

/**
 * Created by Student9 on 17.05.2017.
 */
public interface AccountService {
    void addAccount (Account account);
    void deposit(Account account, int sum);
    void withdraw(Account account, int sum);
    void transfer(Account sender, Account recipient, int sum);
}
