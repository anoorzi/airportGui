import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class booker extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					booker frame = new booker();
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
	public booker() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterFlightId = new JLabel("Enter Flight ID of Desired Flight to book");
		lblEnterFlightId.setBounds(89, 56, 256, 16);
		contentPane.add(lblEnterFlightId);
		
		textField = new JTextField();
		textField.setBounds(89, 84, 152, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int fid = Integer.parseInt(textField.getText());
				
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
					String s = "a";
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
		btnNewButton.setBounds(241, 84, 105, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(353, 6, 91, 16);
		contentPane.add(lblNewLabel);
		
		
		
		
		
	}
}
