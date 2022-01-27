package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Customer;

public class StatisticsCellRenderer implements ListCellRenderer<Customer> {
	
	private DefaultListCellRenderer dlcr;

	@Override
	public Component getListCellRendererComponent(JList<? extends Customer> list, Customer value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		dlcr = new DefaultListCellRenderer();
		String line = value.getName() + "     " + value.getPhoneNumber() + "     " + value.getNumberOfOrders();
		return dlcr.getListCellRendererComponent(list, line, index, isSelected, cellHasFocus);
	}

}
