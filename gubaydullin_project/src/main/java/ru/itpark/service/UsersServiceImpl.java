package ru.itpark.service;


import ru.itpark.dao.UsersDao;
import ru.itpark.models.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public User getUserById(int userId) {
        return usersDao.find(userId);
    }

    public User getUserByMail(String userMail) { return usersDao.findByMail(userMail); }

    public void register(User user) {
        System.out.println("USER ID " + usersDao.save(user));
    }

    public void removeUser(int id) {
        usersDao.delete(id);
    }

    public void update(User user) {
        usersDao.update(user);
    }

    public List<User> getListOfUsers() {
        return usersDao.findAll();
    }
}
