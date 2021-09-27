package com.example.newproject.model;

import com.example.newproject.entity.TodoEntity;

public class TodoModel {
	private Long id;
	private String title;
	private Boolean completed;

	public static TodoModel todoModel (TodoEntity todoEntity) {
		TodoModel model = new TodoModel();
		model.setId(todoEntity.getId());
		model.setTitle(todoEntity.getTitle());
		model.setCompleted(todoEntity.getCompleted());
		return model;
		
	}


	public TodoModel() {
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean isCompleted() {
		return this.completed;
	}

	public Boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
