package ru.itpark.models;

public class User {
    private int id;
    private String name;
    private String mail;

    public User(int id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return id + " " + name;
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
                this.mail.equals(that.mail) &&
                this.name.equals(that.name);
    }
}
