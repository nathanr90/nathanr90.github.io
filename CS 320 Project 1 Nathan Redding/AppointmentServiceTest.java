package test;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

import java.util.Date;

import Appointment.AppointmentService;
import Appointment.Appointment;


public class AppointmentServiceTest {
    
	//tests the addAppointment function of AppointmentService
    @Test
    public void testAddAppointment() {
    	AppointmentService appointments = new AppointmentService();
    	
    	Date appointmentDate = new Date(2024, 11, 29, 12, 0);
        Appointment appointment = new Appointment("1", "Test appointment", appointmentDate);
        
        appointments.addAppointment(appointment);
        assertNotNull(appointments.getAppointment("1"));
    }
    
    //tests that adding a new appointment with a non-unique ID results in a illegal argument exception
    @Test
    public void testUniqueId() {
    	AppointmentService appointments = new AppointmentService();
    	
    	Date appointmentDate = new Date(2024, 11, 29, 12, 0);
        Appointment appointment = new Appointment("1", "Test appointment", appointmentDate);
        
        appointments.addAppointment(appointment);
        
        Date appointmentDate2 = new Date(2025, 11, 29, 12, 0);
        Appointment appointment2 = new Appointment("1", "Appointment test", appointmentDate2);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	appointments.addAppointment(appointment2);
        });
    }
    
    //tests deleteAppointment
    @Test
    public void testDeleteAppointment() {
    	AppointmentService appointments = new AppointmentService();
    	
    	Date appointmentDate = new Date(2024, 11, 29, 12, 0);
        Appointment appointment = new Appointment("1", "Test appointment", appointmentDate);
        
        appointments.addAppointment(appointment);
        appointments.deleteAppointment("1");
        
        assertNull(appointments.getAppointment("1"));
    }
}