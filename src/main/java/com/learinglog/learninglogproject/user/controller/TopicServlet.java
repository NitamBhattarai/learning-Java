package com.learinglog.learninglogproject.user.controller;

import com.learinglog.learninglogproject.topic.model.Topic;
import com.learinglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String page = req.getParameter("page");
//        if(page.equals("list"))
       if("list".equals(page))
        {
            TopicDao dao = new TopicDao();
            try {
                List<Topic> topicsList = dao.fetchTopics();
                req.setAttribute("topics", topicsList);
            }catch (Exception e){
                req.setAttribute("error", e.getMessage());

            }
            req.getRequestDispatcher("/pages/topic-list.jsp").forward(req, res);
        } else if ("edit".equals(page)) {
           int id = Integer.parseInt(req.getParameter("id"));

           req.getRequestDispatcher("pages/edit-topic.jsp").forward(req, res);

       }
        req.getRequestDispatcher("/pages/add-topic.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String action = req.getParameter("action");
        if(action.equals("add")){
            TopicDao dao = new TopicDao();
            int userId = Integer.parseInt(req.getParameter("user_id"));
            String topicName = req.getParameter("topic_name");
            Timestamp createdDate =  new Timestamp(System.currentTimeMillis());
            Timestamp updatedDate =  new Timestamp(System.currentTimeMillis());

            Topic obj = new Topic();
            obj.setName(topicName);
            obj.setUserId(userId);
            obj.setCreatedAt(createdDate);
            obj.setUpdatedAt(updatedDate);

            try {
                boolean result = dao.insertTopic(obj);
                if(result){
                    req.setAttribute("success", "successfully topic added");
                }
                else{
                    req.setAttribute("error","unable to add topic");
                }
            }catch (Exception e){
                req.setAttribute("error",e.getMessage());

            }
            req.getRequestDispatcher("pages/add-topic.jsp").forward(req, res);
        }
    }

}
