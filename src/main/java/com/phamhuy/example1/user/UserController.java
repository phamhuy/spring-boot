package com.phamhuy.example1.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/users/{userId}")
	public User getUser(@PathVariable("userId") long userId) {
		User user = userService.getUser(userId);
		if (user == null) {
			throw new UserNotFoundException(String.format("Unable to find user with id %d.", userId));
		}

		return user;
	}

	@PostMapping(path = "/users")
	public long createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
}
