package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.StaffCtrl;
import model.Product;

public class ProductStatistics extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private StaffCtrl staffCtrl = new StaffCtrl();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProductStatistics dialog = new ProductStatistics();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProductStatistics() {
		setModal(true);
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
				JLabel lblNewLabel = new JLabel("Product Statistics");
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
			
			List<Product> list =staffCtrl.generateProductStatistics();
			
			myTableModel.addColumn("Name");
			myTableModel.addColumn("Stock");
			myTableModel.addColumn("Sold");
			
			for (Product element : list) {
				myTableModel.addRow(new Object[] {element.getName(), element.getStock(),
						element.getNumberOfOrders()});
			}
			
			table.setModel(myTableModel);
	}
}
