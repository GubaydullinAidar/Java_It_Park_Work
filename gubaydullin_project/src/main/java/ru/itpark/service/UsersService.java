package ru.itpark.service;

import ru.itpark.models.User;

import java.util.List;

public interface UsersService {

    boolean hasName(String name, String userMail);

    User getUserByMail(String userMail);

    void register(User user);

    /*List<User> getListOfUsers();*/

    void removeUser(int id);

    void update(User user);

    /*List<Integer> getCardOfUser(int userId);*/
}
