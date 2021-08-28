package com.market.service;

import java.util.List;

import com.market.entity.Userdata;

public interface UserServiceDao {

	public List<Userdata> getAllUser();
	
	public Userdata getOneUser(String email);
	
	public void addUser(Userdata user);
	
}
