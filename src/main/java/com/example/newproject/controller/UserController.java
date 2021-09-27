package com.example.newproject.controller;

import java.util.NoSuchElementException;

import javax.websocket.server.PathParam;

import com.example.newproject.entity.UserEntity;
import com.example.newproject.exception.UserAlreadyExistException;
import com.example.newproject.exception.UserNotFoundException;
import com.example.newproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity registration(@RequestBody UserEntity user) {
		try {
			userService.registrationUser(user);
			return ResponseEntity.ok().body("user saved");
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}
	
	@GetMapping
	public ResponseEntity getOneUser(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(userService.getOneUser(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
		try { 
			return ResponseEntity.ok().body(userService.deleteUser(id));
		} catch (UserNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		} 
	}
}
