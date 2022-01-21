import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Component;

public class CustomerLoginGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel1;
	private JPanel panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerLoginGUI dialog = new CustomerLoginGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerLoginGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			panel2 = new JPanel();
			contentPanel.add(panel2);
			
			JLabel lblNewLabel_1 = new JLabel("Enter product barcode");
			panel2.add(lblNewLabel_1);
			panel2.setVisible(false);
		}
		{
			panel1 = new JPanel();
			contentPanel.add(panel1);
			{
				Box verticalBox = Box.createVerticalBox();
				panel1.add(verticalBox);
				{
					JButton btnNewButton = new JButton("Existing customer ");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							existingCustomer();
						}
					});
					btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
					verticalBox.add(btnNewButton);
				}
				{
					Component verticalStrut = Box.createVerticalStrut(20);
					verticalBox.add(verticalStrut);
				}
				{
					JButton btnNewButton_1 = new JButton("   New customer  ");
					btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
					verticalBox.add(btnNewButton_1);
				}
				{
					Component verticalStrut = Box.createVerticalStrut(20);
					verticalBox.add(verticalStrut);
				}
				{
					JButton btnNewButton_2 = new JButton("Continue as guest");
					btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
					verticalBox.add(btnNewButton_2);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			
			JLabel lblNewLabel = new JLabel("Create Order");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel, BorderLayout.NORTH);
		}
	}
	public void existingCustomer()
	{
		panel1.setVisible(false);
		panel2.setVisible(true);
	}
}