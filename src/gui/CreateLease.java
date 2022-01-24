package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import controller.*;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateLease extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCustomer;
	private JTextField textFieldMachine;
	
	private LeaseCtrl leaseCtrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateLease dialog = new CreateLease();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateLease() {
		leaseCtrl = new LeaseCtrl();
		
		setModal(true);
		setTitle("Create Lease");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 102, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCustomer = new JLabel("Enter customer phone number");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.EAST;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 1;
		gbc_lblCustomer.gridy = 1;
		panel.add(lblCustomer, gbc_lblCustomer);
		
		textFieldCustomer = new JTextField();
		GridBagConstraints gbc_textFieldCustomer = new GridBagConstraints();
		gbc_textFieldCustomer.anchor = GridBagConstraints.WEST;
		gbc_textFieldCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCustomer.gridx = 2;
		gbc_textFieldCustomer.gridy = 1;
		panel.add(textFieldCustomer, gbc_textFieldCustomer);
		textFieldCustomer.setColumns(10);
		
		JLabel lblMachine = new JLabel("Enter machine id");
		GridBagConstraints gbc_lblMachine = new GridBagConstraints();
		gbc_lblMachine.insets = new Insets(0, 0, 0, 5);
		gbc_lblMachine.anchor = GridBagConstraints.EAST;
		gbc_lblMachine.gridx = 1;
		gbc_lblMachine.gridy = 3;
		panel.add(lblMachine, gbc_lblMachine);
		
		textFieldMachine = new JTextField();
		GridBagConstraints gbc_textFieldMachine = new GridBagConstraints();
		gbc_textFieldMachine.anchor = GridBagConstraints.WEST;
		gbc_textFieldMachine.gridx = 2;
		gbc_textFieldMachine.gridy = 3;
		panel.add(textFieldMachine, gbc_textFieldMachine);
		textFieldMachine.setColumns(10);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(ColorScheme.TAB);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnConfirm = new JButton("Confirm Lease");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLease();
			}
		});
		buttonPanel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		buttonPanel.add(btnCancel);
	}

	private void cancel() {
		dispose();
	}
	
	private void createLease() {
		String phone = textFieldCustomer.getText();
		if(leaseCtrl.searchCustomer(phone) != null) {
			System.out.print("nice");
		}
	}
}
