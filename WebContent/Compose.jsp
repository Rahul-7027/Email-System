<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compose New Mail</title>
</head>
<!--  -->
<body background="images/1.jpg">
	<jsp:include page="UserHead.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<form action="compose" method="post">
		<b>To</b>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input size="100" type="text" name="ToName"><b>@mymail.com</b><br />
		<br> <b>Subject</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
			size="100" type="text" name="Subject"><br />
		<br> <b> Body</b> &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <input
			type="text" name="Body" style="width: 630px; height: 298px;"><br>
		<br> <b> Attachment</b> &nbsp;&nbsp;<input type="file"
			name="attach"><br>
		<br> &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <input
			style="font: bold 20px Calibri; width: 140px; height: 50px;"
			type="submit" value="   Send Mail   "> <br>
		<br>
		<br>
		<br>
	</form>

</body>
</html>