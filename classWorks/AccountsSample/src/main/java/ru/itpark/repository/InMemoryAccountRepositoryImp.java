package ru.itpark.repository;

import ru.itpark.model.Account;
import ru.itpark.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student9 on 17.05.2017.
 */
public class InMemoryAccountRepositoryImp implements AccountRepository {
    private List<Account> accounts = new ArrayList<Account>();

    public void add(Account account) {
        accounts.add(account);
    }

    public void remove(Account account) {

    }

    public void save(Account account) {

    }

    public List<Account> findAll() {
        return null;
    }
}
