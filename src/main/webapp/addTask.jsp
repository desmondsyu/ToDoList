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
	<form action="/ToDoList/TaskController?action=add" method="POST">
		<label>Description</label>
		<input type="text" name="description" /> 
		<label>Status</label> 
		<select name="status">
			<option value="pending">Pending</option>
			<option value="completed">Completed</option>
		</select>
		<button type="submit">Submit</button>
	</form>
</body>
</html>