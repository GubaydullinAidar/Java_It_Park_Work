package ru.itpark.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String mail;

    @Column
    private String password;

    @OneToMany
    @JoinTable(name = "users_accounts",
            joinColumns =
            @JoinColumn(name = "owner_id"),
            inverseJoinColumns =
            @JoinColumn(name = "id"))
    private List<Account> accounts;

    public User() {
    }

    public User(int id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public User(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof User)) {
            return false;
        }

        User that = (User) object;

        return this.id == that.id &&
                this.name.equals(that.name) &&
                this.mail.equals(that.mail) &&
                this.password.equals(that.password);
    }
}
