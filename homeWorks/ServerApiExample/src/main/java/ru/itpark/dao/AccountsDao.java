package ru.itpark.dao;

import ru.itpark.models.Account;

public interface AccountsDao extends BaseCrudDao<Account> {
    int saveForUser(int userId, Account account);
}
