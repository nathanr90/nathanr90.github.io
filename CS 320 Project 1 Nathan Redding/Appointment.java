package Appointment;

import java.util.Date;

public class Appointment {
	private final String appointmentId;
	private String description;
	private Date appointmentDate;
	
	
	//constructor
	public Appointment(String appointmentId, String description, Date appointmentDate) {
		
		//length/null tests
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		
		this.appointmentId = appointmentId;
		this.description = description;
		this.appointmentDate = appointmentDate;
	}
	
	//getters
	public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
