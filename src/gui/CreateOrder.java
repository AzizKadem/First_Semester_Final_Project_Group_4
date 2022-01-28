package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.OrderCtrl;
import exceptions.CustomerNotFoundException;
import exceptions.EmptyOrderException;
import exceptions.NotEnoughInStockException;
import exceptions.ProductNotFoundException;
import exceptions.QuantityUnderrunException;
import model.OrderLine;

public class CreateOrder extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320032285602649611L;
	
	private final JPanel contentPanel = new JPanel();
	private JPanel selectCustomerMethodPanel;
	private JPanel phoneNumberPanel;
	private JPanel selectProductsPanel;

	private OrderCtrl orderCtrl;
	private boolean created;
	private ArrayList<JPanel> backPath;
	private JPanel currentPanel;
	
	private JTextField phoneField;
	private JButton btnConfirm;
	private JTextField textBarcode;
	private JButton btnFinishOrder;
	private JSpinner spinnerQuantity;
	private JTable table;
	private JLabel lblTotalPrice;
	private JLabel lblErrorButton;
	private JButton btnBack;
	
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
		backPath = new ArrayList<>();
		
		initGui();
		showPanel(selectCustomerMethodPanel);
		//contentPanel.add(selectCustomerMethodPanel, BorderLayout.CENTER);
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
		contentPanel.setBackground(ColorScheme.BACKGROUND);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			phoneNumberPanel = new JPanel();
			phoneNumberPanel.setBackground(ColorScheme.BACKGROUND);
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
			}
		}
		{
			selectCustomerMethodPanel = new JPanel();
			selectCustomerMethodPanel.setBackground(ColorScheme.BACKGROUND);
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
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							randomCustomer();
						}
					});
					verticalBox.add(btnNewButton_2);
				}
			}
		}
		{
			selectProductsPanel = new JPanel();
			selectProductsPanel.setBackground(ColorScheme.BACKGROUND);
			selectProductsPanel.setLayout(new BorderLayout(0, 0));
			{
				JSplitPane splitPane = new JSplitPane();
				splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				splitPane.setContinuousLayout(true);
				splitPane.setDividerSize(2);
				selectProductsPanel.add(splitPane);
				{
					JPanel addProductPanel = new JPanel();
					addProductPanel.setBackground(ColorScheme.BACKGROUND);
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
					scrollPane.setBackground(ColorScheme.BACKGROUND);
					splitPane.setRightComponent(scrollPane);
					{
						table = new JTable();
						table.setBackground(ColorScheme.BACKGROUND);
						table.setDefaultEditor(Object.class, null);
						scrollPane.setViewportView(table);
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
				JPanel leftButtonPanel = new JPanel();
				leftButtonPanel.setBackground(ColorScheme.TAB);
				buttonPanel.add(leftButtonPanel, BorderLayout.WEST);
				{
					btnBack = new JButton("Back");
					btnBack.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							back();
						}
					});
					leftButtonPanel.add(btnBack);
					btnBack.setHorizontalAlignment(SwingConstants.LEFT);
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
					lblErrorButton.setForeground(ColorScheme.BACKGROUND);
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
				btnBack.setVisible(false);
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
		showPanel(phoneNumberPanel);
		FlowLayout flowLayout = (FlowLayout) phoneNumberPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
	}
	
	public void showProductScreen() {
		showPanel(selectProductsPanel);
	}
	
	private void checkPhoneNumber() {
		String phone =  phoneField.getText();
		try {
			if(orderCtrl.createOrder(phone)) {
				showProductScreen();
				removeErrorMessage();
			}

		} catch (CustomerNotFoundException e) {
			lblErrorButton.setText(e.getMessage());
			phoneField.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT));
		}
	}
	
	private void addProduct() {
		try {
			orderCtrl.createOrderline(textBarcode.getText(), (int)spinnerQuantity.getValue());
			removeErrorMessage();
			updateList();
			lblTotalPrice.setText("Total: " + CurrencyHandler.convertToString(orderCtrl.getTotal()));
			textBarcode.setText("");
			spinnerQuantity.setValue(1);
			
		} catch (QuantityUnderrunException que) {
			spinnerQuantity.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
			lblErrorButton.setText(que.getMessage());
			
		} catch (ProductNotFoundException pnfe) {
			textBarcode.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
			lblErrorButton.setText(pnfe.getMessage());
			
		} catch (NotEnoughInStockException neise) {
			spinnerQuantity.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT, 1));
			lblErrorButton.setText(neise.getMessage());
		}
	}
	
	private void removeErrorMessage() {
		spinnerQuantity.setBorder(new LineBorder(Color.BLACK, 1));
		textBarcode.setBorder(new LineBorder(Color.BLACK, 1));
		phoneField.setBorder(new LineBorder(Color.BLACK, 1));
		lblErrorButton.setText("");
	}
	
	private void updateList() {
		DefaultTableModel myTableModel = new DefaultTableModel();
		
		List<OrderLine> lists = orderCtrl.getCurrentOrder().getOrderLines();
		
		myTableModel.addColumn("Name");
		myTableModel.addColumn("Quantity");
		myTableModel.addColumn("Price");
		
		for (OrderLine element : lists) {
			myTableModel.addRow(new Object[] {element.getAProduct().getName(),
					element.getQuantity(), CurrencyHandler.convertToString(element.getSubTotal())});
		}
		
		table.setModel(myTableModel);
	}
	
	private void finishOrder() {
		if (!orderCtrl.isEmpty()) {
			OrderReceipt dialog = new OrderReceipt(orderCtrl);
			dialog.setVisible(true);
			
			if (dialog.isFinished()) {
				created = dialog.isFinished();
				
				dispose();
			}
		} 
		else {
			lblErrorButton.setText(new EmptyOrderException().getMessage());
		}
	}
	
	private void back() {
		if (currentPanel.equals(selectProductsPanel)) {
			orderCtrl.cancelOrder();
		} else {
			if (currentPanel.equals(phoneNumberPanel)) {
				phoneField.setText("");
			}
		}
		showPanel(backPath.get(backPath.size() - 2));
		backPath.remove(backPath.size() - 1);
		handleButtons();
	}
    
    private void showPanel(JPanel panel) {
    	if (currentPanel != null) {
    		hidePanel(currentPanel);
    	}
    	
    	panel.setVisible(true);
    	contentPanel.add(panel);
    	currentPanel = panel;
    	
    	addToBackPath();
    	handleButtons();
    	
		if (currentPanel.equals(selectProductsPanel)) {
			updateList();
		}
    }
    
    private void hidePanel(JPanel panel) {
    	panel.setVisible(false);
    	contentPanel.remove(panel);
    	currentPanel = null;
    }
    
    private void handleButtons() {
    	btnFinishOrder.setVisible(false);
    	btnConfirm.setVisible(false);
    	
    	if (currentPanel.equals(selectProductsPanel)) {
    		btnFinishOrder.setVisible(!btnFinishOrder.isVisible());
    	}
    	else {
    		if (currentPanel.equals(phoneNumberPanel)) {
    			btnConfirm.setVisible(!btnConfirm.isVisible());
    		}
    	}
    	
    	if (backPath.size() <= 1) {
    		btnBack.setVisible(false);
    	} 
    	else {
    		btnBack.setVisible(true);
    	}
    }
    
	private void cancel() {
		dispose();
	}
	
	private void randomCustomer() {
		try {
			orderCtrl.createOrder("Guest");
			showPanel(selectProductsPanel);
		}
		catch (CustomerNotFoundException e) {
				lblErrorButton.setText(e.getMessage());
				phoneField.setBorder(new LineBorder(ColorScheme.BUTTON_HIGHTLIGHT));
		}
	}
	
	private void addToBackPath() {
		if (!backPath.contains(currentPanel)) {
			backPath.add(currentPanel);
		}
	}
	
	public boolean isCreated() {
		return created;
	}
}