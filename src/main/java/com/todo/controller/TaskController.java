package com.todo.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.todo.model.Task;
import com.todo.model.TaskRepository;

public class TaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskRepository taskRepository;

	public TaskController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init();
		taskRepository = new TaskRepository();
	}

	public void destroy() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("list")) {
			List<Task> tasks = taskRepository.retrieveAllTasks();
			request.setAttribute("tasks", tasks);
			request.getRequestDispatcher("/taskList.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("new")) {
			request.getRequestDispatcher("/addTask.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			taskRepository.deleteTask(id);
			response.sendRedirect("/ToDoList/TaskController?action=list");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("add")) {
			String description = request.getParameter("description");
			String status = request.getParameter("status");
			Task task = new Task( description, status);
			taskRepository.addTask(task);
			response.sendRedirect("/ToDoList/TaskController?action=list");
		}
	}
}
