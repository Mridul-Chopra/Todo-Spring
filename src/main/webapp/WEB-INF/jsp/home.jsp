<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/todo.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/todo-ajax.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>
		<body>

			<div id="myDIV" class="header">
				<h2 style="margin: 5px">My To Do List</h2>
				<input type="text" id="myInput" placeholder="Title..."> <span
					onclick="newElement()" class="addBtn">Add</span>
			</div>

			<ul id="myUL">
			
			</ul>
	</h1>
	<script type="text/javascript" src="js/todo.js"></script>
</body>
</html>