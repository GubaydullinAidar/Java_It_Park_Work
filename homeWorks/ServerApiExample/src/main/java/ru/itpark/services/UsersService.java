package ru.itpark.services;

import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
    //List<User> getUsersByAge(int age);

    User getUserWithAccount (int userId);

    User getUserById(int userId);

    public User getUserByName(String userName);

    void register(User user);

    void removeUser(int id);

    void update(User user);

    List<User> getListOfUsers();
}
