package ru.itpark.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.itpark.models.User;

import static org.junit.Assert.*;


public class UsersDaoJdbcImplTest {

    private UsersDaoJdbcImpl usersDao;

    private final String USER_5_MAIL = "33@mail";
    private final String USER_10_ID = "20@mail.ru";

    private final User USER_5 = new User(5, "Rustam", "33@mail");

    @Before
    public void setUp() throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles("test-db");
        context.load("ru.itpark\\context.xml");
        context.refresh();
        usersDao = context.getBean(UsersDaoJdbcImpl.class);
    }

    @Test
    public void testFind() throws Exception {
        User actual = usersDao.find(USER_5_MAIL);
        User expected = USER_5;

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void testDelete() throws Exception {
        usersDao.delete(10);
        usersDao.find(USER_10_ID);
    }
}