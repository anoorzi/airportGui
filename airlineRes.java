import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class airlineRes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
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
					airlineRes frame = new airlineRes();
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
	public airlineRes() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAirlineReservations = new JLabel("Airline Reservations");
		lblAirlineReservations.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblAirlineReservations.setBounds(123, 6, 199, 22);
		contentPane.add(lblAirlineReservations);
		
		textField = new JTextField();
		textField.setBounds(217, 40, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int x = Integer.parseInt(textField.getText()) ;
				
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

					String query = " DELETE FROM `project1`.`cusflghts` WHERE (`fid` = '"+x+"')  ";
					String query2 = " DELETE FROM `project1`.`flights` WHERE (`fid` = '"+x+"')  ";

					st.executeUpdate(query);
					st.executeUpdate(query2);
					
					cancel one = new cancel();
					one.setVisible(true);

					
					
					
					
					


				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			
				
			
			}
		});
		btnCancel.setBounds(358, 40, 86, 29);
		contentPane.add(btnCancel);
		
		JLabel lblToCancelFlight = new JLabel("To Cancel Flight enter Flight ID");
		lblToCancelFlight.setBounds(6, 45, 199, 16);
		contentPane.add(lblToCancelFlight);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 85, 65, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(71, 87, 65, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 85, 78, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(227, 85, 78, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(317, 85, 65, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblAirline = new JLabel("Airline");
		lblAirline.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblAirline.setBounds(16, 73, 38, 16);
		contentPane.add(lblAirline);
		
		JLabel lblDepartureFrom = new JLabel("Departure From");
		lblDepartureFrom.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblDepartureFrom.setBounds(71, 73, 65, 16);
		contentPane.add(lblDepartureFrom);
		
		JLabel lblArrivalTo = new JLabel("Arrival To");
		lblArrivalTo.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblArrivalTo.setBounds(148, 73, 61, 16);
		contentPane.add(lblArrivalTo);
		
		JLabel lblDepartureInfo = new JLabel("Departure Info");
		lblDepartureInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblDepartureInfo.setBounds(231, 73, 61, 16);
		contentPane.add(lblDepartureInfo);
		
		JLabel lblArrivalInfo = new JLabel("Arrival Info");
		lblArrivalInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblArrivalInfo.setBounds(321, 73, 61, 16);
		contentPane.add(lblArrivalInfo);
		
		textField_6 = new JTextField();
		textField_6.setBounds(103, 123, 78, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(193, 123, 65, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblPrice.setBounds(123, 111, 30, 16);
		contentPane.add(lblPrice);
		
		JLabel lblSeats = new JLabel("Seats");
		lblSeats.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblSeats.setBounds(206, 111, 30, 16);
		contentPane.add(lblSeats);
		
		JButton btnCreateFlight = new JButton("Create Flight");
		btnCreateFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a,b,c,d,f;
				int x,y;
				a = textField_1.getText();
				b = textField_2.getText();
				c = textField_3.getText();
				d = textField_4.getText();
				f = textField_5.getText();
				x = Integer.parseInt(textField_6.getText());
				y = Integer.parseInt(textField_7.getText());
				
				DBinsert one = new DBinsert();
				one.getData(a, b, c, d, f, x, y);
				newFlight one1 = new newFlight();
				one1.setVisible(true);
				
				



			
			}
		});
		btnCreateFlight.setBounds(270, 120, 117, 29);
		contentPane.add(btnCreateFlight);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 180, 438, 92);
		contentPane.add(textArea);
		
		JLabel lblAllReservations = new JLabel("All Reservations");
		lblAllReservations.setBounds(123, 161, 117, 16);
		contentPane.add(lblAllReservations);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					
						 query = "select `l`.`fid`,`airline`,`departure`, `arrival`, `departuretime`, `arrivaltime`, `seats`, `cost` from flights l,cusflghts x where `x`.`fid` = `l`.`fid` ";
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
		btnNewButton.setBounds(227, 156, 78, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(334, 6, 99, 16);
		contentPane.add(lblNewLabel);
	}
}
