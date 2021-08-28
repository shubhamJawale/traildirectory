package com.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.entity.Userdata;
import com.market.repository.UserRepo;
@Service
public class UserServiceDaoImpl implements UserServiceDao {
	@Autowired
	UserRepo repo;
	@Override
	public List<Userdata> getAllUser() {
		
		return this.repo.findAll();
	}

	@Override
	public Userdata getOneUser(String email) {
		
		return this.repo.getById(email);
	}

	@Override
	public void addUser(Userdata user) {
	this.repo.save(user);
	}

}
