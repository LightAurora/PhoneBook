import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PhoneBook {
	public ArrayList<Contact> contacts;
	
	//Standard Constructor
	public PhoneBook() {
		contacts = new ArrayList<>();
	}
	
	/* Constructor through File
	 * Creating phone book through file given
	 * @param file, file given to process information
	 * Reads the file and takes all the info and makes contacts out of them
	 */
	public PhoneBook(File file) {
		contacts = new ArrayList<>();
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("File Was Not Found");
		}
		

		String line;
		String[] info;
		while (fileReader.hasNextLine()) {
			line = fileReader.nextLine();
			info = line.split(",");
			
			String firstName, lastName, emailAddress;
			long homeNumber, officeNumber;
			
			firstName = info[0];
			lastName = info[1];
			homeNumber = Long.parseLong(info[2]);
			officeNumber = Long.parseLong(info[3]);
			emailAddress = info[4];
			add(new Contact(firstName,lastName,homeNumber,officeNumber,emailAddress));
			
			
		}

	}
	
	public void add (Contact c) {
		contacts.add(c);
	}
	
	/* toString method
	 * Makes nice columns for each element
	 * 
	 */
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s\n","First Name:","Last Name:","HomeNumber","Office Number","Email Address")+contacts.toString();
	}
	/* Sorting mechanism for First Names
	 * Bubble Sort
	 */
	public void bubbleSort() {
		for (int i = 0; i < contacts.size(); i++) {
			for (int j = i + 1; j < contacts.size(); j++) {
				if (contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName()) < 0) {
					Collections.swap(contacts, i, j);
				}
			}
		}
	}
	/* Sorting mechanism for Last Names
	 *  Selection Sorting
	 */
	public void selectionSort() {
		for (int i = 0; i < contacts.size(); i++) {
			Contact minimum = contacts.get(i);
			int min = i;
			for (int j = i+1; j < contacts.size(); j++) {
				String value = contacts.get(j).getLastName();
				if (value.compareTo(minimum.getLastName()) > 0) {
					min = j;
				}
			}
			if (min != i) {
				Collections.swap(contacts, min, i);
			}
		}
	}
	
	/* Search mechanism for Last Names
	 * Binary Search
	 * @param lastName, given last name to search for
	 */
	public boolean binarySearch(String lastName) {
		if (this.contacts.size() >= 0) {
			if (this.contacts.size() > 14) {
				this.selectionSort();
			}
			int min = 0, max = contacts.size()-1;
			
			while (min <= max) {
				int middle = (min + max)/2, current = lastName.compareToIgnoreCase(String.valueOf(contacts.get(middle).getLastName()));
				
				if (current == 0) {
					System.out.println(contacts.get(middle).toString());
					return true;
				} else if (current < 0) {
					max = middle -1;
				} else {
					min = middle +1;
				}
			}
		}
		return false;
	}
}
