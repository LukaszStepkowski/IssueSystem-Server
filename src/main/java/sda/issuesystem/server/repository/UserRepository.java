package sda.issuesystem.server.repository;

import sda.issuesystem.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public static final List<User> USER_LIST = new ArrayList<>();

    public void addUser (User user) {
        USER_LIST.add(user);
    }

    public User searchByUserName (String userLogin){
        Optional<User> user = USER_LIST.stream()
                .filter(p -> p.getLogin().equals(userLogin))
                .findFirst();
        return user.get();
    }

    public void removeByUserID (int id) {
        Optional<User> user = USER_LIST.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        USER_LIST.remove(user.get());
    }

    public void printUserList () {
        USER_LIST.stream()
                .forEach(p -> System.out.println(p));
    }

}
