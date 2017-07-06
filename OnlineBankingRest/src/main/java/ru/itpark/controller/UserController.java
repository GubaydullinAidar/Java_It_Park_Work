package ru.itpark.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.dto.UserForSignUp;
import ru.itpark.models.User;
import ru.itpark.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/changeUser")
    public ResponseEntity<User> saveChangeUser(@RequestBody UserForSignUp newuser,
                                                 @RequestHeader("Auth-token") String token) {
        User user = userService.findByToken(token);
        user.setFirstName((newuser.getFirstName()));
        user.setLastName(newuser.getLastName());
        user.setEmail(newuser.getEmail());
        user.setPhone(newuser.getPhone());

        userService.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());

        model.addAttribute("user", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String profilePost(@ModelAttribute("user") User newUser, Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        //user.setUsername(newUser.getUsername());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());

        model.addAttribute("user", user);

        userService.saveUser(user);

        return "profile";
    }


}

