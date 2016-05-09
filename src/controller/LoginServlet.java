package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MailUser;
import dao.MailUserDAO;
import dao.LoginValidateDAO;
import connection.Connect;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	public void init() throws ServletException {
		connection=Connect.getConnection();
	}
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uName = req.getParameter("uName");
		String pwd=req.getParameter("pwd");
		
		MailUser mailuserObj=new MailUser();
		
		mailuserObj.setuName(uName);

		mailuserObj.setPwd(pwd);
		
		LoginValidateDAO lvDAObj=new LoginValidateDAO();
		System.out.println("connection>>"+connection);
		boolean isLoginOk=lvDAObj.isValidLogin(connection, mailuserObj);
		
		if(isLoginOk){
			mailuserObj.setPwd("");
			HttpSession session=req.getSession();
			session.setAttribute("uName", uName);
			String url="";
			url=resp.encodeURL("home.jsp");
			System.out.println("login proper");
			System.out.println(session.getAttribute("uName"));
		resp.sendRedirect(url);
		}
		else {
			String url="";
		url=resp.encodeURL("WrongInfo.jsp");
		System.out.println("login incorrect");
		resp.sendRedirect(url);}
	}
		
	}

