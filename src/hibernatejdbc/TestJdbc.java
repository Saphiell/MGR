package hibernatejdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		
		String jdbcURL = "jdbc:mysql://localhost:3306/mgr?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try{
			
			System.out.println("Connecting to db: "+ jdbcURL);
			
			Connection conn = DriverManager.getConnection(jdbcURL,user,pass);
			
			
			System.out.println("Connection estabilished.");
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
