package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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


public class MainMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7694456555976937236L;
	
	private JPanel contentPane;
	private JPanel ordersPanel;
	private JPanel leasesPanel;

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
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel interactivePanel = new JPanel();
		FlowLayout fl_interactivePanel = (FlowLayout) interactivePanel.getLayout();
		fl_interactivePanel.setAlignment(FlowLayout.LEFT);
		
		ordersPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) ordersPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		ordersPanel.setVisible(false);
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
		FlowLayout flowLayout_1 = (FlowLayout) leasesPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		leasesPanel.setVisible(false);
		interactivePanel.add(leasesPanel);
		
		Box verticalBox_2 = Box.createVerticalBox();
		leasesPanel.add(verticalBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("Leases");
		lblNewLabel_2.setAlignmentX(0.1f);
		verticalBox_2.add(lblNewLabel_2);
		
		JButton btnNewButton_3 = new JButton("Create Lease");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Component verticalStrut_2 = Box.createVerticalStrut(5);
		verticalBox_2.add(verticalStrut_2);
		verticalBox_2.add(btnNewButton_3);

		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.decode("#5085a5"));
		splitPane.setLeftComponent(menuPanel);
		
		splitPane.setRightComponent(interactivePanel);
		
		splitPane.setResizeWeight(0.3);
		
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
	}
}