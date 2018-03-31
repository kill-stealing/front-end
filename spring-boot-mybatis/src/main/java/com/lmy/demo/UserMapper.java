package com.lmy.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select * from user where username =#{name}")
	public List<User> likeName(String name);
	
	@Select("select * from user where id=#{id}")
	public User getById(int id);
	
	@Select("select name from user where id=#{id}")
	public String getNameById(int id);
	
	@Insert("insert into user(username,birthday,sex,address) " +
			"values(#{username},#{birthday},#{sex},#{address})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	public int save(User user);
}
