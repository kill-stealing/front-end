package com.lmy.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public List<User> likeName(String name){
		return userMapper.likeName(name);
	}
	
	public int save(User user){
		return userMapper.save(user);
	}
}
