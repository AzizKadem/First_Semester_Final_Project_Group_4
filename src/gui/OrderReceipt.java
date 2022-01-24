package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import exceptions.EmptyOrderException;
import model.Appliance;
import model.AppliancesOrderLine;
import model.Order;
import model.OrderLine;
import model.PackageLine;
import model.Packages;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JScrollPane;

public class OrderReceipt extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4900436836168536626L;

	private final JPanel contentPanel = new JPanel();
	
	private OrderCtrl orderCtrl;
	private JLabel lblNewLabel_3;
	

	/**
	 * Create the dialog.
	 */
	public OrderReceipt(OrderCtrl orderCtrl) {
		setModal(true);
		this.orderCtrl = orderCtrl;
		initGui();
	}
	
	private void initGui() {
		setTitle("Order for " + orderCtrl.getCurrentOrder().getACustomer().getName());
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel lblNewLabel = new JLabel("Receipt");
				panel.add(lblNewLabel);
			}
		}
		{
			{
				{
					String a = new String("" + orderCtrl.getCurrentOrder().getTotalPrice());
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				lblNewLabel_3 = new JLabel("Sending the invoice...");
				lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
				panel.add(lblNewLabel_3);
				{
					JScrollPane scrollPane = new JScrollPane();
					contentPanel.add(scrollPane, BorderLayout.CENTER);
					{
						Box verticalBox = Box.createVerticalBox();
						scrollPane.setViewportView(verticalBox);
						{
							JLabel lblNewLabel_1 = new JLabel(getItems());
							verticalBox.add(lblNewLabel_1);
						}
						{
							JLabel lblNewLabel_2 = new JLabel("Total: " + CurrencyHandler.convertToString(orderCtrl.getTotal()));
							verticalBox.add(lblNewLabel_2);
						}
					}
				}
				lblNewLabel_3.setVisible(false);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton finishOrderButton = new JButton("Send invoice");
				finishOrderButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finishInvoice();
						//TODO finish order
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton btnNewButton = new JButton("Pay here");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							finishHere();
							//waiting for the answer from terminal
							
						}
					});
					buttonPane.add(btnNewButton);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					buttonPane.add(horizontalStrut);
				}
				buttonPane.add(finishOrderButton);
				getRootPane().setDefaultButton(finishOrderButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO cancel window
						dispose();
					}
				});
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					buttonPane.add(horizontalStrut);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private String getItems() {
		StringBuilder returnString = new StringBuilder();
		for(OrderLine anOrderLine : orderCtrl.getCurrentOrder().getOrderLines()) {
			returnString.append(anOrderLine.getAProduct().getName());
			returnString.append("    " + anOrderLine.getAProduct().getPrice());
			returnString.append(" x" + anOrderLine.getQuantity());
			if (anOrderLine.getQuantity() < 10) {
				returnString.append(" " + anOrderLine.getSubTotal());
			}
			else {
				returnString.append(" " + (anOrderLine.getSubTotal() + anOrderLine.getDiscount()));
				returnString.append(" -" + anOrderLine.getDiscount());
				returnString.append(" " + anOrderLine.getSubTotal());
			}
			
			if (anOrderLine.getAProduct().getClass().isAssignableFrom(Appliance.class)) {
				returnString.append("\n\tColor: ");
				returnString.append(((AppliancesOrderLine)anOrderLine).getCopy().getColor());
			}
		}
		return returnString.toString();
	}
	
	private void finishOrder(){
		try {
			orderCtrl.finishOrder();
		} catch (EmptyOrderException e) {
			e.printStackTrace();
		}
		dispose();
	}
	
	private void finishHere() {
		try {
			Payment dialog = new Payment(orderCtrl);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			finishOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void finishInvoice() {
		finishOrder();
	}

}
