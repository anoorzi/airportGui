
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class checker {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private int checker;
	private boolean x;
	public static int cid;
	
	public checker() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public int statuscheck() {
		
		
		try {
			String query = "select * from status ";
			rs = st.executeQuery(query);
			//System.out.println("Record from database");
			
			while(rs.next()) {
				int one = rs.getInt("checking");
				checker=checker+one;
				
				
				
			}
		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return checker;
	}
	
	
}
