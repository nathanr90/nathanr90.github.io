import pymongo
import datetime

class AppointmentService:
    def __init__(self):
        self.myclient = pymongo.MongoClient("mongodb+srv://n8r9090:QWXt0gku720yGpQD@cs499clusternr.q6vykyf.mongodb.net/?retryWrites=true&w=majority&appName=CS499ClusterNR")
        self.mydb = self.myclient["CS499FinalProject"]
        self.collection = self.mydb["Appointments"]

    def addAppointment(self, appointmentId, description, appointmentDate):
        mydict = {"_id": appointmentId, "description": description, "appointmentDate": appointmentDate}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == appointmentId:
                print("ID already in use")
                return

        x = self.collection.insert_one(mydict)
        print("Appointment entered with ID: " + x.inserted_id)

    def deleteAppointment(self, appointmentId):
        myquery = {"_id": appointmentId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == appointmentId:
                self.collection.delete_one(myquery)
                print("Appointment deleted")
                return

        print("No matching ID")

    def getAppointment(self, appointmentId):
        myquery = {"_id": appointmentId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == appointmentId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)
                return

        print("No matching ID")

    def updateAppointment(self, appointmentId):
        myquery = {"_id": appointmentId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == appointmentId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)

                description = input("What is the description? ")

                currYear = datetime.datetime.now().year
                year = int(input("Specify the year of the appointment: "))
                while year < currYear:
                    year = int(input("Give a current or future year: "))

                currMonth = datetime.datetime.now().month
                month = int(input("The month from 1-12: "))
                while month > 12 or month < 1 or (year == currYear and month <= currMonth):
                    if year == currYear and month <= currMonth:
                        month = int(input("Not enough time in advance, give a future month from 1-12: "))
                    else:
                        month = int(input("Give a valid month from 1-12: "))

                day = int(input("The day: "))
                if month == 2:
                    if year % 4 == 0:
                        while day > 29 or day < 1:
                            day = int(input("Give a valid day for the selected month 1-29: "))
                    else:
                        while day > 28 or day < 1:
                            day = int(input("Give a valid day for the selected month 1-28: "))
                elif month in [4, 6, 9, 11]:
                    while day > 30 or day < 1:
                        day = int(input("Give a valid day for the selected month 1-30: "))
                else:
                    while day > 31 or day < 1:
                        day = int(input("Give a valid day for the selected month 1-31: "))

                hour = int(input("The hour from 0-23: "))
                while hour > 23 or hour < 0:
                    hour = int(input("Give an hour from 0-23: "))

                minute = int(input("The minute from 0-59: "))
                while minute > 59 or minute < 0:
                    minute = int(input("Give a minute from 0-59: "))

                date = datetime.datetime(year, month, day, hour, minute)

                newValues = {"$set": {"_id": appointmentId, "description": description, "appointmentDate": date}}

                self.collection.update_one(myquery, newValues)

                print("Appointment updated")
                return

        print("No matching ID")

    def getAll(self):
        for x in self.collection.find():
            print(x)