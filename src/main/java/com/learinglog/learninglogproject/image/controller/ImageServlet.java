package com.learinglog.learninglogproject.image.controller;

import com.learinglog.learninglogproject.image.model.dao.ImageDao;
import com.learinglog.learninglogproject.utils.ImageUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/image")
@MultipartConfig()
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part imagePart = req.getPart("image");

        String imagePath = ImageUtils.saveImage(imagePart, req);
        if (imagePath == null) {
            req.setAttribute("error", "Something went wrong");
        }else  {
             try {
                 boolean result = ImageDao.insertImage(name, imagePath);
                 if (result) {
                     req.setAttribute("success", "Image has been inserted successfully");
                 }
                 else{
                 req.setAttribute("error", "Image uploaded in directory but not set to database");
            }
        }catch (Exception e){
             req.setAttribute("error", "Image uploaded in directory but not to db" + e.getMessage());
             }
        }
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req, res);

    }
}
