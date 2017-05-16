package ru.itpark.service;

import ru.itpark.models.Account;

import java.util.List;

public interface AccountService {

    Account getAccountById(int owner_Id);

    void register(Account account);

    void removeAccount(int account);

    void update(Account account);

    List<Account> getAccounts(int owner_id);
}
