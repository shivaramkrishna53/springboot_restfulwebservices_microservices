<html>
<head>
<title>Sign In Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
<center>
<h1>Welcome to The TO-DO-SignIn Page</h1>
<h1>${result}</h1>
<form action="/signup" method="post" modelAttribute="usermodelatt">
<h3>Name::<input type="text" name="name"/></h3>
<h3>Email::<input type="email" name="email"/></h3>
<h3>Age::<input type="number" name="age"></h3>
<h3>Password::<input type="password" name="password1"/></h3>
<h3>ConfirmPassword::<input type="password" name="password2"/></h3>
<input type="submit"/>
</form>
</center>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>