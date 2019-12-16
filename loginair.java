import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class loginair extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginair frame = new loginair();
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
	public loginair() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblUsername = new JLabel("Username");
				lblUsername.setBounds(35, 46, 72, 16);
				contentPane.add(lblUsername);
				
				textField = new JTextField();
				textField.setBounds(27, 64, 270, 36);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setBounds(37, 112, 70, 16);
				contentPane.add(lblPassword);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(27, 128, 270, 36);
				contentPane.add(passwordField);
				
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DBconnect connecter = new DBconnect();
						
						boolean l=false;
						String x,y;
						x=textField.getText();
						y=passwordField.getText();
						
						l= connecter.aapasswordcheck2(x, y);
						
						if(l==true) {
							Frame1.usertype=3;
							home home1 = new home();
							home1.setVisible(true);

							
						}
						
					}
				});
				btnLogin.setBounds(27, 182, 117, 29);
				contentPane.add(btnLogin);
				
				JLabel lblCustomer = new JLabel("Airline Admin");
				lblCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
				lblCustomer.setBounds(98, 20, 117, 16);
				contentPane.add(lblCustomer);
				
				JLabel lblNewLabel = new JLabel(Frame1.day);
				lblNewLabel.setBounds(356, 6, 88, 16);
				contentPane.add(lblNewLabel);
	}

}
