package models;

/**
 * Created by danh.tc on 6/20/2017.
 */
public class UserModel {
    public UserModel(){}

    public UserModel(int id, String name, String position){
        this.id = id;
        this.name = name;
        this.position = position;
    }

    //Attributes
    private  int id;
    private String name;
    private String position;

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
