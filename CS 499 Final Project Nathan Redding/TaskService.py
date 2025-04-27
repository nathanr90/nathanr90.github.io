import pymongo

class TaskService:
    def __init__(self):
        self.myclient = pymongo.MongoClient("mongodb+srv://n8r9090:QWXt0gku720yGpQD@cs499clusternr.q6vykyf.mongodb.net/?retryWrites=true&w=majority&appName=CS499ClusterNR")
        self.mydb = self.myclient["CS499FinalProject"]
        self.collection = self.mydb["Tasks"]

    def addTask(self, taskId, name, description):
        mydict = {"_id": taskId, "name": name, "description": description}

        for x in self.collection.find({},{"_id": 1}):
            if x["_id"] == taskId:
                print("ID already in use")
                return

        x = self.collection.insert_one(mydict)
        print("Task entered with ID: " + x.inserted_id)

    def deleteTask(self, taskId):
        myquery = {"_id": taskId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == taskId:
                self.collection.delete_one(myquery)
                print("Task deleted")
                return

        print("No matching ID")

    def getTask(self, taskId):
        myquery = {"_id": taskId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == taskId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)
                return

        print("No matching ID")

    def updateTask(self, taskId):
        myquery = {"_id": taskId}

        for x in self.collection.find({}, {"_id": 1}):
            if x["_id"] == taskId:
                result = self.collection.find(myquery)
                for y in result:
                    print(y)

                name = input("What is the updated name of the task? ")
                description = input("What is the updated description of the task? ")
                newValues = {"$set": {"_id": taskId, "name": name, "description": description}}

                self.collection.update_one(myquery, newValues)

                print("Task updated")
                return

        print("No matching ID")

    def getAll(self):
        for x in self.collection.find():
            print(x)