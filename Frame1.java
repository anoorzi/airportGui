import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Frame1 {

	private JFrame frame;
	public static int created;
	static public ArrayList<flights> list = new ArrayList<>();
	static public ArrayList<flights> list2 = new ArrayList<>();
	static public ArrayList<flights> list3 = new ArrayList<>();
	public static int i;
	public static int usertype;
	public static String day;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		checker ch1 = new checker();
		DBdate one = new DBdate();
		i =ch1.statuscheck();
		if(i==0) {
			Global start = new Global();
			start.CGV();
			one.updatedate();
		}
		day=one.getdate(); 
		//int x = Global.CurrentDate.getMonth();
		//System.out.println(x);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginAsAdministrator = new JLabel("Login As Search Administrator:");
		lblLoginAsAdministrator.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLoginAsAdministrator.setBounds(17, 89, 249, 20);
		frame.getContentPane().add(lblLoginAsAdministrator);
		
		JLabel lblLoginAsCustomer = new JLabel("Login As Customer");
		lblLoginAsCustomer.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLoginAsCustomer.setBounds(17, 16, 155, 20);
		frame.getContentPane().add(lblLoginAsCustomer);
		
		JButton btnLoginsignUp = new JButton("Login/Sign Up");
		btnLoginsignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login login1 = new login();
				login1.setVisible(true);
				
			}
		});
		btnLoginsignUp.setBounds(6, 48, 117, 29);
		frame.getContentPane().add(btnLoginsignUp);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				loginadmin one = new loginadmin();
				one.setVisible(true);
				
			}
		});
		btnLogin.setBounds(6, 121, 117, 29);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Login As Airline Administrator:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(17, 162, 249, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginair one = new loginair();
				one.setVisible(true);
			
			}
		});
		btnLogin_1.setBounds(6, 190, 117, 29);
		frame.getContentPane().add(btnLogin_1);
		
		JLabel lblViewAirports = new JLabel("View Airports");
		lblViewAirports.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblViewAirports.setBounds(17, 231, 105, 16);
		frame.getContentPane().add(lblViewAirports);
		
		JButton btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				airports one = new airports();
				one.setVisible(true);
			
			}
		});
		btnClick.setBounds(134, 227, 84, 29);
		frame.getContentPane().add(btnClick);
		
		JLabel lblNewLabel_1 = new JLabel(Frame1.day);
		lblNewLabel_1.setBounds(346, 6, 98, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnTerminate = new JButton("Terminate");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatechecker checker= new updatechecker();
				checker.set0();
				deleteAll delete = new deleteAll();
				delete.not();
				delete.delete();
				System.exit(0);
			
			}
		});
		btnTerminate.setBounds(327, 243, 117, 29);
		frame.getContentPane().add(btnTerminate);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		if(i==0) {
		
		list.add(new flights("Delta","JFK","LAX",50));
  		list.add(new flights("Delta","JFK","DAL",50));
  		
  		list.add(new flights("Delta","LAX","JFK",50));
  		list.add(new flights("Delta","LAX","DAL",50));
  		
  		list.add(new flights("Delta","DAL","JFK",50));
  		list.add(new flights("Delta","DAL","LAX",50));
  		
  		for(int i=0; i < list.size();i++){
  			list.get(i).initalizer();
  		}
  		for(int x=0; x < list.size();x++){
  		
  			DBinsert c = new DBinsert();
  			c.getData(list.get(x).getAirline(),list.get(x).getDeparture(), list.get(x).getArrival(),list.get(x).getDepartureTimeS(), list.get(x).getArrivalTimeS(), list.get(x).getSeats(),list.get(x).getPrice());
  		
  		}
  		
  		
  		
  		
  		
  		
  		
  		
  		
  		list2.add(new flights("JetBlue","JFK","LAX",50));
  		list2.add(new flights("JetBlue","JFK","DAL",50));
  		
  		list2.add(new flights("JetBlue","LAX","JFK",50));
  		list2.add(new flights("JetBlue","LAX","DAL",50));
  		
  		list2.add(new flights("JetBlue","DAL","JFK",50));
  		list2.add(new flights("JetBlue","DAL","LAX",50));
  		
  		for(int i=0; i < list2.size();i++){
  			list2.get(i).initalizer();
  		}
  		for(int x=0; x < list2.size();x++){
  		
  			DBinsert c = new DBinsert();
  			c.getData(list2.get(x).getAirline(),list2.get(x).getDeparture(), list2.get(x).getArrival(),list2.get(x).getDepartureTimeS(), list2.get(x).getArrivalTimeS(), list2.get(x).getSeats(),list2.get(x).getPrice());
  		
  		}
  		
  		
  		
  		
  		
  		list3.add(new flights("American","JFK","LAX",50));
  		list3.add(new flights("American","JFK","DAL",50));
  		
  		list3.add(new flights("American","LAX","JFK",50));
  		list3.add(new flights("American","LAX","DAL",50));
  		
  		list3.add(new flights("American","DAL","JFK",50));
  		list3.add(new flights("American","DAL","LAX",50));
  		
  		for(int i=0; i < list3.size();i++){
  			list3.get(i).initalizer();
  		}
		
  		
  		
  		for(int x=0; x < list3.size();x++){
  		
  			DBinsert c = new DBinsert();
  			c.getData(list3.get(x).getAirline(),list3.get(x).getDeparture(), list3.get(x).getArrival(),list3.get(x).getDepartureTimeS(), list3.get(x).getArrivalTimeS(), list3.get(x).getSeats(),list3.get(x).getPrice());
  		
  		}
  		
  		
  		updatechecker checker = new updatechecker();
  		checker.set1();
		
  		
		}
		
	
		
		
		
		
		//date CurrentDate = new date(num1,num2,num3); 
		
		
	}
}
