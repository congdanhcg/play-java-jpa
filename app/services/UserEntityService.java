package services;

import com.google.inject.Inject;
import models.User;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by danh.tc on 6/20/2017.
 */
public class UserEntityService {

    JPAApi jpaApi;
    @Inject
    public UserEntityService(JPAApi api){
        this.jpaApi = api;
    }

    @Transactional
    public User getUser(int id){
            EntityManager em = jpaApi.em("default");
            Query query = em.createNativeQuery("select * from user where id=1", User.class);
            List<User> rs = query.getResultList();
            User userE = rs.get(0);

            User user = new User( );


            return user;
    }

    @Transactional
    public void addUser(int id, String name, String position,
                        float salary, Short gender, InputStream extra, Timestamp update){

        EntityManager em = jpaApi.em("default");
        User user = new User(id, name, position, salary, gender, extra, update);
        em.persist(user);
        em.getTransaction().begin();
        em.flush();
    }

    @Transactional
    public void addUser2(int id, String name, String position,
                        float salary, Short gender, InputStream extra, Timestamp update){

        EntityManager em = jpaApi.em("default");
        Query query = em.createNativeQuery()
    }

    }
