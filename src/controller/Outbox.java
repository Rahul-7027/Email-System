package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


import java.util.List;

import connection.Connect;
import dao.OutboxDAO;

import java.sql.Connection;

public class Outbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	public void init() throws ServletException {
		
		connection=Connect.getConnection();
	}

    public Outbox() {
        super(); 
    }

	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			HttpSession ss=req.getSession(false);
			if(ss!=null){
				String userName=(String)ss.getAttribute("uName");
				System.out.println(userName+" 1");
				OutboxDAO id=new OutboxDAO();
				List l=id.CheckSentMail(connection, userName);
				System.out.println(l.size()+"   2");
				req.setAttribute("sentmails", l);
				RequestDispatcher rd=req.getRequestDispatcher("Outbox.jsp");
				rd.forward(req, resp);
			}else{
				//login
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
