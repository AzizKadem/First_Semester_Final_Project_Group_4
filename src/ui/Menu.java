package ui;

import java.util.ArrayList;

public abstract class Menu {
	private ArrayList<String> options;
	private TextInput input;
	private boolean exit;

	/**
	 * Create menu
	 * @param exitOption The name of the option to exit the menu
	 */
	public Menu(String exitOption) {
		options = new ArrayList<>();
		options.add(exitOption);
		
		input = new TextInput();
		exit = false;
	}

	/**
	 * Pring all options in the menu
	 */
	public void printOptions() {
		for (int i = 0; i < options.size(); i++) {
			System.out.println("(" + i + ") " + options.get(i));
		}
	}

	/**
	 * Add an option to the menu
	 * @param option The name of the new option
	 */
	public void addOption(String option) {
		options.add(option);
	}

	/**
	 * Select an option from the menu
	 * @return Selected index of an option
	 */
	public int selectOption() {
		printOptions();
		int selected = input.inputInt("Enter number");
		return selected;
	}
	
	/**
	 * Start the menu mainloop
	 */
	public void start() {
		while (!exit) {
			handleMenu();
		}
	}
	
	/**
	 * Abstract method for handling the menu options
	 */
	public abstract void handleMenu();
	

	/**
	 * Get exit.
	 *
	 * @return exit as boolean.
	 */
	public boolean isExit() {
	    return exit;
	}

	/**
	 * Set exit.
	 *
	 * @param exit the value to set.
	 */
	public void setExit(boolean exit) {
	    this.exit = exit;
	}
}
