package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controller.LeaseCtrl;


public class MainMenu extends JFrame {
	/**
	 * Serial version 
	 */
	private static final long serialVersionUID = 7694456555976937236L;
	
	private JPanel contentPane;
	private JPanel ordersPanel;
	private JPanel leasesPanel;
	private JLabel lblNewLabel;
	private LeaseCtrl leaseCtrl = new LeaseCtrl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					GenerateData.generateData();
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		initGui();
		showOrders();
	}
	
	private void initGui() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(ColorScheme.BACKGROUND);
		
		JPanel interactivePanel = new JPanel();
		interactivePanel.setBackground(ColorScheme.BACKGROUND);
		
		ordersPanel = new JPanel();
		ordersPanel.setBackground(ColorScheme.BACKGROUND);
		FlowLayout flowLayout = (FlowLayout) ordersPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		ordersPanel.setVisible(false);
		interactivePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		interactivePanel.add(ordersPanel);
		
		Box verticalBox_1 = Box.createVerticalBox();
		ordersPanel.add(verticalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Orders");
		lblNewLabel_1.setAlignmentX(0.1f);
		verticalBox_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Create order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrder();
			}
		});
		
		Component verticalStrut_1 = Box.createVerticalStrut(5);
		verticalBox_1.add(verticalStrut_1);
		verticalBox_1.add(btnNewButton_2);
		
		leasesPanel = new JPanel();
		leasesPanel.setBackground(ColorScheme.BACKGROUND);
		FlowLayout flowLayout_1 = (FlowLayout) leasesPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		leasesPanel.setVisible(false);
		interactivePanel.add(leasesPanel);
		
		Box verticalBox_2 = Box.createVerticalBox();
		leasesPanel.add(verticalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Create");
		lblNewLabel_2.setAlignmentX(0.1f);
		verticalBox_2.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Create Lease");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLease();
			}
		});
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		verticalBox_2.add(verticalStrut_2);
		verticalBox_2.add(btnNewButton_3);
		
		Box verticalBox_2_1 = Box.createVerticalBox();
		leasesPanel.add(verticalBox_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Return");
		lblNewLabel_2_1.setAlignmentX(0.1f);
		verticalBox_2_1.add(lblNewLabel_2_1);
		
		Component verticalStrut_2_1 = Box.createVerticalStrut(5);
		verticalBox_2_1.add(verticalStrut_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Return Lease");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnLease();
			}
		});
		verticalBox_2_1.add(btnNewButton_3_1);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
		splitPane.setDividerSize(2);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(ColorScheme.TAB);
		splitPane.setLeftComponent(menuPanel);
		
		splitPane.setRightComponent(interactivePanel);
		
		Box verticalBox_3 = Box.createVerticalBox();
		interactivePanel.add(verticalBox_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(ColorScheme.BACKGROUND);
		verticalBox_3.add(panel);
		
		lblNewLabel = new JLabel("");
		verticalBox_3.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		splitPane.setResizeWeight(0.2);
		
		Box verticalBox = Box.createVerticalBox();
		menuPanel.add(verticalBox);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setAlignmentX(0.5f);
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrders();
			}
		});
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_3);
		verticalBox.add(btnOrders);
		
		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut);
		
		JButton btnLeases = new JButton("Leases");
		btnLeases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLeases();
			}
		});
		btnLeases.setAlignmentX(0.5f);
		verticalBox.add(btnLeases);
		
	}
	
	/**
	 * Show orders menu
	 */
	private void showOrders() {
		hidePanels();
		lblNewLabel.setVisible(false);
		ordersPanel.setVisible(true);
	}
	
	/**
	 * Show leases menu
	 */
	private void showLeases() {
		hidePanels();
		lblNewLabel.setVisible(false);
		leasesPanel.setVisible(true);
	}
	
	/**
	 * Hide all menu panels
	 */
	private void hidePanels() {
		ordersPanel.setVisible(false);
		leasesPanel.setVisible(false);
	}
	
	/**
	 * Handle order creation
	 */
	private void createOrder() {
		CreateOrder login = new CreateOrder();
		
		login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		login.setVisible(true);
		if(login.isCreated()) {
			lblNewLabel.setText("\n Order was successfully created");
			lblNewLabel.setVisible(true);
		}
		else {
			lblNewLabel.setText("\n      Your order was cancelled      ");
			lblNewLabel.setVisible(true);
		}
	}
	
	private void createLease() {
		CreateLease lease = new CreateLease(leaseCtrl);
		
		lease.setVisible(true);
		if(lease.isCreated()) {
			lblNewLabel.setText("\n Lease was successfully created");
			lblNewLabel.setVisible(true);
		}
		else {
			lblNewLabel.setText("\n      Your lease was not created      ");
			lblNewLabel.setVisible(true);
		}
	}
	
	private void returnLease() {
		ReturnLease lease = new ReturnLease(leaseCtrl);
		
		lease.setVisible(true);
		
		if(lease.isCreated()) {
			lblNewLabel.setText("\n Lease was successfully returned");
			lblNewLabel.setVisible(true);
		}
		else {
			lblNewLabel.setText("\n      Your lease was not returned      ");
			lblNewLabel.setVisible(true);
		}
	}
}
