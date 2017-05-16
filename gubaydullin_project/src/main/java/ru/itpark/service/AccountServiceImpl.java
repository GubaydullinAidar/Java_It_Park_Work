package ru.itpark.service;

import ru.itpark.dao.AccountDao;
import ru.itpark.models.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account getAccountById(int owner_Id) {
        return accountDao.find(owner_Id);
    }

    public void register(Account account) {
        accountDao.save(account);
    }

    public void removeAccount(int account) {
        accountDao.delete(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public List<Account> getAccounts(int owner_id) {
        return accountDao.findAllAccounts(owner_id);
    }

    public void debit(int accountDebit, int ammountTransfer) {
        Account accountDebitInf = accountDao.find(accountDebit);
        if (accountDebitInf.getBalance() < ammountTransfer) {
            System.out.println("Недостаточно средств!");
        }
        accountDebitInf.setBalance(accountDebitInf.getBalance() - ammountTransfer);
        accountDao.update(accountDebitInf);
        String message = sendToMail(accountDebitInf, ammountTransfer, "debit");
    }

    public void replenishment(int accountRepl, int ammountTransfer) {
        Account accountReplInf = accountDao.find(accountRepl);
        accountReplInf.setBalance(accountReplInf.getBalance() + ammountTransfer);
        accountDao.update(accountReplInf);
        String message = sendToMail(accountReplInf, ammountTransfer, "repl");
    }

    public String sendToMail (Account account, int ammountTransfer, String operation) {
        if (operation.equals("debit")) {
            operation = "списание ";
        } else
            operation = "пополнение ";
        return "Счет: " + account.getAccount() + ", " + operation + ammountTransfer + "рублей. Баланс:" + account.getBalance();
    }
}
