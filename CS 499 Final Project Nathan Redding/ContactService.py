import pymongo

class ContactService:
    def __init__(self):
        self.myclient = pymongo.MongoClient("mongodb+srv://n8r9090:QWXt0gku720yGpQD@cs499clusternr.q6vykyf.mongodb.net/?retryWrites=true&w=majority&appName=CS499ClusterNR")
        self.mydb = self.myclient["CS499FinalProject"]
        self.collection = self.mydb["Contacts"]

    def addContact(self, contactId, firstName, lastName, phone, address):
        mydict = {"_id": contactId, "firstName": firstName, "lastName": lastName, "phone": phone, "address": address}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == contactId:
                print("ID already in use")
                return

        x = self.collection.insert_one(mydict)
        print("Contact entered with ID: " + x.inserted_id)

    def deleteContact(self, contactId):
        myquery = {"_id": contactId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == contactId:
                self.collection.delete_one(myquery)
                print("Contact deleted")
                return

        print("No matching ID")

    def getContact(self, contactId):
        myquery = {"_id": contactId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == contactId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)
                return

        print("No matching ID")

    def updateContact(self, contactId):
        myquery = {"_id": contactId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == contactId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)

                firstName = input("What's the updated first name? ")
                lastName = input("What's the updated last name? ")
                phone = input("What's the updated phone number? ")
                address = input("What's the updated address? ")
                newValues = {"$set": {"_id": contactId, "firstName": firstName, "lastName": lastName, "phone": phone, "address": address}}

                self.collection.update_one(myquery, newValues)

                print("Contact updated")
                return

        print("No matching ID")

    def getAll(self):
        for x in self.collection.find():
            print(x)