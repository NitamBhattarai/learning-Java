package com.learinglog.learninglogproject.topic.model.dao;

import com.learinglog.learninglogproject.topic.model.Topic;
import com.learinglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TopicDao {
    public boolean insertTopic(Topic obj) throws SQLException {
        String query =
                "Insert into topic(name, user_id, createdAt, updatedAt) values (?,?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, obj.getName());
            st.setInt(2, obj.getUserId());
            st.setTimestamp(3, obj.getCreatedAt());
            st.setTimestamp(4, obj.getUpdatedAt());

            int rowsInserted = st.executeUpdate();
            if(rowsInserted==0){
                return false;
            }
            else {
                return true;
            }
        }

    }

    public List<Topic> fetchTopics() throws SQLException{
        String query = "Select * from topic";
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement st =conn.prepareStatement(query)){
            ResultSet rs = st.executeQuery();
            if (rs.next()){


            }

        }
    }
}
