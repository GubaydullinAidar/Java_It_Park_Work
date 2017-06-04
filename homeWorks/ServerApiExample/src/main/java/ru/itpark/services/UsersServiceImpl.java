package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.dao.AccountsDao;
import ru.itpark.dao.UsersDao;
import ru.itpark.models.Account;
import ru.itpark.models.User;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private AccountsDao accountsDao;

    @Override
    public List<User> getUsersByMail(String mail) {
        return usersDao.findAllByMail(mail);
    }

    @Override
    public User getUserWithAccount(int userId) {
        return usersDao.findByIdWithAccounts(userId);
    }

    @Override
    public int addAccountToUser(int userId, Account account) {
        return accountsDao.saveForUser(userId, account);
    }
}
