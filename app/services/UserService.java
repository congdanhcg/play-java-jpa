package services;

import DAO.UserDAO;
import com.google.inject.Inject;
import models.User;

import java.io.InputStream;
import java.sql.Timestamp;

/**
 * Created by danh.tc on 6/20/2017.
 */
public class UserService {
    @Inject
    private UserDAO userDAO;

    public User getUser(int id){
        return userDAO.getUser(id);
    }

    public void addUser(int id, String name, String position, float salary, Short gender, InputStream extra, Timestamp update){
        userDAO.addUser(id, name, position, salary, gender, extra, update);
    }
    }
