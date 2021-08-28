package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.entity.Userdata;

public interface UserRepo extends JpaRepository<Userdata, String>{

}
