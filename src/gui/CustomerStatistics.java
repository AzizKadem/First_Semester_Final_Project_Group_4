package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.StaffCtrl;
import model.Customer;
import model.Staff;

import javax.swing.JTable;

public class CustomerStatistics extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private StaffCtrl staffCtrl;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerStatistics dialog = new CustomerStatistics(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerStatistics(StaffCtrl staffCtrl) {
		setModal(true);
		this.staffCtrl = staffCtrl;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Customer Statistics");
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setBackground(ColorScheme.BACKGROUND);
				table.setDefaultEditor(Object.class, null);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton backButton = new JButton("Back");
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				backButton.setActionCommand("Cancel");
				buttonPane.add(backButton);
			}
		}
		initializeTable();
	}

	private void close() {
		dispose();
	}	
	
	private void initializeTable() {
			DefaultTableModel myTableModel = new DefaultTableModel();
			
			List<Customer> list =staffCtrl.generateCustomerStatistics();
			
			myTableModel.addColumn("Name");
			myTableModel.addColumn("Phone number");
			myTableModel.addColumn("Number of orders");
			
			for (Customer element : list) {
				myTableModel.addRow(new Object[] {element.getName(), element.getPhoneNumber(),
						element.getNumberOfOrders()});
			}
			
			table.setModel(myTableModel);
	}
}