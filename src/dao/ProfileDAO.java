package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.MailUser;;

public class ProfileDAO {
	public MailUser getAllProfile(Connection connection, String pro) {
		MailUser p=null;
		String spl="select * from registerationtable where username=?";
		try {
			PreparedStatement ps=connection.prepareStatement(spl);
			ps.setString(1, pro);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println("found user");
				 p=new MailUser();
				
				p.setFullName(rs.getString(2));
				p.setuName(pro);
				p.setContactInfo(rs.getString(3));
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}
}
