package com.learinglog.learninglogproject.user.controller;

import com.learinglog.learninglogproject.user.model.User;
import com.learinglog.learninglogproject.user.model.dao.UserDao;
import com.learinglog.learninglogproject.user.model.dao.UserDaoInterface;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("pages/login.jsp").forward(req, res);

    }

@Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try{
            UserDaoInterface userDao = new UserDao();
            User obj = userDao.loginUser(email, password);
            if(obj==null){
                req.setAttribute("error", "Invalid email or password");
                req.getRequestDispatcher("pages/login.jsp");
            }
            else{
                HttpSession session = req.getSession();
                session.setAttribute("user", obj);
                res.sendRedirect("dashboard");
            }

        }catch (Exception e){
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, res);
        }
}
}
