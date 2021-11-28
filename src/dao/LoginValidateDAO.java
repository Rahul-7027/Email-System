package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.MailUser;
import connection.Connect;;

public class LoginValidateDAO {

	public boolean isValidLogin(Connection connection, MailUser mailuser) {
		boolean isValid = false;
		String qry = "select * from registerationtable where username=? and password=?";
		try {
			PreparedStatement ps = connection.prepareStatement(qry);
			if (ps != null) {

				System.out.println("1>>" + mailuser.getuName());

				System.out.println("2>>" + mailuser.getPwd());
				ps.setString(1, mailuser.getuName());

				ps.setString(2, mailuser.getPwd());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					isValid = true;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}

}
