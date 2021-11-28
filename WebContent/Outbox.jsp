<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.ComposeMailBean"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Outbox</title>
</head>
<body background="images/1.jpg">
	<jsp:include page="UserHead.jsp"></jsp:include>
	<center>
		<%
		HttpSession ss = request.getSession(false);
		if (ss != null) {

			List l = (List) request.getAttribute("sentmails");
		%>
		Welcome
		<%=ss.getAttribute("uName")%>

		<%
		if (l != null && (!l.isEmpty())) {
			Iterator<ComposeMailBean> it = l.iterator();
		%>
		<br> <br> <br>
		<table align="center" border="1" cellspacing="3" cellpadding="5">
			<tr>
				<td align="center"><h2>To</h2></td>
				<td align="center"><h2>Subject</h2></td>
				<td align="center"><h2>Body</h2></td>
				<td align="center"><h2>Date Time</h2></td>
			</tr>
			<%
			while (it.hasNext()) {
				ComposeMailBean cb = it.next();
			%>
			<tr>
				<td><%=cb.getToName()%></td>
				<td><font color="blue"><%=cb.getSubject()%></font></td>
				<td><%=cb.getBody()%></td>
				<td><%=cb.getTime()%></td>
			</tr>
			<%
			}
			%>
		</table>

		<%
		} else {
		%>
		<br>
		<h2>Sorry No Email Yet</h2>
		<%
		}
		%>
		<%
		} else {
		request.setAttribute("msg", "Login first");
		%>

		<jsp:forward page="index.jsp"></jsp:forward>
		<%
		}
		%>
	</center>
</body>
</html>