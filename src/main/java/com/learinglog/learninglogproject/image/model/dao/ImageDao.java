package com.learinglog.learninglogproject.image.model.dao;

import com.learinglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDao {
    public static boolean insertImage(String name, String imagePath) throws SQLException {
        String query = "insert into image(name, imagePath) values (?, ?)";
        try (Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)){
            st.setString(1, name);
            st.setString(2, imagePath);
            int rowsAdded = st.executeUpdate();
            if (rowsAdded > 0) {return true;}
            else {return false;}
        }
    }
}
