package com.phamhuy.example1.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}

	@PostMapping(path = "/users")
	public int createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	@GetMapping(path = "/users/{userId}/posts")
	public List<Post> getPosts(@PathVariable int userId) {
		return userService.getPosts(userId);
	}

	@PostMapping(path = "/users/{userId}/posts")
	public int createPost(@PathVariable int userId, @RequestBody Post post) {
		return userService.createPost(userId, post);
	}
}
