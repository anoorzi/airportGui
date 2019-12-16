import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBdate {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	private String date;
	
	public DBdate() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void updatedate() {
		String s = Global.CurrentDate.getString();
		//UPDATE `project1`.`status` SET `date` = 'aa' WHERE (`sid` = '1'); '"+g+"'
		try {
			String query = "UPDATE `project1`.`status` SET `date` = '"+s+"' WHERE (`sid` = '1')";
			st.executeUpdate(query);
			//System.out.println("Record from database");
			
			
			//INSERT INTO `project1`.`flights` (`departure`, `arrival`, `departuretime`, `arrivaltime`, `departuretimedate`, `arrivaltimedate`, `departuretimedate2`, `arrivaltimedate2`, `cost`, `seats`) VALUES ('fff', 'fff', 'fff', 'ff', 'fff', 'ff', 'fff', 'fff', '22', '22');


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	public String getdate() {
		try {
			String query = "select * from status WHERE (`sid` = '1') ";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				date = rs.getString("date");
				
				
			}
			
			


		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return date;
	}
	
	
}
