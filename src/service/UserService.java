package service;

import model.User;

import java.util.List;

public interface UserService {
    String addNewUser(List<User> users); //добавить новый user
    User userUpdateById(Long id,String nickName,String password,String photo); //изменить name, password, и photo
    List<User> getAllUsers();
    User searchByName(String nickName);// искать по name-
    List<User> sortByAge(); //сортировка по возрасту (по возрастанию и убыванию) stream
    List<User> filter();  //фильтрация по age(например старше >20 лет или младше <20 лет stream


}
