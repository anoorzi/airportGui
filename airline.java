import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class airline extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					airline frame = new airline();
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
	public airline() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvalibleAirlines = new JLabel("Avalible Airlines");
		lblAvalibleAirlines.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblAvalibleAirlines.setBounds(104, 34, 260, 37);
		contentPane.add(lblAvalibleAirlines);
		
		JButton btnNewButton = new JButton("Delta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFrame frame2 = new JFrame();
				delta delta1 = new delta();
				delta1.setVisible(true);
			}
		});
		btnNewButton.setBounds(6, 114, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnJetblue = new JButton("JetBlue");
		btnJetblue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JetBlue jet = new JetBlue();
				jet.setVisible(true);
			}
		});
		btnJetblue.setBounds(154, 114, 117, 29);
		contentPane.add(btnJetblue);
		
		JButton btnAmerican = new JButton("American");
		btnAmerican.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				American a = new American();
				a.setVisible(true);
			}
		});
		btnAmerican.setBounds(303, 114, 117, 29);
		contentPane.add(btnAmerican);
		
		JLabel lblNewLabel = new JLabel(Frame1.day);
		lblNewLabel.setBounds(350, 6, 94, 16);
		contentPane.add(lblNewLabel);
		
		
		
		
		if(Frame1.usertype==1) {

		JButton btnN = new JButton("Book");
			btnN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					booker b1 = new booker();
					b1.setVisible(true);
				}
			});
			btnN.setBounds(154, 222, 117, 29);
			contentPane.add(btnN);
		}
	
	}
}
