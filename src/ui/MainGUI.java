package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MainGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 426, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 80, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setBounds(357, 10, 45, 13);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 52, 104, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("Orders");
		btnNewButton.setBounds(172, 66, 104, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customers");
		btnNewButton_1.setBounds(227, 131, 104, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Products");
		btnNewButton_2.setBounds(322, 52, 104, 67);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lease");
		btnNewButton_3.setBounds(145, 153, 104, 100);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Staff");
		btnNewButton_4.setBounds(332, 56, 104, 201);
		contentPane.add(btnNewButton_4);
	}
}
