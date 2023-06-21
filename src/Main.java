import database.DataBase;
import enums.Gender;
import model.User;
import service.serviceImpl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

/**.
 1. Instagram программасын тузунуз
 2. 5 жаны пакет тузунуз - model, service, database, enums, exception.
 3. enum Gender (MALE,FEMALE)
 database package-ке DataBase класс болот, полеси kaтaры List<User> users;
 4. User деген класс болсун. Свойствалары: (nickName, password, age, photo, Gender
 gender)
 UserService interface болот, жана UserServiceImpl класс UserService interfaceti
 implements кылып, полеси katary DataBase классты алат.
 5. Методтор:
 - String addNewUser(User user) //добавить новый user
 - User userUpdateById(Long id,String nickName,String password,String photo) //изменить
 name, password, и photo
 - User searchByName(String nickName)// искать по name-
 User sortByAge(asc,desc) stream//сортировка по возрасту (по возрастанию и убыванию)
 - User filter(asc desc по age) stream //фильтрация по age(например старше >20 лет или младше <20 лет*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num;
        DataBase dataBase=new DataBase();
        UserServiceImpl userService=new UserServiceImpl(dataBase);

        do{
            System.out.println("""
                    ~~~~~~~Choose an operation~~~~~~
                    1-addNewUser
                    2-update user's name,password and photo
                    3-get all users
                    4-search user by name
                    5-sort user by age
                    6-filter by age
                    7-exit program
                    """);
            switch(num=scanner.nextInt()){
                case 1 ->
                    System.out.println(userService.addNewUser(List.of(
                            new User(1L, "Akylai", "1", 21, "Mountains", Gender.FEMALE),
                            new User(2L, "Myrza", "2", 45, "Cars", Gender.MALE),
                            new User(3L, "Elena", "3", 32, "Animals", Gender.FEMALE),
                            new User(4L, "Altynbek", "4", 29, "Flags", Gender.MALE),
                            new User(5L, "Erbol", "5", 19, "With family", Gender.MALE),
                            new User(6L, "Nurzat", "6", 17, "With friend", Gender.FEMALE),
                            new User(7L, "Elhan", "7", 21, "At museum", Gender.MALE),
                            new User(8L, "Temirjan", "8", 13, "At camp", Gender.MALE))));
                case 2->
                    System.out.println(userService.userUpdateById(1L, "Aidai", "2909", "Ocean"));
                case 3-> System.out.println(userService.getAllUsers());
                case 4-> System.out.println("Пользователь,которого вы ищете: \n"+userService.searchByName("Aidai"));
                case 5-> System.out.println(userService.sortByAge());
                case 6-> System.out.println(userService.filter());
            }
        }while (num!=7);
    }
}
