package ru.itpark.models;

import javax.persistence.*;

@Entity
@Table(name = "users_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int account;

    @Column
    private int balance;

    @Column(name = "owner_id")
    private int ownerId;

    public Account(int id, int account, int balance, int ownerId) {
        this.id = id;
        this.account = account;
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public Account() {
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}