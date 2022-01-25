package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import controller.*;
import exceptions.CustomerNotFoundException;
import exceptions.MachineNotFoundException;

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
	private JLabel lblError = new JLabel("");
	
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
		contentPanel.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{27, 139, 96, 0};
		gbl_panel.rowHeights = new int[]{25, 19, 19, 0, 0, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCustomer = new JLabel("Enter customer phone number");
		GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
		gbc_lblCustomer.anchor = GridBagConstraints.EAST;
		gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomer.gridx = 1;
		gbc_lblCustomer.gridy = 2;
		panel.add(lblCustomer, gbc_lblCustomer);
		
		textFieldCustomer = new JTextField();
		GridBagConstraints gbc_textFieldCustomer = new GridBagConstraints();
		gbc_textFieldCustomer.anchor = GridBagConstraints.WEST;
		gbc_textFieldCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCustomer.gridx = 2;
		gbc_textFieldCustomer.gridy = 2;
		panel.add(textFieldCustomer, gbc_textFieldCustomer);
		textFieldCustomer.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		panel.add(panel_1, gbc_panel_1);
		
		JLabel lblMachine = new JLabel("Enter machine id");
		GridBagConstraints gbc_lblMachine = new GridBagConstraints();
		gbc_lblMachine.anchor = GridBagConstraints.EAST;
		gbc_lblMachine.insets = new Insets(0, 0, 5, 5);
		gbc_lblMachine.gridx = 1;
		gbc_lblMachine.gridy = 4;
		panel.add(lblMachine, gbc_lblMachine);
		
		textFieldMachine = new JTextField();
		GridBagConstraints gbc_textFieldMachine = new GridBagConstraints();
		gbc_textFieldMachine.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMachine.anchor = GridBagConstraints.WEST;
		gbc_textFieldMachine.gridx = 2;
		gbc_textFieldMachine.gridy = 4;
		panel.add(textFieldMachine, gbc_textFieldMachine);
		textFieldMachine.setColumns(10);
		
		
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 5;
		panel.add(lblError, gbc_lblError);
		
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
	
	private void createLease(){
		String phone = textFieldCustomer.getText();
		
		try {
			int machine = Integer.parseInt(textFieldMachine.getText());
			leaseCtrl.confirmLease(leaseCtrl.searchCustomer(phone), leaseCtrl.searchMachine(machine));
			LeaseCreated created = new LeaseCreated(leaseCtrl.searchLease(machine));
			dispose();
			created.setVisible(true);
		} catch(NumberFormatException e) {
			lblError.setText("The machine id must be a number.");
		} catch(MachineNotFoundException | CustomerNotFoundException e) {
			lblError.setText(e.getMessage());
		} 
	}
}
