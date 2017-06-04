package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.dao.UsersDao;
import ru.itpark.models.User;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

   /* @Override
    public List<User1> getUsersByAge(int age) {
        return usersDao.findAllByAge(age);
    }*/

    public User getUserWithAccount(int userId) {
        return usersDao.findByIdWithAccounts(userId);
    }

    public UsersServiceImpl() {
    }

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public User getUserById(int userId) {
        return usersDao.find(userId);
    }

    public User getUserByName(String userName) { return usersDao.findByName(userName); }

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
