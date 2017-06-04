package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

@Controller
public class SimpleController {

    @Autowired
    private UsersService usersService;

    /*@GetMapping("/users")
    public List<User> getFriends(@RequestParam("age") int age) {
        return service.getUsersByAge(age);
    }
*/
    @GetMapping(value = "users/{user-id}", params = "select=with_auto")
    public User getUserWithAccount(@PathVariable("user-id") int userId) {
        return usersService.getUserWithAccount(userId);
    }

    @GetMapping("/main")
    public String getMainPage() {
        return "/jsp/main";
    }

    @GetMapping("/first")
    public String getLoginPage() {
        return "/jsp/first";
    }

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String test(@RequestParam("usernamesignup") String userNameSignUp,
                       @RequestParam("emailsignup") String emailSignUp,
                       @RequestParam("passwordsignup") String passwordSignUp,
                       @RequestParam("passwordsignup_confirm") String passwordSignUp_confirm){
        if (passwordSignUp.equals(passwordSignUp_confirm)) {
            User user = new User(userNameSignUp, emailSignUp, passwordSignUp);
            usersService.register(user);
            return "redirect:/first";
        } else
            return "redirect:/main";
    }

}
