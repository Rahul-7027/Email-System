package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Connect;
import java.sql.Connection;
import java.util.List;
import dao.InboxDAO;

public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	public void init() throws ServletException {

		connection = Connect.getConnection();
	}

	public Inbox() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession ss = req.getSession(false);
		if (ss != null) {
			String userName = (String) ss.getAttribute("uName");
			InboxDAO id = new InboxDAO();
			List l = id.CheckNewMail(connection, userName);

			req.setAttribute("mails", l);
			RequestDispatcher rd = req.getRequestDispatcher("Inbox.jsp");
			rd.forward(req, resp);
		} else {
			// login
		}
	}

}
