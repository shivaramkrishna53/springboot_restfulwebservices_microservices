<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Modify To Do Page</title>
</head>
<body>
<center>
<h1>Modify To Do Page</h1>
<form action="/modifyandsavetodo/${username}" method="post">
<h2>Courses List in your Cart::</h2>
<select name="courses">
    <c:forEach items="${courseslst}" var="category">
        <option value="${category}">${category}</option>
    </c:forEach>
</select>
<br>
<input type="date" name="date">New Modified Date for Course End
<br>
<input type="number" name="priority">New Priority Value
<br>
<input type="submit" name="submit" value="submit">
<input type="hidden" name="username" value=${username}>
</form>
</center>
</body>
</html>