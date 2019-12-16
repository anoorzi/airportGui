import java.awt.BorderLayout;
import java.sql.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JetBlue extends JFrame {

	private JPanel contentPane;
	
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JetBlue frame = new JetBlue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JetBlue() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog = new JLabel("https://www.jetblue.com/?source=GOOGLE_jetblue&viq=p28630062474&dev=c&gclid=EAIaIQ");
		lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog.setBounds(6, 6, 438, 16);
		contentPane.add(lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog);
		
		JLabel lblFlightsAvalible = new JLabel("Flights Avalible");
		lblFlightsAvalible.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblFlightsAvalible.setBounds(132, 34, 169, 26);
		contentPane.add(lblFlightsAvalible);
		
		JLabel lb1 = new JLabel("Fid      Departure Info                   Arrival Info              Price  Seats");
		lb1.setBounds(6, 75, 438, 16);
		contentPane.add(lb1);
		
		JLabel lblOOn = new JLabel("O = On Time");
		lblOOn.setBounds(331, 44, 100, 16);
		contentPane.add(lblOOn);
		
		JLabel lblLLate = new JLabel("L = Late");
		lblLLate.setBounds(333, 59, 62, 16);
		contentPane.add(lblLLate);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(357, 20, 87, 16);
		contentPane.add(lblNewLabel);
		
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
		
		try {
			String query = "select * from flights where airline='JetBlue' ";
			rs = st.executeQuery(query);
			//System.out.println("Record from database");
			int y = 92;
			while(rs.next()) {
				int id = rs.getInt("fid");
				String depart = rs.getString("departure");
				String arrive = rs.getString("arrival");
				String dtime = rs.getString("departuretime");
				String atime = rs.getString("arrivaltime");
				int cost = rs.getInt("cost");
				int seat = rs.getInt("seats");
				
				String a,b,c;
				a=Integer.toString(id);
				b=Integer.toString(cost);
				c=Integer.toString(seat);
				
				JLabel e = new JLabel(a+"  "+depart+"  "+dtime + "  "+ arrive+"  "+atime+"   "+b+"  "+c);
	  			e.setBounds(6, y, 438, 16);
				y=y+25;

				
				contentPane.add(e);
				
				
			}
		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
		
		
		
		
	}

}
