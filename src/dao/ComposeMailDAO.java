package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import bean.ComposeMailBean;


public class ComposeMailDAO {
	public boolean composeNewMail(Connection connection,ComposeMailBean ComposeMailBean) {
		boolean MailComposed=false;
		
	
        String qry=	"insert into compose(toname, subject, body,time,sender) values(?,?,?,?,?)";	
		try {
			PreparedStatement ps=connection.prepareStatement(qry);
			if(ps!=null){
		
				System.out.println("1. "+ComposeMailBean.getToName());
				System.out.println("2. "+ComposeMailBean.getSubject());
				System.out.println("3. "+ComposeMailBean.getBody());
				

				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println(dateFormat.format(cal.getTime()));
				ps.setString(1, ComposeMailBean.getToName());
				ps.setString(2, ComposeMailBean.getSubject());
				ps.setString(3, ComposeMailBean.getBody());
				ps.setString(4, dateFormat.format(cal.getTime()));
				ps.setString(5, ComposeMailBean.getSender());
			
			ps.executeUpdate();
				
			}
			
			MailComposed=true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return MailComposed;
	}

}
