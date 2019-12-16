import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class searchAll extends JFrame {

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
					searchAll frame = new searchAll();
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
	public searchAll() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAllSearchReservations = new JLabel("All Search Reservations");
		lblAllSearchReservations.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblAllSearchReservations.setBounds(119, 6, 227, 16);
		contentPane.add(lblAllSearchReservations);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 40, 438, 232);
		contentPane.add(textArea);
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
			st= con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
		
		try {
			
			String query;
			textArea.setText(null);
			
			JLabel lblNewLabel = new JLabel(Frame1.day);
			lblNewLabel.setBounds(346, 0, 98, 16);
			contentPane.add(lblNewLabel);
			int c = DBconnect.cid;
			
				 query = "select `l`.`fid`,`airline`,`departure`, `arrival`, `departuretime`, `arrivaltime`, `seats`, `cost`, `loc` from flights l,cusflghts x where `x`.`fid` = `l`.`fid`  ";
					rs = st.executeQuery(query);
					String newline = "\n";
					while(rs.next()) {
						
						int id = rs.getInt("fid");
						String airline = rs.getString("airline");
						String depart = rs.getString("departure");
						String arrive = rs.getString("arrival");
						String dtime = rs.getString("departuretime");
						String atime = rs.getString("arrivaltime");
						int cost = rs.getInt("cost");
						int seat = rs.getInt("seats");
						String xx = rs.getString("loc");
						
						String a,b,z;
						a=Integer.toString(id);
						b=Integer.toString(cost);
						z=Integer.toString(seat);
						
						
						
					
						
					
						
						
						
							if(xx.contains("e")) {
								textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+z);
								textArea.append(newline);
								contentPane.add(textArea);
							}
						
						
					}

			
			
			
			
				
				
		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
	}
}
