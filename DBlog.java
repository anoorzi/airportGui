
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBlog {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	
	public DBlog() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void setSignup(String a1, String a2) {
		
		
		try {
			String query = " insert into customers "
						 + " (`cfname`, `pword`)"
						 + " VALUES ('"+a1+"', '"+a2+"')";
			//DBconnect.cid = rs.getInt("cid");
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			
			//INSERT INTO `project1`.`flights` (`departure`, `arrival`, `departuretime`, `arrivaltime`, `departuretimedate`, `arrivaltimedate`, `departuretimedate2`, `arrivaltimedate2`, `cost`, `seats`) VALUES ('fff', 'fff', 'fff', 'ff', 'fff', 'ff', 'fff', 'fff', '22', '22');


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}
