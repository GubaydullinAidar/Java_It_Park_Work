package ru.itpark.dao;

import ru.itpark.models.User;

import java.util.List;

public interface UsersDao extends BaseCrudDao<User> {
    //List<User> findAllByAge(int age);
    User findByIdWithAccounts(int id);
    User findByName(String name);
}
