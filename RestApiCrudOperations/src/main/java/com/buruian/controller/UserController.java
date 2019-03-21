package com.buruian.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buruian.model.User;
import com.buruian.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Optional<User> getUserById(@PathVariable long userId) {

		return userRepository.findById(userId);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long userId) {
		userRepository.deleteById(userId);

	}

}
