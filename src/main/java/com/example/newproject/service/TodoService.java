package com.example.newproject.service;

import com.example.newproject.entity.TodoEntity;
import com.example.newproject.entity.UserEntity;
import com.example.newproject.model.TodoModel;
import com.example.newproject.repository.TodoRepo;
import com.example.newproject.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	@Autowired
	public TodoRepo todoRepo;
	@Autowired
	public UserRepo userRepo;

	public TodoModel createTodo(TodoEntity todo, Long userId) {
		UserEntity user = userRepo.findById(userId).get();
		todo.setUser(user);
		return TodoModel.todoModel(todoRepo.save(todo)); 
	}

	public TodoModel completeTodo(Long todoId) {
		TodoEntity todo = todoRepo.findById(todoId).get();
		todo.setCompleted(!todo.getCompleted());
		return TodoModel.todoModel(todoRepo.save(todo)); 
	}
}
