package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderReceipt extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4900436836168536626L;

	private final JPanel contentPanel = new JPanel();
	
	private OrderCtrl orderCtrl;

	/**
	 * Create the dialog.
	 */
	public OrderReceipt(OrderCtrl orderCtrl) {
		this.orderCtrl = orderCtrl;
		initGui();
	}
	
	private void initGui() {
		setTitle("Order for " + orderCtrl.getCurrentOrder().getACustomer().getName());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton finishOrderButton = new JButton("Finish Order");
				finishOrderButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO finish order
					}
				});
				buttonPane.add(finishOrderButton);
				getRootPane().setDefaultButton(finishOrderButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO cancel window
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
