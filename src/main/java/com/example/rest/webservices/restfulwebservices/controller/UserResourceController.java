package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.bean.User;
import com.example.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.example.rest.webservices.restfulwebservices.exceptions.UserAlreadyCreated;
import com.example.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.spring.web.json.Json;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService userDaoService;

	//retrieveAllUsers
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDaoService.findAll();
	}

	//retrieveUser(int id)
	@GetMapping(path = "/getUsers/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userDaoService.findUserById(id);

		if (user == null) {
			throw new UserNotFoundException("The user with the id " + id + " does not exist!");
		}

		return user;
	}

	@PostMapping(path = "/createUsers")
	public ResponseEntity<Object> createNewUser(@Valid @RequestBody User user) {
		User checkUser = userDaoService.findUserByEmail(user.getEmail());
		if (checkUser != null) {
			throw new UserAlreadyCreated("The user with this email already exists");
		}

		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/deleteUsers/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteUserById(id);

		if (user == null) {
			throw new UserNotFoundException("The user with the id " + id + " does not exist!");
		}

		return ResponseEntity.noContent().build();
	}
}
