<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.MailUser"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your profile</title>
</head>
<body background="images/1.jpg">
<jsp:include page="UserHead.jsp"></jsp:include>
	
	<%
		HttpSession ss=request.getSession(false);
	if(ss!=null){
		
		MailUser p=(MailUser)request.getAttribute("profiles");
		
	%>
	Welcome  <%=ss.getAttribute("uName") %>
	
	<%if(p!=null){
		
	%>
	<br> <br>
	<table  align="center"   border="1" cellspacing="5" cellpadding="5">
	<tr><td align ="center" ><h3>&nbsp;&nbsp;   UserID &nbsp;&nbsp;    </h3></td><td align="center"><h3> &nbsp;&nbsp;    Full Name &nbsp;&nbsp;    </h3></td><!-- <td align="center"><h3>  &nbsp;&nbsp;   Contact No.&nbsp;&nbsp;     </h3></td> --></tr>
	
	<tr><td><h3><%=p.getuName()%></h3></td><td ><font color="blue"><h3><%=p.getFullName()%></h3></font></td><%-- <td><h3><%=p.getContactInfo()%></h3></td> --%></tr>
	
	</table>
	
	<%}else{ %>
	<br>
	<h2>no profile</h2>
	<%} %>
	<%}else{ 
		request.setAttribute("msg","Login first");
	%>
	
	<jsp:forward page="index.jsp"></jsp:forward>
	<%} %>

</body>
</html>