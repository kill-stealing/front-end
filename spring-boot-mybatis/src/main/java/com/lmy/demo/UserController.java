package com.lmy.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/likeName")
	public List<User> likeName(String name){
		PageHelper.startPage(1,1);
		return userService.likeName(name);
	}
	
	@RequestMapping("/save")
	public User save(){
		User user=new User();
		user.setBirthday(new Date());
		user.setUsername("Test");
		user.setSex("男");
		user.setAddress("dengta");
		userService.save(user);
		return user;
	}
}
