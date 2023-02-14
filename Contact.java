
public class Contact {
	private String firstName;
	private String lastName;
	private long homeNumber;
	private long officeNumber;
	private String emailAddress;
	
	/* Contact Constructor
	 * @param firstName,LastName,homeNumber,officeNumber,email Address
	 * Given the information and makes a contact object with it
	 */
	public Contact (String firstName, String lastName, long homeNumber, long officeNumber, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeNumber = homeNumber;
		this.officeNumber = officeNumber;
		this.emailAddress = emailAddress;
	}
	
	// Getters
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Long getHomeNumber() {
		return homeNumber;
	}
	public long getOfficeNumber() {
		return officeNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	
	/* Setters
	 * @param is their element
	 */
	public void setFirstName(String firstName ) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName ) {
		this.lastName = lastName;
	}
	public void setHomeNumber(long homeNumber ) {
		this.homeNumber = homeNumber;
	}
	public void setOfficeNumber(long officeNumber ) {
		this.officeNumber = officeNumber;
	}
	public void setEmailAddress(String emailAddress ) {
		this.emailAddress = emailAddress;
	}
	
	/*toString method
	 * Makes nice columns for the information
	 */
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s\n", firstName, lastName, homeNumber, officeNumber, emailAddress); 
	}

}
