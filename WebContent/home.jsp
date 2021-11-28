<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mymail home</title>
</head>


<body background="images/1.jpg">
	<jsp:include page="UserHead.jsp"></jsp:include>



	<%
	HttpSession ss = request.getSession(false);
	if (ss != null) {
	%>


	<h1 align="center">
		Welcome
		<%
	out.print(ss.getAttribute("uName"));
	%>
	</h1>
	<table align="center">
		<tr>
			<td align="center" colspan="18"><img src="images/email.png"
				width="400" height="370" alt="jmail"></td>
		</tr>
	</table>
	<%
	} else {
	%>

	<jsp:forward page="index.jsp"></jsp:forward>
	<%}%>



</body>



</html>