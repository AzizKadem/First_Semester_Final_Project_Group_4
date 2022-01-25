package ui;

import model.Appliance;
import model.ApplianceCopy;
import model.Customer;
import model.CustomerCont;
import model.Date;
import model.Item;
import model.Machine;
import model.MachineCont;
import model.Order;
import model.OrderCont;
import model.PackageLine;
import model.Packages;
import model.Price;
import model.ProductCont;

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
		
		Packages package3 = new Packages("Package in package in package", "6", new Price(new Date(), 1500));
		
		Packages package4 = new Packages("Packageception", "7", new Price(new Date(), 3000));
		
		PackageLine line1 = new PackageLine(item1, 5);
		
		PackageLine line2 = new PackageLine(appliance, 1, appCopy);
		
		PackageLine line3 = new PackageLine(item2, 2);
		
		PackageLine line4 = new PackageLine(package1, 2);
		
		PackageLine line5 = new PackageLine(package2, 2);

		PackageLine line6 = new PackageLine(package3, 1);
		
		package1.add(line1);
		package1.add(line2);
		
		package2.add(line4);
		package2.add(line3);
		
		package3.add(line5);
		package3.add(line2);
		
		package4.add(line6);
		package4.add(line1);
		
		ProductCont.getInstance().addProduct(package1);
		ProductCont.getInstance().addProduct(package2);
		ProductCont.getInstance().addProduct(package3);	
		ProductCont.getInstance().addProduct(package4);			

		menu.start();
		
		for (Order order : OrderCont.getInstance().getOrders()) {
			System.out.println("Customer: " + order.getACustomer().getName());
			System.out.println("Paid: " + order.getPrice());
			System.out.println("ID: " + order.getID());
		}
	}
}
