import java.sql.*;

public class DBinsert {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	
	public DBinsert() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void getData(String g,String a1, String a2, String a3, String a4, int x, int y) {
		
		
		try {
			String query = " insert into flights "
						 + " (`airline`,`departure`, `arrival`, `departuretime`, `arrivaltime`, `seats`, `cost`)"
						 + " VALUES ('"+g+"','"+a1+"', '"+a2+"','"+a3+"', '"+a4+"', '"+x+"', '"+y+"')";
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			
			//INSERT INTO `project1`.`flights` (`departure`, `arrival`, `departuretime`, `arrivaltime`, `departuretimedate`, `arrivaltimedate`, `departuretimedate2`, `arrivaltimedate2`, `cost`, `seats`) VALUES ('fff', 'fff', 'fff', 'ff', 'fff', 'ff', 'fff', 'fff', '22', '22');


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}
