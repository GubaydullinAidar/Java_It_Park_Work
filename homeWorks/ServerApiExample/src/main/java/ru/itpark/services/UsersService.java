package ru.itpark.services;

import ru.itpark.models.Account;
import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
    List<User> getUsersByMail(String mail);

    User getUserWithAccount(int userId);
    int addAccountToUser(int userId, Account account);
}
