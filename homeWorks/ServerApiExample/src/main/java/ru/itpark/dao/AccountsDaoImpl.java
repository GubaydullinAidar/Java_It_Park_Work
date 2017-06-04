package ru.itpark.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.models.Account;

import java.util.List;

@Component
public class AccountsDaoImpl implements AccountsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int saveForUser(int userId, Account account) {
        account.setOwnerId(userId);
        Session session = getSession();
        session.beginTransaction();
        int generatedId = (Integer)session.save("account", account);
        session.getTransaction().commit();
        return generatedId;
    }

    @Override
    public int save(Account model) {
        return 0;
    }

    @Override
    public Account find(int id) {
        return null;
    }

    @Override
    public void update(Account model) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
