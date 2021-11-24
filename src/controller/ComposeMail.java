package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import bean.ComposeMailBean;
import dao.ComposeMailDAO;
import connection.Connect;;

public class ComposeMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;

	public void init() throws ServletException {

		connection = Connect.getConnection();
	}

	public ComposeMail() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession(false);
		String userName = "";
		if (ss != null) {
			userName = (String) ss.getAttribute("uName");
			System.out.println("checking " + userName);
		}
//		{

			System.out.println("ToName>>" + req.getParameter("ToName"));
			System.out.println("Subject>>" + req.getParameter("Subject"));
			System.out.println("Body" + req.getParameter("Body"));
			String ToName = req.getParameter("ToName");
			String Subject = req.getParameter("Subject");
			String Body = req.getParameter("Body");
			String from = (String) ss.getAttribute("uName");
			String Time = req.getParameter("Time");

			ComposeMailBean composemailbean = new ComposeMailBean();
			composemailbean.setToName(ToName);
			composemailbean.setSubject(Subject);
			composemailbean.setBody(Body);
			composemailbean.setTime(Time);
			composemailbean.setSender(userName);

			ComposeMailDAO ud = new ComposeMailDAO();
			System.out.println("connection >>" + connection);
			boolean isComposed = ud.composeNewMail(connection, composemailbean);

			if (isComposed) {
				System.out.println("DONE");
				RequestDispatcher rd = req.getRequestDispatcher("/MailSent.jsp");
				rd.forward(req, resp);

			} else {
				System.out.println("NOT DONE");
			}

//		}
	}
}
