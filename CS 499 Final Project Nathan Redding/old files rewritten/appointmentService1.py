import appointment

class AppointmentService1:
    def __init__(self):
        self.appointments = dict()

    def addAppointment(self, appointment):
        self.appointments.update({appointment.appointmentId: appointment})

    def deleteAppointment(self, appointmentId):
        del self.appointments[appointmentId]

    def getAppointment(self, appointmentId):
        return self.appointments[appointmentId]