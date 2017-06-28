package ru.itpark.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itpark.models.User;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {
	User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}
