package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.OrderCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.EmptyOrderException;
import exceptions.NotEnoughInStockException;
import exceptions.ProductNotFoundException;
import exceptions.QuantityUnderrunException;
import model.OrderLine;
import javax.swing.SwingConstants;

public class CreateOrder extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320032285602649611L;
	
	private final JPanel contentPanel = new JPanel();
	private JPanel selectCustomerMethodPanel;
	private JPanel phoneNumberPanel;
	private JPanel selectProductsPanel;
	private JPanel previousPanel;
	
	private boolean created;

	private OrderCtrl orderCtrl;
	
	private JLabel lblErrorMessage;
	private JTextField phoneField;
	private JButton btnConfirm;
	private JTextField textBarcode;
	private JButton btnFinishOrder;
	private JSpinner spinnerQuantity;
	private JList<OrderLine> list;
	private JLabel lblTotalPrice;
	private JLabel lblErrorButton;
	
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
		//contentPanel.add(selectProductsPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * Initialise gui
	 */
	private void initGui() {
		setModal(true);
		setBounds(100, 100, 600, 400);
		
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
			selectProductsPanel = new JPanel();
			selectProductsPanel.setLayout(new BorderLayout(0, 0));
			{
				JSplitPane splitPane = new JSplitPane();
				splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPane.setContinuousLayout(true);
				splitPane.setDividerSize(2);
				selectProductsPanel.add(splitPane);
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
						textBarcode = new JTextField();
						textBarcode.setColumns(10);
						addProductPanel.add(textBarcode);
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
						SpinnerModel sm = new SpinnerNumberModel(1, 1, null, 1);
						spinnerQuantity = new JSpinner(sm);
						spinnerQuantity.setValue(Integer.valueOf(1));
						addProductPanel.add(spinnerQuantity);
					}
					{
						Component horizontalStrut = Box.createHorizontalStrut(20);
						addProductPanel.add(horizontalStrut);
					}
					{
						JButton btnAddProduct = new JButton("Add Product");
						btnAddProduct.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addProduct();
							}
						});
						addProductPanel.add(btnAddProduct);
					}
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					splitPane.setRightComponent(scrollPane);
					{
						list = new JList<OrderLine>();
						scrollPane.setViewportView(list);
					}
				}
			}
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(ColorScheme.TAB);
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			buttonPanel.setLayout(new BorderLayout(0, 0));
			{
				{
				}
			}
			{
				JPanel rightButtonPanel = new JPanel();
				rightButtonPanel.setBackground(ColorScheme.TAB);
				FlowLayout fl_rightButtonPanel = (FlowLayout) rightButtonPanel.getLayout();
				fl_rightButtonPanel.setAlignment(FlowLayout.LEFT);
				buttonPanel.add(rightButtonPanel, BorderLayout.EAST);
				{
					lblErrorButton = new JLabel("");
					rightButtonPanel.add(lblErrorButton);
					lblErrorButton.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				btnFinishOrder = new JButton("Finish Order");
				rightButtonPanel.add(btnFinishOrder);
				btnFinishOrder.setHorizontalAlignment(SwingConstants.RIGHT);
				btnConfirm = new JButton("Confirm");
				rightButtonPanel.add(btnConfirm);
				btnConfirm.setHorizontalAlignment(SwingConstants.RIGHT);
				{
					JButton btnCancel = new JButton("Cancel");
					rightButtonPanel.add(btnCancel);
					btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
					btnCancel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cancel();
						}
					});
					btnCancel.setActionCommand("Cancel");
				}
				{
					JPanel leftButtonPanel = new JPanel();
					leftButtonPanel.setBackground(ColorScheme.TAB);
					buttonPanel.add(leftButtonPanel, BorderLayout.WEST);
					{
						JButton btnBack = new JButton("Back");
						btnBack.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								back();
							}
						});
						leftButtonPanel.add(btnBack);
						btnBack.setHorizontalAlignment(SwingConstants.LEFT);
					}
				}
				btnConfirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkPhoneNumber();
					}
				});
				btnConfirm.setVisible(false);
				btnFinishOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						finishOrder();
					}
				});
				btnFinishOrder.setVisible(false);
			}
		}
		{
			lblTotalPrice = new JLabel("Total: 0");
			lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			selectProductsPanel.add(lblTotalPrice, BorderLayout.SOUTH);
		}
		
		contentPanel.setLayout(new BorderLayout(0, 0));
	}

	public void selectExistingCustomer() {
		previousPanel = selectCustomerMethodPanel;
		contentPanel.remove(selectCustomerMethodPanel);
		contentPanel.add(phoneNumberPanel);
		
		FlowLayout flowLayout = (FlowLayout) phoneNumberPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		btnConfirm.setVisible(true);
	}
	
	public void showProductScreen() {
		previousPanel = phoneNumberPanel;
		contentPanel.remove(phoneNumberPanel);
		contentPanel.add(selectProductsPanel);

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
	
	private void addProduct() {
		try {
			orderCtrl.createOrderline(textBarcode.getText(), (int)spinnerQuantity.getValue());
			removeErrorBorder();
			updateList();
			lblTotalPrice.setText("Total: " + orderCtrl.getCurrentOrder().getTotalPrice());
			
			
		} catch (QuantityUnderrunException que) {
			spinnerQuantity.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
			
		} catch (ProductNotFoundException pnfe) {
			textBarcode.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
			
		} catch (NotEnoughInStockException neise) {
			spinnerQuantity.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
		}
	}
	
	private void removeErrorBorder() {
		spinnerQuantity.setBorder(new LineBorder(Color.BLACK, 1));
		textBarcode.setBorder(new LineBorder(Color.BLACK, 1));
		lblErrorButton.setText("");
	}
	
	private void updateList() {
		DefaultListModel<OrderLine> myListModel = new DefaultListModel<>();
		
		List<OrderLine> lists = orderCtrl.getCurrentOrder().getOrderLines();
		
		for (OrderLine element : lists) {
			myListModel.addElement(element);
		}
		
		list.setCellRenderer(new OrderLineCellRenderer());
		list.setModel(myListModel);
	}
	
	private void finishOrder() {
		if (!orderCtrl.isEmpty()) {
			OrderReceipt dialog = new OrderReceipt(orderCtrl);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} 
		else {
			lblErrorButton.setText(new EmptyOrderException().getMessage());
		}
	}
	
	private void back() {
		dispose();
		contentPanel.add(previousPanel);
	}
	
	private void cancel() {
		dispose();
	}
}
