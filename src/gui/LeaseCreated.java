package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Customer;
import model.Lease;
import model.Machine;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeaseCreated extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LeaseCreated dialog = new LeaseCreated(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LeaseCreated(Lease lease) {
		setTitle("Lease Created");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Customer");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblCustomer = new JLabel("");
			GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
			gbc_lblCustomer.insets = new Insets(0, 0, 5, 0);
			gbc_lblCustomer.gridx = 3;
			gbc_lblCustomer.gridy = 1;
			contentPanel.add(lblCustomer, gbc_lblCustomer);
			lblCustomer.setText(lease.getCustomer().getName());
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Leased machine");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 3;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		}
		{
			JLabel lblMachine = new JLabel("");
			GridBagConstraints gbc_lblMachine = new GridBagConstraints();
			gbc_lblMachine.insets = new Insets(0, 0, 5, 0);
			gbc_lblMachine.gridx = 3;
			gbc_lblMachine.gridy = 3;
			contentPanel.add(lblMachine, gbc_lblMachine);
			lblMachine.setText(lease.getMachine().getName());
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Period");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 5;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			JLabel lblPeriod = new JLabel("");
			GridBagConstraints gbc_lblPeriod = new GridBagConstraints();
			gbc_lblPeriod.insets = new Insets(0, 0, 5, 0);
			gbc_lblPeriod.gridx = 3;
			gbc_lblPeriod.gridy = 5;
			contentPanel.add(lblPeriod, gbc_lblPeriod);
			lblPeriod.setText(Integer.toString(lease.getPeriod()));
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Price");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 7;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			JLabel lblPrice = new JLabel("");
			GridBagConstraints gbc_lblPrice = new GridBagConstraints();
			gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrice.gridx = 3;
			gbc_lblPrice.gridy = 7;
			contentPanel.add(lblPrice, gbc_lblPrice);
			lblPrice.setText(Double.toString(lease.getMachine().getPrice()));
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Date");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 9;
			contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		}
		{
			JLabel lblDate = new JLabel("");
			GridBagConstraints gbc_lblDate = new GridBagConstraints();
			gbc_lblDate.gridx = 3;
			gbc_lblDate.gridy = 9;
			contentPanel.add(lblDate, gbc_lblDate);
			lblDate.setText(lease.getDate().toString());
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(new Color(80, 133, 165));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			{
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						back();
					}
				});
				buttonPanel.add(btnBack);
			}
		}
	}

	private void back() {
		dispose();
	}
}
