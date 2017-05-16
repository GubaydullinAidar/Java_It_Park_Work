package ru.itpark.dao;

import ru.itpark.models.Account;

import java.util.List;

public interface AccountDao extends BaseCrudDao<Account> {
    List<Account> findAllAccounts(int owner_id);
}
