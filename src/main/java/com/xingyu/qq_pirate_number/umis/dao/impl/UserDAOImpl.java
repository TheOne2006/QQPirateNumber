package com.xingyu.qq_pirate_number.umis.dao.impl;


import com.xingyu.qq_pirate_number.umis.dao.IUserDAO;
import com.xingyu.qq_pirate_number.umis.domain.User;
import com.xingyu.qq_pirate_number.umis.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private void setUser(ResultSet rs, User user) throws SQLException {
        user.setPassword(rs.getString("password"));
        user.setId(rs.getInt("id"));
        user.setLogin_id(rs.getString("login_id"));
    }

    public List<User> listAll() {
        return JdbcTemplate.query("SELECT id,login_id,password FROM qq_numbers",
                rs -> {
                    List<User> list = new ArrayList<>();
                    while (rs.next()) {
                        User user = new User();
                        setUser(rs, user);
                        list.add(user);
                    }
                    return list;
                });
    }

    public User select(String login_id) {
        return JdbcTemplate.query(
                "SELECT id,login_id,password FROM qq_numbers WHERE login_id=?",
                rs -> {
                    User user = new User();
                    while (rs.next()) {
                        setUser(rs, user);
                    }
                    return user;
                }
                , login_id);
    }

    public void save(User user) {
        JdbcTemplate.update("INSERT INTO `qq_numbers` (login_id,password) VALUES (?,?)",
                user.getLogin_id(),
                user.getPassword());
    }

    public void delete(String login_id) {
        JdbcTemplate.update("DELETE FROM `qq_numbers` WHERE login_id", login_id);
    }

}
