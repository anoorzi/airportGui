
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteAll {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	
	public deleteAll() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void delete() {
		
		
		try {
			//DELETE FROM tablename
			String query = " DELETE FROM `project1`.`flights`  ";
			st.executeUpdate(query);
			

		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public void not() {
		
		
		try {
			String query = " DELETE FROM `project1`.`cusflghts`  ";
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}
