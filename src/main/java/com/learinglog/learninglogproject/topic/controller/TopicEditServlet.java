package com.learinglog.learninglogproject.topic.controller;
import com.learinglog.learninglogproject.topic.model.Topic;
import com.learinglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit-topic")
public class TopicEditServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String updatedName = req.getParameter("topic-name");
        try{
            boolean result = TopicDao.updatedTopic(id, updatedName);
            if(result){
                res.sendRedirect("/topic?page=ListSuccess=Successfully topic  edited");
            }
            else {
                req.setAttribute("error","Unable to update topic");
            }
        }catch (Exception e){
            req.setAttribute("error","Something went wrong"+e.getMessage());
        }
        req.getRequestDispatcher("pages/edit-topic.jsp").forward(req,res);


    }
}
