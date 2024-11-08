package com.todo.model;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
	private List<Task> taskList;
	private int currentId = 1;

	public TaskRepository() {
		taskList = new ArrayList<Task>();
	}

	public void addTask(Task task) {
		task.setId(currentId++);
		taskList.add(task);
	}

	public List<Task> retrieveAllTasks() {
		return taskList;
	}

	public Task retrieveTask(Integer id) {
		return taskList.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
	}

	public void deleteTask(Integer id) {
		taskList.removeIf(task -> task.getId().equals(id));
	}
}
