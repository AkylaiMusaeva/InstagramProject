package service.serviceImpl;

import database.DataBase;
import model.User;
import service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl  implements UserService {
    Scanner scanner=new Scanner(System.in);
    int num;
    private DataBase dataBase;

    public UserServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public String addNewUser(List<User> users) {
        dataBase.getUsers().addAll(users);
        return "User is successfully saved!";
    }
    @Override
    public User userUpdateById(Long id, String nickName, String password, String photo) {
        for(User u:dataBase.getUsers()){
            if(u.getId()==id){
                u.setNickName(nickName);
                u.setPassword(password);
                u.setPhoto(photo);
            }
        }
        return dataBase.getUsers().get(0);
    }
    @Override
    public List<User> getAllUsers() {
        return dataBase.getUsers();
    }
    @Override
    public User searchByName(String nickName) {
        List<User> list = dataBase.getUsers().stream()
                .filter(user -> user.getNickName().equalsIgnoreCase(nickName))
                .toList();
        return list.get(0);
    }
    @Override
    public List<User> sortByAge() {
        while(true){
            System.out.println("""
                    1-ascending
                    2-descending""");
            switch(num= scanner.nextInt()){
                case 1->{
                    List<User> list = new java.util.ArrayList<>(dataBase.getUsers().stream().toList());
                    list.sort(byAgeAscending);
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).getAge();
                    }
                    System.out.println(list);
                }
                case 2->{
                    List<User> list = new java.util.ArrayList<>(dataBase.getUsers().stream().toList());
                    list.sort(byAgeDescending);
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).getAge();
                    }
                    System.out.println(list);
                }
            }break;
        }return null;
    }
    Comparator<User>byAgeAscending=new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o1.getAge()-o2.getAge();
        }
    };
    Comparator<User>byAgeDescending=new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            return o2.getAge()-o1.getAge();
        }
    };
    @Override
    public List<User> filter() {
            System.out.println("""
                    1-get users that ages < 20
                    2-get users that ages > 20""");
            switch (num=scanner.nextInt()){
                case 1-> {
                    List<User> list = dataBase.getUsers().stream()
                            .filter(user -> user.getAge() < 20).toList();
                    return list;
                }
                case 2->{
                    List<User> list = dataBase.getUsers().stream()
                            .filter(user -> user.getAge() > 20)
                            .toList();
                    return list;
                }
            }
        return null;

    }
}
