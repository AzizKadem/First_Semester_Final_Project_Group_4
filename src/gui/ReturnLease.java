package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class ReturnLease extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReturnLease dialog = new ReturnLease();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReturnLease() {
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
				textField = new JTextField();
				textField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.anchor = GridBagConstraints.WEST;
				gbc_textField.insets = new Insets(0, 0, 5, 0);
				gbc_textField.gridx = 2;
				gbc_textField.gridy = 2;
				panel.add(textField, gbc_textField);
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
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.anchor = GridBagConstraints.WEST;
				gbc_textField_1.insets = new Insets(0, 0, 5, 0);
				gbc_textField_1.gridx = 2;
				gbc_textField_1.gridy = 4;
				panel.add(textField_1, gbc_textField_1);
			}
			{
				JLabel lblError = new JLabel("");
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
