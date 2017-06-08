package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.Account;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

import java.util.List;

@RestController
public class RestUsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/users")
    public List<User> getFriends(@RequestParam("mail") String mail) {
        return service.getUsersByMail(mail);
    }

    @GetMapping(value = "users/{user-id}", params = "select=with_account")
    public User getUserWithAuto(@PathVariable("user-id") int userId) {
        return service.getUserWithAccount(userId);
    }

    @PostMapping(value = "users/{user-id}/account")
    public Integer addAccountToUser(@PathVariable("user-id") int userId,
                              @RequestBody Account account) {
        return service.addAccountToUser(userId, account);
    }
}
