class Appointment:
    def __init__(self, appointmentId, description, appointmentDate):
        self.appointmentId = appointmentId
        self.description = description
        self.appointmentDate = appointmentDate

    def getAppointmentId(self):
        return self.appointmentId

    def getDescription(self):
        return self.description

    def getAppointmentDate(self):
        return self.appointmentDate