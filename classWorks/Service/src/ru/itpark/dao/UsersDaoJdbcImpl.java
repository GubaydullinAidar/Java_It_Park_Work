package ru.itpark.dao;

import ru.itpark.models.User;

import java.util.LinkedList;

public class UsersDaoJdbcImpl implements UsersDao {
    @Override
    public int save(User model) {
        return 0;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public LinkedList<User> findAll() {
        return null;
    }
}
