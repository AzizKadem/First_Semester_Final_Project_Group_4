package ui;

import java.util.Scanner;

public class TextInput {
	public TextInput() {

	}

	/**
	 * Input string
	 * @param question Question for the user
	 * @return Inputed string
	 */
	public String intupString(String question) {
		printQuestion(question);
		Scanner scanner = new Scanner(System.in);

		String line = scanner.nextLine();
		scanner.close();

		return line;

	}

	/**
	 * Input integer
	 * @param question Question for the user
	 * @return Inputed integer
	 */
	public int inputInt(String question) {
		printQuestion(question);

		Scanner scanner = new Scanner(System.in);
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("Invalid input, please enter a number.");
		}
		
		int number = scanner.nextInt();
		
		return number;
	}

	/**
	 * Print question
	 * @param question The question that will be printed
	 */
	public void printQuestion(String question) {
		System.out.println(question + ": ");
	} 

}
