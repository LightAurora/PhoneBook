import java.io.File;
import java.util.Scanner;

public class PhoneDriver {
	private static PhoneBook phoneBook;
	private static File details;
	private static String menu;
	private static Scanner scan;
	
	/* Main Driver
	 * Prints menu for use to interact with
	 */
	 
	public static void main(String[] args) {
		phoneBook = new PhoneBook(details = new File("ContactDetails -1.txt"));
		
		menu = "Phone Book Menu:\nP: Print Phonebook\nB: Sort Phonebook By First Name\nL: Sort Phonebook By Last Name\n"
				+ "S: Search Contact By Last Name\nA: Add Contact to Phonebook\nQ: Quit\n";
		
		
		
		
		
		scan = new Scanner(System.in);
		String choice = null;
		boolean run = true;
		
		// Interactive Menu
		while (run) {
			System.out.println(menu);
			System.out.println("Pick One Of the Options Above: ");
			choice = scan.nextLine().toUpperCase();
			
			switch (choice){
				
			case "P":
				print();
				break;
			case "B":
				System.out.println("Sorting By First Name");
				phoneBook.bubbleSort();
				break;
			case "L":
				System.out.println("Sorting By Last Name");
				phoneBook.selectionSort();
				break;
			case "S":
				search();
				break;
			case "A":
				add();
				break;
			case "Q":
				run = false;
				break;
			default:
				System.out.println("\nIncorrect Input, Please Try Again\n");
				break;
			}
		}
		System.out.println("See You Again Soon");
	}
	
	//Prints the phonebook
	public static void print() {
		System.out.println(phoneBook.toString());
	}
	
	//Search through phone book for Last Name 
	public static void search() {
		scan = new Scanner(System.in);
		System.out.println("Please enter Last Name");
		String userInput = scan.nextLine();
		if (phoneBook.binarySearch(userInput) == true) {
			System.out.println("The user: " + userInput + " does exist in the phone book");
		} else {
			System.out.println("Could not find a " + userInput);
		}
		
	}
	
	/* Adds people info into phone book
	 * Users are given Step by Step info on which information to jot down
	 */
	public static void add() {
		scan = new Scanner(System.in);
		System.out.println("Please enter First Name");
		String firstName = scan.nextLine();
		System.out.println("Please enter Last Name");
		String lastName = scan.nextLine();
		System.out.println("Please enter Home Number");
		Long homeNumber = scan.nextLong();
		System.out.println("Please enter Office Number");
		Long officeNumber = scan.nextLong();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter Email Address");
		String emailAddress = input.nextLine();
		
		phoneBook.add(new Contact(firstName,lastName,homeNumber,officeNumber,emailAddress));
	}

}
