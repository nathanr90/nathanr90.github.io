package test;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {

	//test constructor
	@Test
    public void testTaskCreation() {
        Task task = new Task("1", "Test name", "Test task");
        assertNotNull(task);
        assertEquals("1", task.getId());
        assertEquals("Test name", task.getName());
        assertEquals("Test task", task.getDescription());
    }
	
	//test illegal arguments for Id
	@Test
	public void testTaskID() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Task task = new Task("12345678910", "Test name", "Test task");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Task task = new Task(null, "Test name", "Test task");
    	});
	}
	
	//test illegal arguments for name
	@Test
	public void testName() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2024 - 1900, 11, 29, 12, 0);
    		Task task = new Task("1", "Test name that is a bit too long", "Test task");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Task task = new Task("1", null, "Test task");
    	});
	}
	
	//test illegal arguments for description
	@Test
	public void testDescription() {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Task task = new Task("1", "Test name", "Test task description that is too long to fit still not long enough");
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Task task = new Task("1", "Test name", null);
    	});
	}
	
	
	//test name setter
	@Test
	public void testSetName() {
		Task task = new Task("1", "Test name", "Test task");
		task.setName("Test task name");
		assertEquals("Test task name", task.getName());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		task.setName("Test name that is a bit too long");
    	});
	}
	
	//test description setter
	@Test
	public void testSetDescription() {
		Task task = new Task("1", "Test name", "Test task");
		task.setDescription("Test task description");
		assertEquals("Test task description", task.getDescription());
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		task.setDescription("Test task description that is too long to fit still not long enough");
    	});
	}
}