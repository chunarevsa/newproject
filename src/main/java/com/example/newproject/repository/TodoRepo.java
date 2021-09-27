package com.example.newproject.repository;

import com.example.newproject.entity.TodoEntity;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository <TodoEntity, Long> {
	
}
