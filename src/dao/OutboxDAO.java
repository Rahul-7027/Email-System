package dao;

import java.util.ArrayList;
import java.util.List;
import connection.Connect;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ComposeMailBean;

public class OutboxDAO {
	public List CheckSentMail(Connection connection, String email) {
		List l = new ArrayList();
		String sl = "select * from compose where sender=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sl);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("OutboxDAO.CheckSentMail()");
				ComposeMailBean cm = new ComposeMailBean();
				cm.setSubject(rs.getString(2));
				cm.setBody(rs.getString(3));
				cm.setFrom(email);
				cm.setToName(rs.getString(1));
				cm.setTime(rs.getString(4));

				l.add(cm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}
}
