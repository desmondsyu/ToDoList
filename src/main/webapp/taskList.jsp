<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/ToDoList/TaskController?action=new">New</a>
	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="task" items="${tasks}">
				<tr>
					<td>${task.id}</td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td><a href="/ToDoList/TaskController?action=delete&id=${task.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>