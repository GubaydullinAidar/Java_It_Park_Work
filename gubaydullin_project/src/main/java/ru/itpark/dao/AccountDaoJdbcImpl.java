package ru.itpark.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itpark.models.Account;
import ru.itpark.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoJdbcImpl implements AccountDao {

    private NamedParameterJdbcTemplate template;

    //language=SQL
    private final String SQL_INSERT_USER = "INSERT INTO users_accounts (owner_id, account) VALUES(:id, :account)";

    //language=SQL
    private final String SQL_DELETE_ACCOUNT_BY_ID = "DELETE FROM users_accounts WHERE account= :account";

    //language=SQL
    private final String SQL_SELECT_ACCOUNTS_BY_ID = "SELECT * FROM users_accounts WHERE account = :account";

    //language=SQL
    private final String SQL_USER_UPDATE_BY_ACCOUNT =
            "UPDATE users_accounts SET owner_id = :id, account = :account, balance = :balance WHERE account = :account";

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM users_accounts WHERE owner_id = :owner_id";

    public AccountDaoJdbcImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public int save(Account model) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", model.getOwner_id());
        params.addValue("account", model.getAccount());
        template.update(SQL_INSERT_USER, params);
        return model.getAccount();
    }

    private RowMapper<Account> userRowMapper = new RowMapper<Account>() {
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("owner_id");
            int account = resultSet.getInt("account");
            int balance = resultSet.getInt("balance");

            return new Account(id, account, balance);
        }
    };

    public Account find(int id) {
        int account = id;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("account", account);
        return template.queryForObject(SQL_SELECT_ACCOUNTS_BY_ID, params, userRowMapper);
    }

    public void update(Account model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", model.getOwner_id());
        params.put("account", model.getAccount());
        params.put("balance", model.getBalance());
        template.update(SQL_USER_UPDATE_BY_ACCOUNT, params);
    }

    public void delete(int id) {
        int account = id;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("account", account);
        template.update(SQL_DELETE_ACCOUNT_BY_ID, params);
    }

    public List<User> findAll() {
        return null;
    }

    public List<Account> findAllAccounts(int owner_id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("owner_id", owner_id);
        return template.query(SQL_SELECT_ALL, params, userRowMapper);
    }
}
