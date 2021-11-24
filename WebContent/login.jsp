<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body  background="images/e.png" style=" background-repeat: no-repeat; background-position: center; ">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

 <a href="index.jsp"><img src="images/button.png"></a><br><br><h2>Please Enter your login details below.</h2>
<form action="LoginServlet" method="post"><br>
<b style="text-decoration: blink;">	Username&nbsp;</b><input type="text" name="uName"><br/>
		<br>
		<b>Password&nbsp;&nbsp;</b><input type="password" name="pwd"><br/><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="checkbox"><b>	Remember me</b>
		<br><br>
&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;
<input style="width:120px;height:30px;" type="submit" value="    Login    ">
</form>

</body>
</html>