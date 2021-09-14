package com.example.rest.webservices.restfulwebservices.dao;

import com.example.rest.webservices.restfulwebservices.bean.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {

	private static List<User> listOfUsers = new ArrayList<>();

	private static int usersCount = 6;

	static {
		listOfUsers.add(new User(1, "Andi", "andi@email.com", new Date()));
		listOfUsers.add(new User(2, "Ciprian", "ciprian@email.com", new Date()));
		listOfUsers.add(new User(3, "Basti", "basti@email.com", new Date()));
		listOfUsers.add(new User(4, "Theo", "theo@email.com", new Date()));
		listOfUsers.add(new User(5, "Lili", "lili@email.com", new Date()));
		listOfUsers.add(new User(6, "Dana", "dana@email.com", new Date()));
	}

	public List<User> findAll() {
		return listOfUsers;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		listOfUsers.add(user);
		return user;
	}

	public User findUserById(int id) {
		for (User user : listOfUsers) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User findUserByEmail(String email) {
		for (User user : listOfUsers) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}

	public User deleteUserById(int id) {
		Iterator<User> iterator = listOfUsers.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
