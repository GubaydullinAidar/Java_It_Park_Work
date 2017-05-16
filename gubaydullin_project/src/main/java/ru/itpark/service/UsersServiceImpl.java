package ru.itpark.service;


import ru.itpark.dao.UsersDao;
import ru.itpark.models.User;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }


    public boolean hasName(String name, String userMail) {
        User user = usersDao.find(userMail);
        return user.getName().equals(name);
    }

    public User getUserByMail(String userMail) {
        return usersDao.find(userMail);
    }


    public void register(User user) {
        System.out.println("USER ID " + usersDao.save(user));
    }

   /* public List<User> getListOfUsers() {
        return usersDao.findAll();
    }*/

    public void removeUser(int id) {
        usersDao.delete(id);
    }

    public void update(User user) {
        usersDao.update(user);
    }

    public List<Integer> getCardOfUser(int userId) {
        return null;
    }
}
