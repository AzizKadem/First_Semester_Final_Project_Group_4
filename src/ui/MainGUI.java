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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import javax.swing.SwingConstants;


public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2;
	private JPanel panel_3;
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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel, BorderLayout.CENTER);
		
		
		

		panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel.add(panel_2);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_2.add(verticalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Orders");
		verticalBox_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Create order");
		verticalBox_1.add(btnNewButton_2);
		
		panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel.add(panel_3);
		
		Box verticalBox_2 = Box.createVerticalBox();
		panel_3.add(verticalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Leases");
		verticalBox_2.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Create Lease");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		verticalBox_2.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		JButton btnNewButton = new JButton("Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openOrders();
			}
		});
		verticalBox.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leases");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLeases();
			}
		});
		verticalBox.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Main menu");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}
	
	private void openOrders() {
		hidePanels();
		panel_2.setVisible(true);
	}
	
	private void openLeases() {
		hidePanels();
		panel_3.setVisible(true);
	}
	
	private void hidePanels() {
		panel_2.setVisible(false);
		panel_3.setVisible(false);
	}
}
