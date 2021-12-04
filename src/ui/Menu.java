package ui;

import java.util.ArrayList;

public abstract class Menu {
	private ArrayList<String> options;
	private TextInput input;
	private boolean exit;

	public Menu(String exitOption) {
		options = new ArrayList<>();
		options.add(exitOption);
		
		input = new TextInput();
		exit = false;
	}

	public void printOptions() {
		for (int i = 0; i < options.size(); i++) {
			System.out.println("(" + i + ") " + options.get(i));
		}
	}

	public void addOption(String option) {
		options.add(option);
	}

	public int selectOption() {
		printOptions();
		int selected = input.inputInt("Enter number");
		return selected;
	}
	
	public void start() {
		while (!exit) {
			handleMenu();
		}
	}
	
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
