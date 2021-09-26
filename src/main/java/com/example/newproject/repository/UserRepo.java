package com.example.newproject.repository;

import com.example.newproject.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
