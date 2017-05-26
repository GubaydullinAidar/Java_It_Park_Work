package ru.itpark.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itpark.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDaoJdbcImpl implements UsersDao {

    private NamedParameterJdbcTemplate template;

    //language=SQL
    private final String SQL_INSERT_USER =
            "INSERT INTO bank_users(name, mail, password) VALUES(:name, :mail, :password)";

    //language=SQL
    private final String SQL_SELECT_USER_BY_ID =
            "SELECT * FROM bank_users WHERE id = :id";

    //language=SQL
    private final String SQL_SELECT_USER_BY_NAME =
            "SELECT * FROM bank_users WHERE name = :name";

    //language=SQL
    private final String SQL_DELETE_USER_BY_ID =
            "DELETE FROM bank_users WHERE id = :id";

    //language=SQL
    private final String SQL_USER_UPDATE_BY_ID =
            "UPDATE bank_users SET name = :name, mail = :mail, password = :password WHERE id = :id";

    //language=SQL
    private final String SQL_SELECT_ALL =
            "SELECT * FROM bank_users";

    public UsersDaoJdbcImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    public int save(User model) {
        // собрали значения именнованных параметров
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", model.getName());
        params.addValue("mail", model.getMail());
        params.addValue("password", model.getPassword());

        String interestingKeys[] = {"id"};

        // держатель сгенерированного ключа вставленной строки
        KeyHolder holder = new GeneratedKeyHolder();
        template.update(SQL_INSERT_USER, params, holder, interestingKeys);
        Number generatedId = holder.getKey();
        return generatedId.intValue();
    }

    // анонимный класс
    // реализуем интерфейс "на месте"
    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String mail = resultSet.getString("mail");
            String password = resultSet.getString("password");

            return new User(id, name, mail, password);
        }
    };

    public User find(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return template.queryForObject(SQL_SELECT_USER_BY_ID, params, userRowMapper);
    }

    public User findByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return template.queryForObject(SQL_SELECT_USER_BY_NAME, params, userRowMapper);
    }

    public void update(User model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", model.getId());
        params.put("name", model.getName());
        params.put("mail", model.getMail());
        params.put("password", model.getPassword());
        template.update(SQL_USER_UPDATE_BY_ID, params);
    }

    public void delete(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        template.update(SQL_DELETE_USER_BY_ID, params);
    }

    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }
}
