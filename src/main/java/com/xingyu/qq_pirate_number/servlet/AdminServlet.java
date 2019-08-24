package com.xingyu.qq_pirate_number.servlet;

import com.xingyu.qq_pirate_number.umis.dao.IUserDAO;
import com.xingyu.qq_pirate_number.umis.dao.impl.UserDAOImpl;
import com.xingyu.qq_pirate_number.umis.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin", name = "AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserDAO iUserDAO;

    @Override
    public void init() {
        iUserDAO = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("admin".equals(req.getParameter("u")) &&
                "wtxy246813579".equals(req.getParameter("p"))) {
            list(req, resp);
        } else {
            resp.sendError(403);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = iUserDAO.listAll();
        req.setAttribute("userList", list);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}
