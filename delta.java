import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class delta extends JFrame {

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
					delta frame = new delta();
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
	public delta() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog = new JLabel("https://www.delta.com/?tripType=ROUND_TRIP&awardTravel=true&hero=seetheworld&Log");
		lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog.setBounds(6, 6, 438, 16);
		contentPane.add(lblHttpswwwdeltacomtriptyperoundtripawardtraveltrueheroseetheworldlog);
		
		JLabel lblFlightsAvalile = new JLabel("Flights Avalible");
		lblFlightsAvalile.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblFlightsAvalile.setBounds(135, 43, 132, 20);
		contentPane.add(lblFlightsAvalile);
		
		JLabel lb1 = new JLabel("Fid      Departure Info                   Arrival Info              Price  Seats");
		lb1.setBounds(6, 75, 438, 16);
		contentPane.add(lb1);
		
		JLabel lblOOn = new JLabel("O = On Time");
		lblOOn.setBounds(323, 46, 100, 16);
		contentPane.add(lblOOn);
		
		JLabel lblLLate = new JLabel("L = Late");
		lblLLate.setBounds(323, 60, 62, 16);
		contentPane.add(lblLLate);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(352, 22, 92, 16);
		contentPane.add(lblNewLabel);

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
		
		try {
			String query = "select * from flights where airline='Delta' ";
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
