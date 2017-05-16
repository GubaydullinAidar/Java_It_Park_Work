package ru.itpark.service;

import ru.itpark.models.User;

public interface UsersService {

    boolean hasName(int userId, String name, String userMail);

    User getUserById(int userId);

    void register(User user);

    void removeUser(int id);

    void update(User user);
}
