package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dto.UserDto;
import ru.itpark.models.User;
import ru.itpark.service.UserService;

import static ru.itpark.converters.Converter.convert;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        if (user.getUsername() != null) {
            if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
                return "Пользователь с таким логином и Email зарегистрирован";
            } else if (userService.checkEmailExists(user.getEmail())) {
                return "Пользователь с таким Email зарегистрирован";
            } else if (userService.checkUsernameExists(user.getUsername())) {
                return "Логин занят, выберите другой Логин";
            } else {

                //userService.createUser(user);

                return "Регистрация прошла успешно";
            }
        } else {
            String oops = "Что-то пошло не так!";
            return oops;
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@RequestHeader("username") String username,
                          @RequestHeader("password") String password) {
        String token = userService.login(username, password);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", token);
        return new ResponseEntity<>(null, headers, HttpStatus.ACCEPTED);
    }
}