package com.poc4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc4.entity.User;
import com.poc4.repository.UserRepository;
@Service
public class UserService {
@Autowired
UserRepository userRepository;
	public User addUser(User user) {
		try
		{
		User result=userRepository.save(user);
		return result;
		}catch (Exception e) {
			return null;
		}
	}

}
