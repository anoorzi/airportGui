import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class searchE extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField booker;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchE frame = new searchE();
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
	public searchE() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchEngine = new JLabel("Search Engine");
		lblSearchEngine.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblSearchEngine.setBounds(166, 6, 139, 22);
		contentPane.add(lblSearchEngine);
		
		
		textField = new JTextField();
		textField.setBounds(18, 45, 117, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAirline = new JLabel("Airline ");
		lblAirline.setBounds(18, 29, 244, 16);
		contentPane.add(lblAirline);
		
		textField_1 = new JTextField();
		textField_1.setBounds(18, 86, 117, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPricelessThen = new JLabel("Price (less then or equal to value)");
		lblPricelessThen.setBounds(18, 72, 229, 16);
		contentPane.add(lblPricelessThen);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 142, 438, 130);
		contentPane.add(textArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				String values = textField.getText();
				String values2 = textField_1.getText();
				
				//int number1 = Integer.parseInt(values2);
				
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
					
					
						 query = "select * from flights ";
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
								
								String a,b,c;
								a=Integer.toString(id);
								b=Integer.toString(cost);
								c=Integer.toString(seat);
								
								
								
							
								
								
								if(   values.contains("?") && values2.contains("?") ) {
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+c);
									textArea.append(newline);
									//contentPane.add(textArea);

								
								}
								
								
								
								
								if(   values.contains(airline.toLowerCase()) && cost<=Integer.parseInt(values2) ) {
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+c);
									textArea.append(newline);
									contentPane.add(textArea);

								
								}
								if(    values.contains(airline.toLowerCase()) && values2.contains("?") ) {
									textArea.append(a+"  "+depart+"  "+dtime+"  "+ arrive+"  "+atime+"   "+b+"   "+c);
									textArea.append(newline);
									//contentPane.add(textArea);

								
								}
								
								
								
								
								
								
							}

					
					
					
					
						
						
				
				
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnSearch.setBounds(138, 87, 85, 29);
		contentPane.add(btnSearch);
		
		
		
		JLabel lblFlightId = new JLabel("Flight ID");
		lblFlightId.setBounds(6, 125, 61, 16);
		contentPane.add(lblFlightId);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(345, 0, 99, 16);
		contentPane.add(lblNewLabel);
		
		if(Frame1.usertype==1) {
			
			booker = new JTextField();
			booker.setBounds(287, 67, 143, 26);
			contentPane.add(booker);
			booker.setColumns(10);
			
			JLabel lblEnterFlightId = new JLabel("Enter Flight ID to book");
			lblEnterFlightId.setBounds(287, 51, 144, 16);
			contentPane.add(lblEnterFlightId);
		
			JButton btnBook = new JButton("Book");
			btnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int fid = Integer.parseInt(booker.getText());
					
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
					
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1","root","Onelove123");
						st= con.createStatement();
						
					}catch(Exception ex) {
						System.out.println("Error: "+ex);
					}
					
					try {
						int a = DBconnect.cid;
						int b = fid;
						String s = "e";
						String query = " insert into cusflghts "
									 + " (`cid`,`fid`,`loc`)"
									 + " VALUES ('"+a+"','"+b+"','"+s+"')";
						st.executeUpdate(query);
						
						confirm c1 = new confirm();
						c1.setVisible(true);
						

					
					}catch(Exception ex) {
						System.out.println(ex);
					}
					
					
				
				}
			});
			btnBook.setBounds(344, 87, 85, 29);
			contentPane.add(btnBook);
		}
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
