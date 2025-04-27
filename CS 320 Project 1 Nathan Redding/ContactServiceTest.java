package test;

import org.junit.Test;
import static org.junit.Assert.*;
import ContactService.Contact;
import ContactService.ContactService;
import org.junit.jupiter.api.Assertions;

public class ContactServiceTest {

	//tests add contact
    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "2", "3", "1234567890", "4");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1"));
    }
    
    //tests unique id
    @Test
    public void testUniqueId() {
    	ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "2", "3", "1234567890", "4");
        contactService.addContact(contact);
        Contact contact2 = new Contact("1", "3", "4", "2345678901", "5");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	contactService.addContact(contact2);
        });
    }

    //tests delete
    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "2", "3", "1234567890", "4");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        assertNull(contactService.getContact("1"));
    }

    //tests update
    @Test
    public void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "2", "3", "1234567890", "4");
        contactService.addContact(contact);
        contactService.updateContact("1", "3", "4", "9876543210", "5");
        Contact updatedContact = contactService.getContact("1");
        assertEquals("3", updatedContact.getFirstName());
        assertEquals("4", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("5", updatedContact.getAddress());
    }
}