package com.example.newproject.service;

import com.example.newproject.entity.UserEntity;
import com.example.newproject.exception.UserAlreadyExistException;
import com.example.newproject.exception.UserNotFoundException;
import com.example.newproject.model.UserModel;
import com.example.newproject.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public UserEntity registrationUser (UserEntity user) throws UserAlreadyExistException{
		if (userRepo.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("Пользователеь с таким именем уже существует");
		}
		return userRepo.save(user);
	}

	public UserModel getOneUser (Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException("Not found this user");
		}
		return UserModel.toModel(user);
 	}

	public Long deleteUser (Long id) throws UserNotFoundException{
		
		UserEntity user = userRepo.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException("Not found this user");
		}
		userRepo.deleteById(id);
		return id;
		
	}

}
