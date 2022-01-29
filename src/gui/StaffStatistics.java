package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.StaffCtrl;
import model.Staff;

public class StaffStatistics extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private StaffCtrl staffCtrl;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StaffStatistics dialog = new StaffStatistics();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StaffStatistics() {
		staffCtrl = new StaffCtrl();
		
		setTitle("Staff Statistics");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setDefaultEditor(Object.class, null);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Back");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						back();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		updateTable();
	}
	
	/**
	 * Disposes the window
	 */
	private void back() {
		dispose();
	}

	/**
	 * Initializes the table
	 */
	private void updateTable() {
		DefaultTableModel myTableModel = new DefaultTableModel();
		
		List<Staff> list =staffCtrl.getStaffList();
		
		myTableModel.addColumn("Name");
		myTableModel.addColumn("ID");
		myTableModel.addColumn("Revenue");
		
		for (Staff element : list) {
			myTableModel.addRow(new Object[] {element.getName(), element.getWorkerID(),
					CurrencyHandler.convertToString(element.getTotal())});
		}
		
		table.setModel(myTableModel);
	}
}
