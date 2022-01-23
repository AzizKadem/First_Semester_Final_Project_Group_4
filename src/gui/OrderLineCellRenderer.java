package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.OrderLine;
import model.Product;



public class OrderLineCellRenderer implements ListCellRenderer<OrderLine> {

	@Override
	public Component getListCellRendererComponent(JList<? extends OrderLine> list, OrderLine value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		
		String orderLine = value.getAProduct().getName() + ", Quantity: "
		    + value.getQuantity() + ", Price: " + value.getSubTotal();
		
		
		return dlcr.getListCellRendererComponent(list, orderLine, index, isSelected, cellHasFocus);
	}
}
