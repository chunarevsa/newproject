package com.example.newproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List <TodoEntity> todoList;

	public UserEntity() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<TodoEntity> getTodoList() {
		return this.todoList;
	}

	public void setTodoList(List<TodoEntity> todoList) {
		this.todoList = todoList;
	}


}
