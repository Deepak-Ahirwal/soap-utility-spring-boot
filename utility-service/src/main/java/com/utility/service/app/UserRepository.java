package com.utility.service.app;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.example.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserRepository {

	private static final Map<String, User> userMap = new HashMap<>();

	@PostConstruct
	public void init() {
		User user = new User();
		user.setName("Deepak");
		user.setMobilenumber(12121);
		user.setAddress("London");
		userMap.put(user.getName(), user);
		
		user = new User();
		user.setName("Mark");
		user.setMobilenumber(2222);
		user.setAddress("Scotland");
		userMap.put(user.getName(), user);

	}
	public User findUser(String name) {
		Assert.notNull(name, "The user name must not be null");
		return userMap.get(name);
	}
}
