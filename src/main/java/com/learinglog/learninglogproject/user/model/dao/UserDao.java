package com.learinglog.learninglogproject.user.model.dao;

import com.learinglog.learninglogproject.user.model.User;
import com.learinglog.learninglogproject.utils.DbConnection;
import com.mysql.cj.jdbc.JdbcConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements UserDaoInterface{

    public boolean insertUser(String fullname, String email, String password) throws SQLException {
        String query = "INSERT INTO user(fullname, email, password) VALUES(?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query))
        {
            st.setString(1, fullname);
            st.setString(2,  email);
            st.setString(3, password);

            int insertedRows = st.executeUpdate();
            if(insertedRows > 0){
                return true;
            }else{
                return false;
            }
        }
    }
    public User loginUser(String email, String password) throws SQLException{
        String query = "Select * from User where email = ?";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query);){
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String hashedPassword = rs.getString("password");
                if(BCrypt.checkpw(password, hashedPassword) ){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    User userObj = new User(id, name, email, hashedPassword);
                    return userObj;
                }
                else{
                    return  null;
                }
            }
            else {
                return null;

            }
        }
    }
}

