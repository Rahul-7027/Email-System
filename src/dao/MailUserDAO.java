package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connect;
import bean.MailUser;

public class MailUserDAO {

	public boolean putRegisterDetails(Connection connection, MailUser mailuser) {
		boolean registrationDone = false;
		// String qry="select * from login where username=? and password=? and type=?";
		// Insert statement
		String qry = "insert into registerationtable (username,name,contactno,password) values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(qry);
			if (ps != null) {

				System.out.println("1" + mailuser.getuName());
				System.out.println("2" + mailuser.getFullName());
				System.out.println("3>>" + mailuser.getContactInfo());
				System.out.println("4>>" + mailuser.getPwd());
				ps.setString(1, mailuser.getuName());
				ps.setString(2, mailuser.getFullName());
				ps.setString(3, mailuser.getContactInfo());
				ps.setString(4, mailuser.getPwd());

				ps.executeUpdate();

			}
			// if(rs.next()){
			registrationDone = true;
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrationDone;
	}

}
