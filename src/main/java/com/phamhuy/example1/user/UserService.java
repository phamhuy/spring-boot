package com.phamhuy.example1.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private static List<User> users = new ArrayList<User>();

  static {
    users.add(new User("Huy", "Pham"));
    users.add(new User("Ly", "Do"));
    users.add(new User("John", "Smith"));
  }

  public List<User> getUsers() {
    return users;
  }

  public User getUser(long id) {
    for (User user : users) {
      if (id == user.getId()) {
        return user;
      }
    }

    return null;
  }

  public long createUser(User user) {
    User newUser = new User(user);
    users.add(newUser);

    return newUser.getId();
  }
}