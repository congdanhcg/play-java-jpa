package controllers;


import com.google.inject.Inject;
import models.User;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserEntityService;
import services.UserService;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;

/**
 * Created by danh.tc on 6/20/2017.
 */
public class UserController extends Controller {
    @Inject
    UserService userService;

    @Inject
    UserEntityService userEntityService;

    @Transactional
    public Result getUser(int id){

        User user = userEntityService.getUser(id);

        return ok(Json.toJson(user));
    }

    public Result getNative(){
        File f = new File("D:\\data.txt");
        long timeNow = Calendar.getInstance().getTimeInMillis();
        java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
        FileInputStream fs;
        long startTime = 0, endTime = 0;
        try {
            fs = new FileInputStream(f);
            startTime = System.currentTimeMillis();

            userService.addUser(2, "John", "Officer", 5*40,
                    Short.parseShort("0"), fs, ts);
            //Execute query
//            for (int i = 1; i < 1001; i++) {
//                userService.addUser(i, "John", "Officer", i*40,
//                        Short.parseShort("0"), fs, ts);
//            }

            endTime = System.currentTimeMillis();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ok(Json.toJson((endTime - startTime)));
    }

    @Transactional
    public Result getQueryObj() {
        File f = new File("D:\\data.txt");
        long timeNow = Calendar.getInstance().getTimeInMillis();
        java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
        FileInputStream fs;
        long startTime = 0, endTime = 0;
        try {
            fs = new FileInputStream(f);
            startTime = System.currentTimeMillis();

            userEntityService.addUser(1, "John", "Officer", 10 * 40,
                    Short.parseShort("0"), fs, ts);
            //Execute query
//            for (int i = 1; i < 1001; i++) {
//                userEntityService.addUser(i, "John", "Officer", i * 40,
//                        Short.parseShort("0"), fs, ts);
//            }

            endTime = System.currentTimeMillis();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok(Json.toJson((endTime - startTime)));
    }
}
