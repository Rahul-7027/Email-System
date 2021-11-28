package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import bean.MailUser;
import connection.Connect;
import dao.MailUserDAO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public void init() throws ServletException {

		connection = Connect.getConnection();
	}

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("uName>>" + req.getParameter("uName"));
		System.out.println("fullName>>" + req.getParameter("fullName"));
		System.out.println("contactInfo>>" + req.getParameter("contactInfo"));
		System.out.println("pwd>>" + req.getParameter("pwd"));

		String uName = req.getParameter("uName");
		String fullName = req.getParameter("fullName");
		String contactInfo = req.getParameter("contactInfo");
		String pwd = req.getParameter("pwd");

		System.out.println("myConnection1 " + connection);
		connection = Connect.getConnection();
		System.out.println("myConnection2 " + connection);

		if (uName != "") {
			if (fullName != "") {
				MailUser mailuser = new MailUser();
				/*
				 * user.setType(type); user.setPassword(password); user.setUserName(userName);
				 */

				mailuser.setuName(uName);
				mailuser.setFullName(fullName);
				mailuser.setContactInfo(contactInfo);
				mailuser.setPwd(pwd);

				MailUserDAO ud = new MailUserDAO();

				System.out.println("connection>>" + connection);
				boolean isRegistered = ud.putRegisterDetails(connection, mailuser);
				System.out.println("isregister>>" + isRegistered);
				/*
				 * if(v){ user.setPassword(""); HttpSession session=req.getSession();
				 * session.setAttribute("userName", userName); String url="";
				 * if(type.equals("user")){ url=resp.encodeURL("UserHome.jsp"); }else{
				 * url=resp.encodeURL("AdminHome.jsp"); } resp.sendRedirect(url); }else{
				 * req.setAttribute("msg", "Invalid Details"); RequestDispatcher
				 * rd=req.getRequestDispatcher("/index.jsp"); rd.forward(req, resp); }
				 */
				if (isRegistered) {
					System.out.println("DONE");
					RequestDispatcher rd = req.getRequestDispatcher("/Rdone.jsp");
					rd.forward(req, resp);

				} else {
					System.out.println("NOT DONE");
					RequestDispatcher rd = req.getRequestDispatcher("/alreadyTaken.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("msg", "Enter Full Name");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "Enter UserName");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
		}
	}

}
