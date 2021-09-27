package com.example.newproject.controller;

import com.example.newproject.entity.TodoEntity;
import com.example.newproject.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	@Autowired
	public TodoService todoService;

	@PostMapping
	public ResponseEntity createTodo(@RequestBody TodoEntity todo,
	@RequestParam Long userId) {
		try {
			return ResponseEntity.ok().body(todoService.createTodo(todo, userId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}
	
	@PutMapping
	public ResponseEntity completeTodo(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(completeTodo(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Ошибка");
		}
	}
	
}
