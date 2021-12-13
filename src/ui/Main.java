package ui;

import model.*;

public class Main {
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		
		CustomerCont.getInstance().addCustommer(new Customer("Bob", 
					"123", "Home", "ThisCity", "0"));
		
		Item item1 = new Item("Wrench", new Price(new Date(), 50), 40, "Tools", "1");
		
		ProductCont.getInstance().addProduct(item1);
		
		Item item2 = new Item("Hammer", new Price(new Date(), 50), 40, "Tools", "2");

		ProductCont.getInstance().addProduct(item2);
		
		Appliance appliance = new Appliance("Fridge", 
									new Price(new Date(), 200), 1,
									1, 2, "Super Fridge");
		
		ApplianceCopy appCopy = new ApplianceCopy("Yellow", "new", "3", 10);
		
		appliance.addCopy(appCopy);
		
		ProductCont.getInstance().addProduct(appliance);
		
		MachineCont.getInstance().addMachine(new Machine(1, "Vacum"));
		
		Packages package1 = new Packages("Fridge and wrench package", "4", new Price(new Date(), 400));
		
		Packages package2 = new Packages("Package in package", "5", new Price(new Date(), 800));
		
		PackageLine line1 = new PackageLine(item1, 5);
		
		PackageLine line2 = new PackageLine(appliance, 1, appCopy);
		
		PackageLine line3 = new PackageLine(item2, 2);
		
		PackageLine line4 = new PackageLine(package2, 2);
		
		package1.add(line1);
		package1.add(line2);
		
		package2.add(line3);
		package2.add(line4);
		
		ProductCont.getInstance().addProduct(package1);
		ProductCont.getInstance().addProduct(package2);

		menu.start();
		
		for (Order order : OrderCont.getInstance().getOrders()) {
			System.out.println("Customer: " + order.getACustomer().getName());
			System.out.println("Paid: " + order.getPrice());
			System.out.println("ID: " + order.getID());
		}
	}
}
