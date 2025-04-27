from AppointmentService import AppointmentService
from ContactService import ContactService
from TaskService import TaskService

import datetime

appointments = AppointmentService()
contacts = ContactService()
tasks = TaskService()

keepGoing = '1'

while keepGoing == '1':
    choice = input("Choose what you want to edit: Appointments(1), Contacts(2), Tasks(3): ")

    if choice == '1':
        #handle appointments
        choice2 = input("\nWhat would you like to do to Appointments?: Add(1), Delete(2), Get(3), Update(4), View All(5): ")
        print()
        if choice2 == '1':
            #add appointment
            appId = input("What is the appointment ID? ")
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
                if year%4 == 0:
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

            appointments.addAppointment(appId, description, date)

        elif choice2 == '2':
            #delete appointment
            appId = input("What is the ID of the appointment you want to delete? ")
            appointments.deleteAppointment(appId)

        elif choice2 == '3':
            #get appointment
            appId = input("What is the ID of the appointment you want to find? ")
            appointments.getAppointment(appId)

        elif choice2 == '4':
            #update appointment
            appId = input("What is the ID of the appointment you want to update? ")
            appointments.updateAppointment(appId)

        elif choice2 == '5':
            #get all entries
            appointments.getAll()

    elif choice == '2':
        #handle contacts
        choice2 = input("\nWhat would you like to do to Contacts?: Add(1), Delete(2), Get(3), Update(4), View All(5): ")
        print()
        if choice2 == '1':
            #add contact
            conId = input("What is the Contact ID? ")
            name = input("What's their first name? ")
            last = input("What's their last name? ")
            phone = input("What's their phone number? ")
            address = input("What's their address? ")

            contacts.addContact(conId, name, last, phone, address)

        elif choice2 == '2':
            #delete contact
            conId = input("What is the ID of the contact you want to delete? ")
            contacts.deleteContact(conId)

        elif choice2 == '3':
            #get contact
            conId = input("What is the ID of the contact you want to find? ")
            contacts.getContact(conId)

        elif choice2 == '4':
            #update contact
            conId = input("What is the ID of the contact you want to update? ")
            contacts.updateContact(conId)

        elif choice2 == '5':
            #get all entries
            contacts.getAll()

    elif choice == '3':
        #handle tasks
        choice2 = input("\nWhat would you like to do to Tasks?: Add(1), Delete(2), Get(3), Update(4), View All(5): ")
        print()
        if choice2 == '1':
            #add task
            taskId = input("What is the Task ID? ")
            name = input("What is the name of the task? ")
            description = input("What is the description of the task? ")

            tasks.addTask(taskId, name, description)

        elif choice2 == '2':
            #delete task
            taskId = input("What is the ID of the task you want to delete? ")
            tasks.deleteTask(taskId)

        elif choice2 == '3':
            #get task
            taskId = input("What is the ID of the task you want to find? ")
            tasks.getTask(taskId)

        elif choice2 == '4':
            #update task
            taskId = input("What is the ID of the task you want to update? ")
            tasks.updateTask(taskId)

        elif choice2 == '5':
            #get all entries
            tasks.getAll()
    
    else:
        print("No choice selected")

    keepGoing = input("\nPress 1 to continue: ")
    print()

print("Session ended, have a nice day!")