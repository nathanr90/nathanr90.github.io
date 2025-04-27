package test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

import ContactService.Contact;

public class ContactTest {

	//tests constructor
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1", "2", "3", "1234567890", "4");
        assertNotNull(contact);
        assertEquals("1", contact.getContactId());
        assertEquals("2", contact.getFirstName());
        assertEquals("3", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("4", contact.getAddress());
    }
    
    //test id null and length
    @Test
    public void testContactIdLength () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345678910", "1", "2", "1234567890", "3");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact(null, "1", "2", "1234567890", "3");
    	});
    }
    
    //test first name null and length
    @Test
    public void testFirstName () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "12345678910", "2", "1234567890", "3");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    		contact.setFirstName("12345678910");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", null, "2", "1234567890", "3");
    	});
    }
    
    //test last name null and length
    @Test
    public void testLastNameLength () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "12345678910", "1234567890", "3");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    		contact.setLastName("12345678910");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", null, "1234567890", "3");
    	});
    }
    
    //test phone null and length
    @Test
    public void testPhone () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "3", "12345678910", "4");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "3", "123456789", "4");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    		contact.setPhone("12345678910");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    		contact.setPhone("123456789");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "3", null, "4");
    	});
    }
    
    //test address null and length
    @Test
    public void testAddress () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "3", "1234567890", "123456789 123456789 12345678910");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    		contact.setAddress("123456789 123456789 12345678910");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("1", "2", "3", "1234567890", null);
    	});
    }
    
    //test setters
    @Test
    public void testSetFName () {
    	Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    	contact.setFirstName("name");
    	assertEquals("name", contact.getFirstName());
    }
    
    @Test
    public void testSetLName () {
    	Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    	contact.setLastName("name");
    	assertEquals("name", contact.getLastName());
    }
    
    @Test
    public void testSetAddress () {
    	Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    	contact.setAddress("place");
    	assertEquals("place", contact.getAddress());
    }
    
    @Test
    public void testSetPhone () {
    	Contact contact = new Contact("1", "2", "3", "1234567890", "4");
    	contact.setPhone("2345678901");
    	assertEquals("2345678901", contact.getPhone());
    }
}