package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.OrderCtrl;
import exceptions.CustomerNotFoundException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;

public class CreateOrder extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320032285602649611L;
	
	private final JPanel contentPanel = new JPanel();
	private JPanel selectCustomerMethodPanel;
	private JPanel phoneNumberPanel;
	private JPanel selectProducts;
	
	private boolean created;

	private OrderCtrl orderCtrl;
	
	private JLabel lblErrorMessage;
	private JTextField phoneField;
	private JButton btnConfirm;
	private JTextField textField;
	private JButton btnFinishOrder;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerateData.generateData();
			CreateOrder dialog = new CreateOrder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrder() {
		setTitle("Create Order");
		orderCtrl = new OrderCtrl();
		
		initGui();
		contentPanel.add(selectCustomerMethodPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Initialise gui
	 */
	private void initGui() {
		setModal(true);
		setBounds(100, 100, 600, 500);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			phoneNumberPanel = new JPanel();
			phoneNumberPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				Box verticalBox = Box.createVerticalBox();
				phoneNumberPanel.add(verticalBox);
				{
					JLabel lblEnterPhone = new JLabel("Enter phone number");
					lblEnterPhone.setAlignmentX(0.1f);
					verticalBox.add(lblEnterPhone);
				}
				{
					Component verticalStrut = Box.createVerticalStrut(20);
					verticalBox.add(verticalStrut);
				}
				{
					phoneField = new JTextField();
					phoneField.setAlignmentX(0.0f);
					verticalBox.add(phoneField);
					phoneField.setColumns(10);
				}
				{
					lblErrorMessage = new JLabel(" ");
					verticalBox.add(lblErrorMessage);
				}
			}
		}
		{
			selectCustomerMethodPanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) selectCustomerMethodPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			{
				Box verticalBox = Box.createVerticalBox();
				selectCustomerMethodPanel.add(verticalBox);
				{
					JButton btnNewButton = new JButton("Existing customer ");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							selectExistingCustomer();
						}
					});
					{
						JLabel lblFindBy = new JLabel("Find customer");
						lblFindBy.setAlignmentX(0.1f);
						verticalBox.add(lblFindBy);
					}
					{
						Component verticalStrut = Box.createVerticalStrut(20);
						verticalBox.add(verticalStrut);
					}
					verticalBox.add(btnNewButton);
				}
				{
					Component verticalStrut = Box.createVerticalStrut(10);
					verticalBox.add(verticalStrut);
				}
				{
					JButton btnNewButton_1 = new JButton("New customer");
					verticalBox.add(btnNewButton_1);
				}
				{
					Component verticalStrut = Box.createVerticalStrut(10);
					verticalBox.add(verticalStrut);
				}
				{
					JButton btnNewButton_2 = new JButton("Continue as guest");
					verticalBox.add(btnNewButton_2);
				}
			}
		}
		{
			selectProducts = new JPanel();
			selectProducts.setLayout(new GridLayout(0, 1, 0, 0));
			{
				JSplitPane splitPane = new JSplitPane();
				splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				selectProducts.add(splitPane);
				{
					JPanel addProductPanel = new JPanel();
					splitPane.setLeftComponent(addProductPanel);
					FlowLayout fl_addProductPanel = new FlowLayout(FlowLayout.CENTER, 5, 5);
					fl_addProductPanel.setAlignOnBaseline(true);
					addProductPanel.setLayout(fl_addProductPanel);
					{
						JLabel lblEnterBarcode = new JLabel("Enter product barcode");
						addProductPanel.add(lblEnterBarcode);
					}
					{
						textField = new JTextField();
						textField.setColumns(10);
						addProductPanel.add(textField);
					}
					{
						Component horizontalStrut = Box.createHorizontalStrut(20);
						addProductPanel.add(horizontalStrut);
					}
					{
						JLabel lblQuantity = new JLabel("Quantity");
						addProductPanel.add(lblQuantity);
					}
					{
						JSpinner spinner = new JSpinner();
						addProductPanel.add(spinner);
					}
					{
						Component horizontalStrut = Box.createHorizontalStrut(20);
						addProductPanel.add(horizontalStrut);
					}
					{
						JButton btnAddProduct = new JButton("AddProduct");
						addProductPanel.add(btnAddProduct);
					}
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					splitPane.setRightComponent(scrollPane);
					{
						JList list = new JList();
						scrollPane.setViewportView(list);
					}
				}
			}
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				btnConfirm = new JButton("Confirm");
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkPhoneNumber();
					}
				});
				{
					btnFinishOrder = new JButton("FinishOrder");
					btnFinishOrder.setVisible(false);
					buttonPanel.add(btnFinishOrder);
				}
				buttonPanel.add(btnConfirm);
				btnConfirm.setVisible(false);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancel();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPanel.add(btnCancel);
			}
		}
		
		contentPanel.setLayout(new BorderLayout(0, 0));
	}

	public void selectExistingCustomer() {
		contentPanel.remove(selectCustomerMethodPanel);
		contentPanel.add(phoneNumberPanel);
		
		FlowLayout flowLayout = (FlowLayout) phoneNumberPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		btnConfirm.setVisible(true);
	}
	
	public void showProductScreen() {
		contentPanel.remove(phoneNumberPanel);
		contentPanel.add(selectProducts);

		btnConfirm.setVisible(false);
		btnFinishOrder.setVisible(true);
	}
	
	private void checkPhoneNumber() {
		String phone =  phoneField.getText();
		try {
			if(orderCtrl.createOrder(phone)) {
				showProductScreen();
			}

		} catch (CustomerNotFoundException e) {
			lblErrorMessage.setText(e.getMessage());
		}
	}
	
	private void cancel() {
		dispose();
	}
}
