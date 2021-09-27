package com.example.newproject.model;

import java.util.List;
import java.util.stream.Collectors;

import com.example.newproject.entity.UserEntity;

public class UserModel {
	private Long id;
	private String username;
	private List<TodoModel> todo;

	public static UserModel toModel (UserEntity userEntity) {
		UserModel userModel = new UserModel();
		userModel.setId(userEntity.getId());
		userModel.setUsername(userEntity.getUsername());
		/* преобразоыываем список в stream, вызываем у него мар. 
		дальше выполняется функия todoModel для каждого элемента массива 
		Коллектом преобразовываем обратно к листу
		Итог: преобразование масива entity в масив моделей
		*/
		userModel.setTodo(userEntity.getTodoList().stream().map(TodoModel::todoModel).collect(Collectors.toList()));
		return userModel;
		}

	public UserModel() {
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


	public List<TodoModel> getTodo() {
		return this.todo;
	}

	public void setTodo(List<TodoModel> todo) {
		this.todo = todo;
	}

}
