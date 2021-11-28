package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MailUser;
import connection.Connect;
import dao.ProfileDAO;
import java.sql.Connection;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init() throws ServletException {

		connection = Connect.getConnection();
	}

	public ProfileServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession ss = req.getSession(false);
		if (ss != null) {
			String userName = (String) ss.getAttribute("uName");
			ProfileDAO id = new ProfileDAO();
			MailUser mu = id.getAllProfile(connection, userName);
			System.out.println(userName);
			req.setAttribute("profiles", mu);
			RequestDispatcher rd = req.getRequestDispatcher("/Profile.jsp");
			rd.forward(req, resp);
		} else {
			// login
		}
	}

}
