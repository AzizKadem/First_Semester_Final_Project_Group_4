package ui;

public class MainMenu extends Menu {
	public MainMenu() {
		super("Exit");
		super.addOption("Customer Menu");
		super.addOption("Order Menu");
		super.addOption("Product Menu");
		super.addOption("Staff Menu");
		super.addOption("Department Menu");
		super.addOption("Lease Menu");
	}

	/**
	 * Handle options in the main menu
	 */
	@Override
	public void handleMenu() {
		int selected = super.selectOption();
		
		switch (selected) {
			case 0:
				super.setExit(!isExit());
				break;
			case 1:
				CustomerMenu customerMenu = new CustomerMenu();
				System.out.println("Customer Menu");
				//customerMenu.start();
				break;
			case 2:
				OrderMenu orderMenu = new OrderMenu();
				System.out.println("Order Menu");
				orderMenu.start();
				break;
			case 3:
				ProductMenu productMenu = new ProductMenu();
				System.out.println("Product Menu");
				//productMenu.start();
				break;
			case 4:
				StaffMenu staffMenu = new StaffMenu();
				System.out.println("Staff Menu");
				//staffMenu.start();
				break;
			case 5:
				DepartmentMenu departmentMenu = new DepartmentMenu();
				System.out.println("Department Menu");
				//departmentMenu.start();
				break;
			case 6:
				LeaseMenu leaseMenu = new LeaseMenu();
				System.out.println("Lease Menu");
				leaseMenu.start();
				break;
		}
	}
}
