package sda.issuesystem.server.repository;

import sda.issuesystem.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public static List<User> userList = new ArrayList<>();

    public static void addUser (User user) {
        userList.add(user);
    }

    public static User searchByLogin(String userLogin){
        Optional<User> user = userList.stream()
                .filter(p -> p.getLogin().equals(userLogin))
                .findFirst();
        return user.get();
    }

    public static void removeByUserID (int id) {
        Optional<User> user = userList.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        userList.remove(user.get());
    }

    public static void printUserList () {
        userList.stream()
                .forEach(p -> System.out.println(p));
    }

}
