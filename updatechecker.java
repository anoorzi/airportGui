/// UPDATE `project1`.`status` SET `checking` = '1' WHERE (`sid` = '1');

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class updatechecker {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	
	public updatechecker() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void set1() {
		
		
		try {
			String query = " UPDATE `project1`.`status` SET `checking` = '1' WHERE (`sid` = '1') ";
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			
			//INSERT INTO `project1`.`flights` (`departure`, `arrival`, `departuretime`, `arrivaltime`, `departuretimedate`, `arrivaltimedate`, `departuretimedate2`, `arrivaltimedate2`, `cost`, `seats`) VALUES ('fff', 'fff', 'fff', 'ff', 'fff', 'ff', 'fff', 'fff', '22', '22');


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public void set0() {
		
		
		try {
			String query = " UPDATE `project1`.`status` SET `checking` = '0' WHERE (`sid` = '1') ";
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}

