package com.imooc.mapper;

import com.imooc.vo.User;

import java.util.List;

public interface UserMapper {
	
	List <User> getAll();
    public User getOne(int id);
    public void insert(User user);
    public void delete(int id);
    public User getUserbyName(String name);
    
}
