package Appointment;

import java.util.HashMap;
import java.util.Map;


public class AppointmentService {
    private Map<String, Appointment> appointments;

    //creates in-memory data structure
    public AppointmentService() {
        appointments = new HashMap<>();
    }

    //adds appointments
    public void addAppointment(Appointment appointment) {
    	//ensures unique ID
    	if (appointments.get(appointment.getAppointmentId()) != null) {
    		throw new IllegalArgumentException("Non-unique ID");
    	}
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    //delete appointment
    public void deleteAppointment(String appointmentId) {
        appointments.remove(appointmentId);
    }
    
    //get appointment for testing purposes
    public Appointment getAppointment(String appointmentId) {
    	return appointments.get(appointmentId);
    }
}
