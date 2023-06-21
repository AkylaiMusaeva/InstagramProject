package database;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<User>users=new ArrayList<>();
    public DataBase(){

    }

    public DataBase(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setUser(User user){
        if(this.users==null){
            this.users=new ArrayList<>();
        }
        this.users.add(user);
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "users=" + users +
                '}';
    }
}
