import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

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
					login frame = new login();
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
	public login() {
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
				
				l= connecter.passwordcheck(x, y);
				
				if(l==true) {
					Frame1.usertype=1;
					home home1 = new home();
					home1.setVisible(true);

					
				}
				
			}
		});
		btnLogin.setBounds(27, 182, 117, 29);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DBlog log1 = new DBlog();
				 
				DBconnect test = new DBconnect();
				
				boolean x = test.passwordcheck2(textField.getText());
				
				if(x==false) {
					log1.setSignup(textField.getText(), passwordField.getText());
					DBconnect two = new DBconnect();
					two.passwordcheck(textField.getText(), passwordField.getText());
					
					Frame1.usertype=1;
					home home1= new home();
					home1.setVisible(true);
					

				}
				
				
				
				
			
			}
		});
		btnSignUp.setBounds(170, 182, 117, 29);
		contentPane.add(btnSignUp);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCustomer.setBounds(98, 20, 117, 16);
		contentPane.add(lblCustomer);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(358, 6, 86, 16);
		contentPane.add(lblNewLabel);
	}
}
