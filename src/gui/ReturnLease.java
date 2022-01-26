package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LeaseCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.LeaseNotFoundException;
import exceptions.MachineNotFoundException;
import exceptions.NotCorrectCustomerException;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnLease extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCustomer;
	private JTextField textFieldId;
	
	private LeaseCtrl leaseCtrl;
	private JLabel lblError;
	private boolean created = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReturnLease dialog = new ReturnLease(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnLease(LeaseCtrl leaseCtrl) {
		this.leaseCtrl = leaseCtrl;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{27, 139, 96, 0};
			gbl_panel.rowHeights = new int[]{25, 19, 19, 0, 0, 20, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblCustomer = new JLabel("Enter customer phone number");
				GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
				gbc_lblCustomer.anchor = GridBagConstraints.EAST;
				gbc_lblCustomer.insets = new Insets(0, 0, 5, 5);
				gbc_lblCustomer.gridx = 1;
				gbc_lblCustomer.gridy = 2;
				panel.add(lblCustomer, gbc_lblCustomer);
			}
			{
				textFieldCustomer = new JTextField();
				textFieldCustomer.setColumns(10);
				GridBagConstraints gbc_textFieldCustomer = new GridBagConstraints();
				gbc_textFieldCustomer.anchor = GridBagConstraints.WEST;
				gbc_textFieldCustomer.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldCustomer.gridx = 2;
				gbc_textFieldCustomer.gridy = 2;
				panel.add(textFieldCustomer, gbc_textFieldCustomer);
			}
			{
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.insets = new Insets(0, 0, 5, 5);
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 3;
				panel.add(panel_1, gbc_panel_1);
			}
			{
				JLabel lblMachine = new JLabel("Enter machine id");
				GridBagConstraints gbc_lblMachine = new GridBagConstraints();
				gbc_lblMachine.anchor = GridBagConstraints.EAST;
				gbc_lblMachine.insets = new Insets(0, 0, 5, 5);
				gbc_lblMachine.gridx = 1;
				gbc_lblMachine.gridy = 4;
				panel.add(lblMachine, gbc_lblMachine);
			}
			{
				textFieldId = new JTextField();
				textFieldId.setColumns(10);
				GridBagConstraints gbc_textFieldId = new GridBagConstraints();
				gbc_textFieldId.anchor = GridBagConstraints.WEST;
				gbc_textFieldId.insets = new Insets(0, 0, 5, 0);
				gbc_textFieldId.gridx = 2;
				gbc_textFieldId.gridy = 4;
				panel.add(textFieldId, gbc_textFieldId);
			}
			{
				lblError = new JLabel("");
				GridBagConstraints gbc_lblError = new GridBagConstraints();
				gbc_lblError.gridx = 2;
				gbc_lblError.gridy = 5;
				panel.add(lblError, gbc_lblError);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(ColorScheme.TAB);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Return Lease");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						returnLease();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void cancel()
	{
		dispose();
	}
	
	public void returnLease() 
	{
		String phone = textFieldCustomer.getText();
		
		try {
				int machine = Integer.parseInt(textFieldId.getText());
				leaseCtrl.searchLease(leaseCtrl.searchCustomer(phone), machine);
				DeletedLease deleted = new DeletedLease(leaseCtrl.searchLease(leaseCtrl.searchCustomer(phone), machine), leaseCtrl);
				dispose();
				deleted.setVisible(true);
		} catch(NumberFormatException e) {
				lblError.setText("The machine id must be a number.");
		} catch(CustomerNotFoundException | NotCorrectCustomerException | LeaseNotFoundException e) {
				lblError.setText(e.getMessage());
		} 
		
		created = true;
		
	}
	
	public boolean isCreated()
	{
		return created;
	}

}
