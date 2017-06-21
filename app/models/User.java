package models;

import com.google.common.io.ByteStreams;

import javax.persistence.*;
import java.io.InputStream;
import java.sql.Timestamp;

/**
 * Created by danh.tc on 6/20/2017.
 */

@Entity
//@Table (name = "user")
public class User {
    @Id
    //@Column(name = "ID")
    public int id;

    @Column
    //@Column(name = "NAME")
    public String name;

    @Column
    //@Column(name = "POSITION")
    public String position;

    @Column
    public float salary;
    @Column
    public Short  gender;
    @Column
    public byte[] extra;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public byte[] getExtra() {
        return extra;
    }

    public void setExtra(byte[] extra) {
        this.extra = extra;
    }

    public Timestamp getUpdate() {
        return update;
    }

    public void setUpdate(Timestamp update) {
        this.update = update;
    }

    @Column
    public Timestamp update;

    public User(){

    }

    public User(int id, String name, String position,
                      float salary, Short gender, InputStream extra, Timestamp update){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.gender = gender;
        this.extra = new byte[1000];

        try {
            this.extra = ByteStreams.toByteArray(extra);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        this.update = update;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}