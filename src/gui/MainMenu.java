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
import controller.StaffCtrl;
import model.LeaseCont;


public class MainMenu extends JFrame {
	/**
	 * Serial version 
	 */
	private static final long serialVersionUID = 7694456555976937236L;
	
	private JPanel contentPane;
	private JPanel ordersPanel;
	private JPanel leasesPanel;
	private JPanel statisticsPanel;
	private JLabel lblNewLabel;
	private LeaseCtrl leaseCtrl = new LeaseCtrl();
	private StaffCtrl staffCtrl = new StaffCtrl();
	
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
		
		JLabel lblOrders = new JLabel("Orders     ");
		lblOrders.setAlignmentX(0.1f);
		verticalBox_1.add(lblOrders);
		
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
		
		statisticsPanel = new JPanel();
		statisticsPanel.setBackground(ColorScheme.BACKGROUND);
		interactivePanel.add(statisticsPanel);
		
		Box verticalBox_1_1 = Box.createVerticalBox();
		statisticsPanel.add(verticalBox_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Statistics");
		lblNewLabel_1_1.setAlignmentX(0.1f);
		verticalBox_1_1.add(lblNewLabel_1_1);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(5);
		verticalBox_1_1.add(verticalStrut_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Generate statistics");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateStatistics();
			}
		});
		verticalBox_1_1.add(btnNewButton_2_1);
		
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
		
		if (staffCtrl.isManager()) {
			Component verticalStrut_4 = Box.createVerticalStrut(10);
			verticalBox.add(verticalStrut_4);
			
			JButton btnStatistics = new JButton("Statistics");
			btnStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showStatistics();
				}
			});
			btnStatistics.setAlignmentX(0.5f);
			verticalBox.add(btnStatistics);
		}
	}
	
	/**
	 * Show orders menu
	 */
	private void showOrders() {
		hidePanels();
		ordersPanel.setVisible(true);
	}
	
	/**
	 * Show leases menu
	 */
	private void showLeases() {
		hidePanels();
		leasesPanel.setVisible(true);
	}
	
	/**
	 * Show orders menu
	 */
	private void showStatistics() {
		hidePanels();
		statisticsPanel.setVisible(true);
	}
	
	/**
	 * Hide all menu panels
	 */
	private void hidePanels() {
		lblNewLabel.setVisible(false);
		
		ordersPanel.setVisible(false);
		leasesPanel.setVisible(false);
		statisticsPanel.setVisible(false);
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
	
	/**
	 * Handles lease creation
	 */
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
		//System.out.println(LeaseCont.getInstance().getContainerSize());
	}
	
	/**
	 * Handles lease return
	 */
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
		//System.out.println(LeaseCont.getInstance().getContainerSize());
	}
	
	/**
	 * Handles statistics generation
	 */
	private void generateStatistics() {
		GenerateStatistics stat = new GenerateStatistics();
		stat.setVisible(true);
	}
}
