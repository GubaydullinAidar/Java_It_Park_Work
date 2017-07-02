package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dao.RoleDao;
import ru.itpark.dto.UserDto;
import ru.itpark.models.User;
import ru.itpark.models.security.UserRole;
import ru.itpark.service.UserService;

import java.util.HashSet;
import java.util.Set;

import static ru.itpark.converters.Converter.convert;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private RoleDao roleDao;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(User user) {

        if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
            return "Пользователь с таким логином и Email зарегистрирован";
        } else if (userService.checkEmailExists(user.getEmail())) {
            return "Пользователь с таким Email зарегистрирован";
        } else if (userService.checkUsernameExists(user.getUsername())) {
            return "Логин занят, выберите другой Логин";
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "Регистрация прошла успешно";
        }
    }

    @PostMapping("/signin")
    public UserDto signin(@RequestHeader("login") String username,
                          @RequestHeader("password") String password) {
        if (userService.findByUsername(username) == null) {
            return null;
        } else {
            if (passwordEncoder.matches(password, userService.findByUsername(username).getPassword())) {
                User user = userService.findByUsername(username);
                UserDto convertedUser = convert(user);
                return convertedUser;
            }
        }
        return null;
    }
}