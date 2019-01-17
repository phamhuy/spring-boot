package com.phamhuy.example1.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepo;

  @Autowired
  PostRepository postRepo;

  public List<User> getUsers() {
    return userRepo.findAll();
  }

  public User getUser(int id) {
	  Optional<User> userOptional = userRepo.findById(id);
	  if (!userOptional.isPresent()) {
		  throw new UserNotFoundException(String.format("Unable to find user with id %d.", id));
	  }
	  return userOptional.get();
  }

  public int createUser(User user) {
    User newUser = new User(user);
    userRepo.saveAndFlush(newUser);
    return newUser.getId();
  }

  public List<Post> getPosts(int userId) {
	  return getUser(userId).getPosts();
  }

  public int createPost(int userId, Post post) {
    User user = getUser(userId);
    post.setUser(user);
    return postRepo.saveAndFlush(post).getId();
  }
}