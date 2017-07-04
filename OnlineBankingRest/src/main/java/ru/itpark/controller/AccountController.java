package ru.itpark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.models.*;
import ru.itpark.service.AccountService;
import ru.itpark.service.TransactionService;
import ru.itpark.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/user/{user-id}/primaryAccountTransaction")
    public ResponseEntity<List<PrimaryTransaction>> primaryTransaction(@PathVariable("user-id") Long userId){
        List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(userId);
        return new ResponseEntity<>(primaryTransactionList, HttpStatus.ACCEPTED);
    }

    @PostMapping("/user/{user-id}/savingsAccountTransaction")
    public ResponseEntity<List<SavingsTransaction>> savingsTransaction(@PathVariable("user-id") Long userId){
        List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(userId);
        return new ResponseEntity<>(savingsTransactionList, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Model model, Principal principal) {

        //List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());

        User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        //model.addAttribute("primaryTransactionList", primaryTransactionList);

        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {

       // List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());

        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
      //  model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositPost(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.deposit(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.GET)
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public String withdrawPost(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, Principal principal) {
        accountService.withdraw(accountType, Double.parseDouble(amount), principal);

        return "redirect:/userFront";
    }


}
