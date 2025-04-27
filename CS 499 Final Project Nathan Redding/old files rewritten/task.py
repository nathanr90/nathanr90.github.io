class Task:
    def __init__(self, taskId, name, description):
        self.taskId = taskId
        self.name = name
        self.description = description

    # Get Id
    def getId(self):
        return self.taskId

    # Name get and set
    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    # Description get and set
    def getDescription(self):
        return self.description

    def setDescription(self, description):
        self.description = description