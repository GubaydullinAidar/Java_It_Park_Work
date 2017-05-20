package ru.itpark.repository;

import ru.itpark.model.Account;

import java.util.List;

/**
 * Created by Student9 on 17.05.2017.
 */
public interface AccountRepository {
    void add(Account account);
    void remove(Account account);
    void save(Account account);
    List<Account> findAll();
}
