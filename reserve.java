import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class reserve extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					reserve frame = new reserve();
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
	public reserve() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("My Reservations");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(133, 6, 162, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblCancelFlights = new JLabel("Cancel Flight (Enter Flight ID)");
		lblCancelFlights.setBounds(6, 53, 202, 16);
		contentPane.add(lblCancelFlights);
		
		textField = new JTextField();
		textField.setBounds(195, 48, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(textField.getText());
				int c = DBconnect.cid;
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
				
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
					st= con.createStatement();
					
				}catch(Exception ex) {
					System.out.println("Error: "+ex);
				}
				try {
					
					//DELETE FROM `project1`.`cusflghts` WHERE (`cid` = '1') and (`fid` = '544');
					//'"+a3+"'//

					String query = " DELETE FROM `project1`.`cusflghts` WHERE (`cid` = '"+c+"') and (`fid` = '"+x+"')  ";
					st.executeUpdate(query);
					
					cancel one = new cancel();
					one.setVisible(true);
					
					//System.out.println("Record from database");
					
					


				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			
			}
		});
		btnCancel.setBounds(327, 48, 98, 29);
		contentPane.add(btnCancel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 117, 438, 155);
		contentPane.add(textArea);
		
		JLabel lblCheckReservations = new JLabel("Check Reservations:");
		lblCheckReservations.setBounds(89, 87, 134, 16);
		contentPane.add(lblCheckReservations);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//"select `fid`,`airline`,`departure`, `arrival`, `departuretime`, `arrivaltime`, `seats`, `cost` from flights l , cusflghts x where (`cid` = '"+c+"') ";
				
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
					int c = DBconnect.cid;
					
						 query = "select `l`.`fid`,`airline`,`departure`, `arrival`, `departuretime`, `arrivaltime`, `seats`, `cost` from flights l,cusflghts x where `x`.`fid` = `l`.`fid` and (`x`.`cid` = '"+c+"') ";
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
								
								String a,b,z;
								a=Integer.toString(id);
								b=Integer.toString(cost);
								z=Integer.toString(seat);
								
								
								
							
								
							
								
								
								
								
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+z);
									textArea.append(newline);
									contentPane.add(textArea);

								
								
							}

					
					
					
					
						
						
				
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			
			
			
			}
		});
		btnCheck.setBounds(218, 82, 83, 29);
		contentPane.add(btnCheck);
		
		JLabel lblNewLabel_1 = new JLabel(Frame1.day);
		lblNewLabel_1.setBounds(353, 0, 91, 16);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
