package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.itpark.models.User;
import ru.itpark.service.UserService;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup (@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
            if (userService.checkUserExists(user.getUsername(), user.getEmail())) {
                if (userService.checkEmailExists(user.getEmail())) {
                    String emailExist = "Пользователь с таким Email зарегистрирован";
                    headers.add("Email exist", emailExist);
                } else if (userService.checkUsernameExists(user.getUsername())) {
                    String usernameExist = "Логин занят, выберите другой Логин";
                    headers.add("Username exist", usernameExist);
                }

                return new ResponseEntity<>(null, headers, HttpStatus.CONFLICT);
            } else {
                String signupOk = "Регистрация прошла успешно";
                headers.add("signupOk", signupOk);
                return new ResponseEntity<>(userService.createUser(user), headers, HttpStatus.OK);
            }
    }

    @PostMapping("/signin")
    public ResponseEntity<User> login (@RequestHeader("username") String username,
                                        @RequestHeader("password") String password) {
        String token = userService.login(username, password);
        User user = userService.findByToken(token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", token);
        return new ResponseEntity<>(user, headers, HttpStatus.ACCEPTED);
    }
}