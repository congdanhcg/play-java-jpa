package DAO;

import com.google.inject.Inject;
import models.User;
import play.api.db.*;

import java.io.InputStream;
import java.sql.*;


/**
 * Created by danh.tc on 6/20/2017.
 */
public class UserDAO {
    @Inject
    private Database db;

    @Inject
    public UserDAO (){
        this.db = db;
    }

    public User getUser(int id){
        Connection conn = db.getConnection();
        String SQL = "select * from user where id=1";

        User user = null;
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs!= null){
                user = new User();
            }
        }
        catch (SQLException e){}

        return user;
    }

    public void addUser(int id, String name, String position, float salary, Short gender, InputStream extra, Timestamp update){

        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = db.getConnection();
        try{
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.setString(2, name);
            st.setString(3, position);
            st.setFloat(4, salary);
            st.setInt(5, gender);
            st.setBlob(6, extra);
            st.setTimestamp(7, update);

            st.execute();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
