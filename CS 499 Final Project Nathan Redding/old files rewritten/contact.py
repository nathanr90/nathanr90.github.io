class Contact:
    def __init__(self, contactId, firstName, lastName, phone, address):
        self.contactId = contactId
        self.firstName = firstName
        self.lastName = lastName
        self.phone = phone
        self.address = address

    # Id get
    def getContactId(self):
        return self.contactId

    # First name get and set
    def getFirstName(self):
        return self.firstName

    def setFirstName(self, firstName):
        self.firstName = firstName

    # Last name get and set
    def getLastName(self):
        return self.lastName

    def setLastName(self, lastName):
        self.lastName = lastName

    # Phone number get and set
    def getPhone(self):
        return self.phone

    def setPhone(self, phone):
        self.phone = phone

    # Address get and set
    def getAddress(self):
        return self.address

    def setAddress(self, address):
        self.address = address