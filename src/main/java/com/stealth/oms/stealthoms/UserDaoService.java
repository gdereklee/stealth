package com.stealth.oms.stealthoms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stealth.oms.model.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("John",1,"12-000"));
		users.add(new User("May",2, "12-001"));
		users.add(new User("Sue",3,"12-003"));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User create(User user) {
		if(user.getId() == 0)
		{
			user.setId(users.size()+1);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator  = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;		
	}
}
