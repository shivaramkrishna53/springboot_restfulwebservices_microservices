<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h1>${username} TO-DO Saved Successfully!!!</h1>
<a href="/viewtodo/${username}">To View Existing ToDo's</a>
<center>
<table>

<thead>
<tr>
<th>Courses</th>
<th>Target-Date</th>
<th>Priority</th>
</tr>
</thead>
<tbody>

<c:forEach items="${res}" var="todo">
<tr>
<td>${todo.courses}</td>
<td>${todo.date}</td>
<td>${todo.priority}</td>
</tr>
</c:forEach>
</tbody>
</table>
</center>
</body>
</html>