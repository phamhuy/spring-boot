package com.phamhuy.example1.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepo;

  public List<User> getUsers() {
    return userRepo.findAll();
  }

  public User getUser(long id) {
    for (User user : getUsers()) {
      if (id == user.getId()) {
        return user;
      }
    }

    return null;
  }

  public long createUser(User user) {
    User newUser = new User(user);
    userRepo.saveAndFlush(newUser);
    return newUser.getId();
  }
}