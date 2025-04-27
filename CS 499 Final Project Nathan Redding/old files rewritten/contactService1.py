import contact

class ContactService1:
    def __init__(self):
        self.contacts = dict()

    def addContact(self, contact):
        self.contacts.update({contact.contactId: contact})

    def deleteContact(self, contactId):
        del self.contacts[contactId]

    def getContact(self, contactId):
        return self.contacts[contactId]