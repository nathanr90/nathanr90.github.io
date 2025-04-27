package ContactService;

public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	//constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		//length/null tests
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	//id get
	public String getContactId() {
		return contactId;
	}
	
	//first name get and set
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
	    this.firstName = firstName;
	}

	//last name get and set
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.lastName = lastName;
	}

	//phone number get and set
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phone = phone;
	}

	//address get and set
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}

