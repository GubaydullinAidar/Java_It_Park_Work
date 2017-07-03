package ru.itpark.service;

import ru.itpark.models.User;

import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    User findByUserId(Long userId);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    User saveUser(User user);

    String login(String login, String password);
}
