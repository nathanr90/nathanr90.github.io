package ContactService;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	private Map<String, Contact> contacts;

    //creates contacts hash map
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    //add contact and tests uniqueness
    public void addContact(Contact contact) {
    	if (contacts.get(contact.getContactId()) != null) {
    		throw new IllegalArgumentException("Non-unique ID");
    	}
        contacts.put(contact.getContactId(), contact);
    }

    //delete contact
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    //update contact based on id
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact != null) {
            if (firstName != null) {
                contact.setFirstName(firstName);
            }
            if (lastName != null) {
                contact.setLastName(lastName);
            }
            if (phone != null) {
                contact.setPhone(phone);
            }
            if (address != null) {
                contact.setAddress(address);
            }
        }
    }

    //get contact for tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
