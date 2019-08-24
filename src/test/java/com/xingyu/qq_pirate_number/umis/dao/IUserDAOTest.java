package com.xingyu.qq_pirate_number.umis.dao;

import com.xingyu.qq_pirate_number.umis.dao.impl.UserDAOImpl;
import com.xingyu.qq_pirate_number.umis.domain.User;
import org.junit.Before;
import org.junit.Test;


public class IUserDAOTest {
    private IUserDAO iUserDAO;

    @Before
    public void init() {
        iUserDAO = new UserDAOImpl();
    }

    @Test
    public void listAll() {
        iUserDAO.listAll().forEach(System.out::println);
    }

    @Test
    public void select() {
        System.out.println(iUserDAO.select("904846781"));
    }

    @Test
    public void save() {
        iUserDAO.save(new User(1, "904846781", "wtxy246813579@"));
    }

    @Test
    public void delete() {
        iUserDAO.delete("904846781");
    }
}