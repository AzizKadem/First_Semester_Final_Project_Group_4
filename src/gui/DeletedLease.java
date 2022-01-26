package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LeaseCtrl;
import model.Lease;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletedLease extends JDialog {

	private LeaseCtrl leaseCtrl = new LeaseCtrl();
	private Lease l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeletedLease dialog = new DeletedLease(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeletedLease(Lease l, LeaseCtrl leaseCtrl) {
		this.leaseCtrl = leaseCtrl;
		this.l = l;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(ColorScheme.TAB);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ReturnLease");
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
		{
			JPanel contentPanel = new JPanel();
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			GridBagLayout gbl_contentPanel = new GridBagLayout();
			gbl_contentPanel.columnWidths = new int[]{32, 0, 0, 0, 0};
			gbl_contentPanel.rowHeights = new int[]{10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			contentPanel.setLayout(gbl_contentPanel);
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
				contentPanel.add(panel, gbc_panel);
			}
			{
				JLabel lblNewLabel = new JLabel("Customer");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 1;
				contentPanel.add(lblNewLabel, gbc_lblNewLabel);
			}
			{
				JLabel lblCustomer = new JLabel((String) null);
				GridBagConstraints gbc_lblCustomer = new GridBagConstraints();
				gbc_lblCustomer.insets = new Insets(0, 0, 5, 0);
				gbc_lblCustomer.gridx = 3;
				gbc_lblCustomer.gridy = 1;
				contentPanel.add(lblCustomer, gbc_lblCustomer);
				lblCustomer.setText(l.getCustomer().getName());
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 2;
				contentPanel.add(panel, gbc_panel);
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
				JLabel lblMachine = new JLabel((String) null);
				GridBagConstraints gbc_lblMachine = new GridBagConstraints();
				gbc_lblMachine.insets = new Insets(0, 0, 5, 0);
				gbc_lblMachine.gridx = 3;
				gbc_lblMachine.gridy = 3;
				contentPanel.add(lblMachine, gbc_lblMachine);
				lblMachine.setText(l.getMachine().getName());
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 4;
				contentPanel.add(panel, gbc_panel);
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
				JLabel lblPeriod = new JLabel("0");
				GridBagConstraints gbc_lblPeriod = new GridBagConstraints();
				gbc_lblPeriod.insets = new Insets(0, 0, 5, 0);
				gbc_lblPeriod.gridx = 3;
				gbc_lblPeriod.gridy = 5;
				contentPanel.add(lblPeriod, gbc_lblPeriod);
				lblPeriod.setText(Integer.toString(l.getPeriod()));
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 6;
				contentPanel.add(panel, gbc_panel);
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
				JLabel lblPrice = new JLabel("0.0");
				GridBagConstraints gbc_lblPrice = new GridBagConstraints();
				gbc_lblPrice.insets = new Insets(0, 0, 5, 0);
				gbc_lblPrice.gridx = 3;
				gbc_lblPrice.gridy = 7;
				contentPanel.add(lblPrice, gbc_lblPrice);
				lblPrice.setText(Double.toString(l.getMachine().getPrice()));
			}
			{
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 5);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 8;
				contentPanel.add(panel, gbc_panel);
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
				JLabel lblDate = new JLabel((String) null);
				GridBagConstraints gbc_lblDate = new GridBagConstraints();
				gbc_lblDate.gridx = 3;
				gbc_lblDate.gridy = 9;
				contentPanel.add(lblDate, gbc_lblDate);
				lblDate.setText(l.getDate().getDateTime());
			}
		}
	}
	
	public void cancel()
	{
		dispose();
	}
	
	public void returnLease()
	{
		leaseCtrl.removeLease(l);
		dispose();
	}
}
