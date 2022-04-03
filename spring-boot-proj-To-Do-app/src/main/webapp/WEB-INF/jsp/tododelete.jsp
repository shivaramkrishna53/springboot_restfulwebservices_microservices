<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>Select the list of courses you want to permentanley delete form your TO-DO-LIST</h2>
<form action="/deletetodofromlist" method="post">

 <c:forEach items="${courseslst}" var="category">

<div class="custom-control custom-checkbox">
        <input type="checkbox" class="custom-control-input" id="customCheck1"
            name="checkboxed" value=${category}> <label class="custom-control-label" for="customCheck1">${category}</label>
    </div>       


    </c:forEach>

<input type="submit" name="submit" value="submit">
</form>
</body>
</html>