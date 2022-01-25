package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;

public class Payment extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private OrderCtrl orderctrl;
	

	/**
	 * Launch the application.
	 */
	public Payment(OrderCtrl ctrl) {
		setModal(true);
		this.orderctrl = ctrl;
		initPayment();
	}

	/**
	 * Create the dialog.
	 */
	public void initPayment() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Was payment of " + orderctrl.getCurrentOrder().getTotalPrice() + " successful?");
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Yes");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						payed();
					}
				});
				okButton.setActionCommand("Yes");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("No");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						notPayed();
					}
				});
				cancelButton.setActionCommand("No");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void payed() {
		Confirmation.getInstance().setCreated(true);
		dispose();
	}
	
	public void notPayed() {
		Confirmation.getInstance().setCreated(false);
		dispose();
	}

}
