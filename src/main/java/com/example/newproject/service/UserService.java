package com.example.newproject.service;

import com.example.newproject.entity.UserEntity;
import com.example.newproject.exception.UserAlreadyExistException;
import com.example.newproject.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserEntity registration (UserEntity user) throws UserAlreadyExistException{
		if (userRepo.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("Пользователеь с таким именем уже существует");
		}
		return userRepo.save(user);
	}
}
