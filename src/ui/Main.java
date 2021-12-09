package ui;

import model.*;

public class Main {
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		
		CustomerCont.getInstance().addCustommer(new Customer("Bob", 
					"123", "Home", "ThisCity", "0", 2));
		
		ProductCont.getInstance().addProduct(new Product("Wrench",
				new Price("Today", 50), 40, "Tools", "1"));


		ProductCont.getInstance().addProduct(new Product("Hammer",
					new Price("Today", 50), 40, "Tools", "2"));
		
		MachineCont.getInstance().addMachine(new Machine(1,"Vacum"));


		menu.start();
	}
}
