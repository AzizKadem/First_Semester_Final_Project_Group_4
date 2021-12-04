package ui;

import model.*;

public class Main {
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();

		CustomerCont.getInstance().addCustommer(new Customer("Bob", 
					"123", "Home", "ThisCity", "0", 2));

		ProductCont.getInstance().addProduct(new Product("Hammer",
					new Price("Today", 50), 40, "Tools", "0304"));


		menu.start();
	}
}
