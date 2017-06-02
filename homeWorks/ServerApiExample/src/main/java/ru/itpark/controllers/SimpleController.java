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
    private UsersService service;

    /*@GetMapping("/users")
    public List<User> getFriends(@RequestParam("age") int age) {
        return service.getUsersByAge(age);
    }
*/
    @GetMapping(value = "users/{user-id}", params = "select=with_auto")
    public User getUserWithAccount(@PathVariable("user-id") int userId) {
        return service.getUserWithAccount(userId);
    }

    @GetMapping("/main")
    public String getMainPage() {
        return "/jsp/main";
    }

    @GetMapping("/first")
    public String getLoginPage() {
        return "first";
    }

    @RequestMapping(value = "/main",method = RequestMethod.POST)
    public String test(@RequestParam("userNameSignUp") String userNameSignUp,
                       @RequestParam("emailsignup") String emailsignup,
                       @RequestParam("passwordsignup") String passwordsignup,
                       @RequestParam("passwordsignup_confirm") String passwordsignup_confirm,
                       Model model){
        model.addAttribute("userNameSignUp", userNameSignUp);
        return "hello";
    }

}
