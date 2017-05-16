package ru.itpark.dao;

import org.junit.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.itpark.models.Account;

import static org.junit.Assert.*;

public class AccountDaoJdbcImplTest {

        private AccountDaoJdbcImpl accountDao;

        private final int ACCOUNT_5_MAIL = 346236235;
        private final int ACCOUNT_10_ID = 6789155;

        private final Account ACCOUNT_5 = new Account(4, 346236235,0);

        private final Account ACCOUNT = new Account(4, 346236);

        private final Account ACCOUNT_6 = new Account(4, 346236235,14000);

        @Before
        public void setUp() {
            GenericXmlApplicationContext context = new GenericXmlApplicationContext();
            ConfigurableEnvironment environment = context.getEnvironment();
            environment.setActiveProfiles("test-db");
            context.load("ru.itpark\\context.xml");
            context.refresh();
            accountDao = context.getBean(AccountDaoJdbcImpl.class);
        }

        @Test
        public void testFind() {
            Account actual = accountDao.find(ACCOUNT_5_MAIL);
            Account expected = ACCOUNT_5;

            assertEquals(expected, actual);
        }

        @Test(expected = EmptyResultDataAccessException.class)
        public void testDelete() throws Exception {
            accountDao.delete(6789155);
            accountDao.find(ACCOUNT_10_ID);
        }

        @Test
        public void testSave() {
            int actual = accountDao.save(ACCOUNT);
            int expected = 346236;

            assertEquals(actual, expected);
        }

        @Test
        public void testUpdate() {
            accountDao.update(ACCOUNT_6);
            Account actual = accountDao.find(346236235);
            Account expected = ACCOUNT_6;
        }
}
