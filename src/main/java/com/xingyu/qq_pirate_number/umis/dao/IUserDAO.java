package com.xingyu.qq_pirate_number.umis.dao;

import com.xingyu.qq_pirate_number.umis.domain.User;

import java.util.List;

public interface IUserDAO {
    List<User> listAll();

    User select(String login_id);

    void save(User user);

    void delete(String login_id);
}
