package dao;

import java.sql.Connection;

import connection.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.ComposeMailBean;
import java.util.ArrayList;
import java.util.List;

public class InboxDAO {
	public List CheckNewMail(Connection connection, String email) {
		List l = new ArrayList();
		String sl = "select * from compose where toname=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sl);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ComposeMailBean cm = new ComposeMailBean();
				cm.setFrom(rs.getString(1));
				cm.setSubject(rs.getString(2));
				cm.setBody(rs.getString(3));
				cm.setTime(rs.getString(4));
				System.out.println(rs.getString(5));
				l.add(cm);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return l;
	}

}
