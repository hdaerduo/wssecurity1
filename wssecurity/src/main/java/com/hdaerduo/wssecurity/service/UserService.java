package com.hdaerduo.wssecurity.service;

import java.util.ArrayList;
import java.util.Random;

import com.hdaerduo.wssecurity.model.User;

public class UserService {

	private static ArrayList<User> users = new ArrayList<User>();

	public User save(User user) {
		synchronized (users) {
			if(user.getUserId()==null)			{
				Random r = new Random();
				user.setUserId(r.nextLong());
			}
			
			if(user.getPassword()==null){
				user.setPassword("000000");
			}
			
			for (int i = 0; i < users.size(); i++) {
				if (user.getUserId() == users.get(i).getUserId()) {
					users.set(i, user);
					return user;
				}
			}

			users.add(user);

			return user;
		}
	}

	public User findByEmail(String email) {
		synchronized (users) {
			for (User user : users) {
				if (user.getEmail() == email) {
					return user;
				}
			}
			return null;
		}
	}

}
