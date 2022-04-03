<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<title>
display to do page
</title>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}


</style>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

</head>
<body>
<center>
<h1>Displaying the DoTodo's for ${username}</h1>
<table>
<thead>
<tr>
<th>Courses</th>
<th>Target Date</th>
<th>Priority</th>
</tr>
</thead>
<tbody>
<c:forEach items="${todolst}" var="todo">
<tr>
<td>${todo.courses}</td>
<td>${todo.date}</td>
<td>${todo.priority}</td>
</tr>
</c:forEach>
</tbody>
</table>
<h4><a href="/addmoretodos/${username}">Add more todos</h4>
<br>
<h4><a href="/modifyexistingtodos/${username}">ModifyExistingTodos</h4>
<br>
<h4><a href="/deleteexistingtodos/${username}">DeleteExistingTodos</h4>
</center>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>