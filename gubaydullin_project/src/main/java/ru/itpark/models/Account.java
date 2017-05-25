package ru.itpark.models;

public class Account {

    private int owner_id;
    private int account;
    private int balance;

    public Account(int owner_id, int account, int balance) {
        this.owner_id = owner_id;
        this.account = account;
        this.balance = balance;
    }

    public Account(int owner_id, int account) {
        this.owner_id = owner_id;
        this.account = account;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account " +
                "№ " + account +
                ", balance=" + balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account accounts = (Account) o;

        if (owner_id != accounts.owner_id) return false;
        if (account != accounts.account) return false;
        return balance == accounts.balance;
    }

}
