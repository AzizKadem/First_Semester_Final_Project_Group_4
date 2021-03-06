package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import exceptions.EmptyOrderException;
import model.Appliance;
import model.AppliancesOrderLine;
import model.OrderLine;

public class OrderReceipt extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4900436836168536626L;

	private final JPanel contentPanel = new JPanel();
	
	private OrderCtrl orderCtrl;
	private JLabel lblNewLabel_3;
	private Box verticalBox;

	private boolean finished;
	

	/**
	 * Create the dialog.
	 */
	public OrderReceipt(OrderCtrl orderCtrl) {
		this.orderCtrl = orderCtrl;
		finished = false;
		
		initGui();
	}
	
	/**
	 * Initializes the gui
	 */
	private void initGui() {
		setModal(true);
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
						verticalBox = Box.createVerticalBox();
						scrollPane.setViewportView(verticalBox);
						{
							getItems();
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
						cancel();
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
	
	/**
	 * Handles the list of products in the order
	 */
	private void getItems() {
		for(int i  = 0; i < orderCtrl.getCurrentOrder().getOrderLines().size(); i++) {
			
			JLabel lblNewLabel = new JLabel("");
			verticalBox.add(lblNewLabel);
			
			StringBuilder returnString = new StringBuilder();
			OrderLine anOrderLine = orderCtrl.getCurrentOrder().getOrderLines().get(i);
			
			returnString.append("\n");
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
				returnString.append("\t Color: ");
				returnString.append(((AppliancesOrderLine)anOrderLine).getCopy().getColor());
			}
			lblNewLabel.setText(returnString.toString());
		}
		
	}
	
	/**
	 * Finishes the order
	 * @throws EmptyOrderException
	 */
	private void finishOrder(){
		try {
			orderCtrl.finishOrder();
			finished = true;
		} catch (EmptyOrderException e) {
			e.printStackTrace();
		}
		dispose();
	}
	
	/**
	 * Asks for payment
	 */
	private void finishHere() {
		try {
			Payment dialog = new Payment(orderCtrl);
			dialog.setVisible(true);
			if (dialog.isPaid()) {
				finishOrder();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handles sending the invoice to registered customer
	 */
	private void finishInvoice() {
		//TODO where the customer is registered, send invoice 
		finishOrder();
	}
	
	/**
	 * @return boolean of finished
	 */
	public boolean isFinished() {
		return finished;
	}
	
	/**
	 * Disposes the window
	 */
	private void cancel() {
		dispose();
	}
}
