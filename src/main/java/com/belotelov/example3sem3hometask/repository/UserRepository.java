package com.belotelov.example3sem3hometask.repository;

import com.belotelov.example3sem3hometask.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    RowMapper<User> userRowMapper = (r, i) -> {
        User rowObject = new User();
        rowObject.setName(r.getString("name"));
        rowObject.setAge(r.getInt("age"));
        rowObject.setEmail(r.getString("email"));
        return rowObject;
    };

    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";
        return jdbc.query(sql, userRowMapper);
    }

    public void save(User user) {
        String sql = "INSERT INTO userTable (`name`, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }


    /* private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    */
}
