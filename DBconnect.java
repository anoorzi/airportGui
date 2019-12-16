import java.sql.*;

public class DBconnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;
	private boolean x;
	public static int cid;
	
	public DBconnect() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public boolean passwordcheck(String a,String b) {
		
		
		try {
			String query = "select * from Customers ";
			rs = st.executeQuery(query);
			//System.out.println("Record from database");
			
			while(rs.next()) {
				String name = rs.getString("cfname");
				String pass = rs.getString("pword");
				
				
				if(name.equals(a) && pass.equals(b)) {
					x=true;
					cid = rs.getInt("cid");
					
					
				}
			}
		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return x;
	}
public boolean passwordcheck2(String a) {
		
		
		try {
			String query = "select * from Customers ";
			rs = st.executeQuery(query);
			//System.out.println("Record from database");
			
			while(rs.next()) {
				String name = rs.getString("cfname");
				String pass = rs.getString("pword");
				
				
				if(name.equals(a)) {
					x=true;
					//cid = rs.getInt("cid");
					
					
				}
			}
		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return x;
	}

public boolean apasswordcheck(String a,String b) {
	
	
	try {
		String query = "select * from adminer ";
		rs = st.executeQuery(query);
		//System.out.println("Record from database");
		
		while(rs.next()) {
			String name = rs.getString("afname");
			String pass = rs.getString("apword");
			
			
			if(name.equals(a) && pass.equals(b)) {
				x=true;
				cid = rs.getInt("cid");
				
				
			}
		}
	
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return x;
}
public boolean apasswordcheck2(String a,String b) {
	
	
	try {
		String query = "select * from adminer ";
		rs = st.executeQuery(query);
		//System.out.println("Record from database");
		
		while(rs.next()) {
			String name = rs.getString("afname");
			String pass = rs.getString("apword");
			
			
			if(name.equals(a) && pass.equals(b)) {
				x=true;
				//cid = rs.getInt("cid");
				
				
			}
		}
	
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return x;
}
public boolean aapasswordcheck2(String a,String b) {
	
	
	try {
		String query = "select * from airadminer ";
		rs = st.executeQuery(query);
		//System.out.println("Record from database");
		
		while(rs.next()) {
			String name = rs.getString("aafname");
			String pass = rs.getString("aapword");
			
			
			if(name.equals(a) && pass.equals(b)) {
				x=true;
				//cid = rs.getInt("cid");
				
				
			}
		}
	
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
	return x;
}
	
	
}
