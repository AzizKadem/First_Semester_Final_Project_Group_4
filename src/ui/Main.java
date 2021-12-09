package ui;

import model.*;

public class Main {
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		
		CustomerCont.getInstance().addCustommer(new Customer("Bob", 
					"123", "Home", "ThisCity", "0"));
		
		ProductCont.getInstance().addProduct(new Item("Wrench",
				new Price(new Date(), 50), 40, "Tools", "1"));


		ProductCont.getInstance().addProduct(new Item("Hammer",
					new Price(new Date(), 50), 40, "Tools", "2"));
		
		MachineCont.getInstance().addMachine(new Machine(1,"Vacum"));


		menu.start();
		
		for (Order order : OrderCont.getInstance().getOrders()) {
			System.out.println("Customer" + order.getACustomer().getName());
			System.out.println("Paid" + order.getPrice());
		}
	}
}
