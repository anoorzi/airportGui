import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

public class airports extends JFrame {

	private JPanel contentPane;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	//private String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					airports frame = new airports();
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
	public airports() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAirports = new JLabel("Airports");
		lblAirports.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblAirports.setBounds(194, 17, 105, 22);
		contentPane.add(lblAirports);
		
		String[] s = {"JFK","LAX","DAL"};
		String[] x = {"Arrival Time","Departure Time"};
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 105, 450, 167);
		contentPane.add(textArea);
		
		JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(62, 46, 97, 27);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(x);
		comboBox_1.setBounds(171, 46, 128, 27);
		contentPane.add(comboBox_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String values = (String)comboBox.getSelectedItem();
				String values2 = (String)comboBox_1.getSelectedItem();
				
				
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
					
					if(values2.contains("Arrival Time")) {
						 query = "select * from flights ";
							rs = st.executeQuery(query);
							String newline = "\n";
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
								
								if(values.contains(arrive)) {
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+c);
									textArea.append(newline);
									//contentPane.add(textArea);

								
								}
								
							}

					
					
					
					}
						
						if(values2.contains("Departure Time")) {
						 query = "select * from flights ";
							rs = st.executeQuery(query);

							String newline = "\n";

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
								
								if(values.contains(depart)) {
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+c);
									textArea.append(newline);
									//contentPane.add(textArea);

								
								}
								
							}

					}

				
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
				
				

			
			}
		});
		btnSearch.setBounds(303, 45, 85, 28);
		contentPane.add(btnSearch);								
		contentPane.add(textArea);
		
		JLabel lblFlightId = new JLabel("Flight ID");
		lblFlightId.setBounds(0, 85, 61, 16);
		contentPane.add(lblFlightId);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(350, 85, 38, 16);
		contentPane.add(lblPrice);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setBounds(385, 85, 33, 16);
		contentPane.add(lblSeats);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(350, 6, 94, 16);
		contentPane.add(lblNewLabel);

		
		
		
		
	}
}
