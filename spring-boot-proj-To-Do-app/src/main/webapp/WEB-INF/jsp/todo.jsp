<html>
<title>to do page</title>
<body>
<h1>${result}</h1>
<form action="/savetodos" method="post" modelAttribute="todomodelatt">
Courses::<select name="courses" id="courses">
<option value="java">Java</option>
<option value="python">Python</option>
<option value="c++">C++</option>
<option value="C#">C#</option>
<option value="js">JS</option>
</select>

Target Date::<input type="date" name="date"/>

Priority::<input type="number" name="priority"/>

<input type="hidden" name="username" value=${username} />

<input type="submit"/>
</form>

<a href="/viewtodo/${username}">To View Existing ToDo's</a>

<h4>Email id is: ${emailid}</h4>
</body>
</html>