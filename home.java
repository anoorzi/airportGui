import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	public home() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvalibleAirlines = new JLabel("Avalible Airlines");
		lblAvalibleAirlines.setBounds(22, 50, 106, 16);
		contentPane.add(lblAvalibleAirlines);
		
		JLabel lblAvalibleAirports = new JLabel("Avalible Airports");
		lblAvalibleAirports.setBounds(22, 91, 106, 16);
		contentPane.add(lblAvalibleAirports);
		
		JLabel lblSearchFlights = new JLabel("Search Flights");
		lblSearchFlights.setBounds(22, 127, 106, 16);
		contentPane.add(lblSearchFlights);
		
	
		
		JButton btnClickHere = new JButton("Click Here");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				airline airline1 = new airline();
				airline1.setVisible(true);
			}
		});
		btnClickHere.setBounds(312, 45, 117, 29);
		contentPane.add(btnClickHere);
		
		JButton btnClickHere_1 = new JButton("Click Here");
		btnClickHere_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				airports air = new airports();
				air.setVisible(true);
			}
		});
		btnClickHere_1.setBounds(312, 86, 117, 29);
		contentPane.add(btnClickHere_1);
		
		JButton btnClickHere_2 = new JButton("Click Here");
		btnClickHere_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchE ex = new searchE();
				ex.setVisible(true);
			
			}
		});
		btnClickHere_2.setBounds(312, 122, 117, 29);
		contentPane.add(btnClickHere_2);
		
		
		
		if(Frame1.usertype==1) {
			
		
			JLabel lblMyReservations = new JLabel("My Reservations");
			lblMyReservations.setBounds(22, 164, 106, 16);
			contentPane.add(lblMyReservations);
		
			JButton btnClickHere_3 = new JButton("Click Here");
			btnClickHere_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					reserve one = new reserve();
					one.setVisible(true);
					
				
				
				}
			});
			btnClickHere_3.setBounds(312, 159, 117, 29);
			contentPane.add(btnClickHere_3);
		
		}
		
		
		if(Frame1.usertype==2) {
			
			
			JLabel lblMyReservations1 = new JLabel("Search Reservations");
			lblMyReservations1.setBounds(22, 164, 131, 16);
			contentPane.add(lblMyReservations1);
		
			JButton btnClickHere_31 = new JButton("Click Here");
			btnClickHere_31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					searchAll one = new searchAll();
					one.setVisible(true);
					
				
				
				}
			});
			btnClickHere_31.setBounds(312, 159, 117, 29);
			contentPane.add(btnClickHere_31);
		
		}
		
		if(Frame1.usertype==3) {
			
			
			JLabel lblMyReservations1 = new JLabel("Airline Reservations");
			lblMyReservations1.setBounds(22, 164, 131, 16);
			contentPane.add(lblMyReservations1);
		
			JButton btnClickHere_31 = new JButton("Click Here");
			btnClickHere_31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				
					airlineRes one = new airlineRes();
					one.setVisible(true);
					
				
				
				}
			});
			btnClickHere_31.setBounds(312, 159, 117, 29);
			contentPane.add(btnClickHere_31);
		
		}
		
		
		
		
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
		btnTerminate.setBounds(349, 243, 101, 29);
		contentPane.add(btnTerminate);
		
		JLabel label = new JLabel(Frame1.day);
		label.setBounds(349, 6, 95, 16);
		contentPane.add(label);
	
		
		
	
	}
}
