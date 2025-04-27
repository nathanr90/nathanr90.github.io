package test;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTest {

	//test constructor
	@Test
    public void testAppointmentCreation() {
		Date appointmentDate = new Date(2024 - 1900, 11, 29, 12, 0);
        Appointment appointment = new Appointment("1", "Test appointment", appointmentDate);
        assertNotNull(appointment);
        assertEquals("1", appointment.getAppointmentId());
        assertEquals("Test appointment", appointment.getDescription());
        assertEquals(new Date(2024 - 1900, 11, 29, 12, 0), appointment.getAppointmentDate());
    }
	
	//tests illegal arguments for ID
	@Test
	public void testAppointmentID () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2024 - 1900, 11, 29, 12, 0);
    		new Appointment("12345678910", "Test appointment", appointmentDate);
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2024 - 1900, 11, 29, 12, 0);
    		new Appointment(null, "Test appointment", appointmentDate);
    	});
	}
	
	//tests illegal arguments for description
	@Test
	public void testDescription () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2024 - 1900, 11, 29, 12, 0);
    		new Appointment("1", "Test appointment to see if checks are working testing description size now", appointmentDate);
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2001 - 1900, 11, 29, 12, 0);
    		new Appointment("1", null, appointmentDate);
    	});
	}
	
	//test illegal arguments for dates
	@Test
	public void testAppointmentDate () {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		new Appointment("1", "Test appointment", null);
    	});
    	Assertions.assertThrows(IllegalArgumentException.class, () -> {
    		Date appointmentDate = new Date(2001 - 1900, 11, 29, 12, 0);
    		new Appointment("1", "Test appointment", appointmentDate);
    	});
	}
		
}
