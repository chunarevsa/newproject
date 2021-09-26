package com.example.newproject.controller;

import com.example.newproject.entity.UserEntity;
import com.example.newproject.exception.UserAlreadyExistException;
import com.example.newproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity registration(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
			return ResponseEntity.ok().body("user saved");
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}
	
	@GetMapping
	public ResponseEntity getUsers() {
		try {
			return ResponseEntity.ok().body("Всё ок");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}
	
}
