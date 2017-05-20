package ru.itpark;

import ru.itpark.model.Account;
import ru.itpark.repository.AccountRepository;
import ru.itpark.repository.InMemoryAccountRepositoryImp;
import ru.itpark.service.AccountService;
import ru.itpark.service.SampleAccountServiceImpl;

/**
 * Created by Student9 on 17.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        AccountService accountService = new SampleAccountServiceImpl();
        Account vasya = new Account(1, "Vasya", 50000);
        Account petya = new Account(2,"Petya", 100000);
        accountService.addAccount(vasya);
        accountService.addAccount(petya);

        accountService.deposit(vasya,2000);
        System.out.println(vasya.getBalance());
    }
}
